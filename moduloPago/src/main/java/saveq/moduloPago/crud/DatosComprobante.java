/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saveq.moduloPago.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Micha
 */
public class DatosComprobante {
    
        public String obtener_datosQR(String matricula_salida){
        // Obtener los datos de la matricula de la base de datos
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        String sql = "select matricula,hora_entrada,fecha_salida,hora_salida from automovil where matricula=?";
        String [] datos = new String[4];
        String datos_comprobante = null;
        
        try{
            PreparedStatement ps=conexion.establecer_conexion().prepareStatement(sql);
            ps.setString(1,matricula_salida);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                
            }
            //JOptionPane.showMessageDialog(null,"Se registro la salida correctamente"+datos[0]+datos[1]+datos[2]);
            datos_comprobante="Comprobante estacionamiento"+" , matricula: "+datos[0]+" , cantidad pagada:"+" , fecha: "+datos[2]+" , hora de entrada :"+datos[1]+" , hora de salida: "+datos[3];
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
        }
        return datos_comprobante;       
    }
}
