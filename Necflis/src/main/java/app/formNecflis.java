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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin Borge
 */
public class formNecflis extends javax.swing.JFrame {

    MySqlConnector conector = new MySqlConnector();
    Connection con1 = conector.conectar();

  

    /**
     * Creates new form formNecflis
     */

    public void limpiar() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtEdad.setText("");
        txtNoCliente.setText("");
 
    }

    public void guardarCliente() {
        try {
            Clientes cliente = new Clientes();
            cliente.setNombre(txtNombre.getText());
            cliente.setDireccion(txtDireccion.getText());
            cliente.setEdad(txtEdad.getText());
            
            
            PreparedStatement pst = con1.prepareStatement("INSERT INTO clientes(Nombre,Direccion,Edad) VALUES (?,?,?)");
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getDireccion());
            pst.setString(3, cliente.getEdad());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Ingresado con Exito!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Guardar Cliente");
        }

    }
    
    public void modificarCliente(){
         try {
            Clientes cliente   = new Clientes();
            cliente.setNombre(txtNombre.getText());
            cliente.setDireccion(txtDireccion.getText());
            cliente.setEdad(txtEdad.getText());
            int fila = tablaClientes.getSelectedRow();
             String noCliente = tablaClientes.getValueAt(fila, 0).toString();
            
            //UPDATE `personas` SET `Nombre` = 'maria' WHERE `personas`.`ID` = 4
            PreparedStatement pst = con1.prepareStatement("UPDATE Clientes SET Nombre = ?,Direccion = ?,Edad = ?  WHERE clientes . No_cliente"+"="+ Integer.parseInt(noCliente)+"");
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getDireccion());
            pst.setString(3, cliente.getEdad());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar los Datos!!!");
        }

    
    }
    
    public void eliminarCliente(){
  try {
            Clientes cliente   = new Clientes();
            cliente.setNombre(txtNombre.getText());
            cliente.setDireccion(txtDireccion.getText());
            int fila = tablaClientes.getSelectedRow();
            String noCliente = tablaClientes.getValueAt(fila, 0).toString();
            
            //UPDATE `personas` SET `Nombre` = 'maria' WHERE `personas`.`ID` = 4
            PreparedStatement pst = con1.prepareStatement("DELETE FROM Clientes WHERE Clientes . No_cliente"+"="+ Integer.parseInt(noCliente)+"");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Eliminado!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona un Cliente!!!");
        }

  }

         
    //error en la tabla clientes corregir mañana
    public void tablaClientes() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            tablaClientes.setModel(model);
            tablaClientes2.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
            MySqlConnector conectorTC = new MySqlConnector();
            Connection con2 = conectorTC.conectar();

            String consulta = "SELECT No_Cliente,Nombre,Direccion,Edad FROM Clientes";
            ps = con2.prepareStatement(consulta);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int noColumnas = rsMD.getColumnCount();
            model.addColumn("No. Cliente");
            model.addColumn("Nombre");
            model.addColumn("Direccion");
            model.addColumn("Edad");

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
   //FUNCIONES PELICULA
    
    public void limpiarPelicula() {
        txtNombrePelicula.setText("");
        txtSinopsis.setText("");
 
    }

    public void guardarPelicula() {
        try {
            Peliculas pelicula = new Peliculas();
            pelicula.setNombre(txtNombrePelicula.getText());
            pelicula.setTipo(comboTipo.getSelectedItem().toString());
            pelicula.setGenero(ComboGenero.getSelectedItem().toString());
            pelicula.setsinopsis(txtSinopsis.getText());
            
            
            PreparedStatement pst = con1.prepareStatement("INSERT INTO peliculas(Nombre,Tipo,Genero,Sinopsis) VALUES (?,?,?,?)");
            pst.setString(1, pelicula.getNombre());
            pst.setString(2, pelicula.getTipo());
            pst.setString(3, pelicula.getGenero());
            pst.setString(4, pelicula.getsinopsis());
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "pelicula Ingresada con Exito!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Guardar Pelicula");
        }

    }
    
    public void modificarPelicula(){
         try {
            Peliculas pelicula = new Peliculas();
            pelicula.setNombre(txtNombrePelicula.getText());
            pelicula.setTipo(comboTipo.getSelectedItem().toString());
            pelicula.setGenero(ComboGenero.getSelectedItem().toString());
            pelicula.setsinopsis(txtSinopsis.getText());

            int fila = TablaPeliculas.getSelectedRow();
            String noPelicula = TablaPeliculas.getValueAt(fila, 0).toString();
            
            //UPDATE `personas` SET `Nombre` = 'maria' WHERE `personas`.`ID` = 4
            PreparedStatement pst = con1.prepareStatement("UPDATE peliculas SET Nombre = ?,Tipo = ?,Genero = ?, Sinopsis =?  WHERE peliculas . No_Pelicula"+"="+ Integer.parseInt(noPelicula)+"");
            pst.setString(1, pelicula.getNombre());
            pst.setString(2, pelicula.getTipo());
            pst.setString(3, pelicula.getGenero());
            pst.setString(4, pelicula.getsinopsis());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Datos  de Pelicula Actualizados!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar los Datos!!!");
        }

    
    }
    
    public void eliminarPelicula(){
  try {
            Peliculas pelicula   = new Peliculas();
            pelicula.setNombre(txtNombrePelicula.getText());
            pelicula.setsinopsis(txtSinopsis.getText());
            int fila = tablaClientes.getSelectedRow();
            String noPeliculas = tablaClientes.getValueAt(fila, 0).toString();
            
            //UPDATE `personas` SET `Nombre` = 'maria' WHERE `personas`.`ID` = 4
            PreparedStatement pst = con1.prepareStatement("DELETE FROM peliculas WHERE peliculas . No_Peliculas"+"="+ Integer.parseInt(noPeliculas)+"");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pelicula Eliminada!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona una Pelicula!!!");
        }
    }
  

         
    //error en la tabla clientes corregir mañana
    public void tablaPeliculas() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            TablaPeliculas.setModel(model);
            TablaPeliculas2.setModel(model);

            PreparedStatement ps = null;
            ResultSet rs = null;
            MySqlConnector conectorTC = new MySqlConnector();
            Connection con2 = conectorTC.conectar();

            String consulta = "SELECT No_Pelicula,Nombre,Tipo,Genero,Sinopsis FROM peliculas";
            ps = con2.prepareStatement(consulta);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int noColumnas = rsMD.getColumnCount();
            model.addColumn("No. Pelicula");
            model.addColumn("Nombre");
            model.addColumn("Tipo");
            model.addColumn("Genero");
            model.addColumn("Sinopsis");

            while (rs.next()) {
                Object[] fila = new Object[noColumnas];
                for (int i = 0; i < noColumnas; i++) {
                    fila[i] = rs.getObject(i+1);

                }
                model.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Cargar Tablas de Peliculas");
        }
    }    
    
    public formNecflis() {
       
        initComponents();
        tablaClientes();
        tablaPeliculas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtEdad = new javax.swing.JTextField();
        btnNuevoC = new javax.swing.JButton();
        btnListaClientes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNoCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtNoSeleccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaClientes2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtSeleccion = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaPeliculas2 = new javax.swing.JTable();
        txtAgregarPlay = new javax.swing.JTextField();
        btnAgregarPL = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtList = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombrePelicula = new javax.swing.JTextField();
        txtNoPelicula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSinopsis = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPeliculas = new javax.swing.JTable();
        btnCrearPelicula = new javax.swing.JButton();
        btnListaPeliculas = new javax.swing.JButton();
        comboTipo = new javax.swing.JComboBox<>();
        ComboGenero = new javax.swing.JComboBox<>();
        btnModificarPelicula = new javax.swing.JButton();
        btnEliminarPelicula = new javax.swing.JButton();
        btnEliminarPelicula1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNuevoC.setText("NUEVO");
        btnNuevoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCActionPerformed(evt);
            }
        });

        btnListaClientes.setText("LISTA DE CLIENTES");
        btnListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaClientesActionPerformed(evt);
            }
        });

        jLabel4.setText("No. Cliente");

        jLabel1.setText("Nombre");

        jLabel2.setText("Dirección");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.: Cliente", "Nombre", "Dirrección", "Edad"
            }
        ));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaClientes);

        jLabel3.setText("Edad");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnModificar.setText("ACTUALIZAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDireccion))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNoCliente)
                                    .addComponent(txtEdad)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnNuevoC)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnModificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar)
                                        .addGap(0, 21, Short.MAX_VALUE)))))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnListaClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevoC)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListaClientes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes ", jPanel1);

        txtNoSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSeleccionActionPerformed(evt);
            }
        });

        jLabel12.setText("Ingrese el Numero del cliente");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        btnSeleccionar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                btnSeleccionarPropertyChange(evt);
            }
        });

        tablaClientes2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.: Cliente", "Nombre", "Dirección", "Edad"
            }
        ));
        jScrollPane5.setViewportView(tablaClientes2);

        txtSeleccion.setColumns(20);
        txtSeleccion.setRows(5);
        jScrollPane6.setViewportView(txtSeleccion);

        TablaPeliculas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.: Pelicula", "Nombre", "Tipo", "Genero", "Sinopsis"
            }
        ));
        jScrollPane7.setViewportView(TablaPeliculas2);

        btnAgregarPL.setText("Agregar Pelicula");
        btnAgregarPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPLActionPerformed(evt);
            }
        });

        txtList.setColumns(20);
        txtList.setRows(5);
        jScrollPane8.setViewportView(txtList);

        jLabel11.setText("PlayList");

        jButton1.setText("PlayList");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNoSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnSeleccionar))
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAgregarPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarPL, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNoSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSeleccionar))
                                .addGap(1, 1, 1)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(txtAgregarPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarPL))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Seleccionar Cliente", jPanel3);

        jLabel6.setText("Nombre");

        jLabel7.setText("Tipo");

        jLabel8.setText("Genero");

        jLabel9.setText("Sinopsis");

        jLabel10.setText("No.: Pelicula");

        txtNombrePelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePeliculaActionPerformed(evt);
            }
        });

        txtSinopsis.setColumns(20);
        txtSinopsis.setRows(5);
        jScrollPane1.setViewportView(txtSinopsis);

        TablaPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.:  Pelicula", "Nombre", "Tipo", "Genero", "Sinopsis"
            }
        ));
        TablaPeliculas.setName("TablaPeliculas"); // NOI18N
        TablaPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPeliculasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaPeliculas);

        btnCrearPelicula.setText("NUEVA PELICULA");
        btnCrearPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPeliculaActionPerformed(evt);
            }
        });

        btnListaPeliculas.setText("Lista de Peliculas");
        btnListaPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPeliculasActionPerformed(evt);
            }
        });

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serie", "Pelicula" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        ComboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drama", "Comedia", "Terror", "Suspenso" }));
        ComboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboGeneroActionPerformed(evt);
            }
        });

        btnModificarPelicula.setText("ACTUALIZAR");
        btnModificarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPeliculaActionPerformed(evt);
            }
        });

        btnEliminarPelicula.setText("ELIMINAR");
        btnEliminarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeliculaActionPerformed(evt);
            }
        });

        btnEliminarPelicula1.setText("LIMPIAR");
        btnEliminarPelicula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPelicula1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                        .addComponent(txtNoPelicula, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombrePelicula))
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnCrearPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarPelicula1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnListaPeliculas)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(ComboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNoPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearPelicula)
                            .addComponent(btnModificarPelicula)
                            .addComponent(btnEliminarPelicula)
                            .addComponent(btnEliminarPelicula1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListaPeliculas))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peliculas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnNuevoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCActionPerformed
        // TODO add your handling code here:
        
        //Aqui condicionamos que todos los textjfield tienen que estar llenos para poder capturar la info
        
        if(txtNombre.getText().isEmpty()||txtDireccion.getText().isEmpty()||txtEdad.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Los datos ingresados estan incompletos");
        }else{
               guardarCliente();
               limpiar();
               tablaClientes();
               }
    }//GEN-LAST:event_btnNuevoCActionPerformed

    private void btnListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListaClientesActionPerformed

    private void txtNombrePeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePeliculaActionPerformed

    private void btnCrearPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPeliculaActionPerformed
        if(txtNombrePelicula.getText().isEmpty()||txtSinopsis.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Completa Todos los Campos");
        }else{
              guardarPelicula();
              limpiarPelicula();
              tablaPeliculas();
               }
       
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnCrearPeliculaActionPerformed

    private void btnListaPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPeliculasActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btnListaPeliculasActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:  //        if(Integer.parseInt(txtNoSeleccion.getText())<lista.size()){

        
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnSeleccionarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnSeleccionarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarPropertyChange

    private void btnAgregarPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPLActionPerformed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_btnAgregarPLActionPerformed

    
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboGeneroActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_ComboGeneroActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
        
        int selecCliente= tablaClientes.rowAtPoint(evt.getPoint());
        txtNombre.setText(tablaClientes.getValueAt(selecCliente,1).toString());
        txtDireccion.setText(tablaClientes.getValueAt(selecCliente,2).toString());
        txtEdad.setText(tablaClientes.getValueAt(selecCliente,3).toString());
       
        
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
     modificarCliente();
     tablaClientes();
     limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtNoSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSeleccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSeleccionActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarCliente();
        tablaClientes();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        tablaClientes();
        limpiar();
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void TablaPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPeliculasMouseClicked
        // TODO add your handling code here:
        int selecPelicula= TablaPeliculas.rowAtPoint(evt.getPoint());
        txtNombrePelicula.setText(TablaPeliculas.getValueAt(selecPelicula,1).toString());
        txtSinopsis.setText(TablaPeliculas.getValueAt(selecPelicula,4).toString());
      
       
        
    }//GEN-LAST:event_TablaPeliculasMouseClicked

    private void btnModificarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPeliculaActionPerformed
        // TODO add your handling code here:
       if(txtNombrePelicula.getText().isEmpty()||txtSinopsis.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"COMPLETA TODOS LOS CAMPOS  /n PARA ACTUALIZAR KLOS DATOS DE UNA PELICULA");
        }else{
        modificarPelicula();
        tablaPeliculas();
        limpiarPelicula();
                }
    }//GEN-LAST:event_btnModificarPeliculaActionPerformed

    private void btnEliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeliculaActionPerformed
        eliminarPelicula();
        tablaPeliculas();
        limpiarPelicula();
// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarPeliculaActionPerformed

    private void btnEliminarPelicula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPelicula1ActionPerformed
        // TODO add your handling code here:
        tablaPeliculas();
        limpiarPelicula();
        
    }//GEN-LAST:event_btnEliminarPelicula1ActionPerformed
       
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
            java.util.logging.Logger.getLogger(formNecflis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formNecflis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formNecflis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formNecflis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formNecflis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboGenero;
    private javax.swing.JTable TablaPeliculas;
    private javax.swing.JTable TablaPeliculas2;
    private javax.swing.JButton btnAgregarPL;
    private javax.swing.JButton btnCrearPelicula;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarPelicula;
    private javax.swing.JButton btnEliminarPelicula1;
    public static javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListaClientes;
    private javax.swing.JButton btnListaPeliculas;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificarPelicula;
    public static javax.swing.JButton btnNuevoC;
    public static javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaClientes2;
    private javax.swing.JTextField txtAgregarPlay;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextArea txtList;
    private javax.swing.JTextField txtNoCliente;
    private javax.swing.JTextField txtNoPelicula;
    private javax.swing.JTextField txtNoSeleccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrePelicula;
    private javax.swing.JTextArea txtSeleccion;
    private javax.swing.JTextArea txtSinopsis;
    // End of variables declaration//GEN-END:variables
}
