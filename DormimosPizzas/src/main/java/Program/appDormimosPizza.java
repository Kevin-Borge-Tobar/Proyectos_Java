/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Kevin Borge
 */
public class appDormimosPizza extends javax.swing.JFrame {

    /**
     * Creates new form appDormimosPizza
     */
    public appDormimosPizza() {
        initComponents();
        
    }
    ArrayList<Admon>s1 = new ArrayList<Admon>();
    ArrayList<Admon>s2 = new ArrayList<Admon>();
    ArrayList<Admon>s3 = new ArrayList<Admon>();
    ArrayList<Pedidos>ordenes = new ArrayList<Pedidos>();
    int  cont = 0;
    
    
   public void CrearPizza(){
    Admon nueva = new Admon();
    nueva.setSucursal(ComboSuc.getSelectedItem().toString());
    String suc = ComboSuc.getSelectedItem().toString();
    nueva.setNombre(txtNombre.getText());
    nueva.setPrecio(txtPrecio.getText());
    nueva.setDescripcion(txtDesc.getText());
    
    switch(suc){
        case "Guatemala":
            s1.add(nueva);
            JOptionPane.showMessageDialog(null, "Pizza agregada a Sucursal: "+suc);
            Pizzass1();
            break;
        case "Jalapa":
            s2.add(nueva);
            Pizzass2();
            JOptionPane.showMessageDialog(null, "Pizza Agregada a Sucursal: "+ suc);
            break;
        case "El Progreso":
            s3.add(nueva);
            JOptionPane.showMessageDialog(null, "Pizza agregada a sucursal: "+ suc);
            Pizzass3();
            break;
        default:
             JOptionPane.showMessageDialog(null, "Error al Agregar Pizza!!!!!");
             break;
     }
}


public void Pizzass1(){
if(s1.size()!=0){
String matriz [][] = new String[s1.size()][3];

for(int i=0; i<s1.size(); i++){
    matriz [i][0] = s1.get(i).getNombre();
    matriz [i][1] = s1.get(i).getDescripcion();
    matriz [i][2] = s1.get(i).getPrecio();
}

TablaLIstaPizza.setModel(new javax.swing.table.DefaultTableModel(
    matriz,
    new String [] {
        "Nombre", "Descripcion", "Precio"
    }
        ));

    }else{
   String matriz[][] =new String [0][0];
    TablaLIstaPizza.setModel(new javax.swing.table.DefaultTableModel(
    matriz,
    new String [] {
        "Nombre", "Descripcion", "Precio"
    }
        ));
}
}


public void Pizzass2(){
if(s2.size() !=0){
String matriz [][] = new String [s2.size()][3];
    for(int i=0; i<s2.size(); i++){
    matriz[i][0] = s2.get(i).getNombre();
    matriz[i][1] = s2.get(i).getDescripcion();
    matriz[i][2] = s2.get(i).getPrecio();
  
    TablaLIstaPizza.setModel(new javax.swing.table.DefaultTableModel(
    matriz,
    new String [] {
        "Nombre", "Descripcion", "Precio"
    }
        ));
}
}else{
   String matriz[][] =new String [0][0];
    TablaLIstaPizza.setModel(new javax.swing.table.DefaultTableModel(
    matriz,
    new String [] {
        "Nombre", "Descripcion", "Precio"
    }
        ));
}
}  

public void Pizzass3(){
if(s3.size() !=0){ 
String matriz [][] = new String [s3.size()][3];

for(int i = 0; i<s3.size(); i++){

    matriz[i][0] = s3.get(i).getNombre();
    matriz[i][1] = s3.get(i).getDescripcion();
    matriz[i][2] = s3.get(i).getPrecio();
    
    TablaLIstaPizza.setModel(new javax.swing.table.DefaultTableModel(
    matriz,
    new String [] {
        "Nombre", "Descripcion", "Precio"
    }
        ));
}
}else{
   String matriz[][] =new String [0][0];
    TablaLIstaPizza.setModel(new javax.swing.table.DefaultTableModel(
    matriz,
    new String [] {
        "Nombre", "Descripcion", "Precio"
    }
        ));
}
}

public void listadoSucursal(){
    String listaSuc = ComboSuc.getSelectedItem().toString();
 switch(listaSuc){
     case "Guatemala":
     Pizzass1();
     break;
     case "Jalapa":
     Pizzass2();
     break;
     case "El Progreso":
     Pizzass3();
     break;
     default:
     JOptionPane.showMessageDialog(null, "Error al cargar las pizas Disponibles");
     break;
}
}

public void listaPizzas(){
    String pizzaSelect =ComboSucursal.getSelectedItem().toString();
    switch(pizzaSelect){
        case "Guatemala":
            ComboPizzaSelec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            String matriz[] = new String [s1.size()];
            for(int i = 0; i<s1.size(); i++){
            matriz[i]= s1.get(i).getNombre();
            ComboPizzaSelec.addItem(matriz[i]);
            }
            break;
        case"Jalapa":
            ComboPizzaSelec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            String matriz2[] = new String [s2.size()];
            for(int i =0; i<s2.size(); i++){
            matriz2[i] = s2.get(i).getNombre();
            ComboPizzaSelec.addItem(matriz2[i]);
        }
        break;
        case"El Progreso":
            ComboPizzaSelec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            String matriz3[] = new String [s3.size()];
            for(int i =0; i<s3.size(); i++){
            matriz3[i] = s3.get(i).getNombre();
            ComboPizzaSelec.addItem(matriz3[i]);
            }
            break;
        default:
            ComboPizzaSelec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            
}
    }

public void  precioDescripcion(){
        int seleccion = ComboPizzaSelec.getSelectedIndex();
        String pizzaSelect =ComboSucursal.getSelectedItem().toString();
         switch(pizzaSelect){
             case "Guatemala":
                 String desc = s1.get(seleccion).getDescripcion();
                 String precio = s1.get(seleccion).getPrecio();
                   labelPrecio.setText(precio);
                 labelDescripcion.setText(desc);
                 break;
             case "Jalapa":
               String desc2 = s2.get(seleccion).getDescripcion();
                 String precio2 = s2.get(seleccion).getPrecio();
                 labelPrecio.setText(precio2);
                 labelDescripcion.setText(desc2);
                 break;
             case "El Progreso":
                 String desc3 = s3.get(seleccion).getDescripcion();
                 String precio3 = s3.get(seleccion).getPrecio();
                   labelPrecio.setText(precio3);
                 labelDescripcion.setText(desc3);
                 break;
             default:
                  ComboPizzaSelec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));        
         } 
}

