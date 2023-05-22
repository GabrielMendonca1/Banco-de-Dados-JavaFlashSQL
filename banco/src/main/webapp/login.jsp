<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login:</h2>
    <form action="LoginServlet" method="post">
        Login: <input type="text" name="login" required/><br/>
        Senha: <input type="password" name="senha" required/><br/>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
    