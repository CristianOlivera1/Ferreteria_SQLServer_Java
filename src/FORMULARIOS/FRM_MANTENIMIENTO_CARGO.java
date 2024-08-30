package FORMULARIOS;
import BASE.conectaBD;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FRM_MANTENIMIENTO_CARGO extends javax.swing.JFrame {
 conectaBD cnx=new conectaBD();
 int Sw;
      public void convertiraMayusculas(javax.swing.JTextField jTextfieldS){
 String cadena= (jTextfieldS.getText()).toUpperCase();
 jTextfieldS.setText(cadena);
 }
 private TableRowSorter trsFiltro;
public void buscarcategoria() {
        int Buscar = 0;
        if (jtxtbuscar.getText() =="CARGO") {
            Buscar = 0;
        }       
        trsFiltro.setRowFilter(RowFilter.regexFilter(jtxtbuscar.getText(),1, Buscar));
    }
public void Limpiar() {
this.jtxtcodigo.setText("");
this.jtxtcargo.setText("");
this.jtxtcodigo.requestFocus();

}
public void Cajas(boolean estado ) {
this.jtxtcodigo.setEnabled(estado);
this.jtxtcargo.setEnabled(estado);


}
public void Botones(boolean estado){
this.jBtnNuevo.setEnabled(estado);
this.jBtnGuardar.setEnabled(!estado);
this.jBtnCancelar.setEnabled(!estado);
this.jBtnEditar.setEnabled(estado);
this.jBtnEliminar.setEnabled(estado);
this.jBtnSalir.setEnabled(estado);
}
public void LimpiarTabla(DefaultTableModel model){
  int x;
  for (x=model.getRowCount()-1; x>=0;x--){
   model.removeRow(x); 
  }  
 }
public void Mostrar(){
         String cod;
         try{
             cod =jtbcargo.getValueAt(jtbcargo.getSelectedRow(),0).toString();
             cnx.rs=cnx.stm.executeQuery("SELECT * FROM V_MANTENIMIENTO_CARGO WHERE idcargo='"+cod+"'");
             if(cnx.rs.next()){
                 this.jtxtcodigo.setText(cnx.rs.getString(1));
                 this.jtxtcargo.setText(cnx.rs.getString(2));
                
 
             }
         }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
 }
   public void LlenarTabla(){
   String sql;
   sql="SELECT*FROM V_MANTENIMIENTO_CARGO";
   try{
    //consulta
    cnx.rs=cnx.stm.executeQuery(sql);
    //defino la variable
    DefaultTableModel model=(DefaultTableModel) jtbcargo.getModel();
    //limpio los datos
    LimpiarTabla(model);
    //llenar los datos
    while(cnx.rs.next()){
     String col1=cnx.rs.getString(1);
     String col2=cnx.rs.getString(2);
      
     //vRow es ifual a una fila
     Vector vRow=new Vector ();
     vRow.addElement(col1);
     vRow.addElement(col2);
    
  
     model.addRow(vRow);
     
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
     
   }
  }


 public FRM_MANTENIMIENTO_CARGO() {
  initComponents();
   this.setLocationRelativeTo(this);
  this.setResizable(false);
  //  this.getContentPane().setBackground(Color.CYAN);
    sololetras(jtxtcargo);
 }


 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbcargo = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnNuevo = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlblcodigo = new javax.swing.JLabel();
        jtxtcodigo = new javax.swing.JTextField();
        jtxtcargo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        panelRedondo1 = new FORMULARIOS.PanelRedondo();
        jLabel4 = new javax.swing.JLabel();
        jtxtbuscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRACION DE CARGO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 255, 255));

        jtbcargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CÓDIGO", "CARGO"
            }
        ));
        jtbcargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbcargoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbcargoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbcargo);
        if (jtbcargo.getColumnModel().getColumnCount() > 0) {
            jtbcargo.getColumnModel().getColumn(0).setMinWidth(80);
            jtbcargo.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setText("CONTROLES:");

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancela.png"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Eliminarr.png"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte I.png"))); // NOI18N
        jBtnEditar.setText("EDITAR");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/guardar.png"))); // NOI18N
        jBtnGuardar.setText("GUADAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir2.png"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("DATOS:");

        jlblcodigo.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jlblcodigo.setText("Código:");

        jtxtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcodigoKeyPressed(evt);
            }
        });

        jtxtcargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcargoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtcargoKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel2.setText("Cargo:");

        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(245, 245, 245));
        jLabel12.setText("BUSCAR POR CÓDIGO:");

        panelRedondo1.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo1.setRoundBottomLeft(20);
        panelRedondo1.setRoundBottomRight(20);
        panelRedondo1.setRoundTopLeft(20);
        panelRedondo1.setRoundTopRight(20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar_1.png"))); // NOI18N

        jtxtbuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtxtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelRedondo1Layout = new javax.swing.GroupLayout(panelRedondo1);
        panelRedondo1.setLayout(panelRedondo1Layout);
        panelRedondo1Layout.setHorizontalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRedondo1Layout.setVerticalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtbuscar)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento item.png"))); // NOI18N
        jLabel13.setText(" MANTENIMIENTO CARGO");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jBtnNuevo)
                                        .addGap(27, 27, 27)
                                        .addComponent(jBtnGuardar))
                                    .addComponent(jBtnEliminar))
                                .addGap(28, 28, 28)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnCancelar)
                                    .addComponent(jBtnSalir)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblcodigo)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jBtnEditar)))
                .addContainerGap(222, Short.MAX_VALUE))
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblcodigo)
                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void sololetras (JTextField a){
  a.addKeyListener(new KeyAdapter(){
    public void keyTyped (KeyEvent e){
    char c=e.getKeyChar();
    if(Character.isDigit(c)&& !Character.isSpaceChar(c)){        
     getToolkit().beep();
     e.consume();
    }
   }
  });
}
 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 cnx.conectar();
