

package FORMULARIOS;

import BASE.conectaBD;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FRM_VENCIMIENTO_PRODUCTO extends javax.swing.JFrame {
    conectaBD cnx=new conectaBD();
    
    Date now = new Date(System.currentTimeMillis());
 SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
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
     String col3=cnx.rs.getString(4);
     String col4=cnx.rs.getString(5);
     String col5=cnx.rs.getString(6);
     String col6=cnx.rs.getString(7);
     String col7=cnx.rs.getString(8);   
    
       
     //vRow es ifual a una fila
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
   
   
    
    public FRM_VENCIMIENTO_PRODUCTO() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbcliente = new javax.swing.JTable();
        jBtnSalir = new javax.swing.JButton();
        jBtnMostrar = new javax.swing.JButton();
        jBtnBuscar = new javax.swing.JButton();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jdcfecha1 = new com.toedter.calendar.JDateChooser();
        jdcfecha2 = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtbcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "PRODUCTO", "PRECIO", "STOCK", "FECHA.V", "MARCA", "CATEGORIA"
            }
        ));
        jScrollPane1.setViewportView(jtbcliente);
        if (jtbcliente.getColumnModel().getColumnCount() > 0) {
            jtbcliente.getColumnModel().getColumn(0).setMinWidth(80);
            jtbcliente.getColumnModel().getColumn(0).setMaxWidth(70);
            jtbcliente.getColumnModel().getColumn(1).setMinWidth(200);
            jtbcliente.getColumnModel().getColumn(1).setMaxWidth(100);
            jtbcliente.getColumnModel().getColumn(2).setMinWidth(80);
            jtbcliente.getColumnModel().getColumn(2).setMaxWidth(70);
            jtbcliente.getColumnModel().getColumn(3).setMinWidth(70);
            jtbcliente.getColumnModel().getColumn(3).setMaxWidth(60);
            jtbcliente.getColumnModel().getColumn(4).setMinWidth(120);
            jtbcliente.getColumnModel().getColumn(4).setMaxWidth(100);
            jtbcliente.getColumnModel().getColumn(5).setMinWidth(200);
            jtbcliente.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jBtnSalir.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/salir2.png"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnMostrar.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        jBtnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/todo.png"))); // NOI18N
        jBtnMostrar.setText("VER TODO");
        jBtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMostrarActionPerformed(evt);
            }
        });

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar boton.png"))); // NOI18N
        jBtnBuscar.setToolTipText("");
        jBtnBuscar.setBorder(null);
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        kGradientPanel3.setkStartColor(new java.awt.Color(0, 0, 255));

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/consulta_item.png"))); // NOI18N
        jLabel19.setText("   VENCIMIENTO DE PRODUCTOS");

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

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));

        jdcfecha1.setDateFormatString("dd-MM-yyyy");

        jdcfecha2.setDateFormatString("dd-MM-yyyy");

        jPanel8.setBackground(new java.awt.Color(80, 130, 225));

        jLabel21.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("DE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(80, 130, 225));

        jLabel23.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("AL");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jdcfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jdcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcfecha2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jdcfecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnMostrar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSalir)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnMostrar)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sql="SELECT * FROM V_MANTENIMIENTO_PRODUCTO ORDER BY nombre";
        cnx.conectar();
       LlenarTabla(sql);
       this.jdcfecha1.setDate(now);
       this.jdcfecha2.setDate(now);
    }//GEN-LAST:event_formWindowOpened

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        String fecha1,fecha2;
        fecha1=date.format(this.jdcfecha1.getDate());
        fecha2=date.format(this.jdcfecha2.getDate());
        String sql1="SELECT * FROM PRODUCTO WHERE fecha_venci >='"+fecha1+"'AND fecha_venci <= '"+fecha2+"'";
        try{
            cnx.rs=cnx.stm.executeQuery(sql1);
            if(cnx.rs.next()){
                LlenarTabla(sql1);
            }
            else{
                JOptionPane.showMessageDialog(null, "No existe productos", "AVISO",1);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMostrarActionPerformed
        String sql1 ="SELECT * FROM V_MANTENIMIENTO_PRODUCTO";
        LlenarTabla(sql1);
    }//GEN-LAST:event_jBtnMostrarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VENCIMIENTO_PRODUCTO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnMostrar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcfecha1;
    private com.toedter.calendar.JDateChooser jdcfecha2;
    private javax.swing.JTable jtbcliente;
    private keeptoo.KGradientPanel kGradientPanel3;
    // End of variables declaration//GEN-END:variables
}
