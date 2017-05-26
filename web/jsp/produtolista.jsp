<%-- 
    Document   : produtolista
    Created on : 17/05/2017, 12:12:06
    Author     : Elton
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Produto"%>
<%@page import="dao.ProdutoImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<jsp:include page="/cabecalho.html" />


<table class="table table-striped table-bordered">
<%
                    
                    List<Produto> list = new ProdutoImpl().getListAll();
                    for(Produto c : list){
%>
	<tr>
                <td><%= c.getNome()%></td>
		<td><%= c.getPreco()%></td>
                <td><%= c.getId()%></td>
		<td>
			<form action="/MercadoAcre/servlet/ProdutoServlet" method="post">
				<input type="hidden" name="id" value="<%= c.getId()%>" >
				<button class="btn btn-danger">Editar</button>
				<input type="hidden" name="cmd" value="editar">
			</form>
		</td>
		<td>
			<form action="/MercadoAcre/servlet/ProdutoServlet" method="post">
				<input type="hidden" name="id" value="<%= c.getId() %>">
				<button class="btn btn-danger">Excluir</button>
				<input type="hidden" name="cmd" value="excluir">
			</form>
		</td>

	</tr>	
	<%	
		}
	%>
</table>
<jsp:include page="/rodape.html" />