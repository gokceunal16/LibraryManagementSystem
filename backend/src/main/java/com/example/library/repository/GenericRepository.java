package com.example.library.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class GenericRepository {


    public void hardDeleteRecordById(int id, String entityName) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "DELETE FROM " + entityName + "s WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // users, reservations and reviews
    public void softDeleteRecordById(int id, String entityName) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE " + entityName + "s SET deleted_at = NOW() WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
