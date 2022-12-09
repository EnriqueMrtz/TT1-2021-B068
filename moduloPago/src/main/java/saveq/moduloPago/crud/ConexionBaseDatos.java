/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saveq.moduloPago.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Micha
 */
public class ConexionBaseDatos {
    private Connection conexion=null;
    private final String usuario="postgres";
    private final String contraseña="1234";
    private final String base_datos="estacionamiento_db";
    private final String ip="localhost";
    private final String puerto="5432";
    private final String cadena="jdbc:postgresql://"+ip+":"+puerto+"/"+base_datos;
    public Connection establecer_conexion(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection(cadena,usuario,contraseña);
//            JOptionPane.showMessageDialog(null,"Se conecto correctamente a la base de datos");
              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos error:"+e.toString());
        }
        return conexion;
    }
           
}
