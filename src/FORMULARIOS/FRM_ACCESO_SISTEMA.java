
package FORMULARIOS;
import BASE.conectaBD; 
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane; 
import javax.swing.JPanel;
public class FRM_ACCESO_SISTEMA extends javax.swing.JFrame {
conectaBD cnx=new conectaBD();
int ban=0;
  JPanel_Registro registro =new JPanel_Registro(); //creamos un objeto del JPanel form 
  
 public FRM_ACCESO_SISTEMA() {
  initComponents();
  this.setLocationRelativeTo(null);
  jTxtUsuario.setText("administrador");

 }
 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        panelPadre = new javax.swing.JPanel();
        panelPadre2 = new keeptoo.KGradientPanel();
        jTxtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JpswdClave = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        panelRedondo2 = new FORMULARIOS.PanelRedondo();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBtnIngresar1 = new com.k33ptoo.components.KButton();
        jBtnIngresar = new com.k33ptoo.components.KButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESAR AL SISTEMA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPadre2.setkEndColor(new java.awt.Color(255, 0, 255));
        panelPadre2.setkStartColor(new java.awt.Color(0, 253, 255));

        jTxtUsuario.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTxtUsuario.setToolTipText("");
        jTxtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtUsuario.setName(""); // NOI18N
        jTxtUsuario.setOpaque(true);
        jTxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtUsuarioKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE DEL CARGO");

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONTRASEÑA");

