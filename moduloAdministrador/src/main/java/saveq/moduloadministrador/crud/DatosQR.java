package saveq.moduloadministrador.crud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DatosQR {
    public String obtener_datosQR(String matricula_salida){
        //Crea la conexion a la base de datos para conseguir los datos
        ConexionBaseDatos conexion=new ConexionBaseDatos();
        //La consulta para la base de datos
        String sql="select matricula,fecha_entrada,hora_entrada from automovil where matricula=?";
        String [] datos= new String[3];

        //Ejecuta la setencia
        try{
            PreparedStatement ps=conexion.establecer_conexion().prepareStatement(sql);
            ps.setString(1,matricula_salida);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
            }
            JOptionPane.showMessageDialog(null,"Se registro la salida correctamente"+datos[0]+datos[1]+datos[2]);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
        }
        return datos[0]+","+datos[1]+","+datos[2];    
    }    
}
