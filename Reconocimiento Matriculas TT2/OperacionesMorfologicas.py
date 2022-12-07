import cv2
import numpy as np


class OperacionesMorfologicas():

    def realizarUmbralizacionAdaptativa(self,imagen_entrada):
       imagen_umbral = cv2.adaptiveThreshold(imagen_entrada,255,cv2.ADAPTIVE_THRESH_GAUSSIAN_C,cv2.THRESH_BINARY,11,12)
       return imagen_umbral

    def realizarBlackhat(self,imagen_entrada):
        rectKernel=cv2.getStructuringElement(cv2.MORPH_RECT,(20,10))         #Se crea un elemento estructurante (kernel)                                                                        #en el cual el tamaño imita al de una placa
        imagen_blackhat=cv2.morphologyEx(imagen_entrada,cv2.MORPH_BLACKHAT,rectKernel)    #Resalta las partes negras que tienen fondo blanco 
        return imagen_blackhat

    def realizarTophat(self,imagen_entrada):
        rectKernel=cv2.getStructuringElement(cv2.MORPH_RECT,(20,10))         #Se crea un elemento estructurante (kernel)                                                                        #en el cual el tamaño imita al de una placa
        imagen_tophat=cv2.morphologyEx(imagen_entrada,cv2.MORPH_TOPHAT,rectKernel)    #Resalta las partes negras que tienen fondo blanco 
        return imagen_tophat
    
    def realizarOperacionCierre(self,imagen_entrada,n,m):
        kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (n, m))    #Usamos un nucleo cuadrado pequeño
        imagen_cerrada= cv2.morphologyEx(imagen_entrada,cv2.MORPH_CLOSE,kernel)
        return imagen_cerrada

    def realizarOperacionApertura(self,imagen_entrada,n,m):
        kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (n, m))    #Usamos un nucleo cuadrado pequeño
        imagen_cerrada= cv2.morphologyEx(imagen_entrada,cv2.MORPH_OPEN,kernel)
        return imagen_cerrada

    def realizarFiltroGaussiano(self,imagen_entrada):
        imagen_gaussiana = cv2.GaussianBlur(imagen_entrada,(5,5),0)
        return imagen_gaussiana
    
    def realizarUmbralizacion(self,imagen_entrada,m,n,metodo):
        imagen_umbralizada = cv2.threshold(imagen_entrada, m, n,metodo)[1]     #Metodo Otsu
        return imagen_umbralizada

    def realizarCanny(self,imagen_entrada):
        gradX = cv2.Sobel(imagen_entrada, ddepth=cv2.CV_32F,dx=1, dy=0, ksize=-1)   
        gradX = np.absolute(gradX)      
        (minVal, maxVal) = (np.min(gradX), np.max(gradX))
        gradX = 255 * ((gradX - minVal) / (maxVal - minVal))        
        gradX = gradX.astype("uint8")
        return gradX
    
    def realizarErosion(self,imagen_entrada,n):
        imagen_erosionada = cv2.erode(imagen_entrada, None, iterations=n)
        return imagen_erosionada

    def realizarDilatacion(self,imagen_entrada,n):
        imagen_dilatada= cv2.dilate(imagen_entrada, None, iterations=n)
        return imagen_dilatada
    
    def realizarOperacionAnd(self,umbral1,umbral2,mascara):
        imagen_and=cv2.bitwise_and(umbral1, umbral2, mask=mascara)
        return imagen_and