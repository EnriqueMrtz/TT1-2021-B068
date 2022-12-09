package saveq.moduloadministrador.Interfaces;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import saveq.moduloadministrador.crud.MostrarBaseDatos;
import saveq.moduloadministrador.horario.Fecha;
import saveq.moduloadministrador.horario.Hora;
import saveq.moduloadministrador.crud.EstadisticasAutomovil;

public class InterfazInicio extends javax.swing.JFrame {
    Timer actualizar;
    int delay=1000;

    public InterfazInicio() {
        initComponents();
        Hora hora=new Hora();
        label_hora.setText(hora.gethora());
        Fecha fecha=new Fecha();
        label_fecha.setText(fecha.getfecha());
        this.reloj(1);
        EstadisticasAutomovil estadisticas=new EstadisticasAutomovil();
        label_total.setText(estadisticas.registro_totales());
        label_estacionados.setText(estadisticas.registro_estacionados());
        MostrarBaseDatos tabla= new MostrarBaseDatos();
        tabla.mostrar_entradas(tabla_entradas);
        tabla.mostrar_salidas(tabla_salidas);
        //Configuracion de ventana
        this.setLocationRelativeTo(null);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        label_hora = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        label_logotipo = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        panel_estacionados2 = new javax.swing.JPanel();
        label_total = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_salidas = new javax.swing.JTable();
        panel_estacionados = new javax.swing.JPanel();
        label_estacionados = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_entradas = new javax.swing.JTable();
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
        jPanel5 = new javax.swing.JPanel();
        label_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SaveQ: Sistema de Acceso Vehicular Inicio");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_hora.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        label_hora.setForeground(new java.awt.Color(255, 255, 255));
        label_hora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_reloj.png"))); // NOI18N
        label_hora.setText("hora");
        jPanel1.add(label_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 120, -1));

        label_fecha.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        label_fecha.setForeground(new java.awt.Color(255, 255, 255));
        label_fecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_calendario.png"))); // NOI18N
        label_fecha.setText("fecha");
        jPanel1.add(label_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 140, 45));

        label_logotipo.setForeground(new java.awt.Color(255, 255, 255));
        label_logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jPanel1.add(label_logotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        panel.setBackground(new java.awt.Color(255, 102, 0));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_estacionados2.setBackground(new java.awt.Color(8, 29, 42));
        panel_estacionados2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 145, 173), 3));

        label_total.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label_total.setForeground(new java.awt.Color(255, 255, 255));
        label_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_total.setText("#");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total automóviles por dia");

        javax.swing.GroupLayout panel_estacionados2Layout = new javax.swing.GroupLayout(panel_estacionados2);
        panel_estacionados2.setLayout(panel_estacionados2Layout);
        panel_estacionados2Layout.setHorizontalGroup(
            panel_estacionados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_estacionados2Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(panel_estacionados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panel_estacionados2Layout.setVerticalGroup(
            panel_estacionados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_estacionados2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel.add(panel_estacionados2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 160, -1));

        tabla_salidas.setBackground(new java.awt.Color(8, 29, 42));
        tabla_salidas.setForeground(new java.awt.Color(255, 255, 255));
        tabla_salidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_salidas.setGridColor(new java.awt.Color(76, 203, 182));
        tabla_salidas.setSelectionBackground(new java.awt.Color(76, 203, 182));
        tabla_salidas.setShowGrid(true);
        jScrollPane1.setViewportView(tabla_salidas);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 389, 133));

        panel_estacionados.setBackground(new java.awt.Color(8, 29, 42));
        panel_estacionados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(67, 145, 173), 3));

        label_estacionados.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label_estacionados.setForeground(new java.awt.Color(255, 255, 255));
        label_estacionados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_estacionados.setText("#");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Automóviles estacionados");

        javax.swing.GroupLayout panel_estacionadosLayout = new javax.swing.GroupLayout(panel_estacionados);
        panel_estacionados.setLayout(panel_estacionadosLayout);
        panel_estacionadosLayout.setHorizontalGroup(
            panel_estacionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_estacionadosLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addComponent(label_estacionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_estacionadosLayout.setVerticalGroup(
            panel_estacionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_estacionadosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_estacionados, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel.add(panel_estacionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 160, -1));

        tabla_entradas.setBackground(new java.awt.Color(8, 29, 42));
        tabla_entradas.setForeground(new java.awt.Color(255, 255, 255));
        tabla_entradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_entradas.setGridColor(new java.awt.Color(0, 176, 240));
        tabla_entradas.setSelectionBackground(new java.awt.Color(0, 176, 240));
        tabla_entradas.setShowGrid(true);
        jScrollPane2.setViewportView(tabla_entradas);

        panel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 394, 133));

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
        boton_inicio.setToolTipText("");
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
            .addComponent(jSeparator3)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_tarifa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator6)
                            .addComponent(boton_darEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_darSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(boton_video, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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
                .addContainerGap(122, Short.MAX_VALUE))
        );

        panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 390));

        jPanel5.setBackground(new java.awt.Color(76, 203, 182));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        label_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo.png"))); // NOI18N
        panel.add(label_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 720, 410));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_inicioActionPerformed
        this.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_boton_inicioActionPerformed

    private void boton_darEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_darEntradaActionPerformed
        InterfazDarEntrada darEntrada= new InterfazDarEntrada();
        darEntrada.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_darEntradaActionPerformed

    private void boton_darSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_darSalidaActionPerformed
        InterfazDarSalida salida=new InterfazDarSalida();
        salida.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boton_darSalidaActionPerformed

    private void boton_tarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_tarifaActionPerformed
        InterfazTarifa tarifa=new InterfazTarifa();
        tarifa.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_boton_tarifaActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel label_estacionados;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_fondo;
    private javax.swing.JLabel label_hora;
    private javax.swing.JLabel label_logotipo;
    private javax.swing.JLabel label_total;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel_estacionados;
    private javax.swing.JPanel panel_estacionados2;
    private javax.swing.JTable tabla_entradas;
    private javax.swing.JTable tabla_salidas;
    // End of variables declaration//GEN-END:variables
   
    public void reloj(int count){
        ActionListener accion= new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Hora hora=new Hora();
               label_hora.setText(hora.gethora());
//               tabla_entradas.updateUI();
//               tabla_salidas.updateUI();
            }
        };
        actualizar= new Timer(delay,accion);
        actualizar.start();
        
    }

}
