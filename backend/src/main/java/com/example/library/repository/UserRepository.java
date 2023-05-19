package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.User;
import com.example.library.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    public void createUser(User user) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO users(created_at, updated_at, first_name, last_name, email, password, phone, city, street, postal_code, role_id) " +
                    "VALUES (NOW()::timestamptz, NOW()::timestamptz, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setUserFields(statement, user);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM users";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getTimestamp("deleted_at"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("postal_code"),
                        resultSet.getInt("role_id")
                );
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User findById(int id) {
        User user = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getInt("id"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getTimestamp("deleted_at"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getInt("postal_code"),
                        resultSet.getInt("role_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void updateUser(int id, User user) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE users " +
                    "SET updated_at = NOW()::timestamptz," +
                    "first_name = COALESCE(?, first_name), " +
                    "last_name = COALESCE(?, last_name), " +
                    "email = COALESCE(?, email), " +
                    "password = COALESCE(?, password), " +
                    "phone = COALESCE(?, phone), " +
                    "city = COALESCE(?, city), " +
                    "street = COALESCE(?, street), " +
                    "postal_code = COALESCE(?, postal_code), " +
                    "role_id = COALESCE(?, role_id) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setUserFields(statement, user);
            filledStatement.setInt(10, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setUserFields(PreparedStatement statement, User user) {
        try {
            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getCity());
            statement.setString(7, user.getStreet());
            statement.setInt(8, user.getPostal_code());
            statement.setInt(9, user.getRole_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
