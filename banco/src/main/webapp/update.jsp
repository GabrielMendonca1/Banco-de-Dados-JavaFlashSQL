<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Atualizar Dados</title>
</head>
<body>
<h2>Atualizar Cadastro:</h2>
    <form action="UpdateServlet" method="post">
        Nome: <input type="text" name="nome" value="${user.nome}" required/><br/>
        Email: <input type="email" name="email" value="${user.email}" required/><br/>
          Senha: <input type="text" name="senha" value="${user.senha}" required/><br/>
        <input type="submit" value="Atualizar"/>
    </form>
</body>
</html>
    