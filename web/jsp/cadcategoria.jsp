<%-- 
    Document   : newjsp
    Created on : 04/05/2017, 23:00:43
    Author     : Elton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="CadCategoria" method="post">
            Categoria: <input type="text" name="nome">
            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
