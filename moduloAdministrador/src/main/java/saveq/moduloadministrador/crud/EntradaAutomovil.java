package saveq.moduloadministrador.crud;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import saveq.moduloadministrador.horario.Fecha;
import saveq.moduloadministrador.horario.Hora;
import saveq.moduloadministrador.Validaciones.Validaciones;



public class EntradaAutomovil {
    
    public void entrada_automovil(JTextField matricula_entrada){
        
        Hora hora=new Hora();
        Fecha fecha=new Fecha();
        Automovil automovil_entrada=new Automovil();
        automovil_entrada.setMatricula(matricula_entrada.getText());
        Validaciones valido= new Validaciones();
        //Para evitar que inserten nulos
        if(valido.validacion_vacia(automovil_entrada.getMatricula()).equals(true)){
            JOptionPane.showMessageDialog(null,"Escriba una matrícula");
            
        }
        else if(valido.validacion_salida(automovil_entrada.getMatricula()).equals(true)){
            JOptionPane.showMessageDialog(null,"La matricula ya existe y no ha salido.");
        }  
        //Conexion base de datos
        else{
            ConexionBaseDatos conexion=new ConexionBaseDatos();
            //Consulta para la base da datos
            String sql="insert into automovil (matricula,fecha_entrada,hora_entrada,status_pago,status_salida) values (?,?,?,'no pagado','false')";
            try{
                CallableStatement cs= conexion.establecer_conexion().prepareCall(sql);
                cs.setString(1, automovil_entrada.getMatricula());
                cs.setString(2, fecha.getfecha());
                cs.setString(3,hora.gethora());
                cs.execute();

                JOptionPane.showMessageDialog(null,"Se registro la entrada correctamente");

            }catch(Exception e){
                 JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
            }
        }
    }
    
}
