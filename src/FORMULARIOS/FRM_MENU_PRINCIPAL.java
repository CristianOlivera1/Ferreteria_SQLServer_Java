
package FORMULARIOS;
import BASE.conectaBD;
import Base.Conectar;
import java.awt.Color;
import java.sql.Connection;

public class FRM_MENU_PRINCIPAL extends javax.swing.JFrame {
     Conectar c= new Conectar();
      Connection cn = c.conexion();
                       
 public FRM_MENU_PRINCIPAL() {
  initComponents();
  this.setResizable(false);
  this.setLocationRelativeTo(null);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSistema = new javax.swing.JLabel();
        panelRedondo1 = new FORMULARIOS.PanelRedondo();
        panelRedondo4 = new FORMULARIOS.PanelRedondo();
        panelRedondo5 = new FORMULARIOS.PanelRedondo();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMMantenimiento = new javax.swing.JMenu();
        jMiEmpleado1 = new javax.swing.JMenuItem();
        jMiCliente1 = new javax.swing.JMenuItem();
        jMiCargo1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMiProducto1 = new javax.swing.JMenuItem();
        jMiMarca1 = new javax.swing.JMenuItem();
        jMiCategoria1 = new javax.swing.JMenuItem();
        jMTransaciones = new javax.swing.JMenu();
        jMiVentaProd = new javax.swing.JMenuItem();
        jMConsultas = new javax.swing.JMenu();
        jMiVentas = new javax.swing.JMenuItem();
        jMiClientes = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMRepotes = new javax.swing.JMenu();
        jMiReporteDia = new javax.swing.JMenuItem();
        jMajustes = new javax.swing.JMenu();
        jMitemAutores = new javax.swing.JMenuItem();
        jMitemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MENU PRINCIPAL");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        kGradientPanel1.setBackground(new java.awt.Color(77, 77, 77));
        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 255, 255));

        jLblNombre.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLblNombre.setForeground(new java.awt.Color(244, 244, 244));
        jLblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNombre.setText("FERRETERíA");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/fondo_principal.jpg"))); // NOI18N

        lblSistema.setBackground(new java.awt.Color(119, 119, 119));
        lblSistema.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        lblSistema.setForeground(new java.awt.Color(244, 244, 244));
        lblSistema.setText("SISTEMA DE VENTAS");

        panelRedondo1.setBackground(new java.awt.Color(232, 232, 232));
        panelRedondo1.setRoundBottomLeft(20);
        panelRedondo1.setRoundBottomRight(20);
        panelRedondo1.setRoundTopLeft(20);
        panelRedondo1.setRoundTopRight(20);

        javax.swing.GroupLayout panelRedondo1Layout = new javax.swing.GroupLayout(panelRedondo1);
        panelRedondo1.setLayout(panelRedondo1Layout);
        panelRedondo1Layout.setHorizontalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        panelRedondo1Layout.setVerticalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        panelRedondo4.setBackground(new java.awt.Color(232, 232, 232));
        panelRedondo4.setForeground(new java.awt.Color(232, 232, 232));
        panelRedondo4.setRoundBottomLeft(20);
        panelRedondo4.setRoundBottomRight(20);
        panelRedondo4.setRoundTopLeft(20);
        panelRedondo4.setRoundTopRight(20);

        javax.swing.GroupLayout panelRedondo4Layout = new javax.swing.GroupLayout(panelRedondo4);
        panelRedondo4.setLayout(panelRedondo4Layout);
        panelRedondo4Layout.setHorizontalGroup(
            panelRedondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        panelRedondo4Layout.setVerticalGroup(
            panelRedondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        panelRedondo5.setBackground(new java.awt.Color(232, 232, 232));
        panelRedondo5.setRoundBottomLeft(20);
        panelRedondo5.setRoundBottomRight(20);
        panelRedondo5.setRoundTopLeft(20);
        panelRedondo5.setRoundTopRight(20);

        javax.swing.GroupLayout panelRedondo5Layout = new javax.swing.GroupLayout(panelRedondo5);
        panelRedondo5.setLayout(panelRedondo5Layout);
        panelRedondo5Layout.setHorizontalGroup(
            panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        panelRedondo5Layout.setVerticalGroup(
            panelRedondo5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(panelRedondo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRedondo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLblNombre)
                    .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(lblSistema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRedondo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRedondo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 563, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 245));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(677, 43));

        jMMantenimiento.setBackground(new java.awt.Color(244, 244, 244));
        jMMantenimiento.setBorder(null);
        jMMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento.png"))); // NOI18N
        jMMantenimiento.setText(" MANTENIMIENTO  ");
        jMMantenimiento.setToolTipText("Mantenimiento ");
        jMMantenimiento.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiEmpleado1.setBackground(new java.awt.Color(244, 244, 244));
        jMiEmpleado1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiEmpleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/empleado2.png"))); // NOI18N
        jMiEmpleado1.setText("Empleado");
        jMiEmpleado1.setToolTipText("Mantenimiento Empleado");
        jMiEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEmpleado1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiEmpleado1);

        jMiCliente1.setBackground(new java.awt.Color(244, 244, 244));
        jMiCliente1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cliente2.png"))); // NOI18N
        jMiCliente1.setText("Cliente");
        jMiCliente1.setToolTipText("Mantenimiento Cliente");
        jMiCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCliente1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCliente1);

        jMiCargo1.setBackground(new java.awt.Color(244, 244, 244));
        jMiCargo1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiCargo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cargo2.png"))); // NOI18N
        jMiCargo1.setText("Cargo");
        jMiCargo1.setToolTipText("Mantenimineto Categoria");
        jMiCargo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCargo1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCargo1);

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 12));
        jMMantenimiento.add(jSeparator1);

        jMiProducto1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/producto_ferreteria.png"))); // NOI18N
        jMiProducto1.setText("Producto");
        jMiProducto1.setToolTipText("Mantenimiento Producto");
        jMiProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiProducto1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiProducto1);

        jMiMarca1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiMarca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/marca2.png"))); // NOI18N
        jMiMarca1.setText("Marca");
        jMiMarca1.setToolTipText("Mantenimineto Categoria");
        jMiMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiMarca1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiMarca1);

        jMiCategoria1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiCategoria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/categoria2_1.png"))); // NOI18N
        jMiCategoria1.setText("Categoria");
        jMiCategoria1.setToolTipText("Mantenimineto Categoria");
        jMiCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCategoria1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCategoria1);

        jMenuBar1.add(jMMantenimiento);

        jMTransaciones.setBorder(null);
        jMTransaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/transaccionesMENU.png"))); // NOI18N
        jMTransaciones.setText("TRANSACCIONES  ");
        jMTransaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMTransaciones.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMTransaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiVentaProd.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiVentaProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/item_venta.png"))); // NOI18N
        jMiVentaProd.setText("Venta de productos");
        jMiVentaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVentaProdActionPerformed(evt);
            }
        });
        jMTransaciones.add(jMiVentaProd);

        jMenuBar1.add(jMTransaciones);

        jMConsultas.setBorder(null);
        jMConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/consulta2.png"))); // NOI18N
        jMConsultas.setText("CONSULTAS  ");
        jMConsultas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiVentas.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/item_venta.png"))); // NOI18N
        jMiVentas.setText("Historial de Ventas");
        jMiVentas.setToolTipText("Consulta Ventas");
        jMiVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVentasActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiVentas);

        jMiClientes.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/clientes.png"))); // NOI18N
        jMiClientes.setText("Clientes");
        jMiClientes.setToolTipText("Consulta Clientes");
        jMiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiClientesActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiClientes);

        jMenuItem3.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ganancia.png"))); // NOI18N
        jMenuItem3.setText("Ganancia del dia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMConsultas.add(jMenuItem3);

        jMenuBar1.add(jMConsultas);

        jMRepotes.setBorder(null);
        jMRepotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/reporte2.png"))); // NOI18N
        jMRepotes.setText("REPORTES  ");
        jMRepotes.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jMRepotes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiReporteDia.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMiReporteDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/reportediario.png"))); // NOI18N
        jMiReporteDia.setText("Reporte diario");
        jMiReporteDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiReporteDiaActionPerformed(evt);
            }
        });
        jMRepotes.add(jMiReporteDia);

        jMenuBar1.add(jMRepotes);

        jMajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/configuracion.png"))); // NOI18N
        jMajustes.setText("AJUSTES");
        jMajustes.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jMitemAutores.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMitemAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/autores.png"))); // NOI18N
        jMitemAutores.setText("Autores");
        jMitemAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMitemAutoresActionPerformed(evt);
            }
        });
        jMajustes.add(jMitemAutores);

        jMitemSalir.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jMitemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir2.png"))); // NOI18N
        jMitemSalir.setText("Volver a inicio de sesión");
        jMitemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMitemSalirActionPerformed(evt);
            }
        });
        jMajustes.add(jMitemSalir);

        jMenuBar1.add(jMajustes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void jMiCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCliente1ActionPerformed
 conectaBD cnx = new conectaBD();
    cnx.conectar(); // Establece la conexión
     FRM_MANTENIMIENTO_CLIENTE cliente = new FRM_MANTENIMIENTO_CLIENTE();
  cliente.show();
 }//GEN-LAST:event_jMiCliente1ActionPerformed

 private void jMiProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiProducto1ActionPerformed
  FRM_MANTENIMIENTO_PRODUCTO producto = new FRM_MANTENIMIENTO_PRODUCTO();
  producto.show();
 }//GEN-LAST:event_jMiProducto1ActionPerformed

 private void jMiEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEmpleado1ActionPerformed
  FRM_MANTENIMIENTO_EMPLEADO empleado = new FRM_MANTENIMIENTO_EMPLEADO();
  empleado.show();
 }//GEN-LAST:event_jMiEmpleado1ActionPerformed

 private void jMiCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCategoria1ActionPerformed
  FRM_MANTENIMIENTO_CATEGORIA categori = new FRM_MANTENIMIENTO_CATEGORIA();
  categori.show();
 }//GEN-LAST:event_jMiCategoria1ActionPerformed

 private void jMiVentaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVentaProdActionPerformed
  FRM_VENTA_PRODUCTO_BOLETA venta = new FRM_VENTA_PRODUCTO_BOLETA();
  venta.show();
 }//GEN-LAST:event_jMiVentaProdActionPerformed

 private void jMiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiClientesActionPerformed
 FRM_CONSULTA_CLIENTES cliente=new FRM_CONSULTA_CLIENTES();
 cliente.show();
 }//GEN-LAST:event_jMiClientesActionPerformed

 private void jMiReporteDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiReporteDiaActionPerformed
