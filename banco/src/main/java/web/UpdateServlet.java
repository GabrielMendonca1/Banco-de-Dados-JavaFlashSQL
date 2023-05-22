package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.http.*;

public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        user.setNome(nome);
        user.setEmail(email);

        try {
            userDao.update(user); // Aqui está ocorrendo a chamada que pode lançar SQLException
            session.setAttribute("user", user);
            response.sendRedirect("dashboard.jsp");
        } catch(SQLException e) {
            // Aqui você pode tratar o erro como preferir, por exemplo logar o erro:
            e.printStackTrace();
            // E/ou redirecionar para uma página de erro
            response.sendRedirect("error.jsp");
        }
    }
}
