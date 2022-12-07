from VisualizadorImagenes import *
from OperacionesMorfologicas import *
from Config import *
import cv2

import imutils

class SegmentadorImagen():
    def __init__(self,imagen_acondicionada):
        #Variables
        self.imagen_acondicionada=imagen_acondicionada
        self.contornos_encontrados=0
        self.licensePlate = 0
        self.imagen_final=0
        #Objetos
        self.ventana = VisualizadorImagenes()
        self.operacion = OperacionesMorfologicas()

    def segmentarImagen(self):  
        
        imagen_gris= cv2.cvtColor(self.imagen_acondicionada, cv2.COLOR_BGR2GRAY)
        self.ventana.mostrarIMG("Escala gris", imagen_gris)
        
        ##Creacion mascara (Regiones claras)
        imagen_cerrada=self.operacion.realizarOperacionCierre(imagen_gris,5,5)
        self.ventana.mostrarIMG("CIERRE MASCARA", imagen_cerrada)
        imagen_gaussiana=self.operacion.realizarFiltroGaussiano(imagen_cerrada)
        self.ventana.mostrarIMG("GAUSIANO MASCARA", imagen_gaussiana)
        imagen_mascara=self.operacion.realizarUmbralizacionAdaptativa(imagen_gaussiana)
        self.ventana.mostrarIMG("UMBRALIZACION MASCARA", imagen_mascara)
       
        ##Procesamiento para otra mascara
        imagen_blackhat=self.operacion.realizarBlackhat(imagen_gris)
        self.ventana.mostrarIMG("BLACKHAT", imagen_blackhat)
        imagen_canny=self.operacion.realizarCanny(imagen_blackhat)
        self.ventana.mostrarIMG("CANNY", imagen_canny)
        imagen_gaussiana=self.operacion.realizarFiltroGaussiano(imagen_canny)
        self.ventana.mostrarIMG("GAUSSIANO", imagen_gaussiana)
        imagen_cerrada=self.operacion.realizarOperacionCierre(imagen_gaussiana,25,20)
        self.ventana.mostrarIMG("OPERACION CIERRE PRINCIPAL", imagen_cerrada)
        imagen_gaussiana=self.operacion.realizarFiltroGaussiano(imagen_cerrada)
        imagen_umbralizada=self.operacion.realizarUmbralizacion(imagen_gaussiana,0,255,cv2.THRESH_BINARY + cv2.THRESH_OTSU)
        self.ventana.mostrarIMG("UMBRALIZACION", imagen_umbralizada)
        imagen_erosionada=self.operacion.realizarErosion(imagen_umbralizada,2)
        imagen_dilatada=self.operacion.realizarDilatacion(imagen_erosionada,3)
        self.ventana.mostrarIMG("EROSION-DILATACION", imagen_dilatada)
        
        ##Comapracion and de las mascaras
        imagen_bitwise=self.operacion.realizarOperacionAnd(imagen_dilatada,imagen_dilatada,imagen_mascara)
        self.ventana.mostrarIMG("OPERACION-AND", imagen_bitwise)

        ##Despues de hace una dilatacion y erosion para limnpiar la imagen
        imagen_final=self.operacion.realizarDilatacion(imagen_bitwise,2)
        self.imagen_final=self.operacion.realizarErosion(imagen_final,1)
        self.ventana.mostrarIMG("RESULTADO SEGMENTACION", self.imagen_final)


    def enlistarContornos(self):
        candidatos = cv2.findContours(self.imagen_final.copy(), cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_SIMPLE)
        candidatos = imutils.grab_contours(candidatos)
        #Clasifíquelos por su tamaño en orden descendente, conservando solo los más grandes
        candidatos = sorted(candidatos, key=cv2.contourArea, reverse=True)
        #guardar la lista de contornos
        self.contornos_encontrados = candidatos

    def localizarMatricula(self):
        for c in self.contornos_encontrados:
            #Se obtiene el cuadro delimitador del contorno (Cordenadas del contorno)
            (x, y, w, h) = cv2.boundingRect(c)
            #Calculamos el "Aspect Ratio" del contorno
            aspect_ratio = w / float(h)
            area = cv2.contourArea(c)
            alto, ancho = h,w
            if(MOSTRAR):
                print("[ASPECT RATIO]",aspect_ratio)
                #Comprobar si el "Aspect Ratio" es rectangular (mayor a 1)
                print("[AREA ]", area)

            if aspect_ratio > AR_MIN and aspect_ratio < AR_MAX and area > AREA_MIN and area < AREA_MAX:
                if MOSTRAR:
                    print("RESOLUCION: ",alto,"x",ancho)
                #Almacenar contorno de la matricula
                self.contornoPlaca = c
                #Extraemos el ROI antes de la umbralización y la limpieza de bordes
                self.licensePlate = self.imagen_acondicionada[y:y + h, x:x + w]
                self.ventana.mostrarIMG("ROI",self.licensePlate)
                break
                
            else:
                print("CONTORNO NO VALIDO")
        else:
            print("NO SE ENCONTRO NINGUN CONTRONO")
            self.licensePlate = None
    
    def iniciarLocalizacion(self):
        self.segmentarImagen()
        self.enlistarContornos()
        self.localizarMatricula()
        return self.licensePlate
