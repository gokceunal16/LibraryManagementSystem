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

    public void createBookOrigin(BookOrigin book_origin) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO book_origins(author_id, name) " +
                    "VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setBookOriginFields(statement, book_origin);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BookOrigin> getBookOrigins() {
        List<BookOrigin> BookOrigins = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM book_origins";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BookOrigin book_origin = new BookOrigin(resultSet.getInt("id"),
                        resultSet.getInt("author_id"),
                        resultSet.getString("name")
                );
                BookOrigins.add(book_origin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return BookOrigins;
    }

    public BookOrigin findById(int id) {
        BookOrigin book_origin = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from book_origins WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                book_origin = new BookOrigin(resultSet.getInt("id"),
                        resultSet.getInt("author_id"),
                        resultSet.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book_origin;
    }

    public void updateBookOrigin(int id, BookOrigin book_origin) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE book_origins " +
                    "SET author_id = COALESCE(?, author_id)," +
                    "name = COALESCE(?, name) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setBookOriginFields(statement, book_origin);
            filledStatement.setInt(3, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setBookOriginFields(PreparedStatement statement, BookOrigin book_origin) {
        try {
            statement.setInt(1, book_origin.getAuthor_id());
            statement.setString(2, book_origin.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
