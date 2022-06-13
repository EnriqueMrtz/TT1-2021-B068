import os.path as path
import cv2
from config import *

class Imagen:
    def __init__(self, nombre):
        self._nombreIMG = nombre
        self._ancho = 0
        self._alto = 0
        self._imgPreProcess = 0

    @property
    def nombreIMG(self):
        return self._nombreIMG
    @nombreIMG.setter
    def nombreIMG(self, nombre):
        self._nombreIMG = nombre

    @property
    def ancho(self):
        return self.ancho
    @ancho.setter
    def ancho(self, ancho):
        self._ancho = ancho

    @property
    def alto(self):
        return self._alto
    @alto.setter
    def alto(self, alto):
        self._alto = alto

    def existeIMG(self):
        if path.exists(self._nombreIMG):
            print("Imagen encontrada, procesando el reconocimiento...")
            return True
        else:
            print("Error al encontrar la imagen...")
            return False

    def comprobar_resolución(self,imgOriginal):
        alto, ancho = imgOriginal.shape[:2]
        if(ancho == ANCHOREQ and alto == ALTOREQ):
            return False
        else:
            return True

    def recortarIMG(self,imgOriginal):
        capt = imgOriginal
        #Obtener alto y ancho de imagen
        captAlto, captAncho =capt.shape[:2]

        #Obtener la zona que nos intereza analizar
        x1 = int(captAncho/3)   #Tomamos el 1/3 de ancho de la imagen
        x2 = int(x1 * 3)        

        y1 = int(captAlto/4)    #Tomamos el 1/4 de alto de la imagen
        y2 = int(y1 * 4)

        #Recortamos la zona de interes
        imgRecortada = capt[y1:y2, 0:x2]
        #mostrarIMG("Recorte", recorteIMG)
        return imgRecortada

    def redimensionar_y_recortar(self):
        if(self.existeIMG()):
            imgOriginal = cv2.imread(self._nombreIMG)
            #Comprobamos si se requiere cambiar la resolución
            if(self.comprobar_resolución(imgOriginal)):
                if MOSTRAR:
                    print("REQUIERE CAMBIO")
                    
                #Se cambia la resolución
                imgRedimensionada = cv2.resize(imgOriginal,(ANCHOREQ,ALTOREQ))
                #Se recorta la imagen para trabajar con solo una sección
                imgRecortada = self.recortarIMG(imgRedimensionada)
                #guardamos la imagen para ser procesada y encontrar los contornos
                self._imgPreProcess = imgRecortada
            else:
                self._imgPreProcess = imgOriginal

        #Asignar "true" en el archivo "config" para mostrar la imagen de esta clase
        if(MOSTRAR):
            cv2.imshow("Imagen recortada y redimensionada",self._imgPreProcess)
            cv2.waitKey(0)

        return self._imgPreProcess