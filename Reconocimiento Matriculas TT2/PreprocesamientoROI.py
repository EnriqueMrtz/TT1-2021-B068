from VisualizadorImagenes import *
from DeteccionOCR import *
import cv2
import numpy as np
from PIL import Image

class PreprocesamientoROI:
    def __init__(self, roi):
        self.imagen_entrada = roi

    def iniciarProcesamiento(self):
        ventana = VisualizadorImagenes()
        ###Normalizacion
        alto,ancho = self.imagen_entrada.shape[:2]
        imagen_aux=cv2.resize(self.imagen_entrada,(ancho*2,alto*2))
        imagen_invertida=cv2.bitwise_not(imagen_aux)
        ###Binarizacion
        imagen_gris = cv2.cvtColor(imagen_invertida, cv2.COLOR_BGR2GRAY)
        imagen_binarizada=cv2.threshold(imagen_gris, 0, 255,cv2.THRESH_BINARY | cv2.THRESH_OTSU)[1]
        ventana.mostrarIMG("ROI BINARIZADO",imagen_binarizada)
        ###Limpieza de ruido
        kernel = cv2.getStructuringElement(cv2.MORPH_ELLIPSE, (3, 3))
        opening = cv2.morphologyEx(imagen_binarizada, cv2.MORPH_OPEN, kernel)
        cv2.imshow("APERTURA", opening)
        cv2.waitKey(0)

        hacerOCR = DeteccionOCR(opening)
        caracteres = hacerOCR.detectarTexto()
        caracteres = caracteres.replace(" ","")
        return caracteres

        