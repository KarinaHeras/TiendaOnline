<%@page import="app.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@page import="app.negocio.Carrito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar carrito</title>
</head>
<body>
<h1>Su carrito contiene...</h1>
<%-- Recuperar la lista de productos --%>
	<%  Carrito carro = (Carrito) session.getAttribute("MiCarro");
		List<Producto> lista = carro.getContenido(); %>
		
	<h2>Importe: <%= carro.getImporte() %></h2>		
	
	
	<table border="1" align="center">
	    <!-- Fila de encabezados -->
		<tr>
			<th>ID</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th>Eliminar</th>
		</tr>
		
		<!-- Filas de datos -->
		<% for(Producto producto : lista){ %>
			<tr>
				<td> <%= producto.getIdProducto() %> </td>
				<td> <%= producto.getNombre() %> </td>
				<td> <%= producto.getPrecio() %> </td>
				<td>
					<a href="servlettienda?op=7&id=<%= producto.getIdProducto() %>">
						<img src="img/eliminar.jpeg" width="50" height="50" />
					</a>
				</td>
			</tr>
	    <% } %>
	</table>
    <a href="index.jsp">Comprar más</a> <br/>
    <a href="pagar.jsp">Pagar</a>
</body>
</html>