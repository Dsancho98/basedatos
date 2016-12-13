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
 *
 * @author Dani
 */
public class Articulos extends javax.swing.JFrame {

       static public ResultSet r;
       static public ResultSet r2;
       static public ResultSet r3;
       static public Connection connection;
    /**
     * Creates new form Articulos
     */
    public Articulos() throws SQLException {
        initComponents();
        aceptar.setVisible(false);
        cancelar.setVisible(false);       
        String url ="jdbc:mysql://localhost:3306/base_datos_1";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url,user,pass);
        
        Statement s = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "select * from articulos A";
        r = s.executeQuery(query);
        r.first();
        code.setText(r.getString("COD_ARTICULO"));
        articulo.setText(r.getString("ARTICULO"));       
        peso.setText(r.getString("PESO"));
        categoria.setText(r.getString("CATEGORIA"));
        precioventa.setText(r.getString("PRECIO_VENTA"));
        preciocoste.setText(r.getString("PRECIO_COSTE"));
        existencias.setText(r.getString("EXISTENCIAS"));
        
          String query2 = "select * from fabricantes";
          
            Statement s2 = connection.createStatement();
            r2 = s2.executeQuery(query2);
            DefaultComboBoxModel value1 = new DefaultComboBoxModel();

            while (r2.next()) {
                   value1.addElement(r2.getString("NOMBRE"));
            }
            CFabricante.setModel(value1);
            CFabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
    }
    public static String getNombreFabricante(int codigo){
                       
               String name="";
               try {
               String queryNombre = "select nombre from fabricantes WHERE cod_fabricante="+codigo;
               
               Statement s3 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               r3= s3.executeQuery(queryNombre);
               r3.first();
               name= r3.getString("NOMBRE");              
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
            return name;
    }
    
     public static int getCodFabricante(String nombre){
                          
               int codigo=0;
               try {
               String queryCodigo = "select cod_fabricante from fabricantes WHERE nombre='"+nombre+"'";
              
               Statement s3 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
               r3= s3.executeQuery(queryCodigo);
               r3.first();
               codigo= r3.getInt("COD_FABRICANTE");
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
        return codigo;
    }
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cod3 = new javax.swing.JLabel();
        cod4 = new javax.swing.JLabel();
        cod5 = new javax.swing.JLabel();
        cod6 = new javax.swing.JLabel();
        cod7 = new javax.swing.JLabel();
        cod = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        cod1 = new javax.swing.JLabel();
        cod2 = new javax.swing.JLabel();
        articulo = new javax.swing.JTextField();
        peso = new javax.swing.JTextField();
        categoria = new javax.swing.JTextField();
        precioventa = new javax.swing.JTextField();
        preciocoste = new javax.swing.JTextField();
        existencias = new javax.swing.JTextField();
        siguiente = new javax.swing.JToggleButton();
        anterior = new javax.swing.JToggleButton();
        ultimo = new javax.swing.JToggleButton();
        primero = new javax.swing.JToggleButton();
        nuevo = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        borrar = new javax.swing.JToggleButton();
        CFabricante = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Vijaya", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Artículos");

        cod3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod3.setText("Categoría");

        cod4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod4.setText("Peso");

        cod5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod5.setText("Precio de venta");

        cod6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod6.setText("Precio coste");

        cod7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod7.setText("Existencias");

        cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod.setText("Código Articulos");

        code.setEditable(false);
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });

        cod1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod1.setText("Articulo");

        cod2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod2.setText("Fabricante");

        precioventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioventaActionPerformed(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        ultimo.setText("Ultimo");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });

        primero.setText("Primero");
        primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeroActionPerformed(evt);
            }
        });

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.setEnabled(false);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Volver al menu");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        CFabricante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CFabricante.setEnabled(false);
        CFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CFabricanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cod)
                                .addComponent(cod1)
                                .addComponent(cod2)
                                .addComponent(cod3)
                                .addComponent(cod4)
                                .addComponent(cod5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cod6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(cod7)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(aceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelar)
                                .addGap(107, 107, 107))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(existencias, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(preciocoste, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(precioventa, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(code)
                                    .addComponent(articulo)
                                    .addComponent(peso)
                                    .addComponent(categoria)
                                    .addComponent(CFabricante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(siguiente)
                        .addGap(18, 18, 18)
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(primero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ultimo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cancelar)
                    .addComponent(aceptar))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod1)
                    .addComponent(articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod2)
                    .addComponent(CFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod4)
                    .addComponent(peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod3)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cod5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod6)
                    .addComponent(preciocoste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cod7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente)
                    .addComponent(ultimo)
                    .addComponent(primero)
                    .addComponent(nuevo)
                    .addComponent(modificar)
                    .addComponent(anterior))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar)
                    .addComponent(jToggleButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
           try {
               if(r.next()){
              
               CFabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
               code.setText(r.getString("COD_ARTICULO"));
               articulo.setText(r.getString("ARTICULO"));             
               peso.setText(r.getString("PESO"));
               categoria.setText(r.getString("CATEGORIA"));
               precioventa.setText(r.getString("PRECIO_VENTA"));
               preciocoste.setText(r.getString("PRECIO_COSTE"));
               existencias.setText(r.getString("EXISTENCIAS"));
               } } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_siguienteActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
           try {
               if(r.previous()){
              
               CFabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
               code.setText(r.getString("COD_ARTICULO"));
               articulo.setText(r.getString("ARTICULO"));
               peso.setText(r.getString("PESO"));
               categoria.setText(r.getString("CATEGORIA"));
               precioventa.setText(r.getString("PRECIO_VENTA"));
               preciocoste.setText(r.getString("PRECIO_COSTE"));
               existencias.setText(r.getString("EXISTENCIAS"));
               }} catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_anteriorActionPerformed

    private void primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeroActionPerformed
           try {
               r.first();
               CFabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
               code.setText(r.getString("COD_ARTICULO"));
               articulo.setText(r.getString("ARTICULO"));
               peso.setText(r.getString("PESO"));
               categoria.setText(r.getString("CATEGORIA"));
               precioventa.setText(r.getString("PRECIO_VENTA"));
               preciocoste.setText(r.getString("PRECIO_COSTE"));        
               existencias.setText(r.getString("EXISTENCIAS"));
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_primeroActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
           try {
               r.last();
               CFabricante.setSelectedItem(getNombreFabricante(r.getInt("FABRICANTE")));
               code.setText(r.getString("COD_ARTICULO"));
               articulo.setText(r.getString("ARTICULO"));
               peso.setText(r.getString("PESO"));
               categoria.setText(r.getString("CATEGORIA"));
               precioventa.setText(r.getString("PRECIO_VENTA"));
               preciocoste.setText(r.getString("PRECIO_COSTE"));
               existencias.setText(r.getString("EXISTENCIAS"));
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_ultimoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
           try {
               code.setEditable(false);
               borrar.setEnabled(true);
               anterior.setEnabled(true);
               nuevo.setEnabled(true);
               modificar.setEnabled(true);
               siguiente.setEnabled(true);
               primero.setEnabled(true);
               ultimo.setEnabled(true);
               aceptar.setVisible(false);
               cancelar.setVisible(false);
               aceptar.setEnabled(false);
               cancelar.setEnabled(false);       
               CFabricante.setEditable(false);
               CFabricante.setEnabled(false);
               code.setText(r.getString("COD_ARTICULO"));
               articulo.setText(r.getString("ARTICULO"));
               peso.setText(r.getString("PESO"));
               categoria.setText(r.getString("CATEGORIA"));
               precioventa.setText(r.getString("PRECIO_VENTA"));
               preciocoste.setText(r.getString("PRECIO_COSTE"));
               existencias.setText(r.getString("EXISTENCIAS"));
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_cancelarActionPerformed

    private void precioventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioventaActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        CFabricante.setEnabled(true);
        CFabricante.setEditable(true);
        code.setEditable(true);
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
        code.setText(null);
        articulo.setText(null);
        peso.setText(null);
        categoria.setText(null);
        precioventa.setText(null);
        preciocoste.setText(null);        
        existencias.setText(null);
        
    }//GEN-LAST:event_nuevoActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
           try {
               String vcode, varticulo, vpeso, vcategoria, vpventa, vpcoste, vexistencias;
               String vCFabricante;
               int fabricante;
               vcode = code.getText();
               vcategoria = categoria.getText();
               varticulo = articulo.getText();
               vpeso = peso.getText();
               vpventa = precioventa.getText();
               vpcoste = preciocoste.getText();
               vexistencias = existencias.getText();
               vCFabricante = (String) CFabricante.getSelectedItem();
               fabricante= getCodFabricante(vCFabricante);
              
               Statement s = connection.createStatement();
               if (code.getText().length()==0) JOptionPane.showMessageDialog(null,"No has asignado un Código");
               else {
               String query = "insert into articulos values ('" + vcode + "','" + varticulo + "'," + fabricante + "," + vpeso + ",'" + vcategoria + "'," + vpventa + "," + vpcoste + "," + vexistencias + ")";
               int resultado = s.executeUpdate(query);
                String query2 = "select * from articulos";
                r = s.executeQuery(query2);
                r.first();
               }
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
           code.setEditable(false);
               borrar.setEnabled(true);
               anterior.setEnabled(true);
               nuevo.setEnabled(true);
               modificar.setEnabled(true);
               siguiente.setEnabled(true);
               primero.setEnabled(true);
               ultimo.setEnabled(true);
               aceptar.setVisible(false);
               cancelar.setVisible(false);
               aceptar.setEnabled(false);
               cancelar.setEnabled(false); 
               CFabricante.setEditable(false);
               CFabricante.setEnabled(false);
               
                
    }//GEN-LAST:event_aceptarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
           try {
               String vcode, varticulo, vfabricante, vpeso, vcategoria, vpventa, vpcoste, vexistencias;
               vcode = code.getText();
               vcategoria = categoria.getText();
               varticulo = articulo.getText();
               vpeso = peso.getText();
               vpventa = precioventa.getText();
               vpcoste = preciocoste.getText();
               vexistencias = existencias.getText();
              
              
               Statement s = connection.createStatement();
               String query = "update articulos set CATEGORIA='" + vcategoria + "', ARTICULO='" + varticulo + "', PESO=" + vpeso + ", CATEGORIA='" + vcategoria + "', PRECIO_VENTA=" + vpventa + ", PRECIO_COSTE=" + vpcoste + ", EXISTENCIAS=" + vexistencias + " WHERE COD_ARTICULO='"+ vcode +"'";
               int resultado = s.executeUpdate(query);
               r.refreshRow();
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_modificarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       Menu cli = new Menu();
cli.setLocationRelativeTo (null);
this.setVisible(false);
cli.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
           try {
               int i= JOptionPane.showConfirmDialog(null, "Realmente desea borrar?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (i==1);
               else {               
               String vcode;
               vcode = code.getText();
             
               Statement s = connection.createStatement();
               String query = "delete FROM articulos WHERE COD_ARTICULO='"+vcode+"'";
               int resultado = s.executeUpdate(query);
               String query2 = "select * from articulos";
               r = s.executeQuery(query2);
               r.first();
               code.setText(r.getString("COD_ARTICULO"));
               articulo.setText(r.getString("ARTICULO"));
               peso.setText(r.getString("PESO"));
               categoria.setText(r.getString("CATEGORIA")); 
               precioventa.setText(r.getString("PRECIO_VENTA"));
               preciocoste.setText(r.getString("PRECIO_COSTE"));
               existencias.setText(r.getString("EXISTENCIAS"));
            }
           } catch (SQLException ex) {
               Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_borrarActionPerformed

    private void CFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CFabricanteActionPerformed
       
    }//GEN-LAST:event_CFabricanteActionPerformed

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
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Articulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Articulos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CFabricante;
    private javax.swing.JButton aceptar;
    private javax.swing.JToggleButton anterior;
    private javax.swing.JTextField articulo;
    private javax.swing.JToggleButton borrar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField categoria;
    private javax.swing.JLabel cod;
    private javax.swing.JLabel cod1;
    private javax.swing.JLabel cod2;
    private javax.swing.JLabel cod3;
    private javax.swing.JLabel cod4;
    private javax.swing.JLabel cod5;
    private javax.swing.JLabel cod6;
    private javax.swing.JLabel cod7;
    private javax.swing.JTextField code;
    private javax.swing.JTextField existencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton nuevo;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField preciocoste;
    private javax.swing.JTextField precioventa;
    private javax.swing.JToggleButton primero;
    private javax.swing.JToggleButton siguiente;
    private javax.swing.JToggleButton ultimo;
    // End of variables declaration//GEN-END:variables
}
