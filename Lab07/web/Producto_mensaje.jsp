
<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.clases"%>
<html>
    <head><title>Empresa Llanos - Registro de Producto</title></head>
    <body>
        <h1>Empresa Llanos - Registro de Producto</h1>
        
        <%
          
         
            String nom = request.getParameter("txtnombre");
            int sto = Integer.parseInt(request.getParameter("txtstock"));
            double pre= Double.parseDouble(request.getParameter("txtprecio"));
            
            clases m= new clases();
            if(m.insertar_articulos(nom,sto,pre)==true){
            
        %>              
        <b>Producto Insertado Correctamente</b>  
        <%}else{%>
           <b>Error al registrar el producto</b>          
           
       <%}%>
         <a href="index.jsp">Menu Principal</a>   
    </body>
</html>
