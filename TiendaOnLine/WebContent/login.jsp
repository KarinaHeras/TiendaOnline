<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<% //Cuando se cargue por segunda vez o siguientes
if(request.getParameter("password")!=null){
%>
<jsp:useBean id="clienteLogin" scope="request" class="app.modelo.Cliente"/>
<jsp:setProperty property="*" name="clienteLogin"/>
<jsp:forward page="servletverificar"/>
<%
}%>
<h1>Login</h1>
<form action="login.jsp" method="post">
	Correo electronico: <input  type="email" name="email"/><br/>
	Password: <input type="password" name="password"/>
	<input type="submit" value="Iniciar Sesion"/>
</form>

</body>
</html>