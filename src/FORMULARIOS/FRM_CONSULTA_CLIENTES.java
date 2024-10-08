
package FORMULARIOS;

import BASE.conectaBD;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FRM_CONSULTA_CLIENTES extends javax.swing.JFrame {
conectaBD cnx=new conectaBD();

    
 public void LimpiarTabla(DefaultTableModel model){
  int x;
  for (x=model.getRowCount()-1; x>=0;x--){
   model.removeRow(x);
   
  }  
 }
  public void LlenarTabla(String sql){
 
   try{
    //consulta
    cnx.rs=cnx.stm.executeQuery(sql);
    //defino la variable
    DefaultTableModel model=(DefaultTableModel) jtbcliente.getModel();
    //limpio los datos
    LimpiarTabla (model);
    //llenar los datos
    while(cnx.rs.next()){
     String col1=cnx.rs.getString(1);
     String col2=cnx.rs.getString(2);
     String col3=cnx.rs.getString(3);
     String col4=cnx.rs.getString(4);
     String col5=cnx.rs.getString(5);
     String col6=cnx.rs.getString(6);
       String col7=cnx.rs.getString(7);
        
     //vRow es igual a una fila
     Vector vRow=new Vector ();
     vRow.addElement(col1);
     vRow.addElement(col2);
     vRow.addElement(col3);
     vRow.addElement(col4);
     vRow.addElement(col5);
      vRow.addElement(col6);
         vRow.addElement(col7);
    
     model.addRow(vRow);
     
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
     
   }
  }
 

 public FRM_CONSULTA_CLIENTES() {
  initComponents();
    this.setLocationRelativeTo(this);
    this.setResizable(false);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbgbuscar = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jrb1 = new javax.swing.JRadioButton();
        jrb2 = new javax.swing.JRadioButton();
        jtxtdni = new javax.swing.JTextField();
        jtxtnombre = new javax.swing.JTextField();
        jbttodos = new javax.swing.JButton();
        jbtnmostrar = new javax.swing.JButton();
        jbtnsalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbcliente = new javax.swing.JTable();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTAS CLIENTES");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        jbgbuscar.add(jrb1);
        jrb1.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jrb1.setText("DNI");
        jrb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb1ActionPerformed(evt);
            }
        });

        jbgbuscar.add(jrb2);
        jrb2.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jrb2.setText("NOMBRE");
        jrb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb2ActionPerformed(evt);
            }
        });

        jtxtdni.setBackground(new java.awt.Color(255, 255, 204));

        jtxtnombre.setBackground(new java.awt.Color(255, 255, 204));
        jtxtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyReleased(evt);
            }
        });

        jbttodos.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jbttodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo.png"))); // NOI18N
        jbttodos.setText("MOSTRAR TODOS");
        jbttodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttodosActionPerformed(evt);
            }
        });

        jbtnmostrar.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jbtnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar_1.png"))); // NOI18N
        jbtnmostrar.setText("BUSCAR");
        jbtnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnmostrarActionPerformed(evt);
            }
        });

        jbtnsalir.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jbtnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir2.png"))); // NOI18N
        jbtnsalir.setText("SALIR");
        jbtnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsalirActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(80, 130, 225));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SELECCIONE EL CRITERIO DE BUSQUEDA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jrb1)
                        .addGap(32, 32, 32)
                        .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jrb2)
                        .addGap(30, 30, 30)
                        .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbtnmostrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jbttodos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb2)
                    .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnmostrar)
                    .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrb1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbttodos)
                    .addComponent(jbtnsalir))
                .addGap(10, 10, 10))
        );

        jtbcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "DNI", "NOMBRE", "TELEFONO", "SEXO", "F_NACI", "DIRECCION"
            }
        ));
        jScrollPane1.setViewportView(jtbcliente);

        kGradientPanel3.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/consulta_item.png"))); // NOI18N
        jLabel19.setText("   CONSULTA CLIENTES");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   String sql="SELECT*FROM V_MANTENIMIENTO_CLIENTE";
  this.jrb1.setSelected(true);
  this.jtxtnombre.setEnabled(false);
 cnx.conectar();

  LlenarTabla(sql);
 }//GEN-LAST:event_formWindowOpened

 private void jrb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb2ActionPerformed
this.jtxtdni.setEnabled(false);
  this.jtxtnombre.setEnabled(true);
  // this.jcbocargo.setEnabled(false);
 }//GEN-LAST:event_jrb2ActionPerformed

 private void jrb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb1ActionPerformed
this.jtxtdni.setEnabled(true);
  this.jtxtnombre.setEnabled(false);
//   this.jcbocargo.setEnabled(false);
 }//GEN-LAST:event_jrb1ActionPerformed

 private void jbtnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnmostrarActionPerformed
 if(this.jrb1.isSelected()){
if(this.jtxtdni.getText().equals("")){
 JOptionPane.showMessageDialog(null, "INGRESE DNI A BUSCAR","Consulta",0);
 this.jtxtdni.requestFocus();
 return;
}
String dato=this.jtxtdni.getText();
String sql1="SELECT*FROM V_MANTENIMIENTO_CLIENTE where dni='"+dato+"'";
try{
 cnx.rs=cnx.stm.executeQuery(sql1);
 if(cnx.rs.next()){
  LlenarTabla(sql1);
  this.jtxtdni.setText("");
 }
 else{
  JOptionPane.showMessageDialog(null, "DNI NO REGISTRADA","Error",0);
  this.jtxtdni.setText("");
  this.jtxtdni.requestFocus();
 }
}
catch (Exception e){
 System.out.println(e.getMessage());
}
 }
 }//GEN-LAST:event_jbtnmostrarActionPerformed

 private void jtxtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyReleased
String nom=this.jtxtnombre.getText();
  String sql ="SELECT*FROM V_MANTENIMIENTO_CLIENTE WHERE nombre LIKE '%"+nom+"%'";
  try{
   LlenarTabla(sql);
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jtxtnombreKeyReleased

 private void jbttodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttodosActionPerformed
   String sql ="SELECT*FROM V_MANTENIMIENTO_CLIENTE";
  try{
   LlenarTabla(sql);
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jbttodosActionPerformed

 private void jbtnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsalirActionPerformed
this.dispose();  // TODO add your handling code here:
 }//GEN-LAST:event_jbtnsalirActionPerformed

 public static void main(String args[]) {
  /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
   * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
   */
  try {
   for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Nimbus".equals(info.getName())) {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
    }
   }
  } catch (ClassNotFoundException ex) {
   java.util.logging.Logger.getLogger(FRM_CONSULTA_CLIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_CONSULTA_CLIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_CONSULTA_CLIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_CONSULTA_CLIENTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_CONSULTA_CLIENTES().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jbgbuscar;
    private javax.swing.JButton jbtnmostrar;
    private javax.swing.JButton jbtnsalir;
    private javax.swing.JButton jbttodos;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JRadioButton jrb2;
    private javax.swing.JTable jtbcliente;
    private javax.swing.JTextField jtxtdni;
    private javax.swing.JTextField jtxtnombre;
    private keeptoo.KGradientPanel kGradientPanel3;
    // End of variables declaration//GEN-END:variables
}
