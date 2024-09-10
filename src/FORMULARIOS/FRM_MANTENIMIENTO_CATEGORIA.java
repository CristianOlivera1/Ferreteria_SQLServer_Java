
package FORMULARIOS;
import BASE.conectaBD;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class FRM_MANTENIMIENTO_CATEGORIA extends javax.swing.JFrame {
 conectaBD cnx=new conectaBD();
 int Sw;
 
  Date now=new Date(System.currentTimeMillis());
    SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
       public void convertiraMayusculas(javax.swing.JTextField jTextfieldS){
 String cadena= (jTextfieldS.getText()).toUpperCase();
 jTextfieldS.setText(cadena);
 }
  
      public void Limpiar(){
          this.jtxtcodigo.setText("");
          this.jtxtnombre.setText("");
          this.jtxtdescripcion.setText("");
          this.jtxtnombre.requestFocus();
      }
      
      public void Cajas(boolean estado){
          this.jtxtcodigo.setEnabled(estado);
          this.jtxtnombre.setEnabled(estado);
          this.jtxtdescripcion.setEnabled(estado);
      }
      
      public void Botones(boolean estado){
         this.jBtnNuevo.setEnabled(estado);
         this.jBtnGuardar.setEnabled(!estado);
         this.jBtnCancelar.setEnabled(!estado);
         this.jBtnEditar.setEnabled(estado);
         this.jBtnEliminar.setEnabled(estado);
         this.jBtnSalir.setEnabled(estado);           
        } 
      
       public void Mostrar(){
         String cod;
         try{
             cod =jtbconcepto.getValueAt(jtbconcepto.getSelectedRow(),0).toString();
             cnx.rs=cnx.stm.executeQuery("SELECT * FROM V_MANTENIMIENTO_CATEGORIA WHERE idcategoria ='"+cod+"'");
             if(cnx.rs.next()){
                 this.jtxtcodigo.setText(cnx.rs.getString(1));
                 this.jtxtnombre.setText(cnx.rs.getString(2));
                   this.jtxtdescripcion.setText(cnx.rs.getString(3));
                 
            }
         }
         catch(Exception e)    {
             System.out.println(e.getMessage());
         }
     }
    
      public void LimpiarTabla(DefaultTableModel model){
        int x;
        for(x=model.getRowCount()-1;x>=0;x--){
            model.removeRow(x);
        }
    }
      
      public void LlenarTabla(){
       String sql="SELECT*FROM V_MANTENIMIENTO_CATEGORIA";
        try{
           cnx.rs=cnx.stm.executeQuery(sql);
           DefaultTableModel model = (DefaultTableModel)jtbconcepto.getModel();
           LimpiarTabla(model);
           while(cnx.rs.next()){
               String col1 = cnx.rs.getString(1);
               String col2 = cnx.rs.getString(2);
               String col3 = cnx.rs.getString(3);
          
            
               
               Vector vRow=new Vector();
               vRow.add(col1);
               vRow.add(col2);
               vRow.add(col3);
         
               model.addRow(vRow);
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
      
      public void Guardar(){
          String nombre,des,codigo;
          int r;
          codigo=this.jtxtcodigo.getText();
          nombre=this.jtxtnombre.getText();
          des=this.jtxtdescripcion.getText();
          
           if (des.equals("")||nombre.equals("")){
  JOptionPane.showMessageDialog(null,"EXISTE ESPACIOS EN BLANCO","error", JOptionPane.ERROR_MESSAGE);
           }
       else{
          try{
              if(Sw==0) {
                 cnx.stm.execute("INSERT INTO CATEGORIA VALUES ('"+nombre+"','"+des+"')");
                   JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAMENTE","Grabar",1);
                  
                }
              if(Sw==1){
            
                    cnx.stm.execute("UPDATE CATEGORIA SET nombre='"+nombre+"',descripcion='"+des+"' WHERE idcategoria='"+codigo+"'");
                   JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS CORRECTAMENTE","Grabar",1);
                
              }
               }
         catch(Exception e)    {
             System.out.println(e.getMessage());
         }     
         LlenarTabla();
        jtbconcepto.changeSelection(0, 0,false,true);
        Mostrar();
        Botones(true);
        Cajas(false);
      
        }
      } 
      
 public FRM_MANTENIMIENTO_CATEGORIA() {
  initComponents();
     this.setLocationRelativeTo(this);
        this.setResizable(false);
     
        sololetras(jtxtnombre);
    
 }


 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbconcepto = new javax.swing.JTable();
        jBtnNuevo = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jlblc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtdescripcion = new javax.swing.JTextField();
        jtxtnombre = new javax.swing.JTextField();
        jtxtcodigo = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel13 = new javax.swing.JLabel();
        panelRedondo1 = new FORMULARIOS.PanelRedondo();
        jtxtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRACION DE CATEGORIA");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 255, 255));

        jtbconcepto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtbconcepto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO", "CATEGORIA", "DESCRIPCION"
            }
        ));
        jtbconcepto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbconceptoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbconcepto);
        if (jtbconcepto.getColumnModel().getColumnCount() > 0) {
            jtbconcepto.getColumnModel().getColumn(0).setMinWidth(80);
            jtbconcepto.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jBtnNuevo.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo2.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnEditar.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar2.png"))); // NOI18N
        jBtnEditar.setText("EDITAR");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/delete_12523095.png"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnSalir.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir2.png"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnCancelar.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancelar3.png"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnGuardar.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar2.png"))); // NOI18N
        jBtnGuardar.setText("GUADAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jlblc.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jlblc.setText("Código:");

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel5.setText("Categoría:");

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel9.setText("Descripción:");

        jtxtdescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdescripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdescripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdescripcionKeyTyped(evt);
            }
        });

        jtxtnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyReleased(evt);
            }
        });

        jtxtcodigo.setEditable(false);
        jtxtcodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento item.png"))); // NOI18N
        jLabel13.setText(" MANTENIMIENTO CATEGORÍA");

        panelRedondo1.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo1.setRoundBottomLeft(20);
        panelRedondo1.setRoundBottomRight(20);
        panelRedondo1.setRoundTopLeft(20);
        panelRedondo1.setRoundTopRight(20);

        jtxtbuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jtxtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar_1.png"))); // NOI18N

        javax.swing.GroupLayout panelRedondo1Layout = new javax.swing.GroupLayout(panelRedondo1);
        panelRedondo1.setLayout(panelRedondo1Layout);
        panelRedondo1Layout.setHorizontalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRedondo1Layout.setVerticalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(panelRedondo1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(245, 245, 245));
        jLabel6.setText("BUSCAR:");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel6)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setText("CONTROLES:");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("DATOS:");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlblc)
                                            .addComponent(jLabel5))
                                        .addGap(13, 13, 13))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtxtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                        .addComponent(jtxtdescripcion))
                                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(180, 180, 180))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jBtnNuevo)
                                .addGap(30, 30, 30)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jBtnEliminar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jBtnSalir))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jBtnGuardar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jBtnEditar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jBtnCancelar))))))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo)
                    .addComponent(jBtnGuardar)
                    .addComponent(jBtnEditar)
                    .addComponent(jBtnCancelar))
                .addGap(32, 32, 32)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblc))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(36, 36, 36))
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

   public void solonumeros (JTextField a){
    a.addKeyListener(new KeyAdapter(){
    public void keyTyped (KeyEvent e){
    char c=e.getKeyChar();
    if(!Character.isDigit(c)){
     getToolkit().beep();
     e.consume();
    }     
            
   }
  }); 
 }
 public void sololetras (JTextField a){
  a.addKeyListener(new KeyAdapter(){
    public void keyTyped (KeyEvent e){
    char c=e.getKeyChar();
    if(!Character.isLetter(c) && !Character.isSpaceChar(c) ){        
     getToolkit().beep();
     e.consume();
    }
   }
  }); 
 }
 private void jtbconceptoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbconceptoMousePressed
  Mostrar();
 }//GEN-LAST:event_jtbconceptoMousePressed

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 
  cnx.conectar();
 LlenarTabla();
  Mostrar();
        jtbconcepto.changeSelection(0, 0, false, true);
        Botones(true);
        Cajas(false);
 }//GEN-LAST:event_formWindowOpened

 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
  Sw = 0;
  Limpiar();
  Botones(false);
  Cajas(true);
  this.jlblc.setVisible(false);
  this.jtxtcodigo.setVisible(false);
 }//GEN-LAST:event_jBtnNuevoActionPerformed

 private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
  try{
   Guardar();
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jBtnGuardarActionPerformed

 private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
  jtbconcepto.changeSelection(0, 0,false,true);
  Mostrar();
  Botones(true);
  Cajas(false);
 }//GEN-LAST:event_jBtnCancelarActionPerformed

 private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
  Sw = 1;
  Mostrar();
  Botones(false);
  Cajas(true);
   this.jlblc.setVisible(true);
  this.jtxtcodigo.setVisible(true);
 }//GEN-LAST:event_jBtnEditarActionPerformed

 private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
  String sql,cod;
  String sql1="SELECT*FROM V_MANTENIMIENTO_CATEGORIA";
  int r;
  cod=this.jtbconcepto.getValueAt(this.jtbconcepto.getSelectedRow(),0).toString();
  sql="DELETE FROM CATEGORIA WHERE idcategoria='"+cod+"'";
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
  jtbconcepto.changeSelection(0,0,false,true);
  Mostrar();
 }//GEN-LAST:event_jBtnEliminarActionPerformed

 private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
  this.dispose();
 }//GEN-LAST:event_jBtnSalirActionPerformed

 private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
  LlenarTabla();
 }//GEN-LAST:event_formWindowActivated

 private void jtxtdescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdescripcionKeyReleased
  convertiraMayusculas(jtxtdescripcion);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtdescripcionKeyReleased

 private void jtxtdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdescripcionKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jBtnGuardar.requestFocus();
  }
 }//GEN-LAST:event_jtxtdescripcionKeyPressed

 private void jtxtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyReleased
  convertiraMayusculas(jtxtnombre);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtnombreKeyReleased

 private void jtxtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyPressed
  String sql,nombre;
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   nombre=this.jtxtnombre.getText();
   sql="SELECT * FROM V_MANTENIMIENTO_CATEGORIA WHERE nombre='"+nombre+"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql);
    if(cnx.rs.next()){
     JOptionPane.showMessageDialog(null,"Categoria ya registrada","Aviso",1);
     Limpiar();
    }
    else{

     this.jtxtnombre.requestFocus();

    }
   }catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
 }//GEN-LAST:event_jtxtnombreKeyPressed

 private void jtxtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdescripcionKeyTyped
 
 }//GEN-LAST:event_jtxtdescripcionKeyTyped
 
 private TableRowSorter trsFiltro;
 public void buscarcategoria() {
    int Buscar = 0;
    if (jtxtbuscar.getText().equalsIgnoreCase("nombre")) {
        Buscar = 0;
    }
    trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + jtxtbuscar.getText(), 1, Buscar));
}
    private void jtxtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyTyped
        jtxtbuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (jtxtbuscar.getText());
                jtxtbuscar.setText(cadena);
                repaint();
                buscarcategoria();
            }
        });
        trsFiltro = new TableRowSorter(jtbconcepto.getModel());
        jtbconcepto.setRowSorter(trsFiltro);
    }//GEN-LAST:event_jtxtbuscarKeyTyped

 /**
  * @param args the command line
  * arguments
  */
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
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MANTENIMIENTO_CATEGORIA().setVisible(true);
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblc;
    private javax.swing.JTable jtbconcepto;
    private javax.swing.JTextField jtxtbuscar;
    private javax.swing.JTextField jtxtcodigo;
    private javax.swing.JTextField jtxtdescripcion;
    private javax.swing.JTextField jtxtnombre;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private FORMULARIOS.PanelRedondo panelRedondo1;
    // End of variables declaration//GEN-END:variables
}
