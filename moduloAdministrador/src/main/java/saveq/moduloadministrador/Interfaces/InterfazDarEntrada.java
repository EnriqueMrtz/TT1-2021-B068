package saveq.moduloadministrador.Interfaces;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import saveq.moduloadministrador.crud.EntradaAutomovil;
import saveq.moduloadministrador.horario.Fecha;
import saveq.moduloadministrador.horario.Hora;

public class InterfazDarEntrada extends javax.swing.JFrame {
    Timer actualizar;
    int delay=1000;

    public InterfazDarEntrada() {
        initComponents();
        Hora hora=new Hora();
        label_hora1.setText(hora.gethora());
        Fecha fecha=new Fecha();
        label_fecha1.setText(fecha.getfecha());
        this.reloj(1);
        matricula_entrada.setText(null);
        matricula_entrada.requestFocus();
        //Configuración de ventana
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_hora = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_hora1 = new javax.swing.JLabel();
        label_fecha1 = new javax.swing.JLabel();
        label_logotipo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        titulo_darEntrada = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        matricula_entrada = new javax.swing.JTextField();
        eboton_cancelar = new javax.swing.JButton();
        eboton_dentrada = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        boton_darEntrada = new javax.swing.JButton();
        boton_inicio = new javax.swing.JButton();
        boton_darSalida = new javax.swing.JButton();
        boton_video = new javax.swing.JButton();
        boton_tarifa = new javax.swing.JButton();
        label_fondo = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_hora.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        label_hora.setForeground(new java.awt.Color(255, 255, 255));
        label_hora.setText("hora");
        jPanel1.add(label_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 77, -1));

