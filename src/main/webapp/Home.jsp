<%-- 
    Document   : Home
    Created on : 07-25-2020, 02:35:25 PM
    Author     : enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="usuarioModel" scope="session" class="com.model.UsuarioModel" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido
            <jsp:getProperty name="usuarioModel" property="nombre" />
        </h1>
        <p>Has ingresado correctamente y te has logueado de buena manera</p>
    </body>
</html>
