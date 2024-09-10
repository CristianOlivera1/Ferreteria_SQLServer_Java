

package FORMULARIOS;

import BASE.conectaBD;
import static FORMULARIOS.FRM_DETALLE_VENTA.jTbDetalle;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FRM_CONSULTA_VENTAS extends javax.swing.JFrame {
      conectaBD cnx = new conectaBD();
      
        String sql ="SELECT * FROM V_CONSULTA_DETALLE";

          Date now = new Date(System.currentTimeMillis());
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
       
    
    public void MostrarenDetalle(){
        String cod=jTblDetalle.getValueAt(jTblDetalle.getSelectedRow(),0).toString();
       String sql="SELECT*FROM V_ENCABEZADO WHERE numventa='"+cod+"'";
    try{
     cnx.rs=cnx.stm.executeQuery(sql);
       if(cnx.rs.next()){
     FRM_DETALLE_VENTA.jLblFecha.setText(cnx.rs.getString(2));
     FRM_DETALLE_VENTA.jLblCli.setText(cnx.rs.getString(3));
     FRM_DETALLE_VENTA.jLblEmp.setText(cnx.rs.getString(4));
 }LlenarTablaDetalle();
}
catch (Exception e){
 System.out.println(e.getMessage());
}
 
  }
    public void LlenarTablaDetalle(){
        int col1=1;
        String cod=jTblDetalle.getValueAt(jTblDetalle.getSelectedRow(),0).toString();
        String detalle="SELECT *FROM V_DETALLE_VENTA WHERE numventa='"+cod+"'";
          try{
              cnx.rs= cnx.stm.executeQuery(detalle);//Se hace la consulta
             DefaultTableModel model= (DefaultTableModel) jTbDetalle.getModel(); //Defino la variabe
            Limpiar(model); //limpiamos
             while(cnx.rs.next()){
                  //Llenar datos
                 String col2 = cnx.rs.getString(2);
                 String col3 = cnx.rs.getString(3);
                 String col4 = cnx.rs.getString(4);
                 String col5 = cnx.rs.getString(5);
                 
                 Vector vRow = new Vector();
                 vRow.add(col1);
                 vRow.add(col2);
                 vRow.add(col3);
                 vRow.add(col4);
                 vRow.add(col5);
                 
                 model.addRow(vRow);
                 col1++;
             }
              
          }
          catch(Exception e){
              System.out.println(e.getMessage());
          }
    }

    public void CalcularGanancia() {
  double precio = 0;
  double costo = 0;
  double ganancia=0;
  for (int fila = 0; fila <= this.jTblDetalle.getRowCount() - 1; fila++) {
   precio=  precio + Double.parseDouble(this.jTblDetalle.getValueAt(fila, 3).toString());
   costo=  costo + Double.parseDouble(this.jTblDetalle.getValueAt(fila, 8).toString());
   ganancia= (double)(precio-costo);
  }
  this.jlblutilidad.setText(String.valueOf(ganancia));
 }
    
    
    
     public void CargarComboEmpleado(){
        try{
            this.jCboEmpleado.removeAllItems();
            cnx.rs= cnx.stm.executeQuery("SELECT nombre FROM Empleado");
             while(cnx.rs.next()){
                 jCboEmpleado.addItem(cnx.rs.getString(1));
             } 
        }
        catch(Exception e){
            
        }
    }
    
      
      public void Limpiar(DefaultTableModel model) {
        int x;
        for (x = model.getRowCount() - 1; x >= 0; x--) {
            model.removeRow(x);
        }
    }

    public void LlenarTabla(String sql) {
       
        try {
            cnx.rs = cnx.stm.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel) jTblDetalle.getModel();
            Limpiar(model);
            while (cnx.rs.next()) {
                String col1 = cnx.rs.getString(1);
                String col2 = cnx.rs.getString(2);
                String col3 = cnx.rs.getString(3);
                String col4 = cnx.rs.getString(4);
                String col5 = cnx.rs.getString(5);
                String col6 = cnx.rs.getString(6);
                String col7 = cnx.rs.getString(7);
                String col8 = cnx.rs.getString(8);
                String col9 = cnx.rs.getString(9);
                
                Vector vRow = new Vector();
                vRow.add(col1);
                vRow.add(col2);
                vRow.add(col3);
                vRow.add(col4);
                vRow.add(col5);
                vRow.add(col6);
                vRow.add(col7);
                vRow.add(col8);
                vRow.add(col9);
                
                model.addRow(vRow);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void CalcularTotal() {
         try{
  double total = 0;
  for (int fila = 0; fila <= this.jTblDetalle.getRowCount() - 1; fila++) {
   total = total + Double.parseDouble(this.jTblDetalle.getValueAt(fila, 6).toString());
  }
  this.jlbltotal.setText(String.valueOf(total));
         }
         catch(Exception e){
             System.out.println("HAY ERROR");
         }
 }
      
      
    
    public FRM_CONSULTA_VENTAS() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBuscar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jBtnMotrar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnBuscar = new javax.swing.JButton();
        jlbltotal = new javax.swing.JLabel();
        jlblutilidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblDetalle = new javax.swing.JTable();
        jdcfecha2 = new com.toedter.calendar.JDateChooser();
        jdcfecha = new com.toedter.calendar.JDateChooser();
        jRbProducto = new javax.swing.JRadioButton();
        jtxtProducto = new javax.swing.JTextField();
        jRbEmpleado = new javax.swing.JRadioButton();
        jCboEmpleado = new javax.swing.JComboBox();
        jRbFecha = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA DE VENTAS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jBtnMotrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo.png"))); // NOI18N
        jBtnMotrar.setText("MOSTRAR TODO");
        jBtnMotrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMotrarActionPerformed(evt);
            }
        });

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir2.png"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar_1.png"))); // NOI18N
        jBtnBuscar.setText("BUSCAR");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jlbltotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbltotal.setForeground(new java.awt.Color(255, 51, 51));
        jlbltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbltotal.setToolTipText("");
        jlbltotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlblutilidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblutilidad.setForeground(new java.awt.Color(255, 0, 0));
        jlblutilidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblutilidad.setToolTipText("");
        jlblutilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº BOLETA", "CANTIDAD", "PRODUCTO", "PRECIO", "CLIENTE", "FECHA", "IMPORTE", "CLIENTE", "COSTO"
            }
        ));
        jTblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblDetalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblDetalle);
        if (jTblDetalle.getColumnModel().getColumnCount() > 0) {
            jTblDetalle.getColumnModel().getColumn(0).setMinWidth(80);
            jTblDetalle.getColumnModel().getColumn(0).setMaxWidth(70);
            jTblDetalle.getColumnModel().getColumn(1).setMinWidth(80);
            jTblDetalle.getColumnModel().getColumn(1).setMaxWidth(70);
            jTblDetalle.getColumnModel().getColumn(3).setMinWidth(80);
            jTblDetalle.getColumnModel().getColumn(3).setMaxWidth(70);
            jTblDetalle.getColumnModel().getColumn(4).setMinWidth(0);
            jTblDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
            jTblDetalle.getColumnModel().getColumn(7).setMinWidth(0);
            jTblDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
            jTblDetalle.getColumnModel().getColumn(8).setMinWidth(0);
            jTblDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jdcfecha2.setDateFormatString("dd-MM-yyyy");

        jdcfecha.setDateFormatString("dd-MM-yyyy");

        bgBuscar.add(jRbProducto);
        jRbProducto.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jRbProducto.setText("PRODUCTO");
        jRbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbProductoActionPerformed(evt);
            }
        });

        jtxtProducto.setBackground(new java.awt.Color(255, 255, 204));
        jtxtProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtProducto.setForeground(new java.awt.Color(0, 0, 255));
        jtxtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtProductoActionPerformed(evt);
            }
        });
        jtxtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtProductoKeyReleased(evt);
            }
        });

        bgBuscar.add(jRbEmpleado);
        jRbEmpleado.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jRbEmpleado.setText("EMPLEADO");
        jRbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbEmpleadoActionPerformed(evt);
            }
        });

        jCboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboEmpleadoActionPerformed(evt);
            }
        });

        bgBuscar.add(jRbFecha);
        jRbFecha.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jRbFecha.setText("FECHA");
        jRbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbFechaActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(80, 130, 225));

        jLabel22.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("TOTAL:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel22)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel10.setBackground(new java.awt.Color(80, 130, 225));

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("GANANCIA:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(57, 57, 57))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        kGradientPanel3.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/transaccionesITEM.png"))); // NOI18N
        jLabel19.setText("   CONSULTA DE VENTAS");

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

        jPanel8.setBackground(new java.awt.Color(80, 130, 225));

        jLabel21.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("DE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel11.setBackground(new java.awt.Color(80, 130, 225));

        jLabel24.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("AL");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jRbProducto)
                                    .addComponent(jRbFecha))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jdcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRbEmpleado)
                                .addGap(18, 18, 18)
                                .addComponent(jCboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtnMotrar)
                                .addGap(36, 36, 36))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlblutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRbFecha)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcfecha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRbProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRbEmpleado)
                            .addComponent(jCboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnMotrar)
                        .addGap(15, 15, 15)
                        .addComponent(jBtnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlblutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cnx.conectar();
        LlenarTabla(sql);
        this.jdcfecha.setDate(now);
        this.jdcfecha2.setDate(now);
        CargarComboEmpleado();
        CalcularTotal();
        CalcularGanancia();
        this.jRbFecha.setSelected(true);
        this.jdcfecha.setEnabled(true);
        this.jdcfecha2.setEnabled(true);
        this.jtxtProducto.setEnabled(false);
        this.jCboEmpleado.setEnabled(true);
        
    }//GEN-LAST:event_formWindowOpened

    private void jtxtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtProductoKeyReleased
       String dato =this.jtxtProducto.getText();
       String sql1="SELECT *FROM V_CONSULTA_DETALLE WHERE nombre LIKE '%"+dato+"%'";
       
       try{
           LlenarTabla(sql1);
           CalcularTotal();
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
       //convertiraMayusculas(jtxtbuscnombre);
    }//GEN-LAST:event_jtxtProductoKeyReleased

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
         if(jRbFecha.isSelected()){
            String fecha,fecha2;
            fecha=date.format(this.jdcfecha.getDate());
            fecha2=date.format(this.jdcfecha2.getDate());
             String sql3="SELECT * FROM V_CONSULTA_DETALLE WHERE fecha >='"+fecha+"'AND fecha <= '"+fecha2+"'";
           
           try{
               cnx.rs=cnx.stm.executeQuery(sql3);
               if(cnx.rs.next()){
                   
                   LlenarTabla(sql3);
                   CalcularTotal();
                   CalcularGanancia();
               }
               else{
                   JOptionPane.showMessageDialog(null,"fecha no encontrada", "Aviso",0);
               }
               
           }
          catch(Exception e){
              System.out.println(e.getMessage());
          } 
        }
         
          if(jRbEmpleado.isSelected()){
            String empleado;
            empleado=this.jCboEmpleado.getSelectedItem().toString();
            String sql2="SELECT * FROM V_CONSULTA_DETALLE WHERE nombreempleado ='"+empleado+"'";
           try{
               cnx.rs=cnx.stm.executeQuery(sql2);
               if(cnx.rs.next()){
                   
                   LlenarTabla(sql2);
                   CalcularTotal();
                   CalcularGanancia();
               }
               else{
                   JOptionPane.showMessageDialog(null,"Este empleado no ah realizado ventas", "Aviso",1);
               }
               
           }
          catch(Exception e){
              System.out.println(e.getMessage());
          } 
        }
         
         
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jRbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbFechaActionPerformed
        this.jdcfecha.setEnabled(true);
        this.jdcfecha.setEnabled(true);
        this.jtxtProducto.setEnabled(false);
        this.jCboEmpleado.setEnabled(false);
    }//GEN-LAST:event_jRbFechaActionPerformed

    private void jRbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbProductoActionPerformed
        this.jdcfecha.setEnabled(false);
        this.jdcfecha2.setEnabled(false);
        this.jtxtProducto.setEnabled(true);
        this.jCboEmpleado.setEnabled(false);
    }//GEN-LAST:event_jRbProductoActionPerformed

    private void jRbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbEmpleadoActionPerformed
        this.jdcfecha.setEnabled(false);
        this.jdcfecha2.setEnabled(false);
        this.jtxtProducto.setEnabled(false);
        this.jCboEmpleado.setEnabled(true);
    }//GEN-LAST:event_jRbEmpleadoActionPerformed

    private void jBtnMotrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMotrarActionPerformed
        
        String sql4="SELECT * FROM V_CONSULTA_DETALLE";
        LlenarTabla(sql4);
        CalcularTotal();
        CalcularGanancia();
    }//GEN-LAST:event_jBtnMotrarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jTblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblDetalleMouseClicked
        
        FRM_DETALLE_VENTA ven=new FRM_DETALLE_VENTA();
        MostrarenDetalle();
        
        ven.show();
    }//GEN-LAST:event_jTblDetalleMouseClicked

    private void jtxtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtProductoActionPerformed

    private void jCboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboEmpleadoActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_CONSULTA_VENTAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgBuscar;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnMotrar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox jCboEmpleado;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRbEmpleado;
    private javax.swing.JRadioButton jRbFecha;
    private javax.swing.JRadioButton jRbProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblDetalle;
    private com.toedter.calendar.JDateChooser jdcfecha;
    private com.toedter.calendar.JDateChooser jdcfecha2;
    private javax.swing.JLabel jlbltotal;
    private javax.swing.JLabel jlblutilidad;
    private javax.swing.JTextField jtxtProducto;
    private keeptoo.KGradientPanel kGradientPanel3;
    // End of variables declaration//GEN-END:variables
}
