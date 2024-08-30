
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

public class FRM_MANTENIMIENTO_PRODUCTO extends javax.swing.JFrame {
 conectaBD cnx=new conectaBD();

 int Sw;
  Date now = new Date(System.currentTimeMillis());
 SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
 
    public void convertiraMayusculas(javax.swing.JTextField jTextfieldS){
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
        if (jtxtbuscar.getText() =="PRODUCTO") {
            Buscar = 0;
        }       
        trsFiltro.setRowFilter(RowFilter.regexFilter(jtxtbuscar.getText(),1, Buscar));
    }
 public void Limpiar() {
    jtxtcod.setText("");
    jtxtstock.setText("");
    jtxtproducto.setText("");
    jtxtprecio.setText("");
    jcbocategoria.setSelectedItem(0);
    jcbomarca.setSelectedItem(0);
    jdcfechav.setDate(now);
    jtxtcod.requestFocus();
    jtxtcosto.setText("");

}
public void Cajas(boolean estado ) {
    jtxtcod.setEnabled(estado);
    jtxtstock.setEnabled(estado);
    jtxtproducto.setEnabled(estado);
    jtxtprecio.setEnabled(estado);
    jcbocategoria.setEnabled(estado);
    jcbomarca.setEnabled(estado);
    jdcfechav.setEnabled(estado);
    jtxtcosto.setEnabled(estado);

}
public void Botones(boolean estado){
    jBtnNuevo.setEnabled(estado);
    jBtnGuardar.setEnabled(!estado);
    jBtnCancelar.setEnabled(!estado);
    jBtnEditar.setEnabled(estado);
    jBtnEliminar.setEnabled(estado);
    jBtnSalir.setEnabled(estado);
}
public void CargaComboCategoria(){
    try{
        cnx.rs=cnx.stm.executeQuery("SELECT  nombre FROM CATEGORIA ORDER BY 1");
        jcbocategoria.removeAllItems();
        while(cnx.rs.next()){
        jcbocategoria.addItem(cnx.rs.getString(1));
         }
    }catch(Exception e){
         System.out.println(e.getMessage());
    }
    }

