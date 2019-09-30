
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.Usuario_DAO;


public class Controlador extends HttpServlet {
    
    Usuario_DAO dao= new Usuario_DAO();
    Usuario p=new Usuario();
    int r;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    String accion=request.getParameter("accion");
    if(accion.equals("Ingresar")){
    
        String usu=request.getParameter("txtUsuario");
        String pass=request.getParameter("txtPassword");
        p.setUsuario(usu);
        p.setPassword(pass);
        r=dao.validar(p);
        if(r==1){
            request.getSession().setAttribute("usu",usu);
            request.getSession().setAttribute("pass",pass);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
        }
    }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
