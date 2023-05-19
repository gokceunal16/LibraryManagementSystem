package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.UserRole;
import com.example.library.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRoleRepository {

    public void createUserRole(UserRole user_role) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO user_roles(name) " +
                    "VALUES (?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setUserRoleFields(statement, user_role);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserRole> getUserRoles() {
        List<UserRole> user_roles = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM user_roles";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UserRole userRole = new UserRole(resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                user_roles.add(userRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user_roles;
    }

    public UserRole findById(int id) {
        UserRole user_role = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from user_roles WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user_role = new UserRole(resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user_role;
    }

    public void updateUserRole(int id, UserRole user_role) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE user_roles " +
                    "SET name = COALESCE(?,name) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setUserRoleFields(statement, user_role);
            filledStatement.setInt(2, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setUserRoleFields(PreparedStatement statement, UserRole user_role) {
        try {
            statement.setString(1, user_role.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
