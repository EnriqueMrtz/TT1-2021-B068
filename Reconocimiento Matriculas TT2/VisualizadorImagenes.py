import cv2
from Config import *

class VisualizadorImagenes():
    def mostrarIMG(self, etiqueta, imagen):
        if(MOSTRAR):
            cv2.imshow(etiqueta,imagen)
            cv2.waitKey(0)