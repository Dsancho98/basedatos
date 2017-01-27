/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;
import static basedatos.Clientes.r;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 * La clase pedidos almacena los ResultSets y la conexión
 * @author AlumMati
 */
public class Pedidos extends javax.swing.JFrame {
    static public ResultSet r;
    static public ResultSet r2;
       static public ResultSet r3;
       static public Connection connection;
    /**
     * Se establece la conexión con la base de datos y se obtienen los primeros datos de la tabla
     * pedidos. También contiene el combobox y la consulta del combobox para obtener el nombre del
     * cliente y el código del cliente
     * También hace invisible los botones aceptar y cancelar
     * @throws SQLException - En caso de error se encarga de tratar dicho error
     */
    public Pedidos() throws SQLException {
        initComponents();
        aceptar.setVisible(false);
        cancelar.setVisible(false);
        String url ="jdbc:mysql://localhost:3306/base_datos_1";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url,user,pass);
        
        Statement s = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "select * from pedidos";
        r = s.executeQuery(query);
        r.first();
        numpedido.setText(r.getString("NUM_PEDIDO"));
        fecha.setText(r.getString("FECHA"));
        
        
        String query2 = "select * from clientes";
          
            Statement s2 = connection.createStatement();
            r2 = s2.executeQuery(query2);
            DefaultComboBoxModel value1 = new DefaultComboBoxModel();

