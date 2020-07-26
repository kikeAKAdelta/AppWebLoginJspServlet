<%-- 
    Document   : LoginErrorAdmin
    Created on : 07-26-2020, 11:26:23 AM
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
        <h1>Login</h1>
        <p>Has tenido un error en tu logeo, vuelve a intentarlo por favor</p>
        <form name="user" action="j_security_check" method="POST">
            
            <input type="text" name="j_username" value="" placeholder="Ingrese nombre"/><br><br>
            <input type="text" name="j_password" value="" placeholder="Ingrese password" /><br><br>
            
            <input type="submit" value="Login" name="j_submit" />
            
        </form>
    </body>
</html>
