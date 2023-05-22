<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>Cadastro de Usuário</title>
</head>
<body>
<h2>Formulario Cadastro</h2>
    <form action="RegisterServlet" method="post">
        Login: <input type="text" name="login" required/><br/>
        Nome: <input type="text" name="nome" required/><br/>
        Email: <input type="email" name="email" required/><br/>
        Confirmar Email: <input type="email" name="confirmEmail" required/><br/>
        Senha: <input type="password" name="senha"  maxlength="8" required/><br/>
        Confirmar Senha: <input type="password" name="confirmSenha" maxlength="8" required/><br/>
        <input type="submit" value="Cadastrar"/>
    </form>
</body>
</html>
    