import qrcode
import cv2

class QR:
    def __init__(self, llaveQR):
        self._llaveQR = llaveQR
        self._imgQR = 0

    def generarQR(self):
        self._imgQR = qrcode.make(self._llaveQR)
        self._imgQR.save("qr.png")
        qr = cv2.imread("qr.png")
        cv2.imshow("LlaveQR",qr)
        cv2.waitKey(0)