package saveq.moduloadministrador.crud;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import saveq.moduloadministrador.horario.Fecha;
import saveq.moduloadministrador.horario.Hora;
import saveq.moduloadministrador.Validaciones.Validaciones;


public class SalidaAutomovil {
    public void salida_automovil(JTextField matricula_salida){
        Hora hora=new Hora();
        Fecha fecha=new Fecha();
        
        Automovil automovil_salida=new Automovil();
        automovil_salida.setMatricula(matricula_salida.getText());
        
        Validaciones valido= new Validaciones();
        //Para evitar que inserten nulos
        if(valido.validacion_vacia(automovil_salida.getMatricula()).equals(true)){
            JOptionPane.showMessageDialog(null,"Escriba una matrícula");
            
        }else if(valido.validacion_dato_existente(automovil_salida.getMatricula()).equals(true)){
            //Conexion a la base de datos
            ConexionBaseDatos conexion=new ConexionBaseDatos();
            //Consulta la base de datos
            String sql="update automovil set fecha_salida=?, hora_salida=?, status_pago='pagado' where matricula=? and status_salida='false';";
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