 public void CargaCombomarca(){
    try{
        cnx.rs=cnx.stm.executeQuery("SELECT  nombre FROM MARCA ORDER BY 1");
        jcbomarca.removeAllItems();
        while(cnx.rs.next()){
        jcbomarca.addItem(cnx.rs.getString(1));
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
}
public void Mostrar(){
String cod;
    try{
    cod=jtbproducto.getValueAt(jtbproducto.getSelectedRow(), 0).toString();
        cnx.rs=cnx.stm.executeQuery("SELECT * FROM V_MANTENIMIENTO_PRODUCTO WHERE idproducto=' "+cod+" ' ");
        if(cnx.rs.next()){
        jtxtcod.setText(cnx.rs.getString(1));
        jtxtproducto.setText(cnx.rs.getString(2));
        jtxtcosto.setText(cnx.rs.getString(3));
        jtxtprecio.setText(cnx.rs.getString(4));
        jtxtstock.setText(cnx.rs.getString(5));
        jdcfechav.setDate(cnx.rs.getDate(6));
        jcbomarca.setSelectedItem(cnx.rs.getString(7));
        jcbocategoria.setSelectedItem(cnx.rs.getString(8));
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
   //String fechav=date.format(this.jdcfechav.getDate());
   sql="SELECT * FROM V_MANTENIMIENTO_PRODUCTO";
   try{
        //consulta
        cnx.rs=cnx.stm.executeQuery(sql);
        //defino la variable
        DefaultTableModel model=(DefaultTableModel) jtbproducto.getModel();
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
     
     model.addRow(vRow);
     
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
     
   }
  }
 public FRM_MANTENIMIENTO_PRODUCTO() {
  initComponents();
   this.setLocationRelativeTo(this);
  this.setResizable(false);
   // this.getContentPane().setBackground(Color.CYAN);
    //sololetras(jtxtproducto);
    //solonumeros(jtxtprecio);
    solonumeros(jtxtstock);
   // solonumeros(jtxtprecio);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbproducto = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcbocategoria = new javax.swing.JComboBox();
        jcbomarca = new javax.swing.JComboBox();
        jtxtcosto = new javax.swing.JTextField();
        jtxtproducto = new javax.swing.JTextField();
        jtxtcod = new javax.swing.JTextField();
        jtxtprecio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtxtstock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jdcfechav = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel18 = new javax.swing.JLabel();
        panelRedondo3 = new FORMULARIOS.PanelRedondo();
        jLabel5 = new javax.swing.JLabel();
        jtxtbuscar = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

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

        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo2.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/delete_12523095.png"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir2.png"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar2.png"))); // NOI18N
        jBtnEditar.setText("EDITAR");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancelar3.png"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar2.png"))); // NOI18N
        jBtnGuardar.setText("GUADAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jtbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "PRODUCTO", "COSTO", "PRECIO", "STOCK", "FECHA.V", "MARCA", "CATEGORIA"
            }
        ));
        jtbproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbproductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbproducto);
        if (jtbproducto.getColumnModel().getColumnCount() > 0) {
            jtbproducto.getColumnModel().getColumn(0).setMinWidth(70);
            jtbproducto.getColumnModel().getColumn(0).setMaxWidth(60);
            jtbproducto.getColumnModel().getColumn(1).setMinWidth(130);
            jtbproducto.getColumnModel().getColumn(1).setMaxWidth(100);
            jtbproducto.getColumnModel().getColumn(2).setMinWidth(80);
            jtbproducto.getColumnModel().getColumn(2).setMaxWidth(60);
            jtbproducto.getColumnModel().getColumn(3).setMinWidth(80);
            jtbproducto.getColumnModel().getColumn(3).setMaxWidth(70);
            jtbproducto.getColumnModel().getColumn(4).setMinWidth(90);
            jtbproducto.getColumnModel().getColumn(4).setMaxWidth(80);
            jtbproducto.getColumnModel().getColumn(5).setMinWidth(90);
            jtbproducto.getColumnModel().getColumn(5).setMaxWidth(70);
            jtbproducto.getColumnModel().getColumn(6).setMinWidth(120);
            jtbproducto.getColumnModel().getColumn(6).setMaxWidth(100);
            jtbproducto.getColumnModel().getColumn(7).setMinWidth(120);
            jtbproducto.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        jLabel6.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel6.setText("Código :");

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel8.setText("Producto:");

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel2.setText("Costo:");

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel11.setText("Marca:");

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel12.setText("Categoria:");

        jcbocategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jcbomarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbomarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbomarcaKeyPressed(evt);
            }
        });

        jtxtproducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtproductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtproductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtproductoKeyTyped(evt);
            }
        });

        jtxtcod.setEditable(false);
        jtxtcod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcodKeyPressed(evt);
            }
        });

        jtxtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtprecioKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Captura.JPG"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Captura.JPG"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel10.setText("Stock:");

        jtxtstock.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtstockKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtstockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtstockKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel1.setText("Fecha de vencimiento:");

        jdcfechav.setDateFormatString("dd-MM-yyyy");

        jLabel9.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel9.setText("Precio unitario:");

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel13.setText("DATOS:");

        jLabel14.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel14.setText("CONTROLES:");

        kGradientPanel3.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel18.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(245, 245, 245));
        jLabel18.setText("BUSCAR POR PRODUCTO:");

        panelRedondo3.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondo3.setRoundBottomLeft(20);
        panelRedondo3.setRoundBottomRight(20);
        panelRedondo3.setRoundTopLeft(20);
        panelRedondo3.setRoundTopRight(20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar_1.png"))); // NOI18N

        jtxtbuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtxtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtbuscarActionPerformed(evt);
            }
        });
        jtxtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelRedondo3Layout = new javax.swing.GroupLayout(panelRedondo3);
        panelRedondo3.setLayout(panelRedondo3Layout);
        panelRedondo3Layout.setHorizontalGroup(
            panelRedondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRedondo3Layout.setVerticalGroup(
            panelRedondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRedondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtbuscar)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRedondo3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento item.png"))); // NOI18N
        jLabel19.setText("   MANTENIMIENTO PRODUCTO");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel19)
                .addGap(41, 41, 41)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(panelRedondo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRedondo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18)))
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
                    .addComponent(jLabel14)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(55, 55, 55)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel2))
                                .addGap(48, 48, 48)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(43, 43, 43)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addGap(25, 25, 25)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcfechav, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jtxtstock)
                            .addComponent(jtxtprecio)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jdcfechav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(jtxtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jtxtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtxtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jcbomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    if(!Character.isDigit(c) && !Character.isDigit(c)){
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
    if(Character.isDigit(c) && !Character.isSpaceChar(c) ){        
     getToolkit().beep();
     e.consume();
    }
   }
  }); 
 }
 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
  Sw = 0;
  Limpiar();
  Botones(false);
  Cajas(true);
  jtxtcod.setVisible(false);
  jLabel6.setVisible(false);
  jtxtproducto.requestFocus();
 }//GEN-LAST:event_jBtnNuevoActionPerformed
