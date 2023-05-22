package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String URL = "jjdbc:hsqldb:hsql://localhost/banco";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void create(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USUARIO (login, senha, nome, email) VALUES (?, ?, ?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getSenha());
            statement.setString(3, user.getNome());
            statement.setString(4, user.getEmail());
            statement.executeUpdate();
        }
    }

    public User getUser(String login) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USUARIO WHERE login = LOGIN");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getString("login"), resultSet.getString("senha"), resultSet.getString("nome"), resultSet.getString("email"));
                return user;
            } else {
                return null;
            }
        }
    }

    public List<User> getAll() throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USUARIO");
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("login"), resultSet.getString("senha"), resultSet.getString("nome"), resultSet.getString("email"));
                users.add(user);
            }
            return users;
        }
    }

    public void delete(String login) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USUARIO WHERE login = ?");
            statement.setString(1, login);
            statement.executeUpdate();
        }
    }

    public void update(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE USUARIO SET senha = ?, nome = ?, email = ? WHERE login = ?");
            statement.setString(1, user.getSenha());
            statement.setString(2, user.getNome());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLogin());
            statement.executeUpdate();
        }
    }

    public boolean existsLogin(String login) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM USUARIO WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            } else {
                return false;
            }
        }
    }

    // Outros métodos aqui...
}
