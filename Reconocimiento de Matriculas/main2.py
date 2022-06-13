import cv2
from Cliente import Cliente
from Imagen import Imagen
from FiltroImagen import FiltroImagen
from OCR import OCR
from QR import QR
from config import *


if __name__ == "__main__":
    foto1 = Imagen(FOTO)
    imagenPreProces = foto1.redimensionar_y_recortar()

    filtro1 = FiltroImagen(imagenPreProces)
    roi, contornoPlaca = filtro1.localizar_matricula()

    if roi is not None and contornoPlaca is not None:
        ocr1 = OCR(roi)
        textoEncontrado = ocr1.detectarTexto()
    
    
    if textoEncontrado is not None and contornoPlaca is not None:
            resaltROI = cv2.boxPoints(cv2.minAreaRect(contornoPlaca))
            resaltROI = resaltROI.astype("int")
            cv2.drawContours(imagenPreProces, [resaltROI], -1, (255, 255, 0), 2)

            # Colocamos el texto a un lado del ROI
            (x, y, w, h) = cv2.boundingRect(contornoPlaca)
            cv2.putText(imagenPreProces, textoEncontrado, (x, y - 15),cv2.FONT_HERSHEY_SIMPLEX, 0.75, (255, 255, 0), 2)

            # Mostramos la imagen de salida
            print("[PLACAS] {}".format(textoEncontrado))
            cv2.imshow("Output ANPR", imagenPreProces)
            cv2.waitKey(0)

            #Se envian los datos al servidor
            cliente1 = Cliente(textoEncontrado)
            llaveQR = cliente1.iniciarCliente()

            #Se genera la el código QR
            qr1 = QR(llaveQR)
            qr1.generarQR()