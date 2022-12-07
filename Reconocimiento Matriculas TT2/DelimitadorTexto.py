from imutils.object_detection import non_max_suppression
import numpy as np
import cv2
from VisualizadorImagenes import *


class DelimitadorTexto:
    def __init__(self, roi):
        ventana=VisualizadorImagenes()
        self.image = roi
        imagen_aux = np.zeros((self.image.shape[0], self.image.shape[1]))
        self.image=cv2.normalize(self.image,imagen_aux,0,255,cv2.NORM_MINMAX)

    def detectarTexto(self):
        ventana=VisualizadorImagenes()
        # la altura y el ancho de la imagen deben ser múltiplos de 32
        imgWidth=288    #288
        imgHeight=128   #128

        orig = self.image.copy()
        (H, W) = self.image.shape[:2]
        (newW, newH) = (imgWidth, imgHeight)

        rW = W / float(newW)
        rH = H / float(newH)
        image = cv2.resize(self.image, (newW, newH))

        (H, W) = image.shape[:2]

        #Cargamos el archivo modelo de detector EAST
        net = cv2.dnn.readNet("frozen_east_text_detection.pb")
        #Crear blob a partir de imagen
        blob = cv2.dnn.blobFromImage(self.image, 1.0, (W, H),
                             (123.68, 116.78, 103.94), swapRB=True, crop=False)

        #Agregar capas para la red
        outputLayers = []
        outputLayers.append("feature_fusion/Conv_7/Sigmoid")
        outputLayers.append("feature_fusion/concat_3")
        #Pase la entrada a la red y obtenga la salida basada en capas
        net.setInput(blob)
        output = net.forward(outputLayers)
        scores = output[0]
        geometry = output[1]
        #Obtener rects y puntaje de confianza para cuadros delimitadores
        (numRows, numCols) = scores.shape[2:4]
        rects = []
        confidences = []

        for y in range(0, numRows):
            scoresData = scores[0, 0, y]
            xData0 = geometry[0, 0, y]
            xData1 = geometry[0, 1, y]
            xData2 = geometry[0, 2, y]
            xData3 = geometry[0, 3, y]
            anglesData = geometry[0, 4, y]

            for x in range(0, numCols):
                # si nuestro puntaje no tiene suficiente probabilidad, ignóralo
                if scoresData[x] < 0.5:
                    continue

                # calcule el factor de compensación ya que nuestros mapas de características resultantes serán 4 veces más pequeños que la imagen de entrada
                (offsetX, offsetY) = (x * 4.0, y * 4.0)
                ## extraer el ángulo de rotación para la predicción y luego calcular el seno y el coseno
                angle = anglesData[x]
                cos = np.cos(angle)
                sin = np.sin(angle)

                # usar el volumen de la geometría para derivar el ancho y la altura del cuadro delimitador
                h = xData0[x] + xData2[x]
                w = xData1[x] + xData3[x]

                # calcular las coordenadas (x, y) de inicio y finalización para el cuadro delimitador de predicción de texto
                endX = int(offsetX + (cos * xData1[x]) + (sin * xData2[x]))
                endY = int(offsetY - (sin * xData1[x]) + (cos * xData2[x]))
                startX = int(endX - w)
                startY = int(endY - h)

                # agregue las coordenadas del cuadro delimitador y el puntaje de probabilidad a nuestras respectivas listas
                
                rects.append((startX, startY, endX, endY))
                confidences.append(scoresData[x])

        #Aplicar supresión para eliminar cuadros delimitadores débiles
        boxes = non_max_suppression(np.array(rects), probs=confidences)

        #Vuelva a escalar la imagen al original y cree cuadros delimitadores
        # bucle sobre los cuadros delimitadores
        contRects = 0
        cajasAuxiliares = []
        for (startX, startY, endX, endY) in boxes:
            # escalar las coordenadas del cuadro delimitador en función de las proporciones respectivas
            startX = int(startX * rW)
            startY = int(startY * rH)
            endX = int(endX * rW)
            endY = int(endY * rH)

            # dibujar el cuadro delimitador en la imagen
            print("CORD Y: ",(endY-startY))
            if((endY-startY)>23):   #Condicion que descarta los cuadros delimitadores que no pertenecen al texto de matricula
                cv2.rectangle(orig, (startX, startY), (endX, endY), (0, 255, 0), 2)
                cajasAuxiliares.append((startX, startY, endX, endY))
                contRects+=1

        ventana.mostrarIMG("ROI Texto Detextado", orig)
        cv2.waitKey(0)

        recorteStartX = 0
        recorteEndX = 0
        recorteStarY = 0
        recorteEndX = 0
        if(MOSTRAR):
            print("cajas acuriliares", cajasAuxiliares)
    
        if(contRects>1):
            if(MOSTRAR):
                print(cajasAuxiliares[0])
                print(cajasAuxiliares[1])
            (startX1, startY1, endX1, endY1) = cajasAuxiliares[0]
            (startX2, startY2, endX2, endY2) = cajasAuxiliares[1]
            if(startX1 <=0 ):
                startX1=2
            if(startX2 <=0 ):
                startX2=2
            #Comparacion en X
            if(startX1 < startX2):
                recorteStartX = startX1
            else:
                recorteStartX = startX2
            if(endX1 > endX2):
                recorteEndX = endX1
            else:
                recorteEndX = endX2
            #Comparacion en Y
            if(startY1 < startY2):
                recorteStarY = startY1
            else:
                recorteStarY = startY2
            if(endY1 > endY2):
                recorteEndY = endY1
            else:
                recorteEndY = endY2
            if(MOSTRAR):
                print(recorteStartX,recorteStarY,recorteEndX,recorteEndY)
            return self.image[recorteStarY-5:recorteEndY+7, recorteStartX:recorteEndX+7]
        else:
            (startX1, startY1, endX1, endY1) = cajasAuxiliares[0]
            if(startX1 <= 0 ):
                startX1=1
            print(startX1,startY1,endX1,endY1)
            ancho_pixel=endX1-startX1
            largo_pixel=endY1-startY1
            area=ancho_pixel*largo_pixel
            print(area)
            #Considera el area de la imagen cuando sale antes.
            if area<8000:
                if startX1>100:
                    startX1=7
                if endX1<100:
                    endX1=self.image.shape[1]-7
            return self.image[startY1-5:endY1+7, startX1:endX1+7]
