import sys
import socket
from Config import *

class Cliente:
    def __init__(self, caracteresEncontrados):
        self._caracteresEncontrados = caracteresEncontrados

    def iniciarCliente(self):
        # Creando un socket TCP/IP
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

        # Conecta el socket en el puerto cuando el servidor esté escuchando
        server_address = (HOST, PORT)
        print('Conectado a {} puerto {}'.format(*server_address))
        sock.connect(server_address)

        try:
            # Enviando datos
            mensaje = self._caracteresEncontrados
            message1 = mensaje.encode("UTF8")
            print('Enviando: {!r}'.format(message1))
            sock.send(message1)
            
            print("Esperando datos:")
            data = sock.recv(512)
            print('Recibido: {!r}'.format(data))
            

        finally:
            print('Cerrando socket')
            sock.close()
        
        return self._caracteresEncontrados