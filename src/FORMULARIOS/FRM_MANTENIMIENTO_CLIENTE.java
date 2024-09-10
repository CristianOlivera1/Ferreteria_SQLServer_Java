
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
public class FRM_MANTENIMIENTO_CLIENTE extends javax.swing.JFrame {
 conectaBD cnx=new conectaBD();
 int Sw;
 
  Date now=new Date(System.currentTimeMillis());
    SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
    
       public void convertiraMayusculas(javax.swing.JTextField jTextfieldS){
 String cadena= (jTextfieldS.getText()).toUpperCase();
 jTextfieldS.setText(cadena);
 }
    private TableRowSorter filtro;
      
      public void buscar() {
        int columnaABuscar = 0;
        if (jtxtbuscar.getText() == "Nombre") {
            columnaABuscar = 0;
        }
            
        filtro.setRowFilter(RowFilter.regexFilter(jtxtbuscar.getText(),0, columnaABuscar));
    }
      
      public void Limpiar(){
          this.jtxtcodigo.setText("");
          this.jtxtdni.setText("");
          this.jtxtnombre.setText("");
          this.jtxttelefono.setText("");
          this.jcbosexo.setSelectedItem("");
          this.jdcfecha.setDate(now);
          this.jtxtdireccion.setText("");
          this.jtxtdni.requestFocus();
      }
      
      public void Cajas(boolean estado){
          this.jtxtcodigo.setEnabled(estado);
          this.jtxtdni.setEnabled(estado);
          this.jtxtnombre.setEnabled(estado);
          this.jtxttelefono.setEnabled(estado);
          this.jcbosexo.setEnabled(estado);
          this.jdcfecha.setEnabled(estado);
          this.jtxtdireccion.setEnabled(estado);
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
             cod =jtbcliente.getValueAt(jtbcliente.getSelectedRow(),0).toString();
             cnx.rs=cnx.stm.executeQuery("SELECT * FROM V_MANTENIMIENTO_CLIENTE WHERE idcliente ='"+cod+"'");
             if(cnx.rs.next()){
                 this.jtxtcodigo.setText(cnx.rs.getString(1));
                 this.jtxtdni.setText(cnx.rs.getString(2));
                 this.jtxtnombre.setText(cnx.rs.getString(3));
                 this.jtxttelefono.setText(cnx.rs.getString(4));
                 this.jcbosexo.setSelectedItem(cnx.rs.getString(5));
                 this.jdcfecha.setDate(cnx.rs.getDate(6));
                 this.jtxtdireccion.setText(cnx.rs.getString(7));
                 
                 
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
      
      public void LlenarTabla(String con_sql){
       
        try{
           cnx.rs=cnx.stm.executeQuery(con_sql);
           DefaultTableModel model = (DefaultTableModel)jtbcliente.getModel();
           LimpiarTabla(model);
           while(cnx.rs.next()){
               String col1 = cnx.rs.getString(1);
               String col2 = cnx.rs.getString(2);
               String col3 = cnx.rs.getString(3);
               String col4 = cnx.rs.getString(4);
               String col5 = cnx.rs.getString(5); 
               String col6 = cnx.rs.getString(6);
               String col7 = cnx.rs.getString(7); 
               
               Vector vRow=new Vector();
               vRow.add(col1);
               vRow.add(col2);
               vRow.add(col3);
               vRow.add(col4);
               vRow.add(col5);
               vRow.add(col6);
               vRow.add(col7);
               model.addRow(vRow);
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
      
      public void Guardar(){
         String sql="SELECT *FROM V_MANTENIMIENTO_CLIENTE";
          String dni,nombre,telefono,sexo,fecha,direccion,codigo;
          int r;
          codigo=this.jtxtcodigo.getText();
          dni=this.jtxtdni.getText();
          nombre=this.jtxtnombre.getText();
          telefono=this.jtxttelefono.getText();
          sexo=this.jcbosexo.getSelectedItem().toString();
          fecha=date.format(this.jdcfecha.getDate());
          direccion=this.jtxtdireccion.getText();
          
           if (dni.equals("")||nombre.equals("")|| telefono.equals("")||sexo.equals("")||
  fecha.equals("")|| direccion.equals("")){
  JOptionPane.showMessageDialog(null,"existe espacios en blanco","error", JOptionPane.ERROR_MESSAGE);
           }
       else{
          try{
              if(Sw==0) {
                 cnx.stm.execute("INSERT INTO CLIENTE VALUES ('"+dni+"','"+nombre+"','"+telefono+"','"+sexo+"','"+fecha+"','"+direccion+"')");
                   JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAMENTE","Grabar",1);
                  
                }
              if(Sw==1){
            
                    cnx.stm.execute("UPDATE CLIENTE SET dni='"+dni+"',nombre='"+nombre+"',telefono='"+telefono+"',sexo='"+sexo+"',fecha_naci='"+fecha+"',direccion='"+direccion+"'WHERE idcliente='"+codigo+"'");
                   JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS CORRECTAMENTE","Grabar",1);
                
              }
               }
         catch(Exception e)    {
             System.out.println(e.getMessage());
         }     
         LlenarTabla(sql);
        jtbcliente.changeSelection(0, 0,false,true);
        Mostrar();
        Botones(true);
        Cajas(false);
      
        }
      } 
      
 public FRM_MANTENIMIENTO_CLIENTE() {
  initComponents();
     this.setLocationRelativeTo(this);
        this.setResizable(false);
        solonumeros(jtxtdni);
        sololetras(jtxtnombre);
        solonumeros(jtxttelefono);
    
 }


 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JGB1 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbcliente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlblc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxttelefono = new javax.swing.JTextField();
        jtxtnombre = new javax.swing.JTextField();
        jtxtdni = new javax.swing.JTextField();
        jtxtcodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtdireccion = new javax.swing.JTextField();
        jdcfecha = new com.toedter.calendar.JDateChooser();
        jcbosexo = new javax.swing.JComboBox();
        jBtnSalir = new javax.swing.JButton();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        panelRedondo1 = new FORMULARIOS.PanelRedondo();
        jLabel4 = new javax.swing.JLabel();
        jtxtbuscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        jtbcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "DNI", "NOMBRE", "TELEFONO", "SEXO", "FECHA NAC", "DIRECCION"
            }
        ));
        jtbcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbclienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbcliente);
        if (jtbcliente.getColumnModel().getColumnCount() > 0) {
            jtbcliente.getColumnModel().getColumn(0).setMinWidth(80);
            jtbcliente.getColumnModel().getColumn(0).setMaxWidth(70);
            jtbcliente.getColumnModel().getColumn(4).setMinWidth(40);
            jtbcliente.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setText("CONTROLES:");

        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo2.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar2.png"))); // NOI18N
        jBtnGuardar.setText("GUADAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancelar3.png"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar2.png"))); // NOI18N
        jBtnEditar.setText("EDITAR");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/delete_12523095.png"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("DATOS:");

        jlblc.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jlblc.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel2.setText("DNI:");

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel6.setText("Teléfono:");

        jtxttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxttelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxttelefonoKeyTyped(evt);
            }
        });

        jtxtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyReleased(evt);
            }
        });

        jtxtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdniKeyTyped(evt);
            }
        });

        jtxtcodigo.setEditable(false);
        jtxtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtcodigoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel7.setText("Sexo:");

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel8.setText("Fecha de Nacimiento:");

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel9.setText("Dirección:");

        jtxtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdireccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdireccionKeyReleased(evt);
            }
        });

        jdcfecha.setDateFormatString("dd-MM-yyyy");

        jcbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));
        jcbosexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbosexoKeyPressed(evt);
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

        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(245, 245, 245));
        jLabel12.setText("BUSCAR:");

        panelRedondo1.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo1.setRoundBottomLeft(20);
        panelRedondo1.setRoundBottomRight(20);
        panelRedondo1.setRoundTopLeft(20);
        panelRedondo1.setRoundTopRight(20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar_1.png"))); // NOI18N

        jtxtbuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
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
                .addGap(15, 15, 15)
                .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panelRedondo1Layout.setVerticalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jtxtbuscar))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento item.png"))); // NOI18N
        jLabel13.setText("   MANTENIMIENTO CLIENTE");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(panelRedondo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
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
                .addGap(52, 52, 52)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jlblc))
                        .addGap(37, 37, 37)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtxtdni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(jtxtcodigo, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(36, 36, 36)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(37, 37, 37)
                                .addComponent(jtxttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jBtnNuevo)
                                .addGap(33, 33, 33)
                                .addComponent(jBtnGuardar)
                                .addGap(33, 33, 33)
                                .addComponent(jBtnCancelar)
                                .addGap(33, 33, 33)
                                .addComponent(jBtnEditar)
                                .addGap(33, 33, 33)
                                .addComponent(jBtnEliminar)
                                .addGap(33, 33, 33)
                                .addComponent(jBtnSalir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(52, Short.MAX_VALUE))))
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblc))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

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
 private void jtxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyReleased
  /*String dato= this.jtxtbuscar.getText();
  String sql1;
  try{
   
    sql1="SELECT *FROM V_MANTENIMIENTO_CLIENTE WHERE dni LIKE '%"+dato+"%'";
    cnx.rs=cnx.stm.executeQuery(sql1);
    LlenarTabla(sql1);
   }
   catch(Exception e){
       System.out.println(e.getMessage());
   }*/
 }//GEN-LAST:event_jtxtbuscarKeyReleased

 private void jtbclienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbclienteMousePressed
  Mostrar();
 }//GEN-LAST:event_jtbclienteMousePressed

 private void jtxtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxttelefono.requestFocus();
  }
 }//GEN-LAST:event_jtxtnombreKeyPressed

 private void jtxttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttelefonoKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jcbosexo.requestFocus();
  }
 }//GEN-LAST:event_jtxttelefonoKeyPressed

 private void jtxtdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyPressed
  String sql,dni;
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   dni=this.jtxtdni.getText();
   sql="SELECT * FROM V_MANTENIMIENTO_CLIENTE WHERE dni='"+ dni +"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql);
    if(cnx.rs.next()){
     JOptionPane.showMessageDialog(null,"CLIENTE YA ESTA REGISTRADO","Aviso",1);
     Limpiar();
    }
    else{

     this.jtxtnombre.requestFocus();

    }
   }catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
 }//GEN-LAST:event_jtxtdniKeyPressed

 private void jtxtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyTyped
  String Caracteres = jtxtdni.getText();
  if(Caracteres.length()>=8){
   evt.consume();
  }

 }//GEN-LAST:event_jtxtdniKeyTyped

 private void jcbosexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbosexoKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jdcfecha.requestFocus();
  }
 }//GEN-LAST:event_jcbosexoKeyPressed

 private void jtxtdireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdireccionKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jBtnGuardar.requestFocus();
  }
 }//GEN-LAST:event_jtxtdireccionKeyPressed

 private void jdcfechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcfechaKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxtdireccion.requestFocus();
  }
 }//GEN-LAST:event_jdcfechaKeyPressed

 private void jtxtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtcodigoActionPerformed

 }//GEN-LAST:event_jtxtcodigoActionPerformed

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  String sql;
        sql="SELECT * FROM V_MANTENIMIENTO_CLIENTE ORDER BY nombre";
        cnx.conectar();
        LlenarTabla(sql);
         Mostrar();
        jtbcliente.changeSelection(0, 0, false, true);
        Botones(true);
        Cajas(false);
        this.jdcfecha.setDate(now);
       
 }//GEN-LAST:event_formWindowOpened

 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
  Sw = 0;
  Limpiar();
  Botones(false);
  Cajas(true);
  this.jtxtcodigo.setVisible(false);
  this.jlblc.setVisible(false);
  this.jtxtdni.requestFocus();
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
  jtbcliente.changeSelection(0, 0,false,true);
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
  this.jlblc.setVisible(true);
  this.jtxtdni.requestFocus();
 }//GEN-LAST:event_jBtnEditarActionPerformed

 private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
  String sql,cod;
  String sql1="SELECT*FROM V_MANTENIMIENTO_CLIENTE";
  int r;
  cod=this.jtbcliente.getValueAt(this.jtbcliente.getSelectedRow(),0).toString();
  sql="DELETE FROM CLIENTE WHERE idcliente='"+cod+"'";
  try{
   r=JOptionPane.showConfirmDialog(null,"DESEA ELIMINAR REGISTRO","ESTA SEGURO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
   if(r==JOptionPane.YES_OPTION){
    cnx.stm.execute(sql);
    
   }
  }
  catch(Exception e){
   System.out.println(e.getMessage());
   JOptionPane.showConfirmDialog(null,"ERROR AL ELIMINAR ABANCAY");
  }
  LlenarTabla(sql1);
  jtbcliente.changeSelection(0,0,false,true);
  Mostrar();
 }//GEN-LAST:event_jBtnEliminarActionPerformed

 private void jtxttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttelefonoKeyTyped
  String Caracteres = jtxttelefono.getText();
  if(Caracteres.length()>=9){
   evt.consume();
  }
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxttelefonoKeyTyped

 private void jtxtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyReleased
convertiraMayusculas(jtxtnombre);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtnombreKeyReleased

 private void jtxtdireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdireccionKeyReleased
convertiraMayusculas(jtxtdireccion);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtdireccionKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        String sql1="SELECT * FROM V_MANTENIMIENTO_CLIENTE ORDER BY nombre";
        LlenarTabla(sql1);
    }//GEN-LAST:event_formWindowActivated

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed
    //buscar cliente
    private TableRowSorter trsFiltro;
    public void buscarcliente() {
    int Buscar = 0;
    if (jtxtbuscar.getText().equalsIgnoreCase("nombre")) {
        Buscar = 0;
    }
    trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)" + jtxtbuscar.getText(), 2, Buscar));
    }
    private void jtxtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyTyped
        jtxtbuscar.addKeyListener(new KeyAdapter() {
         public void keyReleased(final KeyEvent e) {
             String cadena = (jtxtbuscar.getText());
             jtxtbuscar.setText(cadena);
             repaint();
             buscarcliente();
         }
     });
     trsFiltro = new TableRowSorter(jtbcliente.getModel());
     jtbcliente.setRowSorter(trsFiltro);
        
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
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_CLIENTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MANTENIMIENTO_CLIENTE().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup JGB1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbosexo;
    private com.toedter.calendar.JDateChooser jdcfecha;
    private javax.swing.JLabel jlblc;
    private javax.swing.JTable jtbcliente;
    private javax.swing.JTextField jtxtbuscar;
    private javax.swing.JTextField jtxtcodigo;
    private javax.swing.JTextField jtxtdireccion;
    private javax.swing.JTextField jtxtdni;
    private javax.swing.JTextField jtxtnombre;
    private javax.swing.JTextField jtxttelefono;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private FORMULARIOS.PanelRedondo panelRedondo1;
    // End of variables declaration//GEN-END:variables
}
