
package controlador;
import java.sql.*;
import javax.swing.JOptionPane;
public class libreria {
    
    public Connection conex;
    public String driver="com.mysql.jdbc.Driver";
    public String cadena="jdbc:mysql://localhost/semana7";
    public String usuario="root";
    public String clave="";
    public Connection obtener_Conexion(){
    
        try{
        
            Class.forName(driver);
            conex=DriverManager.getConnection(cadena, usuario, clave);
           
        
        }catch(ClassNotFoundException e){
         
          JOptionPane.showMessageDialog(null, "Error en el Driver");
            
        }catch(SQLException e2){
             JOptionPane.showMessageDialog(null, "Error en la Conexion");
        }
        return conex;
    
    }
    
    
}
