from ActivadorCamara import *
from AcondicionadorFotos import *
from SegementadorImagen import *
from DelimitadorTexto import *
from VisualizadorImagenes import *
from PreprocesamientoROI import *
from GeneradorQR import *
from Config import *
from Cliente import *
if __name__ == "__main__":
    #Variables
    captura_camara = 0
    llaveQR = 0
    #Objetos
    acondisionarImagen = 0
    segmentarImagen =  0
    delimitarTexto = 0
    processROI = 0
    cliente = 0
    ventana = VisualizadorImagenes()
    now = datetime.now()

    #Inicio codigo
    if(TOMARCAPTURA):   #Si TOMARCATURA es verdadero habilitara el uso de la camara
        actCamara = ActivadorCamara()
        actCamara.tomar_captura()
        captura_camara = actCamara.getFoto()
        acondisionarImagen = AcondicionadorFotos(captura_camara)
    else:   #En caso contrario usara el path de un archivo de foto
        acondisionarImagen = AcondicionadorFotos(PATH_FOTO)

    #Iniciar acondicionamiento de la imagen de entrada
    imagen_acondisionada = acondisionarImagen.redimensionar_y_recortar()
    #Iniciar segmendacion de la imagen acondisionada
    segmentarImagen = SegmentadorImagen(imagen_acondisionada)
    imagen_roi = segmentarImagen.iniciarLocalizacion()

    if(imagen_roi is not None):
        img_name = "roi/{}_{}.png".format(now.date(),now.timestamp())
        cv2.imwrite(img_name, imagen_roi)
        delimitarTexto = DelimitadorTexto(imagen_roi)
        #La variable "imagen_delimTexto" es una imagen con el texto de la matricula, quita el texto basura del porta placas o de la placa misma
        imagen_delimTexto = delimitarTexto.detectarTexto()
        ventana.mostrarIMG("TEXTO DELIMITADO",imagen_delimTexto)
        #Aqui seguiria el procesamiento para imagen_delimTexto y apliocar el OCR
        processROI = PreprocesamientoROI(imagen_delimTexto)
        caracteres_encontrados = processROI.iniciarProcesamiento()
        print("CARACTERES ENCONTRADOS: ", caracteres_encontrados)
        if(CLISERV):
            cliente = Cliente(caracteres_encontrados)
            llaveQR = cliente.iniciarCliente()
            imagenQR = GeneradorQR(llaveQR)
            imagenQR.generarQR()


    else:
        print("NO SE ENCONTRO NINGUNA MATRICULA PARA ANALIZAR")

        