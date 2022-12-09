package saveq.moduloPago.Horario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Micha
 */
public class Fecha {
    private final LocalDate fecha=LocalDate.now();

    /* Obtener la fecha local de la computadora */
    public String getfecha(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha_string= fecha.format(formatter);
        return fecha_string;
    }
    
}
