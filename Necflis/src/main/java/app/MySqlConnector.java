package app;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Borge
 * // ConectorJavaB
 */
public class MySqlConnector{
    
    Connection con  = null;
    
    public Connection conectar(){
    //db = "jdbc:mysql://localhost/necflis";
    //user = "kevin";
     //pass = "!UW/3-KZbn4b!H(-";
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/necflis","kevin","!UW/3-KZbn4b!H(-");     
    }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error de Conexion BD");
    }
     return con; 
    } 
}