        label_fecha.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        label_fecha.setForeground(new java.awt.Color(255, 255, 255));
        label_fecha.setText("fecha");
        jPanel1.add(label_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 107, 45));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SaveQ: Sistema de Acceso Vehicular Dar Entrada");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_hora1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        label_hora1.setForeground(new java.awt.Color(255, 255, 255));
        label_hora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_reloj.png"))); // NOI18N
        label_hora1.setText(" hora");
        jPanel2.add(label_hora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 130, -1));

        label_fecha1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        label_fecha1.setForeground(new java.awt.Color(255, 255, 255));
        label_fecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_calendario.png"))); // NOI18N
        label_fecha1.setText(" fecha");
        jPanel2.add(label_fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 150, 45));

        label_logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jPanel2.add(label_logotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(76, 203, 182));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jPanel8.setBackground(new java.awt.Color(57, 118, 149));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo_darEntrada.setForeground(new java.awt.Color(255, 255, 255));
        titulo_darEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_entrada.png"))); // NOI18N
        titulo_darEntrada.setText("Dar entrada autómovil");
        jPanel8.add(titulo_darEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Escribe el número de matrícula");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 20));

        matricula_entrada.setForeground(new java.awt.Color(76, 203, 182));
        matricula_entrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        matricula_entrada.setText("Escribir matricula");
        matricula_entrada.setBorder(null);
        matricula_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matricula_entradaActionPerformed(evt);
            }
        });
        jPanel8.add(matricula_entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 390, 40));

        eboton_cancelar.setBackground(new java.awt.Color(76, 203, 182));
        eboton_cancelar.setText("Cancelar");
        eboton_cancelar.setBorderPainted(false);
        eboton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eboton_cancelarActionPerformed(evt);
            }
        });
        jPanel8.add(eboton_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 150, 40));

        eboton_dentrada.setBackground(new java.awt.Color(76, 203, 182));
        eboton_dentrada.setText("Dar Entrada");
        eboton_dentrada.setBorderPainted(false);
        eboton_dentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eboton_dentradaActionPerformed(evt);
            }
        });
        jPanel8.add(eboton_dentrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 140, 40));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 520, 290));

        jPanel4.setBackground(new java.awt.Color(10, 34, 44));

        jSeparator1.setBackground(new java.awt.Color(72, 203, 182));
        jSeparator1.setForeground(new java.awt.Color(72, 203, 182));

        jSeparator2.setBackground(new java.awt.Color(72, 203, 182));
        jSeparator2.setForeground(new java.awt.Color(72, 203, 182));

        jSeparator3.setBackground(new java.awt.Color(72, 203, 182));
        jSeparator3.setForeground(new java.awt.Color(72, 203, 182));

        jSeparator4.setBackground(new java.awt.Color(72, 203, 182));
        jSeparator4.setForeground(new java.awt.Color(72, 203, 182));

        jSeparator5.setBackground(new java.awt.Color(72, 203, 182));
        jSeparator5.setForeground(new java.awt.Color(72, 203, 182));

        jSeparator6.setBackground(new java.awt.Color(72, 203, 182));
        jSeparator6.setForeground(new java.awt.Color(72, 203, 182));

        boton_darEntrada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_darEntrada.setForeground(new java.awt.Color(255, 255, 255));
        boton_darEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_entrada.png"))); // NOI18N
        boton_darEntrada.setText("Dar entrada automóvil");
        boton_darEntrada.setBorderPainted(false);
        boton_darEntrada.setContentAreaFilled(false);
        boton_darEntrada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton_darEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_darEntradaActionPerformed(evt);
            }
        });

        boton_inicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_inicio.setForeground(new java.awt.Color(255, 255, 255));
        boton_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_inicio.png"))); // NOI18N
        boton_inicio.setText("Inicio");
        boton_inicio.setBorderPainted(false);
        boton_inicio.setContentAreaFilled(false);
        boton_inicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_inicioActionPerformed(evt);
            }
        });

        boton_darSalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_darSalida.setForeground(new java.awt.Color(255, 255, 255));
        boton_darSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_salida.png"))); // NOI18N
        boton_darSalida.setText("Dar salida autómovil");
        boton_darSalida.setBorderPainted(false);
        boton_darSalida.setContentAreaFilled(false);
        boton_darSalida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton_darSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_darSalidaActionPerformed(evt);
            }
        });

        boton_video.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_video.setForeground(new java.awt.Color(255, 255, 255));
        boton_video.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_video.png"))); // NOI18N
        boton_video.setText("Video");
        boton_video.setBorderPainted(false);
        boton_video.setContentAreaFilled(false);
        boton_video.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_videoActionPerformed(evt);
            }
        });

        boton_tarifa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton_tarifa.setForeground(new java.awt.Color(255, 255, 255));
        boton_tarifa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_tarifa.png"))); // NOI18N
        boton_tarifa.setText("Tarifa");
        boton_tarifa.setBorderPainted(false);
        boton_tarifa.setContentAreaFilled(false);
        boton_tarifa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boton_tarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_tarifaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boton_video, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_tarifa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator5)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_darEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_darSalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_inicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(121, 121, 121))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(boton_inicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_darEntrada)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_darSalida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_tarifa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_video)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, -1));

        label_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo.png"))); // NOI18N
        jPanel3.add(label_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 720, 410));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matricula_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matricula_entradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matricula_entradaActionPerformed

    private void eboton_dentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eboton_dentradaActionPerformed
        EntradaAutomovil entrada= new EntradaAutomovil();
        entrada.entrada_automovil(matricula_entrada);
    }//GEN-LAST:event_eboton_dentradaActionPerformed

    private void eboton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eboton_cancelarActionPerformed
        InterfazInicio inicio=new InterfazInicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_eboton_cancelarActionPerformed

    private void boton_tarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_tarifaActionPerformed
        InterfazTarifa tarifa=new InterfazTarifa();
        tarifa.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_boton_tarifaActionPerformed

    private void boton_darSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_darSalidaActionPerformed
        InterfazDarSalida salida=new InterfazDarSalida();
        salida.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_darSalidaActionPerformed

    private void boton_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_inicioActionPerformed
        InterfazInicio inicio=new InterfazInicio();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_inicioActionPerformed

    private void boton_darEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_darEntradaActionPerformed
        InterfazDarEntrada darEntrada= new InterfazDarEntrada();
        darEntrada.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_boton_darEntradaActionPerformed

    private void boton_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_videoActionPerformed
        InterfazVideo video=new InterfazVideo();
        video.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_videoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_darEntrada;
    private javax.swing.JButton boton_darSalida;
    private javax.swing.JButton boton_inicio;
    private javax.swing.JButton boton_tarifa;
    private javax.swing.JButton boton_video;
    private javax.swing.JButton eboton_cancelar;
    private javax.swing.JButton eboton_dentrada;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_fecha1;
    private javax.swing.JLabel label_fondo;
    private javax.swing.JLabel label_hora;
    private javax.swing.JLabel label_hora1;
    private javax.swing.JLabel label_logotipo;
    private javax.swing.JTextField matricula_entrada;
    private javax.swing.JLabel titulo_darEntrada;
    // End of variables declaration//GEN-END:variables
    public void reloj(int count){
        ActionListener accion= new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Hora hora=new Hora();
               label_hora1.setText(hora.gethora());
            }
        };
        actualizar= new Timer(delay,accion);
        actualizar.start();
        
    }

}