        JpswdClave.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        JpswdClave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JpswdClave.setOpaque(true);
        JpswdClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JpswdClaveActionPerformed(evt);
            }
        });
        JpswdClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JpswdClaveKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icon_login.png"))); // NOI18N

        panelRedondo2.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo2.setRoundBottomLeft(70);
        panelRedondo2.setRoundTopRight(70);

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setText("INICIAR SESIÓN EN EL SISTEMA");

        javax.swing.GroupLayout panelRedondo2Layout = new javax.swing.GroupLayout(panelRedondo2);
        panelRedondo2.setLayout(panelRedondo2Layout);
        panelRedondo2Layout.setHorizontalGroup(
            panelRedondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRedondo2Layout.setVerticalGroup(
            panelRedondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/usuario-20.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/contraseña-20.png"))); // NOI18N

        jBtnIngresar1.setText("REGISTRARSE");
        jBtnIngresar1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jBtnIngresar1.setkEndColor(new java.awt.Color(255, 255, 255));
        jBtnIngresar1.setkFillButton(false);
        jBtnIngresar1.setkHoverColor(new java.awt.Color(204, 204, 204));
        jBtnIngresar1.setkHoverEndColor(new java.awt.Color(51, 255, 255));
        jBtnIngresar1.setkHoverForeGround(new java.awt.Color(0, 204, 204));
        jBtnIngresar1.setkHoverStartColor(new java.awt.Color(0, 255, 255));
        jBtnIngresar1.setkPressedColor(new java.awt.Color(255, 255, 255));
        jBtnIngresar1.setkStartColor(new java.awt.Color(255, 255, 255));
        jBtnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresar1ActionPerformed(evt);
            }
        });

        jBtnIngresar.setText("INICIAR SESIÓN");
        jBtnIngresar.setkEndColor(new java.awt.Color(255, 255, 255));
        jBtnIngresar.setkForeGround(new java.awt.Color(0, 0, 0));
        jBtnIngresar.setkHoverEndColor(new java.awt.Color(220, 220, 220));
        jBtnIngresar.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        jBtnIngresar.setkHoverStartColor(new java.awt.Color(220, 220, 220));
        jBtnIngresar.setkStartColor(new java.awt.Color(255, 255, 255));
        jBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPadre2Layout = new javax.swing.GroupLayout(panelPadre2);
        panelPadre2.setLayout(panelPadre2Layout);
        panelPadre2Layout.setHorizontalGroup(
            panelPadre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPadre2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(panelPadre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPadre2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(panelRedondo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPadre2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(panelPadre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelPadre2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(panelPadre2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(JpswdClave)
                            .addComponent(jTxtUsuario)
                            .addComponent(jBtnIngresar1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(jBtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        panelPadre2Layout.setVerticalGroup(
            panelPadre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPadre2Layout.createSequentialGroup()
                .addGroup(panelPadre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPadre2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(panelRedondo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelPadre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelPadre2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JpswdClave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnIngresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPadre2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1)))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPadreLayout = new javax.swing.GroupLayout(panelPadre);
        panelPadre.setLayout(panelPadreLayout);
        panelPadreLayout.setHorizontalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPadre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPadreLayout.setVerticalGroup(
            panelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPadre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(panelPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 777, 491));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//metodo para retornar el panelPadre al realizar click en volver a iniciar sesion
    public JPanel getMainPanel() {
        return panelPadre2;
    }
    
    public void ingresar(){
 String cargo,clave;
 cargo =jTxtUsuario.getText();
 clave=JpswdClave.getText();
 String codcargo="";
 try{
      cnx.conectar();
        cnx.rs=cnx.stm.executeQuery("SELECT idcargo FROM CARGO WHERE nombre='"+ cargo +"'");
            while(cnx.rs.next()){
                codcargo=cnx.rs.getString("idcargo");
            }
           cnx.rs=cnx.stm.executeQuery("SELECT * FROM EMPLEADO WHERE idcargo='"+codcargo
                +"' and clave='" +clave +"'");
            if(cnx.rs.next()){
                //JOptionPane.showConfirmDialog(null,"BIENVENIDO AL SISTEMA","Acceso Correcto",2);
               FRM_MENU_PRINCIPAL  FRM_MENU=new FRM_MENU_PRINCIPAL ();
                FRM_MENU.show();
               this.dispose();
            }else{
                JOptionPane.showConfirmDialog(null,"CONTRASEÑA Y/O USUARIO INCORRECTO","Seguridad del Sistema",2);
                jTxtUsuario.setText("");
                JpswdClave.setText("");
                ban=ban+1;
            }
            if (ban==3){
                JOptionPane.showConfirmDialog(null,"Usted a agotado sus intentos","Seguridad del Sistema",2);
                System.exit(0);
            }
   
  }
  catch (Exception e) {
   System.out.println(e.getMessage());
   
  }
  
}
//JPanel dentro de otro para el registro

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  cnx.conectar();
  this.jTxtUsuario.requestFocus();
 }//GEN-LAST:event_formWindowOpened

 private void jTxtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtUsuarioKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
  this.JpswdClave.requestFocus();
  
 }
 }//GEN-LAST:event_jTxtUsuarioKeyPressed

 private void JpswdClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpswdClaveActionPerformed
  // TODO add your handling code here:
 }//GEN-LAST:event_JpswdClaveActionPerformed

 private void JpswdClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JpswdClaveKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
  this.jBtnIngresar.requestFocus();
  ingresar();
 }
 }//GEN-LAST:event_JpswdClaveKeyPressed

    private void jBtnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresar1ActionPerformed
  ShowPanel(registro);
    }//GEN-LAST:event_jBtnIngresar1ActionPerformed

    private void jBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresarActionPerformed
      ingresar();
    }//GEN-LAST:event_jBtnIngresarActionPerformed
private void ShowPanel(JPanel p) {
    p.setSize(777, 491);
    p.setLocation(0, 0);
    panelPadre2.removeAll();
    panelPadre2.add(p, BorderLayout.CENTER);
    panelPadre2.validate();
    panelPadre2.repaint();
}

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
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_ACCESO_SISTEMA().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JpswdClave;
    private com.k33ptoo.components.KButton jBtnIngresar;
    private com.k33ptoo.components.KButton jBtnIngresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTxtUsuario;
    private javax.swing.JPanel panelPadre;
    private keeptoo.KGradientPanel panelPadre2;
    private FORMULARIOS.PanelRedondo panelRedondo2;
    // End of variables declaration//GEN-END:variables
}
