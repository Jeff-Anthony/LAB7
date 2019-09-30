
<%@page import="java.sql.*"%>
<%@page import="modelo.clases"%>
<html>
    <head><title>Empresa Llanos - Consulta de Productos</title></head>
    <body>
        <h1>Empresa Llanos - Consulta de Productos</h1>
        
        
       
        
        <%
        
        clases m = new clases();
        
        ResultSet datos=m.consulta_articulos("select * from articulos");
        
        %>
        <table border="1" cellspacing="5" cellpadding="5">
            <td>ID</td>               
            <td>Nombre</td>              
            <td>Stock</td>             
            <td>Precio</td>     
        <%
        while(datos.next()){%>
        <tr>
            <%for(int i=1; i<=4;i++){%>
                <td><%=datos.getString(i)%></td>          
            <%}%>
        </tr> 
        <%} m.cerrar();%>
        </table>
          <a href="index.jsp">Menu Principal</a>
    </body>
</html>