FRM_VENTA_DIA dia=new FRM_VENTA_DIA();
dia.show();
 }//GEN-LAST:event_jMiReporteDiaActionPerformed

 private void jMiMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiMarca1ActionPerformed
FRM_MANTENIMIENTO_MARCA M=new FRM_MANTENIMIENTO_MARCA(); 
M.show();
 }//GEN-LAST:event_jMiMarca1ActionPerformed

 private void jMiCargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCargo1ActionPerformed
  FRM_MANTENIMIENTO_CARGO M=new FRM_MANTENIMIENTO_CARGO();
  M.show();
 }//GEN-LAST:event_jMiCargo1ActionPerformed

    private void jMiVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVentasActionPerformed
       FRM_CONSULTA_VENTAS ventas = new FRM_CONSULTA_VENTAS();
       ventas.show();
    }//GEN-LAST:event_jMiVentasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FRM_UTILIDAD C = new FRM_UTILIDAD();//Consultas-ganancias
        C.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMitemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMitemSalirActionPerformed
        // TODO add your handling code here:
        dispose();
        new FRM_ACCESO_SISTEMA().setVisible(true);
    }//GEN-LAST:event_jMitemSalirActionPerformed

    private void jMitemAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMitemAutoresActionPerformed
        // TODO add your handling code here:
         FRM_AUTOR autor = new FRM_AUTOR();
     autor.show();
    }//GEN-LAST:event_jMitemAutoresActionPerformed


 public static void main(String args[]) {
  
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MENU_PRINCIPAL().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JMenu jMConsultas;
    private javax.swing.JMenu jMMantenimiento;
    private javax.swing.JMenu jMRepotes;
    private javax.swing.JMenu jMTransaciones;
    private javax.swing.JMenu jMajustes;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMiCargo1;
    private javax.swing.JMenuItem jMiCategoria1;
    private javax.swing.JMenuItem jMiCliente1;
    private javax.swing.JMenuItem jMiClientes;
    private javax.swing.JMenuItem jMiEmpleado1;
    private javax.swing.JMenuItem jMiMarca1;
    private javax.swing.JMenuItem jMiProducto1;
    private javax.swing.JMenuItem jMiReporteDia;
    private javax.swing.JMenuItem jMiVentaProd;
    private javax.swing.JMenuItem jMiVentas;
    private javax.swing.JMenuItem jMitemAutores;
    private javax.swing.JMenuItem jMitemSalir;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblSistema;
    private FORMULARIOS.PanelRedondo panelRedondo1;
    private FORMULARIOS.PanelRedondo panelRedondo4;
    private FORMULARIOS.PanelRedondo panelRedondo5;
    // End of variables declaration//GEN-END:variables
}
