
package FORMULARIOS;
import BASE.conectaBD;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class FRM_MANTENIMIENTO_EMPLEADO extends javax.swing.JFrame {
 conectaBD cnx=new conectaBD();
 int Sw;
 
  Date now = new Date(System.currentTimeMillis());
 SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
 
    public void convertiraMayusculasEnJtextfield(javax.swing.JTextField jTextfieldS){
 String cadena= (jTextfieldS.getText()).toUpperCase();
 jTextfieldS.setText(cadena);
 }
      public void icono(){
      Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/users.gif"));
      setIconImage(icon);
      setVisible(true);
    }
 private TableRowSorter trsFiltro;
public void buscarzona() {
        int Buscar = 0;
        if (jtxtbuscar.getText() =="DNI") {
            Buscar = 0;
        }       
        trsFiltro.setRowFilter(RowFilter.regexFilter(jtxtbuscar.getText(),1, Buscar));
    }
 public void Limpiar() {
this.jtxtcod.setText("");
this.jtxtnombre.setText("");
this.jtxtdni.setText("");
this.jtxttelefono.setText("");
this.jcbosexo.setSelectedItem(0);
this.jtxtdireccion.setText("");
this.jdcfechaingreso.setDate(now);
this.jtxtsalario.setText("");
this.jcbocargo.setSelectedItem(0);
this.jtxtclave.setText("");
this.jtxtcod.requestFocus();

}
public void Cajas(boolean estado ) {
this.jtxtcod.setEnabled(estado);
this.jtxtnombre.setEnabled(estado);
this.jtxtdni.setEnabled(estado);
this.jtxttelefono.setEnabled(estado);
this.jcbosexo.setEnabled(estado);
this.jtxtdireccion.setEnabled(estado);
this.jdcfechaingreso.setEnabled(estado);
this.jtxtsalario.setEnabled(estado);
this.jcbocargo.setEnabled(estado);
this.jtxtclave.setEnabled(estado);
}
public void Botones(boolean estado){
this.jBtnNuevo.setEnabled(estado);
this.jBtnGuardar.setEnabled(!estado);
this.jBtnCancelar.setEnabled(!estado);
this.jBtnEditar.setEnabled(estado);
this.jBtnEliminar.setEnabled(estado);
this.jBtnSalir.setEnabled(estado);
}

public void CargaCombocargo(){
try{
cnx.rs=cnx.stm.executeQuery("SELECT  nombre FROM CARGO ORDER BY 1");
while(cnx.rs.next()){
jcbocargo.addItem(cnx.rs.getString(1));
}
}catch(Exception e){
System.out.println(e.getMessage());
}
}
public void Mostrar(){
String cod;
try{
cod=jtbempleado.getValueAt(jtbempleado.getSelectedRow(), 0).toString();
cnx.rs=cnx.stm.executeQuery("SELECT * FROM V_MANTENIMIENTO_EMPLEADO WHERE idempleado=' "+cod+" ' ");
if(cnx.rs.next()){
this.jtxtcod.setText(cnx.rs.getString(1));
this.jtxtdni.setText(cnx.rs.getString(2));
this.jtxtnombre.setText(cnx.rs.getString(3));
this.jtxttelefono.setText(cnx.rs.getString(4));
this.jcbosexo.setSelectedItem(cnx.rs.getString(5));
this.jtxtdireccion.setText(cnx.rs.getString(6));
this.jdcfechaingreso.setDate(cnx.rs.getDate(7));
this.jtxtsalario.setText(cnx.rs.getString(8));
this.jcbocargo.setSelectedItem(cnx.rs.getString(9));
this.jtxtclave.setText(cnx.rs.getString(10));

  
}
}catch(Exception a){
System.out.println(a.getMessage());
}
}
public void LimpiarTabla(DefaultTableModel model){
  int x;
  for (x=model.getRowCount()-1; x>=0;x--){
   model.removeRow(x); 
  }  
 }
   public void LlenarTabla(){
   String sql;
   sql="SELECT*FROM V_MANTENIMIENTO_EMPLEADO ";
   try{
    //consulta
    cnx.rs=cnx.stm.executeQuery(sql);
    //defino la variable
    DefaultTableModel model=(DefaultTableModel) jtbempleado.getModel();
    //limpio los datos
    LimpiarTabla(model);
    //llenar los datos
    while(cnx.rs.next()){
     String col1=cnx.rs.getString(1);
     String col2=cnx.rs.getString(2);
     String col3=cnx.rs.getString(3);
     String col4=cnx.rs.getString(4);
     String col5=cnx.rs.getString(5);
    String col6=cnx.rs.getString(6);
     String col7=cnx.rs.getString(7);
      String col8=cnx.rs.getString(8);
       String col9=cnx.rs.getString(9);
        String col10=cnx.rs.getString(10);
        
    
       
     //vRow es ifual a una fila
     Vector vRow=new Vector ();
     vRow.addElement(col1);
     vRow.addElement(col2);
     vRow.addElement(col3);
     vRow.addElement(col4);
     vRow.addElement(col5);  
     vRow.addElement(col6); 
       vRow.addElement(col7);  
       vRow.addElement(col8); 
         vRow.addElement(col9); 
           vRow.addElement(col10); 
           
       
     model.addRow(vRow);
     
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
     
   }
  }
 public FRM_MANTENIMIENTO_EMPLEADO() {
  initComponents();
   this.setLocationRelativeTo(this);
  this.setResizable(false);
  //  this.getContentPane().setBackground(Color.CYAN);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbempleado = new javax.swing.JTable();
        jtxtcod = new javax.swing.JTextField();
        jlblc = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcbocargo = new javax.swing.JComboBox();
        jdcfechaingreso = new com.toedter.calendar.JDateChooser();
        jtxtdireccion = new javax.swing.JTextField();
        jtxttelefono = new javax.swing.JTextField();
        jtxtnombre = new javax.swing.JTextField();
        jtxtdni = new javax.swing.JTextField();
        jcbosexo = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jtxtsalario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtclave = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        panelRedondo1 = new FORMULARIOS.PanelRedondo();
        jtxtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 255, 255));

        jBtnNuevo.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo2.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
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

        jBtnCancelar.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancelar3.png"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setText("CONTROLES:");

        jtbempleado.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jtbempleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "DNI", "NOMBRES", "TELÉFONO", "SEXO", "DIRECCION", "FECHA INGRESO", "SALARIO", "CARGO", "CLAVE"
            }
        ));
        jtbempleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbempleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbempleado);
        if (jtbempleado.getColumnModel().getColumnCount() > 0) {
            jtbempleado.getColumnModel().getColumn(0).setMinWidth(60);
            jtbempleado.getColumnModel().getColumn(0).setMaxWidth(20);
            jtbempleado.getColumnModel().getColumn(4).setMinWidth(60);
            jtbempleado.getColumnModel().getColumn(4).setMaxWidth(20);
        }

        jtxtcod.setEditable(false);
        jtxtcod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcodKeyPressed(evt);
            }
        });

        jlblc.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jlblc.setText("Código:");

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel8.setText("DNI:");

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel11.setText("Teléfono:");

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel12.setText("Dirección:");

        jLabel15.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel15.setText("Fecha de ingreso:");

        jLabel16.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel16.setText("Cargo:");

        jcbocargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbocargoActionPerformed(evt);
            }
        });

        jdcfechaingreso.setDateFormatString("dd-MM-yyyy");

        jtxttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
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

        jtxtdni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdniKeyTyped(evt);
            }
        });

        jcbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel10.setText("Sexo:");

        jLabel14.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel14.setText("Salario:");

        jLabel17.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel17.setText("Clave:");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setText("DATOS:");

        kGradientPanel2.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(245, 245, 245));
        jLabel5.setText("BUSCAR POR DNI:");

        panelRedondo1.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo1.setRoundBottomLeft(20);
        panelRedondo1.setRoundBottomRight(20);
        panelRedondo1.setRoundTopLeft(20);
        panelRedondo1.setRoundTopRight(20);

        jtxtbuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtxtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtbuscarActionPerformed(evt);
            }
        });
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
                .addContainerGap()
                .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panelRedondo1Layout.setVerticalGroup(
            panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRedondo1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jtxtbuscar))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento item.png"))); // NOI18N
        jLabel4.setText("   MANTENIMIENTO EMPLEADO");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
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
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
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
                            .addComponent(jlblc)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jtxtcod, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtdni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel10)
                                        .addGap(42, 42, 42)
                                        .addComponent(jcbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(59, 59, 59)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(48, 48, 48)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbocargo, 0, 174, Short.MAX_VALUE)
                                    .addComponent(jtxtsalario)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdcfechaingreso, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(jtxtclave)))))
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
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
                        .addComponent(jBtnSalir)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbocargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jtxtclave))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblc)
                            .addComponent(jtxtcod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jcbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtxttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtxtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
  Sw = 0;
  Limpiar();
  Botones(false);
  Cajas(true);
    this.jtxtcod.setVisible(false);
  this.jlblc.setVisible(false);
  this.jtxtdni.requestFocus();
 }//GEN-LAST:event_jBtnNuevoActionPerformed
