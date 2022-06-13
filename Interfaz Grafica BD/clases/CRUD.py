import psycopg2
import time
from datetime import datetime
import tarifa as tf

class CRUD:
    def __init__(self):
        tarf=tf.tarifa()
        self.tarifa=tarf.tarifa
    #Conecta a la base de datos

    def conexion_bd(self):
        conexion=psycopg2.connect(
            user='postgres',
            password='1234',
            host='localhost',
            port='5432',
            database='estacionamiento_db')
        return conexion
    #Obtiene la fecha actual del sistema
    def fecha(self):
        fecha=time.strftime("%d/%m/%Y")
        return fecha
    #Obtiene la hora actual de la hora de entrada
    def hora(self):
        hora=time.strftime("%H:%M:%S",time.localtime())
        #print(hora)
        return hora
    #formato
    def f_hora(self,hora):
        hora=datetime.strptime(hora,'%H:%M:%S')
        return hora
    #gormato
    def f_timestamp(self,fecha,hora):
        fecha=str(fecha)+" "+str(hora)
        timestamp=datetime.strptime(fecha,'%Y-%m-%d %H:%M:%S')
        return timestamp

    def registro_entrada(self,placa):
        conexion=self.conexion_bd()
        cursor=conexion.cursor()
        query="INSERT INTO automovil(placa,fecha_entrada,hora_entrada) values(%s,%s,%s)"
        placa=placa
        fecha_entrada=self.fecha()
        hora_entrada=self.hora()
        datos=(placa,fecha_entrada,hora_entrada)
        cursor.execute(query,datos)
        conexion.commit()
        cursor.close()
        conexion.close()

    #Actualiza en la base de datos la hora y fecha de salida.
    def registro_salida(self,placa):
        hora_sal=self.hora()
        #print(hora_sal)
        fecha_salida=self.fecha()
        #print(fecha_salida)
        conexion=self.conexion_bd()
        cursor=conexion.cursor()
        query = f"UPDATE automovil SET hora_salida = '{hora_sal}', fecha_salida= '{fecha_salida}' WHERE placa = '{placa}'"
        cursor.execute(query)
        conexion.commit() 
        cursor.close()
        conexion.close()
    
    #Muestra la base de datos.
    def mostrar_bd(self):
        conexion=self.conexion_bd()
        try:
            with conexion:
                with conexion.cursor() as cursor:
                    setencia="SELECT * FROM automovil"
                    cursor.execute(setencia)
                    registros=cursor.fetchall()
        except Exception as e:
            print(f'Ocurrio un error: {e}')   
        finally:
            conexion.close()
        return registros
    #Compara si ha pasado un dia o mas
    def compracion_fechas(self,placa):
        conexion=self.conexion_bd()
        try:
            with conexion:
                with conexion.cursor() as cursor:
                    query=f"SELECT fecha_entrada,fecha_salida FROM automovil WHERE placa = '{placa}' "
                    cursor.execute(query)
                    registros=cursor.fetchall()
        except Exception as e:
            print(f'Ocurrio un error: {e}')   
        finally:
            if(registros[0][0]!=registros[0][1]):
                return True
            else:
                return False
        

    #Obtiene el tiempo que permanecio un auto estacionado.
    def tiempo_estacionado(self,placa):
        conexion=self.conexion_bd()
        #auxiliar contiene el falso o veradero y los registros en caso de ser verdadero
        aux=self.compracion_fechas(placa)
        #print(aux)
        try:
            with conexion:
                with conexion.cursor() as cursor:
                    query=f"SELECT fecha_entrada,fecha_salida,hora_entrada,hora_salida FROM automovil WHERE placa = '{placa}' "
                    cursor.execute(query)
                    registros=cursor.fetchall()
        except Exception as e:
            print(f'Ocurrio un error: {e}')   
        finally:
            #print(registros)
            if aux:
                fecha_entrada=self.f_timestamp(registros[0][0],registros[0][2])
                fecha_salida=self.f_timestamp(registros[0][1],registros[0][3])
                dias_estacionado=fecha_salida-fecha_entrada
                str_dias=str(dias_estacionado)
                dias=str_dias.split()
                #print(dias)
                dias_horas=int(dias[0])*24
                #print(dias_horas)
                dia=dias[2]
                dias_horas=dias_horas+int(dia[0])
                dias_horas=str(dias_horas)+dia[1:]
                #print(dias_horas)
                #print(dia)
                #print(dias_estacionado)
                conexion.close()
                return dias_horas
            else:
                hora_entrada=self.f_hora(str(registros[0][2]))
                hora_salida=self.f_hora(str(registros[0][3]))
                horas_estacionado=hora_salida-hora_entrada
                conexion.close()
                return str(horas_estacionado)
    #Obtiene el pago a realizar
    def pago_tarifa(self,placa):
        tiempo=self.tiempo_estacionado(placa)
        tiempo=str(tiempo)
        tiempo=tiempo.split(sep=":")
        tiempo_hora=int(tiempo[0])
        #condicion para calcular si se pasa de una hora.
        tiempo_min=int(tiempo[1])
        if tiempo_min>0:
            tiempo_hora=tiempo_hora+1
        pago_total=int(self.tarifa)*tiempo_hora
        return pago_total
    #registra en la base de datos la cantidad a pagar
    def registro_pago(self,placa):
        pago=self.pago_tarifa(placa)
        conexion=self.conexion_bd()
        cursor=conexion.cursor()
        query=f"UPDATE automovil SET pago='{pago}' WHERE placa = '{placa}'"
        cursor.execute(query)
        conexion.commit() 
        cursor.close()
        conexion.close() 

# tarifa_pago=tf.tarifa()
# datos=CRUD()
# print(datos.mostrar_bd())
# datos.registro_entrada("enrique1")
# datos.registro_salida("enrique1")
# datos.registro_salida("enrique")
# datos.registro_pago("enrique")


# print(datos.tiempo_estacionado("enrique1"))
