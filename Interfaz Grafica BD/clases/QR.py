import qrcode
import cv2
import CRUD as conexion
class QR():
    def __init__(self):
        self.datos=conexion.CRUD()


    def generarQR(self):
        fecha = self.datos.fecha()
        hora=self.datos.hora()
        matricula = "NCR-23-73"
        llaveQR = "%s,%s" % (matricula,fecha)
        imgQR = qrcode.make(llaveQR)
        imgQR.save("qr.png")
        qr = cv2.imread("qr.png")
        cv2.imshow("LlaveQR",qr)
        cv2.waitKey(0)