public void guardar(){
 int r;
 String cod,nombre,costo,precio,stock,fechav,marca,categoria;
   cod=jtxtcod.getText();
   nombre=jtxtproducto.getText();
   costo=jtxtcosto.getText();
   stock=jtxtstock.getText();
   precio=jtxtprecio.getText();
   fechav=new SimpleDateFormat("yyyy-MM-dd").format(this.jdcfechav.getDate());
   marca=jcbomarca.getSelectedItem().toString();
   categoria=jcbocategoria.getSelectedItem().toString();
   
String codcategoria="";
String codmarca="";

   if (nombre.equals("")||precio.equals("")||stock.equals("")|| marca.equals("")||categoria.equals("")){
  JOptionPane.showMessageDialog(null,"existe espacios en blanco","error", JOptionPane.ERROR_MESSAGE);
   }
  else{ 
      try{
       cnx.rs=cnx.stm.executeQuery("SELECT idmarca FROM MARCA WHERE nombre='"+ marca +"'");
            while(cnx.rs.next()){
                codmarca=cnx.rs.getString("idmarca");
            }
            cnx.rs=cnx.stm.executeQuery("SELECT idcategoria FROM CATEGORIA WHERE nombre='"+ categoria +"'");
            while(cnx.rs.next()){
                codcategoria=cnx.rs.getString("idcategoria");
            }
         if(Sw==0){
               
                    cnx.stm.execute("INSERT INTO PRODUCTO VALUES('"+ nombre +"','"+costo+"','"+precio+"','"+stock+"','"+fechav+"','"+ codmarca +"','"+ codcategoria+"')");
                 JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAMENTE ","Grabar",1);
            }
            if(Sw==1){
              
                    cnx.stm.execute("UPDATE PRODUCTO SET nombre='"+nombre+"',costo='"+costo+"',preciounit='"+precio+"',stock='"+stock+"',idmarca='"+codmarca+"',fecha_venci='"+fechav+"',idcategoria='"+codcategoria+"' WHERE idproducto='"+ cod +"'");
                JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS CORRECTAMENTE ","Grabar",1);
                }
        }
        catch(SQLException a){
            System.out.println(a.getMessage());
        }
        LlenarTabla();
        jtbproducto.changeSelection(0, 0,false,true);
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
  jtbproducto.changeSelection(0, 0,false,true);
  Mostrar();
  Botones(true);
  Cajas(false);
 }//GEN-LAST:event_jBtnCancelarActionPerformed

 private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
  Sw = 1;
  Mostrar();
  Botones(false);
  Cajas(true);
  jtxtcod.setVisible(true);
  jLabel6.setVisible(true);
  jtxtcod.requestFocus();
 }//GEN-LAST:event_jBtnEditarActionPerformed

 private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
  String sql,cod;
  int r;
  cod=jtbproducto.getValueAt(jtbproducto.getSelectedRow(),0).toString();
  sql="DELETE FROM PRODUCTO WHERE idproducto='"+cod+"'";
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
  jtbproducto.changeSelection(0,0,false,true);
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
  trsFiltro = new TableRowSorter(jtbproducto.getModel());
  jtbproducto.setRowSorter(trsFiltro);
 }//GEN-LAST:event_jtxtbuscarKeyTyped

 private void jtxtcodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcodKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   jtxtproducto.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtcodKeyPressed

 private void jtxtproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtproductoKeyPressed
  String sql,dni;
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   dni=jtxtproducto.getText();
   sql="SELECT * FROM PRODUCTO WHERE nombre='"+ dni +"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql);
    if(cnx.rs.next()){
     JOptionPane.showMessageDialog(null,"PRODUCTO YA  REGISTRADO","Aviso",1);
     Limpiar();
    }
    else{

     this.jtxtprecio.requestFocus();

    }
   }catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtproductoKeyPressed

 private void jtxtproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtproductoKeyTyped
 
 }//GEN-LAST:event_jtxtproductoKeyTyped

 private void jtxtstockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstockKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   jcbomarca.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtstockKeyPressed

 private void jtxtstockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstockKeyReleased
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtstockKeyReleased

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    icono();
    cnx.conectar();
    LlenarTabla();
    CargaComboCategoria();
    CargaCombomarca();
    Mostrar();
    jtbproducto.changeSelection(0, 0,false,true);
    Botones(true);
    Cajas(false);
    jdcfechav.setDate(now);

 }//GEN-LAST:event_formWindowOpened

 private void jtbproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbproductoMouseClicked
