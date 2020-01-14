
package gestion_base_de_datos;
import java.sql.*;

/**
 *
 * @author alex
 */
public class Gestion_base_de_Datos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbempresa", "root","alex");
            Statement stmt=con.createStatement();
            //ResultSet rs= stmt.executeQuery("select * from empleado");  
             //       while(rs.next())  
              //  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            new interfaz_principal().setVisible(true);
                //con.close();  
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
