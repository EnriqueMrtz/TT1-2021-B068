/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saveq.moduloPago.Tarifa;
import javax.swing.JOptionPane;
import saveq.moduloPago.Validaciones.Validaciones;

/**
 *
 * @author Micha
 */
public class Tarifa {
    private String tarifa="5"; // cantidad a pagar

    public String getTarifa() {
        return tarifa;
    }

    // asignar la tarifa de estacionamiento
    public void setTarifa(String tarifa) {
        Validaciones valido = new Validaciones();
        if(valido.validacion_numero(tarifa).equals(true)){
            this.tarifa = tarifa;
            JOptionPane.showMessageDialog(null,"Se cambio la tarifa correctamente");
        }else{
            JOptionPane.showMessageDialog(null,"La tarifa debe ser un número");
        }
    }
    
}
