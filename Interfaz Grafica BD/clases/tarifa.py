class tarifa:
    def __init__(self):
        self.tarifa=self.carga_tarifa()
    
    def carga_tarifa(self):
        archivo=open("C:/Users/Mgima/Desktop/BD/clases/tarifa/tarifa.txt","r")
        self.tarifa=archivo.read()
        archivo.close()
        return self.tarifa

    def cambiar_tarifa(self,nueva_tarifa):
        archivo=open("C:/Users/Mgima/Desktop/BD/clases/tarifa/tarifa.txt","w")
        archivo.write(str(nueva_tarifa))
        archivo.close()
        self.tarifa=self.carga_tarifa()
        return self.tarifa





#tarifa_pago=tarifa()
# tarifa.cambiar_tarifa(55544)
# print(tarifa.tarifa)
# tarifa.cambiar_tarifa(9999)
#print(tarifa_pago.tarifa)