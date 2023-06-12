package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Borrowing;
import com.example.library.entity.Borrowing;
import com.example.library.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BorrowingRepository {

    public void createBorrowing(Borrowing borrowing) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO borrowings(user_id, publication_id, loan_date, return_date) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setBorrowingFields(statement, borrowing);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Data
    @AllArgsConstructor
    public static class BorrowingDto {
        private int id;
        private int user_id;
        private int publication_id;
        private Timestamp loan_date;
        private Timestamp return_date;
        private String publication_title;
        private String publisher_name;
    }

    public List<Object> getBorrowings() {
        String query = "SELECT b.*, p.title as publication_title, p2.name as publisher_name FROM borrowings b " +
                "INNER JOIN publications p ON b.publication_id = p.id " +
                "INNER JOIN publishers p2 on p.publisher_id = p2.id";
        return getBorrowings(query);
    }

    public List<Object> getBorrowings(int user_id) {
        String query = String.format("SELECT b.*, p.title as publication_title, p2.name as publisher_name FROM borrowings b " +
                "INNER JOIN publications p ON b.publication_id = p.id " +
                "INNER JOIN publishers p2 on p.publisher_id = p2.id " +
                "WHERE b.user_id = %d ORDER BY loan_date DESC", user_id);
        return getBorrowings(query);
    }

    public List<Object> getBorrowings(String query) {
        List<Object> borrowings = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BorrowingDto borrowing = new BorrowingDto(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id"),
                        resultSet.getTimestamp("loan_date"),
                        resultSet.getTimestamp("return_date"),
                        resultSet.getString("publication_title"),
                        resultSet.getString("publisher_name")
                );
                borrowings.add(borrowing);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowings;
    }

    public Borrowing findById(int id) {
        Borrowing borrowing = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from borrowings WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                borrowing = new Borrowing(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id"),
                        resultSet.getTimestamp("loan_date"),
                        resultSet.getTimestamp("return_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return borrowing;
    }

    public void updateBorrowing(int id, Borrowing borrowing) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE borrowings " +
                    "SET user_id = COALESCE(?, user_id)," +
                    "publication_id = COALESCE(?, publication_id), " +
                    "loan_date = COALESCE(?, loan_date), " +
                    "return_date = COALESCE(?, return_date) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setBorrowingFields(statement, borrowing);
            filledStatement.setInt(5, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setBorrowingFields(PreparedStatement statement, Borrowing borrowing) {
        try {
            statement.setInt(1, borrowing.getUser_id());
            statement.setInt(2, borrowing.getPublication_id());
            statement.setTimestamp(3, borrowing.getLoan_date());
            statement.setTimestamp(4, borrowing.getReturn_date());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
