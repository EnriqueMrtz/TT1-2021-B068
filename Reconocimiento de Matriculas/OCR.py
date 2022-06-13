import pytesseract
import cv2
import imutils
from pytesseract import Output
from config import *

class OCR:
    def __init__(self, roi):
        self._roi = roi
        self._caracteresEncontrados = ""
        self._configOCR = ""
    
    def config_tesseract(self):
        # Indicamos que caracteres seran aceptados por Tesseract
        alfanumerico = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-"
        self._configOCR = "-c tessedit_char_whitelist={}".format(alfanumerico)
        # Establecemos uno de los 13 modos PSM existentes
        # En este caso es el 7 (Tratar la imagen como una sola linea de texto) 
        self._configOCR += " --psm {}".format(PSM)
    
    def limpiarTexto(self):
        #Eliminamos el texto que no sea ASCII para que podamos dibujar el texto en la imagen
        return "".join([c if ord(c) < 128 else "" for c in self._caracteresEncontrados]).strip()

    def detectarTexto(self):
        self.config_tesseract()
        if self._roi is not None:
            self._caracteresEncontrados = pytesseract.image_to_string(self._roi, config=self._configOCR)
            self._caracteresEncontrados = self.limpiarTexto()
        
        return (self._caracteresEncontrados[0:9])