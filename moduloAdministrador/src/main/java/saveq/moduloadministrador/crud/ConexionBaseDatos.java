package saveq.moduloadministrador.crud;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionBaseDatos {
    private Connection conexion=null;
    private final String usuario="saveq.admin";
    private final String contraseña="1234";
    private final String base_datos="saveq.matriculas";
    private final String ip="localhost";
    private final String puerto="5432";
    private final String cadena="jdbc:postgresql://"+ip+":"+puerto+"/"+base_datos;
    //Conexion a la base de datos
    public Connection establecer_conexion(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion=DriverManager.getConnection(cadena,usuario,contraseña);
              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos error:"+e.toString());
        }
        return conexion;
    }
           
}
