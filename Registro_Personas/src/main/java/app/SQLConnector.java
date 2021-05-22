/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author Kevin Borge
 */
public class SQLConnector {
    Connection con  = null;
    
    public Connection conectar(){
    //db = "jdbc:mysql://localhost/necflis";
    //user = "kevin";
     //pass = "!UW/3-KZbn4b!H(-";
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Registro_Personas","kevin","!UW/3-KZbn4b!H(-");     
    }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error de Conexion BD");
    }
     return con; 
    } 

    PreparedStatement prepareStatement(String insert_into_personasNombreApellidoDirecci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

