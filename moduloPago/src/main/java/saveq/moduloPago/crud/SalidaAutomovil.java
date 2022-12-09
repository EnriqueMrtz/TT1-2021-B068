/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saveq.moduloPago.crud;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import saveq.moduloPago.Horario.Fecha;
import saveq.moduloPago.Horario.Hora;
import saveq.moduloPago.Validaciones.Validaciones;

/**
 *
 * @author Micha
 */
public class SalidaAutomovil {
    public void salida_automovil(String matricula_salida){
        Hora hora = new Hora();
        Fecha fecha = new Fecha();
        
        Automovil automovil_salida = new Automovil();
        automovil_salida.setMatricula(matricula_salida);
        
        Validaciones valido = new Validaciones();
        //Para evitar que inserten nulos
        if(valido.validacion_vacia(automovil_salida.getMatricula()).equals(true)){
            JOptionPane.showMessageDialog(null,"Escriba una matrícula");
            
        }else if(valido.validacion_dato_existente(automovil_salida.getMatricula()).equals(true)){
            // Cambiar el estatus de la matricula a "pagado"
            ConexionBaseDatos conexion = new ConexionBaseDatos();
            String sql = "update automovil set fecha_salida=?, hora_salida=?, status_pago='pagado' where matricula=? and status_salida='false';";
            try{
                CallableStatement cs= conexion.establecer_conexion().prepareCall(sql);
                cs.setString(1, fecha.getfecha());
                cs.setString(2,hora.gethora());
                cs.setString(3, automovil_salida.getMatricula());
                cs.execute();
                JOptionPane.showMessageDialog(null,"Se registro la salida correctamente");

            }catch(Exception e){
                 JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
            }
        }else{
            JOptionPane.showMessageDialog(null,"No existe la matrícula");
        }
    }
}
