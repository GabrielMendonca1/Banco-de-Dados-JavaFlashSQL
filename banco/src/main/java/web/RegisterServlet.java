package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String confirmEmail = request.getParameter("confirmEmail");
        String senha = request.getParameter("senha");
        String confirmSenha = request.getParameter("confirmSenha");

        // Validações
        try {
            if (userDao.existsLogin(login)) {
                // login já existe
            }
        } catch(SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        if (!email.equals(confirmEmail)) {
            // emails não coincidem
        }

        if (!senha.equals(confirmSenha)) {
            // senhas não coincidem
        }

        if (senha.equals(login)) {
            // senha não pode ser igual ao login
        }

        // Se todas as validações passarem, crie o usuário
        User user = new User(login, senha, nome, email);
        try {
            userDao.create(user);
        } catch(SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
