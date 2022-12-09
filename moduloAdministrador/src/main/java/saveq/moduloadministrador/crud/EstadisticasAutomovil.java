package saveq.moduloadministrador.crud;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EstadisticasAutomovil {
    //Funcion que obtiene los registros totales en la base de datos
    public String registro_totales(){
        //Conexion a  la base de datos
        ConexionBaseDatos conexion= new ConexionBaseDatos();
        //Consulta de la base de datos
        String sql="select count(*) from automovil";
        String  num_registros= new String();
        Statement setencia_sql;


        try{
            setencia_sql=conexion.establecer_conexion().createStatement();
            ResultSet rs = setencia_sql.executeQuery(sql);
            while(rs.next()){
               num_registros=rs.getString(1);

            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
       }
       return num_registros;
    }
    //Funcion que contiene los registros de los autos estacionados
    public String registro_estacionados(){
        ConexionBaseDatos conexion= new ConexionBaseDatos();
        String sql="select count(*) from automovil where status_salida='false'";
        String  num_estacionados= new String();
        Statement setencia_sql;


        try{
            setencia_sql=conexion.establecer_conexion().createStatement();
            ResultSet rs = setencia_sql.executeQuery(sql);
            while(rs.next()){
               num_estacionados=rs.getString(1);

            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
       }
       return num_estacionados;
    }
}