Mostrar();
 }//GEN-LAST:event_jtbproductoMouseClicked

 private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
  LlenarTabla();
  CargaComboCategoria();
  CargaCombomarca();
  
 }//GEN-LAST:event_formWindowActivated

 private void jtxtproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtproductoKeyReleased
convertiraMayusculas(jtxtproducto);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtproductoKeyReleased

 private void jtxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyReleased
convertiraMayusculas(jtxtbuscar);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtbuscarKeyReleased

 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
FRM_MANTENIMIENTO_CATEGORIA cat=new  FRM_MANTENIMIENTO_CATEGORIA();
cat.show();// TODO add your handling code here:
 }//GEN-LAST:event_jButton1ActionPerformed

 private void jtxtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstockKeyTyped
 String Caracteres = jtxtstock.getText(); 
        if(Caracteres.length()==3 ){ 
            evt.consume();    
        }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtstockKeyTyped

 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   conectaBD cnx = new conectaBD();
    cnx.conectar(); // Establece la conexión
     FRM_MANTENIMIENTO_MARCA M=new  FRM_MANTENIMIENTO_MARCA();
M.show();
 }//GEN-LAST:event_jButton2ActionPerformed

 private void jtxtprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtprecioKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxtstock.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtprecioKeyPressed

 private void jcbomarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbomarcaKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jcbocategoria.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jcbomarcaKeyPressed

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
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MANTENIMIENTO_PRODUCTO().setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbocategoria;
    private javax.swing.JComboBox jcbomarca;
    private com.toedter.calendar.JDateChooser jdcfechav;
    private javax.swing.JTable jtbproducto;
    private javax.swing.JTextField jtxtbuscar;
    public static javax.swing.JTextField jtxtcod;
    private javax.swing.JTextField jtxtcosto;
    private javax.swing.JTextField jtxtprecio;
    public static javax.swing.JTextField jtxtproducto;
    public static javax.swing.JTextField jtxtstock;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private FORMULARIOS.PanelRedondo panelRedondo3;
    // End of variables declaration//GEN-END:variables
}
