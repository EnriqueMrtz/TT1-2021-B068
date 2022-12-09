package saveq.moduloadministrador.horario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Micha
 */
public class Fecha {
    private final LocalDate fecha=LocalDate.now();

    public String getfecha(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fecha_string= fecha.format(formatter);
        return fecha_string;
    }
    
}
