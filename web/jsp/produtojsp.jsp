<%-- 
    Document   : produtojsp
    Created on : 09/05/2017, 13:03:12
    Author     : Elton
--%>
<%@page import="modelo.Categoria"%>
<%@page import="dao.CategoriaImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>mercadoAcre</title>
	<link href="/mercadoAcre/css/bootstrap.css" rel="stylesheet">
	<link href="/mercadoAcre/css/loja.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="conteiner">
			<div class="navbar-header">
				<a class="navbar-brand" href="/mercadoAcre/index.jsp">mercadoAcre</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li><a href="/mercadoAcre/jsp/produtojsp.jsp">Adiciona Produto</a></li>
					<li><a href="/mercadoAcre/jsp/produtolista.jsp">Lista Produtos</a></li>
				</ul>
			</div>
		</div>
	</div>	

	<div class="container">
		<div class="principal">
	<h1>Formulario de produto</h1>
	<form action="/mercadoAcre/servlet/ProdutoServlet" method="post">
		<table class="table">
			<tr>
				<td>Nome</td>
				<td><input class="form-control" type="text" name="nome"></td>
			</tr>
			<tr>
				<td>Preco</td>
				<td><input class="form-control" type="number" name="preco"></td>
			</tr>
			<tr>
				<td>Descrição</td>
				<td><textarea class="form-control" name="descricao"></textarea></td>
			</tr>
			<tr>
				<td>Categoria</td>
		<%        
                    List<Categoria> list = new CategoriaImpl().getListAll();
                    for(Categoria c : list){
                %>
                        <tr>
                            <td>&nbsp;&nbsp</td>
                            <td>
			        <input type="radio" name="categoria_id"
						value="<%= c.getId()%>">
						<%= c.getNome()%><br/>
                            </td>
			</tr>
                <%
                    }
                %>        
			<tr>
				<td>
                                    <input type="hidden" name="cmd" value="salvar">
                                    <button class="btn btn-primary" type="submit">cadastrar</button>
				</td>
			</tr>
		</table>
	</form>	
		</div>	
	</div>
</body>
</html>
