
package FORMULARIOS;

import BASE.conectaBD;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FRM_EMPLEADO_PASAR extends javax.swing.JFrame {
conectaBD cnx=new conectaBD();

public void CargaComboarea(){
 String sql="SELECT nombre from Cargo  ORDER BY 1";
try{
cnx.rs=cnx.stm.executeQuery(sql);
jcbocargo.removeAllItems();
while(cnx.rs.next()){
jcbocargo.addItem(cnx.rs.getString(1));

}
}catch(Exception e){
System.out.println(e.getMessage());
}
}
  public void MOSTRAR_DATOS_EN_VENTA(){
String cod=jtbpersonal.getValueAt(jtbpersonal.getSelectedRow(),0).toString();
String sql="SELECT*FROM V_MANTENIMIENTO_EMPLEADO WHERE idempleado='"+cod+"'";
try{
 cnx.rs=cnx.stm.executeQuery(sql);
 if(cnx.rs.next()){
FRM_VENTA_PRODUCTO_BOLETA.jtxtcodempleado.setText(cnx.rs.getString(1));
FRM_VENTA_PRODUCTO_BOLETA.jtxtnomempleado.setText(cnx.rs.getString(3));

 }
}
catch (Exception e){
 System.out.println(e.getMessage());
}
 
  }

    
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
    DefaultTableModel model=(DefaultTableModel) jtbpersonal.getModel();
    //limpio los datos
    LimpiarTabla (model);
    //llenar los datos
    while(cnx.rs.next()){
     String col1=cnx.rs.getString(1);
     String col2=cnx.rs.getString(2);
     String col3=cnx.rs.getString(3);
     String col4=cnx.rs.getString(5);
     String col5=cnx.rs.getString(9);
   
     //vRow es igual a una fila
     Vector vRow=new Vector ();
     vRow.addElement(col1);
     vRow.addElement(col2);
     vRow.addElement(col3);
     vRow.addElement(col4);
     vRow.addElement(col5);
   
     model.addRow(vRow);
     
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
     
   }
  }
 

 public FRM_EMPLEADO_PASAR() {
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
        jrb3 = new javax.swing.JRadioButton();
        jtxtcodigo = new javax.swing.JTextField();
        jtxtnombre = new javax.swing.JTextField();
        jcbocargo = new javax.swing.JComboBox();
        jbttodos = new javax.swing.JButton();
        jbtnmostrar = new javax.swing.JButton();
        jbtnsalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbpersonal = new javax.swing.JTable();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA DEL PERSONAL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        jbgbuscar.add(jrb1);
        jrb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrb1.setText("CODIGO");
        jrb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb1ActionPerformed(evt);
            }
        });

        jbgbuscar.add(jrb2);
        jrb2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrb2.setText("NOMBRE");
        jrb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb2ActionPerformed(evt);
            }
        });

        jbgbuscar.add(jrb3);
        jrb3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrb3.setText("CARGO");
        jrb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb3ActionPerformed(evt);
            }
        });

        jtxtcodigo.setBackground(new java.awt.Color(255, 255, 204));
        jtxtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtcodigoActionPerformed(evt);
            }
        });

        jtxtnombre.setBackground(new java.awt.Color(255, 255, 204));
        jtxtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyReleased(evt);
            }
        });

        jbttodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo.png"))); // NOI18N
        jbttodos.setText("MOSTRAR ");
        jbttodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttodosActionPerformed(evt);
            }
        });

        jbtnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar_1.png"))); // NOI18N
        jbtnmostrar.setText("BUSCAR");
        jbtnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnmostrarActionPerformed(evt);
            }
        });

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
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb2)
                    .addComponent(jrb1)
                    .addComponent(jrb3))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbocargo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbttodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrb1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jtxtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrb2)
                            .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbocargo))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbttodos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );

        jtbpersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "DNI", "NOMBRE", "SEXO", "CARGO"
            }
        ));
        jtbpersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbpersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbpersonal);
        if (jtbpersonal.getColumnModel().getColumnCount() > 0) {
            jtbpersonal.getColumnModel().getColumn(0).setMinWidth(80);
            jtbpersonal.getColumnModel().getColumn(0).setMaxWidth(70);
            jtbpersonal.getColumnModel().getColumn(3).setMinWidth(60);
            jtbpersonal.getColumnModel().getColumn(3).setMaxWidth(20);
        }

        kGradientPanel3.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/transaccionesITEM.png"))); // NOI18N
        jLabel19.setText("   BUSCAR EMPLEADO");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel19)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
   String sql="SELECT*FROM V_MANTENIMIENTO_EMPLEADO";
  this.jrb1.setSelected(true);
  this.jtxtnombre.setEnabled(false);
  this.jcbocargo.setEnabled(false);
  cnx.conectar();
  CargaComboarea();
  LlenarTabla(sql);
 }//GEN-LAST:event_formWindowOpened

 private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
 String sql="SELECT*FROM V_MANTENIMIENTO_EMPLEADO";
   LlenarTabla(sql);
  CargaComboarea();
 // TODO add your handling code here:
 }//GEN-LAST:event_formWindowActivated

 private void jbtnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsalirActionPerformed
  this.dispose();  // TODO add your handling code here:
 }//GEN-LAST:event_jbtnsalirActionPerformed

 private void jbtnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnmostrarActionPerformed
  if(this.jrb1.isSelected()){
   if(this.jtxtcodigo.getText().equals("")){
    JOptionPane.showMessageDialog(null, "INGRESE CODIGO A BUSCAR","Consulta",0);
    this.jtxtcodigo.requestFocus();
    return;
   }
   String dato=this.jtxtcodigo.getText();
   String sql1="SELECT*FROM V_MANTENIMIENTO_EMPLEADO where idempleado='"+dato+"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql1);
    if(cnx.rs.next()){
     LlenarTabla(sql1);
    }
    else{
     JOptionPane.showMessageDialog(null, "CODIGO NO ENCONTRADO","Error",0);
     this.jtxtcodigo.setText("");
     this.jtxtcodigo.requestFocus();
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
   }
  }
  if(this.jrb3.isSelected()){
   String dato =this.jcbocargo.getSelectedItem().toString();
   String sql2="SELECT*FROM V_MANTENIMIENTO_EMPLEADO where cargo='"+dato+"'";
   try{
    LlenarTabla(sql2);
   }
   catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
 }//GEN-LAST:event_jbtnmostrarActionPerformed

 private void jbttodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttodosActionPerformed
  String sql ="SELECT*FROM V_MANTENIMIENTO_EMPLEADO";
  try{
   LlenarTabla(sql);
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jbttodosActionPerformed

 private void jtxtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyReleased
  String nom=this.jtxtnombre.getText();
  String sql ="SELECT*FROM V_MANTENIMIENTO_EMPLEADO WHERE nombre LIKE '%"+nom+"%'";
  try{
   LlenarTabla(sql);
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jtxtnombreKeyReleased

 private void jrb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb3ActionPerformed
  this.jtxtcodigo.setEnabled(false);
  this.jtxtnombre.setEnabled(false);
  this.jcbocargo.setEnabled(true);
 }//GEN-LAST:event_jrb3ActionPerformed

 private void jrb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb2ActionPerformed
  this.jtxtcodigo.setEnabled(false);
  this.jtxtnombre.setEnabled(true);
  this.jcbocargo.setEnabled(false);
 }//GEN-LAST:event_jrb2ActionPerformed

 private void jrb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb1ActionPerformed
  this.jtxtcodigo.setEnabled(true);
  this.jtxtnombre.setEnabled(false);
  this.jcbocargo.setEnabled(false);
 }//GEN-LAST:event_jrb1ActionPerformed

 private void jtbpersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbpersonalMouseClicked
MOSTRAR_DATOS_EN_VENTA();
this.dispose();
// TODO add your handling code here:
 }//GEN-LAST:event_jtbpersonalMouseClicked

    private void jtxtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtcodigoActionPerformed

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
   java.util.logging.Logger.getLogger(FRM_EMPLEADO_PASAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_EMPLEADO_PASAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_EMPLEADO_PASAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_EMPLEADO_PASAR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_EMPLEADO_PASAR().setVisible(true);
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
    private javax.swing.JComboBox jcbocargo;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JRadioButton jrb2;
    private javax.swing.JRadioButton jrb3;
    private javax.swing.JTable jtbpersonal;
    private javax.swing.JTextField jtxtcodigo;
    private javax.swing.JTextField jtxtnombre;
    private keeptoo.KGradientPanel kGradientPanel3;
    // End of variables declaration//GEN-END:variables
}
