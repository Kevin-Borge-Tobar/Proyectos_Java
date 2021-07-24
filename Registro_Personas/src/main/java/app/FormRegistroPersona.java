/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Kevin Borge
 */
public class FormRegistroPersona extends javax.swing.JFrame {
 
  SQLConnector conector = new SQLConnector();
  Connection con1 = conector.conectar();
  int selectPersona;

  
  
 public void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
     
  }
 
  
  public void guardarPersona(){
  try {
            RegistroPersona persona = new RegistroPersona();
            persona.setNombre(txtNombre.getText());
            persona.setApellido(txtApellido.getText());
            persona.setDireccion(txtDireccion.getText());
            persona.setTelefono(txtTelefono.getText());
            
            
            PreparedStatement pst = con1.prepareStatement("INSERT INTO personas(Nombre,Apellido,Direccion,Telefono) VALUES (?,?,?,?)");
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getDireccion());
            pst.setString(4, persona.getTelefono());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Persona Ingresada con Exito!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Guardar Persona");
        }

    }
  
  public void modificarPersona(){
    try {
            RegistroPersona persona   = new RegistroPersona();
            persona.setNombre(txtNombre.getText());
            persona.setApellido(txtApellido.getText());
            persona.setDireccion(txtDireccion.getText());
            persona.setTelefono(txtTelefono.getText());
            int fila = tablaPersonas.getSelectedRow();
            String personaAct= tablaPersonas.getValueAt(fila, 0).toString();
            PreparedStatement pst = con1.prepareStatement("UPDATE personas SET Nombre = ?,Apellido = ?,Direccion = ?,Telefono = ?  WHERE personas .ID"+"= "+ Integer.parseInt(personaAct)+"");
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getDireccion());
            pst.setString(4, persona.getTelefono());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Datos Actualizados!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona una Persona!!!");
        }
    }
  
  public void EliminarPersona(){
  try {
            RegistroPersona persona   = new RegistroPersona();
            persona.setNombre(txtNombre.getText());
            persona.setApellido(txtApellido.getText());
            persona.setDireccion(txtDireccion.getText());
            persona.setTelefono(txtTelefono.getText());
            int fila = tablaPersonas.getSelectedRow();
            String personaEli = tablaPersonas.getValueAt(fila, 0).toString();
            
            //UPDATE `personas` SET `Nombre` = 'maria' WHERE `personas`.`ID` = 4
            PreparedStatement pst = con1.prepareStatement("DELETE FROM personas WHERE personas . ID"+"="+ Integer.parseInt(personaEli)+"");
            pst.execute();
            JOptionPane.showMessageDialog(null, "Persona Eliminada!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona una persona!!!");
        }

  }
 
  
  
  public void tabla() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            tablaPersonas.setModel(model);
            

            PreparedStatement ps = null;
            ResultSet rs = null;
            SQLConnector conectorTP = new SQLConnector();
            Connection con2 = conectorTP.conectar();

            String consulta = "SELECT ID,Nombre,Apellido,Direccion,Telefono FROM personas";
            ps = con2.prepareStatement(consulta);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int noColumnas = rsMD.getColumnCount();
            model.addColumn("No. Persona");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Direccion");
            model.addColumn("Telefono");
           
            
            while (rs.next()) {
                Object[] fila = new Object[noColumnas];
                for (int i = 0; i < noColumnas; i++) {
                    fila[i] = rs.getObject(i+1);

                }
                model.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Cargar los Datos");
        }
    }
  
  
    /**
     * Creates new form FormRegistroPersona
     */
    public FormRegistroPersona() {
        initComponents();
        tabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jColorChooser1 = new javax.swing.JColorChooser();
        LNombre = new javax.swing.JLabel();
        LApellido = new javax.swing.JLabel();
        LDireccion = new javax.swing.JLabel();
        LTelefono = new javax.swing.JLabel();
        LID = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        LNombre1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LNombre.setText("Nombre");

        LApellido.setText("Apellido");

        LDireccion.setText("Direccion");

        LTelefono.setText("Telefono");

        LID.setText("ID");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Direccion", "Telefono"
            }
        ));
        tablaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPersonas);

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        LNombre1.setText("REGISTRO DE PERSONAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(LTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LID, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtID)
                                    .addComponent(txtApellido)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(LNombre1)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LNombre1)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LApellido, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnGuardar))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
if(txtNombre.getText().isEmpty()||txtApellido.getText().isEmpty()||txtDireccion.getText().isEmpty()||txtTelefono.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Los Datos Ingresados están incompletos");
        }else{
        guardarPersona();
        limpiar();
        tabla();
}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here: 
       limpiar();
       tabla();
    
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonasMouseClicked
    selectPersona= tablaPersonas.rowAtPoint(evt.getPoint());
        txtNombre.setText(tablaPersonas.getValueAt(selectPersona,1).toString());
        txtApellido.setText(tablaPersonas.getValueAt(selectPersona,2).toString());
        txtDireccion.setText(tablaPersonas.getValueAt(selectPersona,3).toString());
        txtTelefono.setText(tablaPersonas.getValueAt(selectPersona,4).toString());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPersonasMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        EliminarPersona();
        limpiar();
        tabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    if(txtNombre.getText().isEmpty()||txtApellido.getText().isEmpty()||txtDireccion.getText().isEmpty()||txtTelefono.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Datos Incompletos no se pueden Actualizar los Datos");
        }else{
        modificarPersona();
        limpiar();
        tabla();
    }
 
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(FormRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegistroPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegistroPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LApellido;
    private javax.swing.JLabel LDireccion;
    private javax.swing.JLabel LID;
    private javax.swing.JLabel LNombre;
    private javax.swing.JLabel LNombre1;
    private javax.swing.JLabel LTelefono;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tablaPersonas;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
