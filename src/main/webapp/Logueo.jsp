<%-- 
    Document   : Logueo
    Created on : 02-17-2020, 02:48:25 PM
    Author     : enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido!! Por Favor Ingresa a Nuestro sistema</h1>
        
        <form name="form" action="ProcesoUsuario" method="POST">
            
            <label>Usuario:</label>
            <input type="text" name="usuario" id="usuario" placeholder="Introduce tu usuario..." /><br><br>
            
            <label>Contraseña:</label>
            <input type="password" name="usuario" id="usuario" placeholder="Introduce tu contraseña..." /><br><br>
            
            <input type="submit" value="Registrar" name="btnAceptar" />
        </form>
        
        
    </body>
</html>
