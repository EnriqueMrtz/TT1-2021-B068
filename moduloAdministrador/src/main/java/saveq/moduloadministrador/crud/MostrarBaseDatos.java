package saveq.moduloadministrador.crud;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarBaseDatos {
    
    public void mostrar_entradas(JTable Tabla){
        //Conxion a la base de datos
        ConexionBaseDatos conexion= new ConexionBaseDatos();
        DefaultTableModel modelo= new DefaultTableModel();
        //Creacion de las columnas para mostrar en pantalla
        modelo.addColumn("matrícula");
        modelo.addColumn("fecha_entrada");
        modelo.addColumn("hora_entrada");
        modelo.addColumn("status_pago");
//        modelo.addColumn("terminal");
        //Consulta en la base de datos
        String sql="select matricula,fecha_entrada,hora_entrada,status_pago from automovil";
        String [] datos= new String[4];
        Statement setencia_sql;
        
        //Ejecucion de la consulta
        try{
            setencia_sql=conexion.establecer_conexion().createStatement();
            ResultSet rs = setencia_sql.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
//                datos[4]=rs.getString(5);
                modelo.addRow(datos);
            }
            Tabla.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
        }
        
    }
    
    public void mostrar_salidas(JTable Tabla){
        //Conxion a la base de datos
        ConexionBaseDatos conexion= new ConexionBaseDatos();
        DefaultTableModel modelo= new DefaultTableModel();
         //Creacion de las columnas para mostrar en pantalla
        modelo.addColumn("matrícula");
        modelo.addColumn("fecha_salida");
        modelo.addColumn("hora_salida");
        modelo.addColumn("status_salida");
//        modelo.addColumn("terminal");
        //Consulta en la base de datos
        String sql="select matricula,fecha_salida,hora_salida,status_salida from automovil where status_pago='pagado'";
        String [] datos= new String[4];
        Statement setencia_sql;
        
        //Ejecucion de la consulta
        try{
            setencia_sql=conexion.establecer_conexion().createStatement();
            ResultSet rs = setencia_sql.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
//                datos[4]=rs.getString(5);
                modelo.addRow(datos);
            }
            Tabla.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
        }
        
    }
    
}
