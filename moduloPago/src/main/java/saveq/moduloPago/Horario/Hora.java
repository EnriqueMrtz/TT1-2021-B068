package saveq.moduloPago.Horario;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Micha
 */
public class Hora {
    private final LocalTime hora=LocalTime.now();
    
    /* Obtener la hora local de la computadora */
    public String gethora(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss ");
        String hora_string = hora.format(formatter);
        return hora_string;
    }   
}
