package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Author;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    public void createAuthor(Author author) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO authors(first_name, last_name, date_of_birth, nationality, biography) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setAuthorFields(statement, author);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM authors";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Author author = new Author(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getString("nationality"),
                        resultSet.getString("biography")
                );
                authors.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }

    public Author findById(int id) {
        Author author = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from authors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                author = new Author(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("date_of_birth"),
                        resultSet.getString("nationality"),
                        resultSet.getString("biography")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public void updateAuthor(int id, Author author) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE authors SET first_name = COALESCE(?, first_name), " +
                    "last_name = COALESCE(?, last_name), " +
                    "date_of_birth = COALESCE(?, date_of_birth), " +
                    "nationality = COALESCE(?, nationality)," +
                    "biography = COALESCE(?, biography) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setAuthorFields(statement, author);
            filledStatement.setInt(6, id);
            filledStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setAuthorFields(PreparedStatement statement, Author author) {
        try {
            statement.setString(1, author.getFirst_name());
            statement.setString(2, author.getLast_name());
            statement.setDate(3, new java.sql.Date(Optional.ofNullable(author.getDate_of_birth())
                    .orElse(new java.util.Date(0)).getTime()) );
            statement.setString(4, author.getNationality());
            statement.setString(5, author.getBiography());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
