import cv2
import numpy as np
import imutils
from config import *

class FiltroImagen:
    def __init__(self, imagen):
        self._imgInicial = imagen
        self._contornosEncontrados = 0
        self._roi = 0
        self._contornoPlaca = 0

    def mostrarIMG(self, nameWin, img):
        if(MOSTRAR):
            cv2.imshow(nameWin,img)
            cv2.waitKey(0)
    
    def filtrado_inicial(self):
        self._imgInicial = cv2.cvtColor(self._imgInicial, cv2.COLOR_BGR2GRAY)
        self.mostrarIMG("ORIGINAL", self._imgInicial)
        # Permite realizar una operación morfológica "blackhat"
        # que nos permitirá revelar regiones oscuras ubicadas en fondos blancos
        # como es el caso del texto ubicado en la placa de un auto
        rectKernel=cv2.getStructuringElement(cv2.MORPH_RECT,(20,10))         #Se crea un elemento estructurante (kernel)
                                                                                #en el cual el tamaño imita al de una placa
        blackhatIMG=cv2.morphologyEx(self._imgInicial,cv2.MORPH_BLACKHAT,rectKernel)    #Resalta las partes negras que tienen fondo blanco 
        self.mostrarIMG("Blackhat",blackhatIMG)        #muestra la imagen con blackhat

        #Ahora buscamos regiones claras en la imagen para obtener una mascara, para ello aplicamos
        #una "operación de cierre" para llenar pequeños agujeros
        #y ayudarnos a identificar estructuras más grandes
        cuadradoKernel = cv2.getStructuringElement(cv2.MORPH_RECT, (5, 5))    #Usamos un nucleo cuadrado pequeño
        lightIMG = cv2.morphologyEx(self._imgInicial,cv2.MORPH_CLOSE,cuadradoKernel)          #Operación de cierre
        #Realizamos un umbral binario en nuestra imagen utilizando el "método de Otsu"
        #para revelar las regiones claras de la imagen que puedan contener texto como el de las matriculas
        filtGauss1 = cv2.GaussianBlur(lightIMG,(5,5),0)
        lightIMG = cv2.threshold(filtGauss1, 127, 255,cv2.THRESH_BINARY + cv2.THRESH_OTSU)[1]     #Metodo Otsu
        self.mostrarIMG("Regiones claras",lightIMG)

        #El "degradado de Scharr" enfatizará los límites de los caracteres en la matrícula:
        gradX = cv2.Sobel(blackhatIMG, ddepth=cv2.CV_32F,dx=1, dy=0, ksize=-1)     #Calculamos la representación
                                                                                #del gradiente de Scharr en la dirección x
        gradX = np.absolute(gradX)      
        (minVal, maxVal) = (np.min(gradX), np.max(gradX))
        gradX = 255 * ((gradX - minVal) / (maxVal - minVal))        #Escalamos el resultado de nuevo al rango [0, 255]
        gradX = gradX.astype("uint8")
        self.mostrarIMG("Degradado de Scharr", gradX)

        #Difuminar la representación del degradado
        # aplicar una operación de cierre y aplicar un umbral
        # a la imagen utilizando el método de Otsu
        gradX = cv2.GaussianBlur(gradX, (5, 5), 0)
        self.mostrarIMG("Filtro Gaussiano", gradX)
        gradX = cv2.morphologyEx(gradX, cv2.MORPH_CLOSE, rectKernel)
        self.mostrarIMG("Operacion de cierre", gradX)
        filtGauss2 = cv2.GaussianBlur(gradX,(5,5),0)
        umbralIMG = cv2.threshold(filtGauss2, 0, 255,cv2.THRESH_BINARY + cv2.THRESH_OTSU)[1]
        self.mostrarIMG("Grad Thresh", umbralIMG)

        #realizar una serie de "erosiones" y "dilataciones" para limpiar el ruido la imagen umbralizada
        umbralIMG = cv2.erode(umbralIMG, None, iterations=2)
        umbralIMG = cv2.dilate(umbralIMG, None, iterations=3)
        self.mostrarIMG("Grad Erode/Dilate", umbralIMG)

        #Esta imagen "lightIMG" sirve como nuestra "máscara" para un "bitwise-AND" 
        # entre el resultado del umbral y las regiones "claras" de la imagen para revelar los candidatos a matrícula
        umbralIMG = cv2.bitwise_and(umbralIMG, umbralIMG, mask=lightIMG)
        #Ahora realizamos una dilatacion y una erosión para tapar huecos y limpiar la imagen
        finalIMG = cv2.dilate(umbralIMG, None, iterations=2)
        finalIMG = cv2.erode(finalIMG, None, iterations=1)
        self._imgFinal=finalIMG
        self.mostrarIMG("Final", self._imgFinal)
    
    def enlistar_contornos(self):
        #E#ncuentre contornos en la imagen con umbral
        candidatos = cv2.findContours(self._imgFinal.copy(), cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_SIMPLE)
        candidatos = imutils.grab_contours(candidatos)
        #Clasifíquelos por su tamaño en orden descendente, conservando solo los más grandes
        candidatos = sorted(candidatos, key=cv2.contourArea, reverse=True)
        #guardar la lista de contornosS
        self._contornosEncontrados = candidatos
    
    def localizar_matricula(self):
        self.filtrado_inicial()
        self.enlistar_contornos()
        #Se recorren todos los contornos candidatos
        for c in self._contornosEncontrados:
            #Se obtiene el cuadro delimitador del contorno (Cordenadas del contorno)
            (x, y, w, h) = cv2.boundingRect(c)
            #Calculamos el "Aspect Ratio" del contorno
            aspect_ratio = w / float(h)
            area = cv2.contourArea(c)
            
            if MOSTRAR:
                print("[ASPECT RATIO]",aspect_ratio)

            #Comprobar si el "Aspect Ratio" es rectangular (mayor a 1)
            if aspect_ratio > AR_MIN and aspect_ratio < AR_MAX and area > AREA_MIN and area < AREA_MAX:
                
                if MOSTRAR:
                    print("[AREA ]", area)
                
                #Almacenar contorno de la matricula
                self._contornoPlaca = c
                #Extraemos el ROI antes de la umbralización y la limpieza de bordes
                licensePlate = self._imgInicial[y:y + h, x:x + w]
                #Aplicamos una umbral adaptativo al ROI
                filtGauss3 = cv2.GaussianBlur(licensePlate,(5,5),0)
                self._roi = cv2.adaptiveThreshold(filtGauss3,255,cv2.ADAPTIVE_THRESH_GAUSSIAN_C,cv2.THRESH_BINARY_INV,45,1)
                #Se elimina el filtro que aun pueda existir en la zona de interes de la matricula
                self._roi = cv2.erode(self._roi, None, iterations=1)
                self._roi = cv2.dilate(self._roi, None, iterations=1)
                self._roi = cv2.adaptiveThreshold(filtGauss3,255,cv2.ADAPTIVE_THRESH_GAUSSIAN_C,cv2.THRESH_BINARY,45,1)
                #Crea el kernel
                kernel = np.ones((3,3),np.float32)/25
                #Filtra la imagen utilizando el kernel anterior
                self._roi = cv2.filter2D(self._roi,-1,kernel)
                #Recortamos un poco el ROI de los bordes y dejarlo más limpio
                captAlto, captAncho = self._roi.shape[:2]
                self._roi = self._roi[int(captAlto/5):int((captAlto/5)*4),0:captAncho]
                
                self.mostrarIMG("ROI", self._roi)
                break
            else:
                print("NO SE ENCONTRO UN CANDIDATO...")
                self._roi = None
                self._contornoPlaca = None
        return (self._roi, self._contornoPlaca)