            while (r2.next()) {
                   value1.addElement(r2.getString("NOMBRE"));
            }
            clienteh.setModel(value1);
            clienteh.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
    }
    /**
     * El método getNombreCliente nos da el nombre del cliente haciendo uso del código del cliente
     * @param codigo - Código del cliente
     * @return name - nombre del cliente
     */
    public static String getNombreCliente(String codigo){
                       
               String name="";
               try {
               String queryNombre = "select nombre from clientes WHERE NIF='"+codigo+"'";
               
               Statement s3 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               r3= s3.executeQuery(queryNombre);
               r3.first();
               name= r3.getString("NOMBRE");              
           }   catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
            return name;
    
    }
    /**
     * El método getNifCliente nos da el NIF del cliente haciendo uso del nombre del cliente
     * @param nombre - Nombre del cliente
     * @return codigo - Codigo del cliente
     */
     public static String getNifCliente(String nombre){
                          
               String codigo="";
               try {
               String queryCodigo = "select NIF from clientes WHERE nombre='"+nombre+"'";
              
               Statement s3 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               r3= s3.executeQuery(queryCodigo);
               r3.first();
               codigo= r3.getString("NIF");
           } catch (SQLException ex) {
               Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
           }
        return codigo;
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numpedido = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        anterior = new javax.swing.JToggleButton();
        siguiente = new javax.swing.JToggleButton();
        nuevo = new javax.swing.JToggleButton();
        modificar = new javax.swing.JToggleButton();
        primero = new javax.swing.JToggleButton();
        ultimo = new javax.swing.JToggleButton();
        borrar = new javax.swing.JToggleButton();
        volver = new javax.swing.JToggleButton();
        aceptar = new javax.swing.JToggleButton();
        cancelar = new javax.swing.JToggleButton();
        clienteh = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Vijaya", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Pedidos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Numero Pedido");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Cliente");

        numpedido.setEditable(false);
        numpedido.setToolTipText("");

        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        primero.setText("Primero");
        primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeroActionPerformed(evt);
            }
        });

        ultimo.setText("Ultimo");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        volver.setText("Volver al Menu");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        clienteh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ultimo)
                            .addComponent(primero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numpedido, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addComponent(fecha)
                                    .addComponent(clienteh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aceptar)
                                    .addComponent(cancelar))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptar))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anterior)
                    .addComponent(siguiente)
                    .addComponent(nuevo)
                    .addComponent(modificar)
                    .addComponent(primero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar)
                    .addComponent(volver)
                    .addComponent(ultimo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if(r.previous()){
                
                numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
                clienteh.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
            } } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
  try {
               if(r.next()){
               
               numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
                clienteh.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
               } } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }       
    }//GEN-LAST:event_siguienteActionPerformed

    private void primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeroActionPerformed
        try {
            r.first();
            numpedido.setText(r.getString("NUM_PEDIDO"));
            fecha.setText(r.getString("FECHA"));
            clienteh.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_primeroActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            r.last();
            numpedido.setText(r.getString("NUM_PEDIDO"));
            fecha.setText(r.getString("FECHA"));
            clienteh.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
         clienteh.setEnabled(true);
        numpedido.setEditable(true);
        borrar.setEnabled(false);
        nuevo.setEnabled(false);
        modificar.setEnabled(false);
        anterior.setEnabled(false);         
        siguiente.setEnabled(false);
        primero.setEnabled(false);
        ultimo.setEnabled(false);
        aceptar.setVisible(true);
        cancelar.setVisible(true);
        aceptar.setEnabled(true);
        cancelar.setEnabled(true);
        numpedido.setText(null);
        fecha.setText(null);
    }//GEN-LAST:event_nuevoActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {       
        String vnum, vfecha, vcliente, cliente;
               vnum = numpedido.getText();
               vfecha = fecha.getText();
               vcliente= (String) clienteh.getSelectedItem();
               cliente= getNifCliente(vcliente);
               String url = "jdbc:mysql://localhost:3306/base_datos_1";
               String user = "root";
               String pass = "";
               Connection connection = DriverManager.getConnection(url, user, pass);
               Statement s = connection.createStatement();
               if (numpedido.getText().length()==0) JOptionPane.showMessageDialog(null,"No has asignado un Código");
               else {
               String query = "insert into pedidos values ('" + vnum + "','" + vfecha + "','" + cliente + "')";
               int resultado = s.executeUpdate(query);
                String query2 = "select * from pedidos";
                r = s.executeQuery(query2);
                r.first();
                      }
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }       
        
        try {
            Pedidos ped = new Pedidos ();            
            ped.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
           //    numpedido.setEditable(false);
           //    borrar.setEnabled(true);
             //  anterior.setEnabled(true);
            //   nuevo.setEnabled(true);
            //   modificar.setEnabled(true);
           //    siguiente.setEnabled(true);
           //    primero.setEnabled(true);
            //   ultimo.setEnabled(true);
           //   aceptar.setVisible(false);
            //   cancelar.setVisible(false);
          //     aceptar.setEnabled(false);
             //  cancelar.setEnabled(false);
            //   clienteh.setEnabled(false);
    }//GEN-LAST:event_aceptarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
                  Menu cli = new Menu();
                  cli.setLocationRelativeTo (null);
                  this.setVisible(false);
                  cli.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
                     try {
               String vnum, vfecha, vcliente,cliente;
               vnum = numpedido.getText();
               vfecha = fecha.getText();
               vcliente= (String) clienteh.getSelectedItem();
               cliente= getNifCliente(vcliente);
               String url = "jdbc:mysql://localhost:3306/base_datos_1";
               String user = "root";
               String pass = "";
               Connection connection = DriverManager.getConnection(url, user, pass);
               Statement s = connection.createStatement();
               String query = "update pedidos set FECHA='" + vfecha + "',CLIENTE='" +cliente+"' WHERE NUM_PEDIDO='"+ vnum +"'";
               int resultado = s.executeUpdate(query);
               r.refreshRow();
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);              
           }
    }//GEN-LAST:event_modificarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
                 try {
               int i= JOptionPane.showConfirmDialog(null, "Realmente desea borrar?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (i==1);
               else {               
               String vnum;
               vnum = numpedido.getText();
               String url = "jdbc:mysql://localhost:3306/base_datos_1";
               String user = "root";
               String pass = "";
               Connection connection = DriverManager.getConnection(url, user, pass);
               Statement s = connection.createStatement();
               String query = "delete FROM pedidos WHERE NUM_PEDIDO='"+vnum+"'";
               int resultado = s.executeUpdate(query);
               String query2 = "select * from pedidos";
               r = s.executeQuery(query2);
               r.first();
               numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
            }
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_borrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
             try {          
            numpedido.setEditable(false);
            borrar.setEnabled(true);
            nuevo.setEnabled(true);
            modificar.setEnabled(true);
            anterior.setEnabled(true);
            siguiente.setEnabled(true);
            primero.setEnabled(true);
            ultimo.setEnabled(true);
            aceptar.setVisible(false);
            cancelar.setVisible(false);
            aceptar.setEnabled(false);
            cancelar.setEnabled(false);
            r.first();
             numpedido.setText(r.getString("NUM_PEDIDO"));
                fecha.setText(r.getString("FECHA"));
                clienteh.setSelectedItem(getNombreCliente(r.getString("CLIENTE")));
        
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancelarActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pedidos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton aceptar;
    private javax.swing.JToggleButton anterior;
    private javax.swing.JToggleButton borrar;
    private javax.swing.JToggleButton cancelar;
    private javax.swing.JComboBox<String> clienteh;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton modificar;
    private javax.swing.JToggleButton nuevo;
    private javax.swing.JTextField numpedido;
    private javax.swing.JToggleButton primero;
    private javax.swing.JToggleButton siguiente;
    private javax.swing.JToggleButton ultimo;
    private javax.swing.JToggleButton volver;
    // End of variables declaration//GEN-END:variables
}
