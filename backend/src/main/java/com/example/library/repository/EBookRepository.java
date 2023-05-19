package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.EBook;
import com.example.library.entity.EBook;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EBookRepository {

    public void createEBook(EBook e_book) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO ebooks(electronic_publication_id, book_origin_id) " +
                    "VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setEBookFields(statement, e_book);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EBook> getEBooks() {
        List<EBook> e_books = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM e_books";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                EBook e_book = new EBook(
                        resultSet.getInt("id"),
                        resultSet.getInt("electronic_publication_id"),
                        resultSet.getInt("book_origin_id")
                );
                e_books.add(e_book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return e_books;
    }

    public EBook findById(int id) {
        EBook e_book = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from e_books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                e_book = new EBook(
                        resultSet.getInt("id"),
                        resultSet.getInt("electronic_publication_id"),
                        resultSet.getInt("book_origin_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return e_book;
    }

    public void updateEBook(int id, EBook e_book) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE e_books " +
                    "SET electronic_publication_id  = COALESCE(?, electronic_publication_id )," +
                    "book_origin_id  = COALESCE(?, book_origin_id ) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setEBookFields(statement, e_book);
            filledStatement.setInt(3, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setEBookFields(PreparedStatement statement, EBook e_book) {
        try {
            statement.setInt(1, e_book.getElectronic_publication_id());
            statement.setInt(2, e_book.getBook_origin_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
