from time import sleep
from Config import *
import cv2
from datetime import datetime
class ActivadorCamara:
    def __init__(self):
        self._capturaCamara = 0
    
    
    def getFoto(self):
        return self._capturaCamara

    def tomar_captura(self):
        now = datetime.now()
        cam = cv2.VideoCapture(0)
        #Se establece la resolución de la imagen
        cam.set(cv2.CAP_PROP_FRAME_WIDTH, 1920)
        cam.set(cv2.CAP_PROP_FRAME_HEIGHT, 1080)

        cv2.namedWindow("Captura de foto")

        while True:
            ret, frame = cam.read()
            if not ret:
                print("failed to grab frame")
                break
            cv2.imshow("test", frame)

            k = cv2.waitKey(1)
            if k%256 == 27:
                # ESC presionado
                print("Escape presionado, Cerrando...")
                break
            elif k%256 == 32:
                # SPACE presionado
                img_name = "/CapturasCamara/{}_{}.png".format(now.date(),now.time())
                cv2.imwrite(img_name, frame)
                self._capturaCamara = frame
                print("{} Escrito!!".format(img_name))
                break

        cam.release()
        cv2.destroyAllWindows()