package web;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.*;

public class UpdateFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // private UserDao userDao = new UserDao(); // remover essa linha

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        request.setAttribute("user", user);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}

