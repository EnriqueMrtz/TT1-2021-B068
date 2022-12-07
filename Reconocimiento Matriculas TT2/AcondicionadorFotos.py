import os.path as path
import cv2
from Config import *
from VisualizadorImagenes import *
class AcondicionadorFotos:
    def __init__(self, foto):
        self._nombreIMG = foto
        self._capturaFoto = foto
        self._ancho = 0
        self._alto = 0
        self._imgPreProcess = 0

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
        return imgRecortada

    def redimensionar_y_recortar(self):
        ventana = VisualizadorImagenes()
        if(TOMARCAPTURA):
            imgOriginal = self._capturaFoto
            ventana.mostrarIMG("IMAGEN INICIAL",imgOriginal)
            if(self.comprobar_resolución(imgOriginal)):
                imgRedimensionada = cv2.resize(imgOriginal,(ANCHOREQ,ALTOREQ))
                imgRecortada = self.recortarIMG(imgRedimensionada)
                self._imgPreProcess = imgRecortada
            else:
                imgRecortada = self.recortarIMG(imgOriginal)
                self._imgPreProcess = imgRecortada
        else:
            imgOriginal = cv2.imread(self._nombreIMG)
            ventana.mostrarIMG("IMAGEN INICIAL",imgOriginal)
            if(self.existeIMG()):
                if(self.comprobar_resolución(imgOriginal)):
                    imgRedimensionada = cv2.resize(imgOriginal,(ANCHOREQ,ALTOREQ))
                    imgRecortada = self.recortarIMG(imgRedimensionada)
                    self._imgPreProcess = imgRecortada
                else:
                    imgRecortada = self.recortarIMG(imgOriginal)
                    self._imgPreProcess = imgRecortada

        return self._imgPreProcess