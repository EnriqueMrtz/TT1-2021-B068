/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package saveq.moduloPago;
import saveq.moduloPago.Interfaz.InterfazLeerQRDesdeCamaraWeb;
import saveq.moduloPago.Interfaz.InterfazPagar;

/**
 *
 * @author Micha
 */
public class ModuloPago {

    public static void main(String[] args) {
 
        /* Crear y mostrar la aplicación */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazLeerQRDesdeCamaraWeb().setVisible(true);
                //new InterfazPagar("daniela").setVisible(true);
            }
        });
    }

}
