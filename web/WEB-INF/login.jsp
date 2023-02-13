<%-- 
    Document   : login
    Created on : 8-Feb-2023, 7:57:20 PM
    Author     : Mitchell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
          <p>Username:</p>
          <input type="text" name="username" value="${username}"><br>
          <p>Password:</p>
          <input type="text" name="password"><br>          
          <br>
          <input type="submit" value="Log in">
        </form>
        <p style="color:red;">${errorMessage}</p>
    </body>
</html>
