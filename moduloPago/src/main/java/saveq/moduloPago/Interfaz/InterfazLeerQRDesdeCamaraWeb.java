/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package saveq.moduloPago.Interfaz;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import saveq.moduloPago.Horario.Fecha;
import saveq.moduloPago.Horario.Hora;

/**
 *
 * @author malin
 */
public class InterfazLeerQRDesdeCamaraWeb extends javax.swing.JFrame implements Runnable, ThreadFactory {

    /* Variables para obtener la cámara y visualizarla */
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public InterfazLeerQRDesdeCamaraWeb() {
        initComponents(); // Inicializar componentes de la interfaz
        initWebcam(); // Inicializar la cámara web
        
        /* Obtener fecha y hora */
        Hora hora=new Hora();
        label_hora.setText(hora.gethora());
        Fecha fecha=new Fecha();
        label_fecha.setText(fecha.getfecha());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panel_barraSuperior = new javax.swing.JPanel();
        label_hora = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        camara_web = new javax.swing.JLabel();
        panel_qr = new javax.swing.JPanel();
        panel_camara = new javax.swing.JPanel();
        texto_colocar = new javax.swing.JLabel();
        campo_matricula = new javax.swing.JLabel();
        panel_instrucciones = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(0, 0, 0));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_barraSuperior.setBackground(new java.awt.Color(0, 0, 0));

        label_hora.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        label_hora.setForeground(new java.awt.Color(255, 255, 255));
        label_hora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_reloj.png"))); // NOI18N
        label_hora.setText("hora");

        label_fecha.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        label_fecha.setForeground(new java.awt.Color(255, 255, 255));
        label_fecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_calendario.png"))); // NOI18N
        label_fecha.setText("fecha");

        javax.swing.GroupLayout panel_barraSuperiorLayout = new javax.swing.GroupLayout(panel_barraSuperior);
        panel_barraSuperior.setLayout(panel_barraSuperiorLayout);
        panel_barraSuperiorLayout.setHorizontalGroup(
            panel_barraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_barraSuperiorLayout.createSequentialGroup()
                .addContainerGap(510, Short.MAX_VALUE)
                .addComponent(label_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panel_barraSuperiorLayout.setVerticalGroup(
            panel_barraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barraSuperiorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_barraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_hora)
                    .addComponent(label_fecha))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        background.add(panel_barraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 50));

        separador.setBackground(new java.awt.Color(72, 203, 182));
        separador.setForeground(new java.awt.Color(72, 203, 182));
        background.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1010, 10));
        background.add(camara_web, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 340, 191));

        panel_qr.setBackground(new java.awt.Color(8, 29, 42));
        panel_qr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 145, 173), 3));

        panel_camara.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panel_camaraLayout = new javax.swing.GroupLayout(panel_camara);
        panel_camara.setLayout(panel_camaraLayout);
        panel_camaraLayout.setHorizontalGroup(
            panel_camaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        panel_camaraLayout.setVerticalGroup(
            panel_camaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        texto_colocar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        texto_colocar.setForeground(new java.awt.Color(255, 255, 255));
        texto_colocar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto_colocar.setText("Coloque su QR en el lector");

        campo_matricula.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        campo_matricula.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_qrLayout = new javax.swing.GroupLayout(panel_qr);
        panel_qr.setLayout(panel_qrLayout);
        panel_qrLayout.setHorizontalGroup(
            panel_qrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(texto_colocar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
            .addComponent(panel_camara, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_qrLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(campo_matricula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_qrLayout.setVerticalGroup(
            panel_qrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_qrLayout.createSequentialGroup()
                .addComponent(texto_colocar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_camara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campo_matricula)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        background.add(panel_qr, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 420, 400));

        panel_instrucciones.setBackground(new java.awt.Color(57, 118, 149));
        panel_instrucciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("¿Cómo pagar?");
        panel_instrucciones.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 19, 401, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Insertar la cantidad solicitada.");
        panel_instrucciones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 410, 34));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Paso 2.");
        panel_instrucciones.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 410, 34));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Paso 1.");
        panel_instrucciones.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 83, 410, 34));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tocar en \"Pagar\".");
        panel_instrucciones.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 410, 34));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Colocar la imagen del QR en el lector QR.");
        panel_instrucciones.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 117, 410, 34));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Paso 3.");
        panel_instrucciones.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 410, 34));

        background.add(panel_instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 420, 390));

        background2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Micha\\Documents\\NetBeansProjects\\moduloPago\\src\\main\\resources\\fondo.png")); // NOI18N
        background2.setText("jLabel4");
        background.add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1020, 540));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel camara_web;
    private javax.swing.JLabel campo_matricula;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_hora;
    private javax.swing.JPanel panel_barraSuperior;
    private javax.swing.JPanel panel_camara;
    private javax.swing.JPanel panel_instrucciones;
    private javax.swing.JPanel panel_qr;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel texto_colocar;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        webcam = Webcam.getDefault(); // obtener cámara web
        //webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(webcam.getViewSizes()[0]);
        
        /* Configuración de las características de la cámara  */
        panel = new WebcamPanel(webcam);
        panel.setMirrored(true);
        panel.setPreferredSize(webcam.getViewSize());
        panel.setFPSDisplayed(true);
        panel.setOpaque(true);
        panel.setBounds(0, 0, 400, 300);
        //panel_camara.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 600, 300));
        panel_camara.add(panel); // Colocar la cámara en la interfaz
        executor.execute(this);
    }

    private void getMatriculaDeQR(Result r) {
        /* Condicional para leer si hay algún codigo qr en la cámara */
        if (r != null) {
            String result_string = r.getText(); // Obtener texto del qr
            String[] result_parts = result_string.split(",");
            campo_matricula.setText(result_parts[0]); // Mostrar la matricula
            String text_matricula = campo_matricula.getText(); // Obtener la matricula
            
            /* Si la matricula no está vacía pasamos al pago */
            if(!text_matricula.equals("")){
                InterfazPagar pagar= new InterfazPagar(text_matricula);
                pagar.setVisible(true);
            }
            this.setVisible(false); 
            webcam.close(); // Cerramos la cámara
        }
    }

    /* Hilo para leer el codigo qr desde la cámara */
    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(InterfazLeerQRDesdeCamaraWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    //System.out.println("Hello World!");
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (ReaderException ex) {
                Logger.getLogger(InterfazLeerQRDesdeCamaraWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
            getMatriculaDeQR(result);
            
        } while (true);
    }

    /* Hilo para leer el qr */
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "Mi hilo");
        t.setDaemon(true);
        return t;
    }
}
