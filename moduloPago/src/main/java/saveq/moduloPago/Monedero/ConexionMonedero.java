package saveq.moduloPago.Monedero;

import com.fazecast.jSerialComm.*;

public class ConexionMonedero{
    //Variables para configurar la conexion serial
    private int BaudRate = 9600;
    private int DataBits = 8;
    private int StopBits = SerialPort.ONE_STOP_BIT;
    private int Parity   = SerialPort.NO_PARITY;
    //Variables para obtener la suma del dinero ingresado
    private String tarifa;
    private String cadena_numero = "";
    private int suma_cantidad = 0;
    private Boolean señal_pago = false;

    public Boolean getSeñal_pago() {
        return señal_pago;
    }

    public ConexionMonedero(String tarifa){
        this.tarifa = tarifa;
    }
    
    public int getCantidadMonedero(){
        return suma_cantidad;
    }
    
    public void iniciar_lecturaMonedero(){
        //Convertir string tarifa a entero para su comparacion.
        int numTarifa = Integer.valueOf(tarifa);
        SerialPort [] AvailablePorts = SerialPort.getCommPorts();
        System.out.println("\n\n Entrada de Datos Seriales");
        
        // Se imprimen los puertos seriales disponibles
        System.out.print("\n\n Available Ports ");
        for (int i = 0; i<AvailablePorts.length ; i++){
            System.out.println(i + " - " + AvailablePorts[i].getSystemPortName() + " -> " + AvailablePorts[i].getDescriptivePortName());
        }
        
        //Se abre el segundo puerto disponible
        SerialPort MySerialPort = AvailablePorts[0];
        
        //Se establecen los parametros de la conexion
        MySerialPort.setComPortParameters(BaudRate,DataBits,StopBits,Parity);
        MySerialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 0); //Set Read Time outs
        MySerialPort.openPort(); //Se abre el puerto
        if (MySerialPort.isOpen()){
    		System.out.println("\n" + MySerialPort.getSystemPortName() + " Abierto ");
        }else{
   		System.out.println(" Puerto no abierto ");
        }
        
        //Se despliega en pantalla los parametros de la conexion
      	System.out.println("\n Puerto seleccionado               = " + MySerialPort.getSystemPortName());
      	System.out.println(" Baud rate seleccionado          = " + MySerialPort.getBaudRate());
        System.out.println(" Numero de bits = " + MySerialPort.getNumDataBits());
      	System.out.println(" Numero de bit de parada = " + MySerialPort.getNumStopBits());
      	System.out.println(" Tipo de paridad             = " + MySerialPort.getParity());
      	System.out.println(" Tiempos muertos del lectura      = " + MySerialPort.getReadTimeout() + "mS");

      	MySerialPort.flushIOBuffers();

      	try{
            while (suma_cantidad < numTarifa){
                byte[] readBuffer = new byte[12];
                int numRead = MySerialPort.readBytes(readBuffer, readBuffer.length);
                System.out.println("Leido " + numRead + " bytes -");
                String S = new String(readBuffer, "UTF-8"); //Convierte bytes a cadena
                
                if(numRead == 12){
                    cadena_numero = S.substring(5,10);
                    suma_cantidad = suma_cantidad + Integer.valueOf(cadena_numero);
                    System.out.println("Cadena -> " + cadena_numero);
                    System.out.println("Numero -> " + suma_cantidad);
                }
            }
            señal_pago=true;
	}catch (Exception e){
            e.printStackTrace(); 
        }

      	MySerialPort.closePort(); //Se cierra el puerto

      	if (MySerialPort.isOpen()){
            System.out.println(MySerialPort.getSystemPortName() + " Abierto ");
        }else{
            System.out.println("\n Puerto no abierto ");
        }
    }
}
