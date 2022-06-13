import socket
import sys
import CRUD as bd

#Instancia de la clase de CRUD
registro=bd.CRUD()

#Variables
host = "0.0.0.0"
port = 8050

# Creando el socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Enlace de socket y puerto
server_address = (host, port)
print('Conectado en {} puerto {}'.format(*server_address))
sock.bind(server_address)

# Escuchando conexiones entrantes
sock.listen(1)

while True:
    # Esperando una conexion
    print('Esperando a conectarse')
    connection, client_address = sock.accept()
    try:
        print('Conectado desde:', client_address)

        # Recibir los datos en pequeños fragmentos y retransmitirlos
        while True:
            data = connection.recv(10)
            if data:
                matricula = data.decode('UTF-8')
                registro.registro_entrada(matricula)
                fecha=registro.fecha()
                hora=registro.hora()
                print('Recibido: ', matricula)
                print('Enviar datos de vuelta al cliente')
                #enviar QR.
                llaveQR = "%s,%s,%s" % (matricula,fecha,hora)
                print(llaveQR)
                message = bytes(llaveQR,'UTF-8')
                connection.sendall(message)
            else:
                print('No hay mas datos', client_address)
                break

    finally:
        # Cerrando conexion
        connection.close()