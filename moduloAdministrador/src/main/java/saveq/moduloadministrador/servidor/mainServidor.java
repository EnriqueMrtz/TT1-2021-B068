
package saveq.moduloadministrador.servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextField;
import saveq.moduloadministrador.crud.DatosQR;
import saveq.moduloadministrador.crud.EntradaAutomovil;


public class mainServidor {
    public static void main(String[] args) throws IOException{
        EntradaAutomovil automovil_entrada= new EntradaAutomovil();
        DatosQR datos= new DatosQR();
        try{
            ServerSocket ss= new ServerSocket(8050);
            System.out.println("Iniciando servidor");
            for(;;){
            Socket cl= ss.accept();
            System.out.println("Conexion establecida con cliente");              
            String mensaje="Conexion terminada";
            PrintWriter pw= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            pw.print(mensaje);
            pw.flush();


            //leer la cadena que envia el cliente

            BufferedReader entrada = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            String matricula_servidor = entrada.readLine();
            System.out.println("Matricula recibida: "+matricula_servidor);
            System.out.println("Fin de la conexión con cliente");
            //LLamar al cliente para darlo de alta
            automovil_entrada.entrada_automovil(new JTextField(matricula_servidor));

            pw.flush();
            //Cerrar conexiones
            pw.close();
            cl.close();
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
