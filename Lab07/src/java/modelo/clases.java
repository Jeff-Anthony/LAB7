
package modelo;

import controlador.libreria;
import java.sql.*;
import javax.swing.JOptionPane;

public class clases extends libreria {
    
    PreparedStatement sen; 
   
    ResultSet data;
    
    public boolean insertar_articulos(String nombre, int stock, double precio){
    
        try{
        
            String codigosql="insert into articulos (nombre, stock, precio)values(?,?,?)";
            sen=obtener_Conexion().prepareStatement(codigosql);
          
            sen.setString(1, nombre);
            sen.setInt(2, stock);
            sen.setDouble(3, precio);
            sen.executeUpdate();
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error en el proceso");
            
        }
        return true;
    }
    
     public boolean insertar_usuario(String apellido, String nombre, String usuario,String password){
    
        try{
        
            String codigosql="insert into usuarios (apellidos,nombres,usuario,password) values(?,?,?,?)";
            sen=obtener_Conexion().prepareStatement(codigosql);
            
            sen.setString(1, apellido);
            sen.setString(2, nombre);
            sen.setString(3, usuario);
            sen.setString(4, password);
            sen.executeUpdate();
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error en el proceso");
            
        }
        return true;
    }
    
    
    
    public ResultSet consulta_articulos(String codigo){
    
        try{
            String codigosql=codigo;
            sen = obtener_Conexion().prepareStatement(codigosql);
            data = sen.executeQuery();
            
        }catch(SQLException e2){
            
            JOptionPane.showMessageDialog(null, "Error en el proceso");
        
        }
        return data;
    }
    
    public void cerrar(){
    
        try{
            data.close();
            sen.close();
            conex.close();
        }catch(SQLException e3){
        
            JOptionPane.showMessageDialog(null,"Error en el proceso");
        
        }
    
    }
    
}
