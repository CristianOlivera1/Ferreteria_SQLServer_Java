
package FORMULARIOS;
import BASE.conectaBD;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JPanel_Registro extends javax.swing.JPanel {
conectaBD cnx=new conectaBD(); 

    public JPanel_Registro() {
        initComponents();
        cnx.conectar();
    
    }
    //para registrarse
    public void registrar() {
    String usuario = jTxtUsuario.getText();
    String clave = JpswdClave.getText();
    String confirmarClave = JpswdConfirmarClave.getText();

    // Verificar que los campos no estén vacíos
    if (usuario.isEmpty() || clave.isEmpty() || confirmarClave.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar que la contraseña y la confirmación coincidan
    if (!clave.equals(confirmarClave)) {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
      
        // Insertar el nuevo cargo (usuario)
        String insertCargoSQL = "INSERT INTO CARGO (nombre) VALUES ('" + usuario + "')";
        cnx.stm.executeUpdate(insertCargoSQL);

        // Obtener el idcargo del nuevo cargo insertado
        cnx.rs = cnx.stm.executeQuery("SELECT idcargo FROM CARGO WHERE nombre='" + usuario + "'");
        String idcargo = "";
        if (cnx.rs.next()) {
            idcargo = cnx.rs.getString("idcargo");
        }

        // Insertar el nuevo empleado con la clave y el idcargo
        String insertEmpleadoSQL = "INSERT INTO EMPLEADO (dni, nombre, telefono, sexo, direccion, fecha_ingreso, salario, idcargo, clave) "
                + "VALUES ('', '', '', '', '', GETDATE(), 0, '" + idcargo + "', '" + clave + "')";
        cnx.stm.executeUpdate(insertEmpleadoSQL);

        JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        jTxtUsuario.setText("");
        JpswdClave.setText("");
        JpswdConfirmarClave.setText("");
    } catch (Exception e) {
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al registrar el usuario. Intente nuevamente.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHijo = new javax.swing.JPanel();
        panelHijo2 = new keeptoo.KGradientPanel();
        jTxtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JpswdClave = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        panelRedondo2 = new FORMULARIOS.PanelRedondo();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBtnIngresar = new javax.swing.JButton();
        jBtnIngresar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JpswdConfirmarClave = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHijo2.setkEndColor(new java.awt.Color(255, 0, 255));
        panelHijo2.setkStartColor(new java.awt.Color(0, 253, 255));
        panelHijo2.setPreferredSize(new java.awt.Dimension(777, 491));

        jTxtUsuario.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jTxtUsuario.setToolTipText("");
        jTxtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTxtUsuario.setName(""); // NOI18N
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/candadologin.png"))); // NOI18N

        panelRedondo2.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo2.setRoundBottomLeft(70);
        panelRedondo2.setRoundTopRight(70);

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setText("REGISTRARSE EN EL SISTEMA");

        javax.swing.GroupLayout panelRedondo2Layout = new javax.swing.GroupLayout(panelRedondo2);
        panelRedondo2.setLayout(panelRedondo2Layout);
        panelRedondo2Layout.setHorizontalGroup(
            panelRedondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jBtnIngresar.setBackground(new java.awt.Color(235, 235, 235));
        jBtnIngresar.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jBtnIngresar.setForeground(new java.awt.Color(30, 128, 218));
        jBtnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/ingresar.png"))); // NOI18N
        jBtnIngresar.setText("        INICIAR SESIÓN      ");
        jBtnIngresar.setBorder(null);
        jBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresarActionPerformed(evt);
            }
        });

        jBtnIngresar1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jBtnIngresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/register.png"))); // NOI18N
        jBtnIngresar1.setText("        REGISTRARSE         ");
        jBtnIngresar1.setBorder(null);
        jBtnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresar1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CONFIRMAR CONTRASEÑA");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/contraseña-20.png"))); // NOI18N

        JpswdConfirmarClave.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        JpswdConfirmarClave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JpswdConfirmarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JpswdConfirmarClaveActionPerformed(evt);
            }
        });
        JpswdConfirmarClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JpswdConfirmarClaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelHijo2Layout = new javax.swing.GroupLayout(panelHijo2);
        panelHijo2.setLayout(panelHijo2Layout);
        panelHijo2Layout.setHorizontalGroup(
            panelHijo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHijo2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addGroup(panelHijo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelHijo2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(panelHijo2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(panelHijo2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(JpswdClave)
                    .addComponent(jBtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnIngresar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtUsuario)
                    .addComponent(JpswdConfirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHijo2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRedondo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        panelHijo2Layout.setVerticalGroup(
            panelHijo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHijo2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(panelRedondo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelHijo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHijo2Layout.createSequentialGroup()
                        .addGroup(panelHijo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelHijo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JpswdClave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelHijo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JpswdConfirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jBtnIngresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelHijoLayout = new javax.swing.GroupLayout(panelHijo);
        panelHijo.setLayout(panelHijoLayout);
        panelHijoLayout.setHorizontalGroup(
            panelHijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHijo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelHijoLayout.setVerticalGroup(
            panelHijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHijo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(panelHijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 777, 491));
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtUsuarioKeyPressed
    
    }//GEN-LAST:event_jTxtUsuarioKeyPressed

    private void JpswdClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpswdClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JpswdClaveActionPerformed

    private void JpswdClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JpswdClaveKeyPressed
      
    }//GEN-LAST:event_JpswdClaveKeyPressed

    private void jBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresarActionPerformed
    FRM_ACCESO_SISTEMA login = new FRM_ACCESO_SISTEMA();
        JPanel loginPanel = login.getMainPanel(); // Obtén el JPanel desde el JFrame
        ShowPanel(loginPanel);
       
     
    }//GEN-LAST:event_jBtnIngresarActionPerformed
  private void ShowPanel(JPanel p) {
        p.setSize(777, 491);
        p.setLocation(0, 0);
        panelHijo2.removeAll();
        panelHijo2.add(p, BorderLayout.CENTER);
        panelHijo2.validate();
        panelHijo2.repaint();
    }
    private void jBtnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresar1ActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_jBtnIngresar1ActionPerformed

    private void JpswdConfirmarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpswdConfirmarClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JpswdConfirmarClaveActionPerformed

    private void JpswdConfirmarClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JpswdConfirmarClaveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JpswdConfirmarClaveKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JpswdClave;
    private javax.swing.JPasswordField JpswdConfirmarClave;
    private javax.swing.JButton jBtnIngresar;
    private javax.swing.JButton jBtnIngresar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTxtUsuario;
    private javax.swing.JPanel panelHijo;
    private keeptoo.KGradientPanel panelHijo2;
    private FORMULARIOS.PanelRedondo panelRedondo2;
    // End of variables declaration//GEN-END:variables
}
