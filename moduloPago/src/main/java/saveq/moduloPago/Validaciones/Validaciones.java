/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saveq.moduloPago.Validaciones;


import saveq.moduloPago.crud.DatoExistente;

/**
 *
 * @author Micha
 */
public class Validaciones {
    private Boolean valido = false;

    public Boolean getValido() {
        return valido;
    }
    
    public Boolean validacion_vacia(String cadena){
        if(cadena.equals("")){
            return valido = true;
        }else
            return valido = false;
    }
    
    public Boolean validacion_cadena(){
        return valido;
    }
    
    public Boolean validacion_numero(String cadena){
        try{
            Integer.parseInt(cadena);
            valido = true;
        }catch(NumberFormatException exception){
            valido = false;
        }
         return valido;
    }
    
    public Boolean validacion_dato_existente(String cadena){
        DatoExistente datos = new DatoExistente();       
        valido = datos.consultar(cadena);
        return valido;
    }
    public Boolean validacion_salida(String cadena){
        DatoExistente datos = new DatoExistente();       
        valido = datos.consultar(cadena);
        return valido;
    }
}
