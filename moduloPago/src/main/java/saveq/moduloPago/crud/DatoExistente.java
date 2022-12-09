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
public class DatoExistente {
    private Boolean existe = false;
    
    // Consultar la existencia de la matricula a la hora de salir
    public Boolean consultar(String cadena){
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        String sql = "select matricula,status_salida from automovil where matricula=?";
        String dato [] = new String[2]; 
        try{
            PreparedStatement ps = conexion.establecer_conexion().prepareStatement(sql);
            ps.setString(1,cadena);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dato[0] = rs.getString(1);   
                dato[1] = rs.getString(2);
            }
            //JOptionPane.showMessageDialog(null,"Se registro la salida correctamente"+dato[0]);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
        }
        
        if (dato[0]==null){
            return existe = false;
        }else{
            if(dato[1].equals(true)){
                return existe = false;
            }else{
                return existe = true;
            }
        }
    }

}
