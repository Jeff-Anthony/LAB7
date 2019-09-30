
package modelo;
import controlador.libreria;
import java.sql.*;
public class Usuario_DAO implements Validacion{

    Connection con;
    libreria lib= new libreria();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    @Override
    public int validar(Usuario per) {
        int r=0;
        String sql="select * from usuarios where usuario=? and password=?";
        try{
            con = lib.obtener_Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,per.getUsuario());
            ps.setString(2,per.getPassword());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setUsuario(rs.getString("usuario"));
                per.setPassword(rs.getString("password"));
            }
            if(r==1){          
                return 1;
            }else{
                return 0;
            }
        }catch(Exception e){
            return 0;
        }  
    }
    
    
    
}
