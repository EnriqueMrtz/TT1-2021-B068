package saveq.moduloadministrador;
import java.io.IOException;
import saveq.moduloadministrador.Interfaces.InterfazInicio;

public class ModuloAdministrador {

    public static void main(String[] args)  throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazInicio().setVisible(true);
            }
        });

    }
}
