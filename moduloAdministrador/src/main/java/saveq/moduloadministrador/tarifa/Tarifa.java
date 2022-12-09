/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saveq.moduloadministrador.tarifa;
import javax.swing.JOptionPane;
import saveq.moduloadministrador.Validaciones.Validaciones;

/**
 *
 * @author Micha
 */
public class Tarifa {
    private String tarifa="5";

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        Validaciones valido=new Validaciones();
        if(valido.validacion_numero(tarifa).equals(true)){
            this.tarifa = tarifa;
            JOptionPane.showMessageDialog(null,"Se cambio la correctamente");
        }else{
            JOptionPane.showMessageDialog(null,"La tarifa debe ser un número");
        }
    }
    
}
