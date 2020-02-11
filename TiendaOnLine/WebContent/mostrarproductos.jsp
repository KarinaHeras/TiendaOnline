<%@page import="app.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Productos</title>
</head>
<body>
<%-- Recuperar la lista de productos --%>
	<% List<Producto> lista = (List) request.getAttribute("p"); %>
	
	<table border="1" align="center">
	    <!-- Fila de encabezados -->
		<tr>
			<th>ID</th>
			<th>Descripcion</th>
			<th>Precio</th>
			<th>Comprar</th>
		</tr>
		
		<!-- Filas de datos -->
		<% for(Producto producto : lista){ %>
			<tr>
				<td> <%= producto.getIdProducto() %> </td>
				<td> <%= producto.getNombre() %> </td>
				<td> <%= producto.getPrecio() %> </td>
				<td>
					<a href="servlettienda?op=6&id=<%= producto.getIdProducto() %>">
						<img src="img/carrito.png" width="50" height="50" />
					</a>
				</td>
			</tr>
	    <% } %>
	</table>

</body>
</html>