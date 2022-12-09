package saveq.moduloadministrador.crud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class DatoExistente {
    private Boolean existe=false;
    
    public Boolean consultar(String cadena){
        //Crear conexion a base de datos
        ConexionBaseDatos conexion=new ConexionBaseDatos();
        //Consulta en la base de datos
        String sql="select matricula,status_salida from automovil where matricula=?";
        String  dato []= new String[2]; 
        //Ejecutar setencia
        try{
            PreparedStatement ps=conexion.establecer_conexion().prepareStatement(sql);
            ps.setString(1,cadena);
            
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                dato[0]=rs.getString(1);   
                dato[1]=rs.getString(2);
            }
            
            //JOptionPane.showMessageDialog(null,"Se registro la salida correctamente"+dato[0]);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
        }
        if (dato[0]==null){
            return existe= false;
            
        }else{
            if(dato[1].equals(true)){
                return existe=false;
            }else{
                return existe=true;
            }
        }
    }
   
}
