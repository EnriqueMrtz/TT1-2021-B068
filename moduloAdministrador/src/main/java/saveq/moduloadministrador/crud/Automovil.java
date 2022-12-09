package saveq.moduloadministrador.crud;

public class Automovil {

    private String id_matricula;
    private String matricula;
    private String fecha_entrada;
    private String fecha_salida;
    private String hora_entrada;
    private String hora_salida;
    private int pago;
    private Boolean status_pago;
    
    public String getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(String id_matricula) {
        this.id_matricula = id_matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public Boolean getStatus_pago() {
        return status_pago;
    }

    public void setStatus_pago(Boolean status_pago) {
        this.status_pago = status_pago;
    }
}
