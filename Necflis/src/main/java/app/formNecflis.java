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
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Kevin Borge
 */
public class formNecflis extends javax.swing.JFrame {

    MySqlConnector conector = new MySqlConnector();
    Connection con1 = conector.conectar();
    String noClienteLista = "";
    String noPeliculaLista = "";
    String eliminar = "";
  

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
            JOptionPane.showMessageDialog(null, "Cliente Guardado!!");
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos Incompletos");
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
            
       
            PreparedStatement pst = con1.prepareStatement("UPDATE clientes SET Nombre=?,Direccion = ?,Edad = ?  WHERE clientes . No_cliente"+"="+ Integer.parseInt(noCliente)+"");
            PreparedStatement ps  = con1.prepareStatement("UPDATE playlist SET cliente = ? WHERE playlist . No_Cliente"+"="+noCliente+"");
     
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getDireccion());
            pst.setString(3, cliente.getEdad());
            ps.setString(1, cliente.getNombre());
            ps.execute();
            pst.executeUpdate();
         
            JOptionPane.showMessageDialog(null, "Datos Actualizados!!");
            pst.close();
            ps.close();
          
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Actualizar los Datos!!!");
        }

    
    }
    
    public void eliminarCliente(){
  try {
            Clientes cliente   = new Clientes();
            cliente.setNombre(txtNombre.getText());
            cliente.setDireccion(txtDireccion.getText());
            int fila = tablaClientes.getSelectedRow();
            String noCliente = tablaClientes.getValueAt(fila, 0).toString();
            
            PreparedStatement pst = con1.prepareStatement("DELETE FROM Clientes WHERE Clientes . No_cliente"+"="+ Integer.parseInt(noCliente)+"");
            PreparedStatement pst2 = con1.prepareStatement("DELETE FROM playlist WHERE playlist . No_cliente"+"="+ Integer.parseInt(noCliente)+"");
            
            pst.executeUpdate();
            pst2.executeUpdate();
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
            tablaClientes3.setModel(model);

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
        txtNoPelicula.setText("");
 
    }

    public void guardarPelicula() {
        try {
            Peliculas pelicula = new Peliculas();
            pelicula.setNombre(txtNombrePelicula.getText());
            pelicula.setTipo(comboTipo.getSelectedItem().toString());
            pelicula.setGenero(comboGenero.getSelectedItem().toString());
            pelicula.setsinopsis(txtSinopsis.getText());
            
            
            PreparedStatement pst = con1.prepareStatement("INSERT INTO peliculas(Nombre,Tipo,Genero,Sinopsis) VALUES (?,?,?,?)");
            pst.setString(1, pelicula.getNombre());
            pst.setString(2, pelicula.getTipo());
            pst.setString(3, pelicula.getGenero());
            pst.setString(4, pelicula.getsinopsis());
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Pelicula Ingresada!!");
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos Incompletos");
        }

    }
    
    public void modificarPelicula(){
         try {
            Peliculas pelicula = new Peliculas();
            pelicula.setNombre(txtNombrePelicula.getText());
            pelicula.setTipo(comboTipo.getSelectedItem().toString());
            pelicula.setGenero(comboGenero.getSelectedItem().toString());
            pelicula.setsinopsis(txtSinopsis.getText());

            int fila = TablaPeliculas.getSelectedRow();
            String noPelicula = TablaPeliculas.getValueAt(fila, 0).toString();
            
            //UPDATE `personas` SET `Nombre` = 'maria' WHERE `personas`.`ID` = 4
            PreparedStatement pst = con1.prepareStatement("UPDATE peliculas SET Nombre = ?,Tipo = ?,Genero = ?, Sinopsis =?  WHERE peliculas . No_Pelicula"+"="+ Integer.parseInt(noPelicula)+"");
            PreparedStatement pst2 = con1.prepareStatement("UPDATE  playlist SET pelicula = ? WHERE playlist . No_Pelicula"+"="+ Integer.parseInt(noPelicula)+"");
            
            
            pst.setString(1, pelicula.getNombre());
            pst.setString(2, pelicula.getTipo());
            pst.setString(3, pelicula.getGenero());
            pst.setString(4, pelicula.getsinopsis());
            pst2.setString(1,pelicula.getNombre());
            pst.executeUpdate();
            pst2.executeUpdate();
            pst.close();
            pst2.close();
            
            JOptionPane.showMessageDialog(null, "Pelicula Actualizada!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar Pelicula!!!");
        }

    
    }
    
            public void eliminarPelicula(){
            try {
            Peliculas pelicula   = new Peliculas();
            pelicula.setNombre(txtNombrePelicula.getText());
            pelicula.setsinopsis(txtSinopsis.getText());
            int fila = TablaPeliculas.getSelectedRow();
            String noPeliculas = TablaPeliculas.getValueAt(fila, 0).toString();
            //"DELETE FROM Clientes WHERE Clientes . No_cliente"+"="+ Integer.parseInt(noCliente)+""
            //UPDATE `personas` SET `Nombre` = 'maria' WHERE `personas`.`ID` = 4
            PreparedStatement pst = con1.prepareStatement("DELETE FROM peliculas WHERE peliculas . No_Pelicula"+"="+ Integer.parseInt(noPeliculas)+"");
            PreparedStatement pst2 = con1.prepareStatement("DELETE FROM playlist WHERE playlist . No_Pelicula"+"="+ Integer.parseInt(noPeliculas)+"");
            pst.executeUpdate();
            pst2.executeUpdate();
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

 public void guardarCliente_Pelicula() {
        try {
            
            PeliculaCliente seleccion = new PeliculaCliente();
            seleccion.setNo_Cliente(noClienteLista);
            seleccion.setNo_Pelicula(noPeliculaLista);
            seleccion.setcliente(txtSelecCliente.getText());
            seleccion.setpelicula(txtSelectPelicula.getText());
            
            
            PreparedStatement pst = con1.prepareStatement("INSERT INTO playlist(No_Cliente,cliente,No_Pelicula, pelicula) VALUES (?,?,?,?)");
            pst.setString(1,seleccion.getNo_Cliente());
            pst.setString(2,seleccion.getcliente());
            pst.setString(3,seleccion.getNo_Pelicula());
            pst.setString(4, seleccion.getpelicula());
 
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Pelicula Agregada!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Agegar Pelicula");
        }

    }
 
  public void playlist() {
        try {
            String buscar =txtSelecCliente.getText();
            DefaultTableModel model = new DefaultTableModel();
            PreparedStatement ps = null;
            ResultSet rs = null;
            MySqlConnector conectorTC = new MySqlConnector();
            Connection con2 = conectorTC.conectar();

            String consulta = "SELECT ID, pelicula FROM playlist WHERE cliente LIKE '%"+buscar+"%'";
            ps = con2.prepareStatement(consulta);
            rs = ps.executeQuery();

            ResultSetMetaData rsMD = rs.getMetaData();
            int noColumnas = rsMD.getColumnCount();
            model.addColumn("ID");
            model.addColumn("Lista de Peliculas");
            tablaPlayList.setModel(model);
            
            while (rs.next()) {
                Object[] fila = new Object[noColumnas];
                for (int i = 0; i < noColumnas; i++) {
                    fila[i] = rs.getObject(i+1);

                }
                model.addRow(fila);
                
            }
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona un Cliente");
        }
    }
  
  
  
  public void vaciar(){
      
      try{
         DefaultTableModel modelo = (DefaultTableModel)tablaPlayList.getModel();
        int filas = tablaPlayList.getRowCount();
        for(int i=0; i < filas; i++){
        modelo.removeRow(0);
        }
      }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al eliminar borrar la PLaylist");
      }
  
  }
  
    public void  eliminarPeliculaCliente(){
        try {
            PeliculaCliente pelicula   = new PeliculaCliente();
            pelicula.setpelicula(txtSelecCliente.getText());
            int fila = tablaPlayList.getSelectedRow();
            String eliminar = tablaPlayList.getValueAt(fila, 0).toString();
             
            //"DELETE FROM playlist WHERE playlist . No_Pelicula"+"="+ Integer.parseInt(noPeliculas)+""
            //¿Realmente desea ejecutar "DELETE FROM `peliculas` WHERE `peliculas`.`No_Pelicula` = 3"?
            PreparedStatement pst = con1.prepareStatement("DELETE FROM playlist WHERE playlist . ID "+"="+ Integer.parseInt(eliminar)+"");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pelicula Eliminada!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona una pelicula!!!");
        }
    }
 

    public formNecflis() {
       
        initComponents();
        tablaClientes();
        tablaPeliculas();
        txtAreaSinopsis.setLineWrap(true);
        txtSinopsis.setLineWrap(true);
        this.setLocationRelativeTo(null);
      

       
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
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtEdad = new javax.swing.JTextField();
        btnNuevoC = new javax.swing.JButton();
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
        btnAyuda = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPeliculas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNoPelicula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSinopsis = new javax.swing.JTextArea();
        btnModificarPelicula = new javax.swing.JButton();
        comboGenero = new javax.swing.JComboBox<>();
        comboTipo = new javax.swing.JComboBox<>();
        txtNombrePelicula = new javax.swing.JTextField();
        btnCrearPelicula1 = new javax.swing.JButton();
        btnEliminarPelicula = new javax.swing.JButton();
        btnlimpiarPelicula = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSelecCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnLimpiarCliente = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaClientes3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaPeliculas2 = new javax.swing.JTable();
        txtSelectPelicula = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnPlayList = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnLimpiarPeli = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaPlayList = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAreaSinopsis = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnEliminarPeliPlay = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

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

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(49, 171, 49));
        setFont(new java.awt.Font("Arial Nova Cond", 3, 10)); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFocusTraversalPolicyProvider(true);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(900, 600));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(900, 600));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        btnNuevoC.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevoC.setText("NUEVO");
        btnNuevoC.setAlignmentY(0.0F);
        btnNuevoC.setBorder(null);
        btnNuevoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("No. Cliente");

        txtNoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        tablaClientes.setGridColor(new java.awt.Color(51, 51, 51));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaClientes);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Edad");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 255, 153));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar.setText("ACTUALIZAR");
        btnModificar.setBorder(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAyuda.setBackground(new java.awt.Color(204, 204, 255));
        btnAyuda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAyuda.setText("AYUDA");
        btnAyuda.setAutoscrolls(true);
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("CLIENTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNuevoC, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(btnAyuda)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTES", jPanel1);

        jPanel2.setBackground(new java.awt.Color(239, 239, 239));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tipo");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Genero");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Sinopsis");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("No. Pelicula");

        txtNoPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoPeliculaActionPerformed(evt);
            }
        });

        txtSinopsis.setColumns(20);
        txtSinopsis.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtSinopsis.setRows(5);
        jScrollPane1.setViewportView(txtSinopsis);

        btnModificarPelicula.setBackground(new java.awt.Color(255, 255, 153));
        btnModificarPelicula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificarPelicula.setText("ACTUALIZAR");
        btnModificarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPeliculaActionPerformed(evt);
            }
        });

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drama", "Comedia", "Terror", "Suspenso" }));
        comboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGeneroActionPerformed(evt);
            }
        });

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serie", "Pelicula" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        txtNombrePelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePeliculaActionPerformed(evt);
            }
        });

        btnCrearPelicula1.setBackground(new java.awt.Color(204, 255, 204));
        btnCrearPelicula1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCrearPelicula1.setText("NUEVA");
        btnCrearPelicula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPelicula1ActionPerformed(evt);
            }
        });

        btnEliminarPelicula.setBackground(new java.awt.Color(255, 153, 153));
        btnEliminarPelicula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminarPelicula.setText("ELIMINAR");
        btnEliminarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeliculaActionPerformed(evt);
            }
        });

        btnlimpiarPelicula.setBackground(new java.awt.Color(153, 204, 255));
        btnlimpiarPelicula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnlimpiarPelicula.setText("LIMPIAR");
        btnlimpiarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarPeliculaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("PELICULAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNoPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombrePelicula, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(comboTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCrearPelicula1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificarPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnlimpiarPelicula)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(366, 366, 366))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtNoPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearPelicula1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlimpiarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PELICULAS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(239, 239, 239));

        txtSelecCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSelecClienteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("SELECCIONAR CLIENTE");

        btnLimpiarCliente.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiarCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiarCliente.setText("LIMPIAR");
        btnLimpiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarClienteActionPerformed(evt);
            }
        });
        btnLimpiarCliente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                btnLimpiarClientePropertyChange(evt);
            }
        });

        tablaClientes3.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientes3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaClientes3);

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
        TablaPeliculas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPeliculas2MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TablaPeliculas2);

        txtSelectPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSelectPeliculaActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnPlayList.setBackground(new java.awt.Color(204, 204, 255));
        btnPlayList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPlayList.setText("PLAYLIST");
        btnPlayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayListActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("SELECIONAR PELICULA");

        btnLimpiarPeli.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiarPeli.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiarPeli.setText("LIMPIAR");
        btnLimpiarPeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPeliActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("PLAYLIST");

        tablaPlayList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Lista de Peliculas"
            }
        ));
        tablaPlayList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlayListMouseClicked(evt);
            }
        });
        tablaPlayList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaPlayListKeyPressed(evt);
            }
        });
        jScrollPane9.setViewportView(tablaPlayList);

        txtAreaSinopsis.setColumns(20);
        txtAreaSinopsis.setRows(5);
        jScrollPane6.setViewportView(txtAreaSinopsis);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Sinopsis:");

        btnEliminarPeliPlay.setBackground(new java.awt.Color(255, 153, 153));
        btnEliminarPeliPlay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminarPeliPlay.setText("ELIMINAR");
        btnEliminarPeliPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeliPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane6)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSelectPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(31, 31, 31))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSelecCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnLimpiarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPlayList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiarPeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                            .addComponent(btnEliminarPeliPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlayList))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpiarCliente)
                            .addComponent(txtSelecCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txtSelectPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarPeli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarPeliPlay))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SELECCIONAR CLIENTE", jPanel3);

        jLabel16.setText("jLabel16");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel16)
                .addContainerGap(625, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel16)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarPeliPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeliPlayActionPerformed
       
        if(txtSelecCliente.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"selecciona un Cliente");
            }else{
                    eliminarPeliculaCliente();
    }
        
       
    }//GEN-LAST:event_btnEliminarPeliPlayActionPerformed

    private void tablaPlayListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaPlayListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPlayListKeyPressed

    private void tablaPlayListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlayListMouseClicked
        int eliminarPelicula = tablaPlayList.rowAtPoint(evt.getPoint());
        eliminar = (tablaPlayList.getValueAt(eliminarPelicula,1).toString());
        ///Corregir para mostrar la tabla de una sola columna
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPlayListMouseClicked

    private void btnLimpiarPeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPeliActionPerformed
        txtSelectPelicula.setText("");
        txtAreaSinopsis.setText("");
        TablaPeliculas2.clearSelection();
        noPeliculaLista = "";
    }//GEN-LAST:event_btnLimpiarPeliActionPerformed

    private void btnPlayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayListActionPerformed

        if(txtSelecCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleciona un cliente");
        }else{
            playlist();
           tablaPlayList.getColumnModel().getColumn(0).setMaxWidth(0);
           tablaPlayList.getColumnModel().getColumn(0).setMinWidth(0);
            tablaPlayList.getColumnModel().getColumn(0).setPreferredWidth(0);

        }
    }//GEN-LAST:event_btnPlayListActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:

        if(txtSelecCliente.getText().isEmpty() && txtSelectPelicula.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Selecciona un Cliente");
        }else if(txtSelectPelicula.getText().isEmpty ()){
            JOptionPane.showMessageDialog(null,"Selecciona una Pelicula!!");
        }else if(txtSelecCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Selecciona un Cliente");
        }else{
            guardarCliente_Pelicula();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtSelectPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSelectPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelectPeliculaActionPerformed

    private void TablaPeliculas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPeliculas2MouseClicked

        int selecPelicula = TablaPeliculas2.rowAtPoint(evt.getPoint());
        noPeliculaLista = (TablaPeliculas2.getValueAt(selecPelicula, 0).toString());
        txtSelectPelicula.setText(TablaPeliculas2.getValueAt(selecPelicula,1).toString());
        txtAreaSinopsis.setText(TablaPeliculas.getValueAt(selecPelicula,4).toString());
    }//GEN-LAST:event_TablaPeliculas2MouseClicked

    private void tablaClientes3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientes3MouseClicked
        // TODO add your handling code here:
        int selecClientePlay= tablaClientes3.rowAtPoint(evt.getPoint());
        noClienteLista=(tablaClientes3.getValueAt(selecClientePlay, 0).toString());
        txtSelecCliente.setText(tablaClientes3.getValueAt(selecClientePlay,1).toString());
    }//GEN-LAST:event_tablaClientes3MouseClicked

    private void btnLimpiarClientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnLimpiarClientePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarClientePropertyChange

    private void btnLimpiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarClienteActionPerformed
        txtSelecCliente.setText("");
        tablaClientes3.clearSelection();
        vaciar();
        noClienteLista = "";
    }//GEN-LAST:event_btnLimpiarClienteActionPerformed

    private void txtSelecClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSelecClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSelecClienteActionPerformed

    private void btnlimpiarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarPeliculaActionPerformed
        limpiarPelicula();
        tablaPeliculas();
    }//GEN-LAST:event_btnlimpiarPeliculaActionPerformed

    private void btnEliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeliculaActionPerformed
        eliminarPelicula();
        limpiarPelicula();
        tablaPeliculas();
    }//GEN-LAST:event_btnEliminarPeliculaActionPerformed

    private void btnCrearPelicula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPelicula1ActionPerformed
        // TODO add your handling code here:
        if(txtNombrePelicula.getText().isEmpty()||txtSinopsis.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Los datos ingresados estan incompletos");
        }else{
            guardarPelicula();
            limpiarPelicula();
            tablaPeliculas();
        }
    }//GEN-LAST:event_btnCrearPelicula1ActionPerformed

    private void txtNombrePeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePeliculaActionPerformed

    private void comboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGeneroActionPerformed

    private void btnModificarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPeliculaActionPerformed
        if(txtNombrePelicula.getText().isEmpty()||txtSinopsis.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"  Datos incompletos");
        }else{
            modificarPelicula();
            limpiarPelicula();
            tablaPeliculas();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarPeliculaActionPerformed

    private void txtNoPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoPeliculaActionPerformed

    private void TablaPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPeliculasMouseClicked
        int selecCliente= TablaPeliculas.rowAtPoint(evt.getPoint());
        txtNombrePelicula.setText(TablaPeliculas.getValueAt(selecCliente,1).toString());
        txtSinopsis.setText(TablaPeliculas.getValueAt(selecCliente,4).toString());
        txtNoPelicula.setText(TablaPeliculas.getValueAt(selecCliente,0).toString());

    }//GEN-LAST:event_TablaPeliculasMouseClicked

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Grupo No.: 6"+"\n"+"\n"
            +"Integrantes"+"\n"+"\n"
            +"Kevin Borge Tobar  Carnet No.: 0907-20-15112"+"\n" +"Mabelin Estefani Aroche FLores Carnet No.: 0907-20-21187"
            +"\n" +"Marlen Breneli Escobar Lima Carnet No.: 0907-20-15527"+"\n" +"Celita Maria Morales Marroquin Carnet No.: 0907-20-24672"
            +"\n" +"Andrik Saul Estrada Aguilar Carnet No.: 0907-19-12405"
        );
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        tablaClientes();
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarCliente();
        tablaClientes();
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
     if(txtNombre.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtEdad.getText().isEmpty()){
     JOptionPane.showMessageDialog(null,"Los datos Estan Incompletos");
     }else{
        modificarCliente();
        tablaClientes();
        limpiar();
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:

        int selecCliente= tablaClientes.rowAtPoint(evt.getPoint());
        txtNombre.setText(tablaClientes.getValueAt(selecCliente,1).toString());
        txtDireccion.setText(tablaClientes.getValueAt(selecCliente,2).toString());
        txtEdad.setText(tablaClientes.getValueAt(selecCliente,3).toString());
        txtNoCliente.setText(tablaClientes.getValueAt(selecCliente,0).toString());
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void txtNoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoClienteActionPerformed

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

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    
         
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
    private javax.swing.JTable TablaPeliculas;
    private javax.swing.JTable TablaPeliculas2;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCrearPelicula1;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarPeliPlay;
    private javax.swing.JButton btnEliminarPelicula;
    public static javax.swing.JButton btnLimpiar;
    public static javax.swing.JButton btnLimpiarCliente;
    private javax.swing.JButton btnLimpiarPeli;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificarPelicula;
    public static javax.swing.JButton btnNuevoC;
    private javax.swing.JButton btnPlayList;
    private javax.swing.JButton btnlimpiarPelicula;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaClientes3;
    private javax.swing.JTable tablaPlayList;
    private javax.swing.JTextArea txtAreaSinopsis;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNoCliente;
    private javax.swing.JTextField txtNoPelicula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrePelicula;
    private javax.swing.JTextField txtSelecCliente;
    private javax.swing.JTextField txtSelectPelicula;
    private javax.swing.JTextArea txtSinopsis;
    // End of variables declaration//GEN-END:variables
}
