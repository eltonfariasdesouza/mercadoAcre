
<%--


    Document   : listjsp
    Created on : 09/05/2017, 16:59:47
    Author     : Elton
--%>

<%@page import="modelo.Produto"%>
<%@page import="dao.ProdutoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
    <head>
       
        <title>Lista de </title>
    </head>
    <body>
        <%@include file="../index.html" %>
        <h1>Produto</h1>
        <div>
            <table>
                <tr>
                    <td>ID</td>
                    <td>NOME</td>                    
                </tr>
                <%
                    
                    List<Produto> list = new ProdutoImpl().getListAll();
                    for(Produto c : list){
                        %>
                        <tr>
                            <td><%= c.getId() %></td>
                            <td><%= c.getNome()%></td>
                            
                            <td><a href="Alterarproduto.jsp?id=<%= c.getId()%>">editar</a></td>
                        </tr>
                        <%
                    }
                %>
            </table>
            <a href="/MercadoAcre/index.html">Inicio</a>
        </div>
    </body>

</html>