public void guardar(){
 int r;
  String cod,dni,nom,telefono,sexo,direccion,fechai,salario,cargo,clave;
   cod=this.jtxtcod.getText();
   dni=this.jtxtdni.getText();
   nom=this.jtxtnombre.getText();
   telefono=this.jtxttelefono.getText();
sexo=this.jcbosexo.getSelectedItem().toString();
direccion=this.jtxtdireccion.getText();
fechai=new SimpleDateFormat("yyyy-MM-dd").format(this.jdcfechaingreso.getDate());
salario=this.jtxtsalario.getText();
cargo=this.jcbocargo.getSelectedItem().toString();
clave=this.jtxtclave.getText();
String codcargo="";
 
   if (dni.equals("")||nom.equals("")|| telefono.equals("")||sexo.equals("")||direccion.equals("")
           ||fechai.equals("")||salario.equals("")||cargo.equals("")||clave.equals("")){
  JOptionPane.showMessageDialog(null,"existe espacios en blanco","error", JOptionPane.ERROR_MESSAGE);
   }
  else{      
        try{
         cnx.rs=cnx.stm.executeQuery("SELECT idcargo FROM CARGO WHERE nombre='"+ cargo +"'");
            while(cnx.rs.next()){
                codcargo=cnx.rs.getString("idcargo");
            }
         if(Sw==0){
                r= JOptionPane.showConfirmDialog(null,"Grabar Datos","Registrar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (r==JOptionPane.YES_OPTION){
                    cnx.stm.execute("INSERT INTO EMPLEADO VALUES('"+ dni +"','"+nom +"','"+ telefono +"','"+ sexo +"','"+ direccion +"'"
                            + ",'"+ fechai +"','"+ salario +"','"+ codcargo +"','"+ clave +"')");
                }
            }
            if(Sw==1){
              
                    cnx.stm.execute("UPDATE EMPLEADO SET dni='"+dni+"',nombre='"+nom+"',telefono='"+telefono+"',sexo='"+sexo+"',direccion='"+direccion+"'"
                            + ",fecha_ingreso='"+fechai+"',salario='"+salario+"',idcargo='"+codcargo+"' ,clave='"+clave+"' WHERE idempleado='"+ cod +"'");
                JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS ","Grabar",1);
                }
        }
        catch(SQLException a){
            System.out.println(a.getMessage());
        }
        LlenarTabla();
        jtbempleado.changeSelection(0, 0,false,true);
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
  jtbempleado.changeSelection(0, 0,false,true);
  Mostrar();
  Botones(true);
  Cajas(false);
 }//GEN-LAST:event_jBtnCancelarActionPerformed

 private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
  Sw = 1;
  Mostrar();
  Botones(false);
  Cajas(true);
    this.jtxtcod.setVisible(true);
  this.jlblc.setVisible(true);
  this.jtxtdni.requestFocus();
 }//GEN-LAST:event_jBtnEditarActionPerformed

 private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
  String sql,cod;
  int r;
  cod=this.jtbempleado.getValueAt(this.jtbempleado.getSelectedRow(),0).toString();
  sql="DELETE FROM EMPLEADO WHERE idempleado='"+cod+"'";
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
  jtbempleado.changeSelection(0,0,false,true);
  Mostrar();

 }//GEN-LAST:event_jBtnEliminarActionPerformed

 private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
  this.dispose();
 }//GEN-LAST:event_jBtnSalirActionPerformed

 private void jtxtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtbuscarActionPerformed
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtbuscarActionPerformed

 private void jtxtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyTyped
  jtxtbuscar.addKeyListener(new KeyAdapter() {
   public void keyReleased(final KeyEvent e) {
    String cadena = (jtxtbuscar.getText());
    jtxtbuscar.setText(cadena);
    repaint();
    buscarzona();
   }
  });
  trsFiltro = new TableRowSorter(jtbempleado.getModel());
  jtbempleado.setRowSorter(trsFiltro);
 }//GEN-LAST:event_jtxtbuscarKeyTyped

 private void jtxtcodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcodKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxtdni.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtcodKeyPressed

 private void jtxtdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyPressed
  String sql,dni;
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   dni=this.jtxtdni.getText();
   sql="SELECT * FROM EMPLEADO WHERE dni='"+ dni +"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql);
    if(cnx.rs.next()){
     JOptionPane.showMessageDialog(null,"EMPLEADO YA ESTA REGISTRADO","Aviso",1);
     Limpiar();
    }
    else{

     this.jtxtnombre.requestFocus();

    }
   }catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtdniKeyPressed

 private void jtxtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyTyped
  String Caracteres = jtxtdni.getText();
  if(Caracteres.length()==8){
   evt.consume();
  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtdniKeyTyped

 private void jtxtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jcbosexo.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtnombreKeyPressed

 private void jtxtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyReleased
  convertiraMayusculasEnJtextfield(jtxtnombre);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtnombreKeyReleased

 private void jtxttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttelefonoKeyTyped
  String Caracteres = jtxttelefono.getText();
  if(Caracteres.length()==9){
   evt.consume();
  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxttelefonoKeyTyped

 private void jcbocargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbocargoActionPerformed
  // TODO add your handling code here:
 }//GEN-LAST:event_jcbocargoActionPerformed

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
icono();
cnx.conectar();
LlenarTabla();
CargaCombocargo();
Mostrar();
this.jdcfechaingreso.setDate(now);
jtbempleado.changeSelection(0, 0,false,true);
Botones(true);
Cajas(false);
this.jtxtcod.setVisible(false);
 }//GEN-LAST:event_formWindowOpened

 private void jtbempleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbempleadoMouseClicked
Mostrar();
 }//GEN-LAST:event_jtbempleadoMouseClicked

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
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_EMPLEADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_EMPLEADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_EMPLEADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_EMPLEADO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MANTENIMIENTO_EMPLEADO().setVisible(true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbocargo;
    private javax.swing.JComboBox jcbosexo;
    private com.toedter.calendar.JDateChooser jdcfechaingreso;
    private javax.swing.JLabel jlblc;
    private javax.swing.JTable jtbempleado;
    private javax.swing.JTextField jtxtbuscar;
    private javax.swing.JPasswordField jtxtclave;
    public static javax.swing.JTextField jtxtcod;
    private javax.swing.JTextField jtxtdireccion;
    public static javax.swing.JTextField jtxtdni;
    public static javax.swing.JTextField jtxtnombre;
    private javax.swing.JTextField jtxtsalario;
    private javax.swing.JTextField jtxttelefono;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private FORMULARIOS.PanelRedondo panelRedondo1;
    // End of variables declaration//GEN-END:variables
}
