from base64 import decode
import socket
from config import *

class Cliente:
    def __init__(self, caracteresEncontrados):
        self._caracteresEncontrados = caracteresEncontrados
        self._llaveQR = ""

    def iniciarCliente(self):
        # Creando un socket TCP/IP
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

        # Conecta el socket en el puerto cuando el servidor esté escuchando
        server_address = (HOST, PORT)
        print('Conectado a {} puerto {}'.format(*server_address))
        sock.connect(server_address)

        try:
            # Enviando datos
            message1 = bytes(self._caracteresEncontrados,'UTF-8')
            print('Enviando {!r}'.format(self._caracteresEncontrados))
            sock.sendall(message1)

            # Buscando respuesta
            amount_received = 0
            amount_expected = len(self._caracteresEncontrados)
            
            while amount_received < amount_expected:
                data = sock.recv(1024)
                amount_received += len(data)
                print('Recibido {!r}'.format(data))
                self._llaveQR = data.decode("UTF-8")

        finally:
            print('Cerrando socket')
            sock.close()
        
        return self._llaveQR