public void ordenar(){
    cont++;
      Pedidos orden = new Pedidos();
      orden.setNoOrden(Integer.toString(cont));
      orden.setPizza(ComboPizzaSelec.getSelectedItem().toString());
      orden.setDescripcion(labelDescripcion.getText());
      orden.setSucursal(ComboSucursal.getSelectedItem().toString());
      ordenes.add(orden);
      if(ordenes.size()!=0){
       String[][]  matriz = new String[ordenes.size()][4];
       for(int i=0; i<ordenes.size(); i++){
           matriz[i][0] = ordenes.get(i).getNoOrden();
           matriz[i][1] = ordenes.get(i).getPizza();
           matriz[i][2] = ordenes.get(i).getDescripcion();
           matriz[i][3] = ordenes.get(i).getSucursal(); 
      }
    tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        "No.: ", "Orden", "Descripcion", "Sucursal"
    }
));
}
}

public void limpiarAdmon(){
    txtNombre.setText("");
    txtDesc.setText("");
    txtPrecio.setText("");
}


public void limpiarOrden(){
labelPrecio.setText("");
labelDescripcion.setText("");
}

 public void SucursalPizzas(){
 String sucursal = ComboSuc.getSelectedItem().toString();
 switch(sucursal){
     case "Guatemala":
         Pizzass1();
         break;
     case "Jalapa":
         Pizzass2();
         break;
     case "El Progreso":
         Pizzass3();
         break;
     default:
         JOptionPane.showMessageDialog(null, "Error al Cargar los datos"); 
         break;
 }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        ComboSuc = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaLIstaPizza = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaOrdenes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        ComboSucursal = new javax.swing.JComboBox<>();
        ComboPizzaSelec = new javax.swing.JComboBox<>();
        labelPrecio = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        jLabel1.setText("Sucursal");

        jLabel2.setText("Pizzas");

        jLabel3.setText("Nombre");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Precio");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        ComboSuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guatemala", "Jalapa", "El Progreso" }));
        ComboSuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboSucItemStateChanged(evt);
            }
        });
        ComboSuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboSucMouseClicked(evt);
            }
        });
        ComboSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSucActionPerformed(evt);
            }
        });

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TablaLIstaPizza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No.:", "Descripcion", "Precio"
            }
        ));
        jScrollPane3.setViewportView(TablaLIstaPizza);

        jLabel6.setText("ADMINISTRACION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(ComboSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtNombre))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
                .addGap(229, 229, 229))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(87, 87, 87))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("ADMINISTRACION", jPanel1);

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        tablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.:", "Orden", "Descripcion", "Precio"
            }
        ));
        jScrollPane4.setViewportView(tablaOrdenes);

        jLabel7.setText("ORDENES");

        jLabel8.setText("Sucursal");

        jLabel9.setText("Descripcion");

        jLabel10.setText("Pizza");

        btnOrdenar.setText("ORDENAR");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        ComboSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guatemala", "Jalapa", "El Progreso" }));
        ComboSucursal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboSucursalItemStateChanged(evt);
            }
        });
        ComboSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboSucursalMouseClicked(evt);
            }
        });
        ComboSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSucursalActionPerformed(evt);
            }
        });

        ComboPizzaSelec.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboPizzaSelecItemStateChanged(evt);
            }
        });
        ComboPizzaSelec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboPizzaSelecMouseClicked(evt);
            }
        });
        ComboPizzaSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPizzaSelecActionPerformed(evt);
            }
        });

        jLabel11.setText("Precio");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboPizzaSelec, 0, 130, Short.MAX_VALUE)
                                    .addComponent(labelPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel10))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(ComboPizzaSelec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ORDENES", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void ComboSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboSucActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtNombre.getText().isEmpty() ||txtPrecio.getText().isEmpty() ||txtDesc.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Completa los campos");
        }else{
        CrearPizza();
        limpiarAdmon();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboPizzaSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPizzaSelecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPizzaSelecActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void ComboPizzaSelecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboPizzaSelecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPizzaSelecMouseClicked

    private void ComboSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboSucursalMouseClicked
           
             listaPizzas();     
    }//GEN-LAST:event_ComboSucursalMouseClicked

    private void ComboSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboSucursalActionPerformed

    private void ComboSucursalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboSucursalItemStateChanged
       listaPizzas();
    }//GEN-LAST:event_ComboSucursalItemStateChanged

    private void ComboPizzaSelecItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboPizzaSelecItemStateChanged

        precioDescripcion();
    }//GEN-LAST:event_ComboPizzaSelecItemStateChanged

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        if(labelDescripcion.getText().isEmpty() || labelPrecio.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"Selecciona una sucursal o pizza");
        }else{
        ordenar();
        limpiarOrden();
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void ComboSucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboSucItemStateChanged
     //listadoSucursal();
     SucursalPizzas();
    }//GEN-LAST:event_ComboSucItemStateChanged

    private void ComboSucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboSucMouseClicked
        //listadoSucursal();
        SucursalPizzas();
    }//GEN-LAST:event_ComboSucMouseClicked

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
            java.util.logging.Logger.getLogger(appDormimosPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appDormimosPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appDormimosPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appDormimosPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appDormimosPizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboPizzaSelec;
    private javax.swing.JComboBox<String> ComboSuc;
    private javax.swing.JComboBox<String> ComboSucursal;
    private javax.swing.JTable TablaLIstaPizza;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JTable tablaOrdenes;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
