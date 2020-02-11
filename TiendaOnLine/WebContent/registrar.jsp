<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%   //Este if se quiere que se ejecute la segunda vez que se carga la página
     //La primera vez que se carga la página muestra el formulario para ser rellenado
     //por el usuario.
     if(request.getParameter("password")!=null)
     {
%>
<jsp:useBean id="c1" scope="request" class="app.modelo.Cliente"/>
<jsp:setProperty property="*" name="c1"/>
<jsp:forward page="servletcliente"/>

<%} %>
<h1>Formulario para registrarse</h1>
<form action="registrar.jsp" method="post">
Nombre: <input type="text" name="nombre" /> <br/>
Email: <input type="email" name="email" /> <br/>
Direccion: <input type="text" name="direccion" /> <br/>
Password: <input type="password" name="password" /> <br/>
<input type="submit" value="Registrarse">
</form>

</body>
</html>