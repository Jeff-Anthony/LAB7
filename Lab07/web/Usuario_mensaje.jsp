
<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.clases"%>
<html>
    <head><title>Empresa Llanos - Registro de Usuario</title></head>
    <body>
        <h1>Empresa Llanos - Registro de Usuario</h1>
        
        <%
          
            String ape = request.getParameter("txtapellido");
            String nom = request.getParameter("txtnombre");
            String usu = request.getParameter("txtusuario");
            String pass = request.getParameter("txtpassword");
            
            clases m= new clases();
            if(m.insertar_usuario(ape,nom,usu,pass)==true){
            
        %>              
        <b>Usuario Registrado Correctamente</b>  
        <%}else{%>
           <b>Error al Registrar Usuario</b>          
           
       <%}%>
         <a href="index.jsp">Volver al Login</a>   
    </body>
</html>
