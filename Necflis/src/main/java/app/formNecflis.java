/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Borge
 */
public class formNecflis extends javax.swing.JFrame {
    int cont = 0;   // se crea el contador de clientes dentro del progrma
    ArrayList <Clientes> lista=new ArrayList<Clientes>(); //Se crea el array que guarda los datos de los clientes:  
 int cont2 = 0; //se crea el contador de las pelicualas
 ArrayList <Peliculas> listaPeliculas=new ArrayList<Peliculas>();
  String matrizPlayList [][] = new String [10000][10000];
 int j = 0;
 int z = 0;
 int w = 0;
 int j1 = 0;
 int cont3= 0;
 int cont4 = 0;
 int pl = 0;
 int z2 = 0;
 String resultado = "";
    /**
     * Creates new form formNecflis
     */
    public formNecflis() {
       
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombrePelicula = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtNoPelicula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSinopsis = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaPeliculas = new javax.swing.JTable();
        btnCrearPelicula = new javax.swing.JButton();
        btnListaPeliculas = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtNoSeleccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaClientes2 = new javax.swing.JTable();
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

        btnNuevoC.setText("Nuevo Cliente");
        btnNuevoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCActionPerformed(evt);
            }
        });

        btnListaClientes.setText("Lista de Clientes");
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
        jScrollPane3.setViewportView(tablaClientes);

        jLabel3.setText("Edad");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 199, Short.MAX_VALUE)
                        .addComponent(btnNuevoC)
                        .addGap(34, 34, 34)
                        .addComponent(btnListaClientes)
                        .addGap(84, 84, 84))
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
                                    .addComponent(txtEdad))))
                        .addGap(43, 43, 43)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListaClientes)
                            .addComponent(btnNuevoC)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes ", jPanel1);

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

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
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
        jScrollPane4.setViewportView(TablaPeliculas);

        btnCrearPelicula.setText("Crear pelicula");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(183, Short.MAX_VALUE)
                        .addComponent(btnCrearPelicula)
                        .addGap(47, 47, 47)
                        .addComponent(btnListaPeliculas)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTipo)
                            .addComponent(txtGenero, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(txtNoPelicula, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombrePelicula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNoPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListaPeliculas)
                            .addComponent(btnCrearPelicula)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peliculas", jPanel2);

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

        TablaClientes2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(TablaClientes2);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane8)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Seleccionar Cliente", jPanel3);

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
                cont++;
                txtNoCliente.setText(Integer.toString(cont));
                Clientes Cliente = new Clientes(txtNombre.getText(),txtDireccion.getText(),txtEdad.getText(),cont);
                lista.add(Cliente);
                contenidoLista();
                JOptionPane.showMessageDialog(this,"El  Cliente ha sido Registrado con Exito!!");

                txtNombre.setText("");
                txtDireccion.setText("");
                txtEdad.setText("");
                txtNoCliente.setText("");
               }
    }//GEN-LAST:event_btnNuevoCActionPerformed

    public void contenidoLista(){
        if(lista.size()!=0){
            String matriz [][]= new String[lista.size()][4];
    
    for(int i = 0; i < lista.size(); i++){
    matriz [i][0]= Integer.toString(lista.get(i).getNoCliente());
    matriz [i][1]= lista.get(i).getNombre();
    matriz [i][2]= lista.get(i).getDireccion();
    matriz [i][3]= lista.get(i).getEdad();
    
    }
    // Aca se muestra la tabla de los clientes activos en el sistema
     tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
           matriz,
            new String [] {
                "No.: Cliente", "Nombre", "Dirrección", "Edad"
            }
        ));
     
    
     TablaClientes2.setModel(new javax.swing.table.DefaultTableModel(
           matriz,
            new String [] {
                "No.: Cliente", "Nombre", "Dirrección", "Edad"
            }
        ));
    
        }else{
        JOptionPane.showMessageDialog(this,"No se ha ingresado ningun cliente!!!");
        }
    }
    
    private void btnListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaClientesActionPerformed
        // TODO add your handling code here:
        contenidoLista();
    }//GEN-LAST:event_btnListaClientesActionPerformed

    private void txtNombrePeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePeliculaActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void btnCrearPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPeliculaActionPerformed

        // TODO add your handling code here:
        
               if(txtNombrePelicula.getText().isEmpty()|| txtTipo.getText().isEmpty()||txtGenero.getText().isEmpty()||txtSinopsis.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Los datos ingresados estan incompletos");
            }else{
        cont2++;
        txtNoPelicula.setText(Integer.toString(cont2));
        Peliculas Pelicula = new Peliculas(txtNombrePelicula.getText(), txtTipo.getText(),txtGenero.getText(), txtSinopsis.getText(),cont2);
        listaPeliculas.add(Pelicula);
        contenidoP();
        JOptionPane.showMessageDialog(this,"La pelicula a  ha sido Registrada con Exito!!");
        
        txtNombrePelicula.setText("");
        txtTipo.setText("");
        txtGenero.setText("");
        txtSinopsis.setText("");
        txtNoPelicula.setText("");
        }
    }//GEN-LAST:event_btnCrearPeliculaActionPerformed

    private void btnListaPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPeliculasActionPerformed
        // TODO add your handling code here:
        contenidoP();
    }//GEN-LAST:event_btnListaPeliculasActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:  //        if(Integer.parseInt(txtNoSeleccion.getText())<lista.size()){

        if(Integer.parseInt(txtNoSeleccion.getText())>lista.size()){
        JOptionPane.showMessageDialog(this,"El dato ingresado es Incorrecto");
        }else if(txtNoSeleccion.getText().isEmpty()){
        JOptionPane.showMessageDialog(this,"Debes ingresar un No.: de Cliente");
        }else{
        JOptionPane.showMessageDialog(this,"Cargando Información");
        j=0;
        j = Integer.parseInt(txtNoSeleccion.getText())-1;
         
        
        String n, d, e;
        n = lista.get(j).getNombre();
        d = lista.get(j).getDireccion();
        e = lista.get(j).getEdad();
        txtSeleccion.setText("Identifiador:  "+(j+1)+"\n"+"Nombre:  "+n+"\n"+"Dirección:  "+d+""+"\n"+"Edad:  "+e);
        z=j;
        txtNoSeleccion.setText("");
        j=0; // z este seria el usario correspondiente
        
        }
        
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnSeleccionarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnSeleccionarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarPropertyChange

    private void btnAgregarPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPLActionPerformed
        // TODO add your handling code here:
        
        if(txtAgregarPlay.getText().isEmpty()|| Integer.parseInt(txtAgregarPlay.getText())>listaPeliculas.size()){
        JOptionPane.showMessageDialog(this,"El dato ingresado es Incorrecto");
        }else {
        JOptionPane.showMessageDialog(this,"Cargando PlayList");
        z2 = Integer.parseInt(txtAgregarPlay.getText());
        z2 = z2-1;
        JOptionPane.showMessageDialog(this,z+"clientes"+z2+"peliculas");  
    matrizPlayList[z][z2]=listaPeliculas.get(z2).getNombre(); // fila z2 es peliculas // z es clientes columnas
    mostrar();
        }
    }//GEN-LAST:event_btnAgregarPLActionPerformed

    
   public void mostrar(){
    for(int m11 = 0; m11<lista.size(); m11++){
    String r=  matrizPlayList[z2][m11];
    resultado =resultado+ r+" ";
    txtList.setText(resultado);
    resultado = "";
    z2= 0;
    z = 0;
     }
        }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        mostrar();
        
    }//GEN-LAST:event_jButton1ActionPerformed
     
    
    
   
    
    
    
    
    
    
    
    public void contenidoP(){
    if(listaPeliculas.size()!=0){
    String matrizP [][]= new String[listaPeliculas.size()][5];
    
    for(int i =0; i<listaPeliculas.size(); i++){
    matrizP [i][0] = Integer.toString(listaPeliculas.get(i).getNoPelicula());
    matrizP [i][1] = listaPeliculas.get(i).getNombre();
    matrizP [i][2] = listaPeliculas.get(i).getTipo();
    matrizP [i][3] = listaPeliculas.get(i).getGenero();
    matrizP [i][4] = listaPeliculas.get(i).getsinopsis();
    }
    
    
    // aqui debe ir la tabla
TablaPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            matrizP,
            new String [] {
                "No.: Pelicula", "Nombre", "Tipo", "Genero", "Sinopsis"
            }
        ));
    //tabla peliculas seleccion
    
    TablaPeliculas2.setModel(new javax.swing.table.DefaultTableModel(
            matrizP,
            new String [] {
                "No.: Pelicula", "Nombre", "Tipo", "Genero", "Sinopsis"
            }
        ));
    }else{
    JOptionPane.showMessageDialog(this,"No se ha ingresado ninguna pelicula!!!");
    }
  }
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
    private javax.swing.JTable TablaClientes2;
    private javax.swing.JTable TablaPeliculas;
    private javax.swing.JTable TablaPeliculas2;
    private javax.swing.JButton btnAgregarPL;
    private javax.swing.JButton btnCrearPelicula;
    private javax.swing.JButton btnListaClientes;
    private javax.swing.JButton btnListaPeliculas;
    public static javax.swing.JButton btnNuevoC;
    public static javax.swing.JButton btnSeleccionar;
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
    private javax.swing.JTextField txtAgregarPlay;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextArea txtList;
    private javax.swing.JTextField txtNoCliente;
    private javax.swing.JTextField txtNoPelicula;
    private javax.swing.JTextField txtNoSeleccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrePelicula;
    private javax.swing.JTextArea txtSeleccion;
    private javax.swing.JTextArea txtSinopsis;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}