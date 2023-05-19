package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.PhysicalBook;
import com.example.library.entity.PhysicalBook;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PhysicalBookRepository {

    public void createPhysicalBook(PhysicalBook physical_book) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO physical_books(physical_publication_id, book_origin_id, page_number) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPhysicalBookFields(statement, physical_book);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PhysicalBook> getPhysicalBooks() {
        List<PhysicalBook> physical_books = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM physical_books";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PhysicalBook physical_book = new PhysicalBook(
                        resultSet.getInt("id"),
                        resultSet.getInt("physical_publication_id"),
                        resultSet.getInt("book_origin_id"),
                        resultSet.getInt("page_number")
                );
                physical_books.add(physical_book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return physical_books;
    }

    public PhysicalBook findById(int id) {
        PhysicalBook physical_book = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from physical_books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                physical_book = new PhysicalBook(
                        resultSet.getInt("id"),
                        resultSet.getInt("physical_publication_id"),
                        resultSet.getInt("book_origin_id"),
                        resultSet.getInt("page_number")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return physical_book;
    }

    public void updatePhysicalBook(int id, PhysicalBook physical_book) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE physical_books " +
                    "SET physical_publication_id  = COALESCE(?, physical_publication_id )," +
                    "book_origin_id  = COALESCE(?, book_origin_id ), " +
                    "page_number   = COALESCE(?, page_number  ), " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPhysicalBookFields(statement, physical_book);
            filledStatement.setInt(4, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setPhysicalBookFields(PreparedStatement statement, PhysicalBook physical_book) {
        try {
            statement.setInt(1, physical_book.getPhysical_publication_id());
            statement.setInt(2, physical_book.getBook_origin_id());
            statement.setInt(3, physical_book.getPage_number());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
