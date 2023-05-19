package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.BookOrigin;
import com.example.library.entity.BookOrigin;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookOriginRepository {

    public void createBookOrigin(BookOrigin BookOrigin) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO BookOrigins(author_id, name) " +
                    "VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setBookOriginFields(statement, BookOrigin);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BookOrigin> getBookOrigins() {
        List<BookOrigin> BookOrigins = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM BookOrigins";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BookOrigin BookOrigin = new BookOrigin(resultSet.getInt("id"),
                        resultSet.getInt("author_id"),
                        resultSet.getString("name")
                );
                BookOrigins.add(BookOrigin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return BookOrigins;
    }

    public BookOrigin findById(int id) {
        BookOrigin BookOrigin = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from BookOrigins WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                BookOrigin = new BookOrigin(resultSet.getInt("id"),
                        resultSet.getInt("author_id"),
                        resultSet.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return BookOrigin;
    }

    public void updateBookOrigin(int id, BookOrigin BookOrigin) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE BookOrigins " +
                    "SET author_id = COALESCE(?, author_id)," +
                    "name = COALESCE(?, name) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setBookOriginFields(statement, BookOrigin);
            filledStatement.setInt(3, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setBookOriginFields(PreparedStatement statement, BookOrigin BookOrigin) {
        try {
            statement.setInt(1, BookOrigin.getAuthor_id());
            statement.setString(2, BookOrigin.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