LlenarTabla();
jtbcargo.changeSelection(0, 0,false,true);
Botones(true);
Cajas(false);

 }//GEN-LAST:event_formWindowOpened

 private void jtbcargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbcargoMousePressed

 }//GEN-LAST:event_jtbcargoMousePressed

 private void jtxtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyTyped
  jtxtbuscar.addKeyListener(new KeyAdapter() {
   public void keyReleased(final KeyEvent e) {
    String cadena = (jtxtbuscar.getText());
    jtxtbuscar.setText(cadena);
    repaint();
    buscarcategoria();
   }
  });
  trsFiltro = new TableRowSorter(jtbcargo.getModel());
  jtbcargo.setRowSorter(trsFiltro);
 }//GEN-LAST:event_jtxtbuscarKeyTyped

 private void jtbcargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbcargoMouseClicked
Mostrar();
 }//GEN-LAST:event_jtbcargoMouseClicked

 private void jtxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyReleased
convertiraMayusculas(jtxtbuscar);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtbuscarKeyReleased

 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
  Sw = 0;
  Limpiar();
  Botones(false);
  Cajas(true);
  this.jtxtcodigo.setVisible(false);
  this.jlblcodigo.setVisible(false);
  this.jtxtcargo.requestFocus();
 }//GEN-LAST:event_jBtnNuevoActionPerformed
public void guardar(){
 int r;
 String cod,marca;
   cod=this.jtxtcodigo.getText();
  marca=this.jtxtcargo.getText();

   if (marca.equals("")){
  JOptionPane.showMessageDialog(null,"REGISTRE  EL CARGO PORFAVOR","error", JOptionPane.ERROR_MESSAGE);
   }
  else{ 
      try{
       
         if(Sw==0){ 
                    cnx.stm.execute("INSERT INTO CARGO VALUES('"+ marca +"')");
                      JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAMENTE ","Grabar",1);
            }
            if(Sw==1){
              
                    cnx.stm.execute("UPDATE  CARGO SET nombre='"+marca+"' WHERE idcargo='"+ cod +"'");
               JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS CORRECTAMENTE ","Grabar",1);
                }
        }
        catch(SQLException a){
            System.out.println(a.getMessage());
        }
        LlenarTabla();
        jtbcargo.changeSelection(0, 0,false,true);
        Mostrar();
        Botones(true);
        Cajas(false);
}
}
 private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
  try{
  guardar();

  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jBtnGuardarActionPerformed

 private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
  jtbcargo.changeSelection(0, 0,false,true);
  Mostrar();
  Botones(true);
  Cajas(false);
 }//GEN-LAST:event_jBtnCancelarActionPerformed

 private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
  Sw = 1;
  Mostrar();
  Botones(false);
  Cajas(true);
  this.jtxtcodigo.setVisible(true);
  this.jlblcodigo.setVisible(true);
   this.jtxtcargo.requestFocus();
 }//GEN-LAST:event_jBtnEditarActionPerformed

 private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
  String sql,cod;
  int r;
  cod=this.jtbcargo.getValueAt(this.jtbcargo.getSelectedRow(),0).toString();
 sql="DELETE FROM CARGO WHERE idcargo='"+cod+"'";
  try{
   r=JOptionPane.showConfirmDialog(null,"DESEA ELIMINAR REGISTRO","ESTA SEGURO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
   if(r==JOptionPane.YES_OPTION){
    cnx.stm.execute(sql);
   }
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
  LlenarTabla();
  jtbcargo.changeSelection(0,0,false,true);
  Mostrar();
 }//GEN-LAST:event_jBtnEliminarActionPerformed

 private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
  this.dispose();
 }//GEN-LAST:event_jBtnSalirActionPerformed

 private void jtxtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcodigoKeyPressed
    if(evt.getKeyCode()==KeyEvent.VK_ENTER){
  this.jtxtcargo.requestFocus();
  
 }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtcodigoKeyPressed

 private void jtxtcargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcargoKeyReleased
convertiraMayusculas(jtxtcargo);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtcargoKeyReleased

    private void jtxtcargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcargoKeyPressed
        String sql,nombre;
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   nombre=this.jtxtcargo.getText();
   sql="SELECT * FROM V_MANTENIMIENTO_CARGO WHERE nombre='"+nombre+"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql);
    if(cnx.rs.next()){
     JOptionPane.showMessageDialog(null,"CARGO YA ESTA REGISTRADO","Aviso",1);
     Limpiar();
    }
    else{

     this.jtxtcargo.requestFocus();

    }
   }catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
    }//GEN-LAST:event_jtxtcargoKeyPressed
 
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
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CARGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CARGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CARGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CARGO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MANTENIMIENTO_CARGO().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblcodigo;
    private javax.swing.JTable jtbcargo;
    private javax.swing.JTextField jtxtbuscar;
    private javax.swing.JTextField jtxtcargo;
    private javax.swing.JTextField jtxtcodigo;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private FORMULARIOS.PanelRedondo panelRedondo1;
    // End of variables declaration//GEN-END:variables
}
