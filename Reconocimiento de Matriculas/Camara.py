from picamera import PiCamera
from time import sleep
from config import *

class Camara:
    def __init__(self):
        self._capturaCamara = 0
    
    def tomar_captura(self):
        camara = PiCamera()
        #camara.resolution = (ANCHOREQ, ALTOREQ)      # Establecer la resolución de la cámara
        #camara.framerate = 60                 # Establecer velocidad de fotogramas de la cámara
        camara.start_preview()
        sleep(1)
        camara.capture("capturaCamara.png")
        camara.stop_preview()