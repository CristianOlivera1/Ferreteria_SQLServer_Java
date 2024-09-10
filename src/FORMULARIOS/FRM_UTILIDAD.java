
package FORMULARIOS;
import BASE.conectaBD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class FRM_UTILIDAD extends javax.swing.JFrame {
    conectaBD cnx= new conectaBD();
    
     Date ahora = new Date(System.currentTimeMillis());

     public void MostrarVentas(){
      String sql;
      sql="SELECT * FROM V_GANANCIA WHERE fecha ='"+ahora+"'";
      try{
         cnx.rs=cnx.stm.executeQuery(sql);
         if(cnx.rs.next()){
            this.jlblutilidad.setText(cnx.rs.getString(1));
         }             
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
    }
    
    public FRM_UTILIDAD() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(java.awt.Color.WHITE);
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color (0,0,255)); // Establecer fondo blanco al panel
        jLabel1.setForeground(Color.WHITE);
        // Mover el JLabel al topPanel
        topPanel.add(jLabel1);

        // Establecer el layout del JFrame
        this.getContentPane().setLayout(new BorderLayout());
        // Agregar el topPanel al JFrame en la parte superior (NORTH)
        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        
        //agregar el boton salir
          JButton salir = new JButton("SALIR");
            salir.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/salir2.png")));
         JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
          bottomPanel.add(salir);
         this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
            salir.addActionListener(e -> dispose());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblutilidad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jlblutilidad.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jlblutilidad.setForeground(new java.awt.Color(255, 0, 0));
        jlblutilidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblutilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("GANANCIA DIARIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jlblutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cnx.conectar();
      MostrarVentas();
    }//GEN-LAST:event_formWindowOpened
 
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_UTILIDAD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlblutilidad;

    // End of variables declaration//GEN-END:variables
}
