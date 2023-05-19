package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Genre;
import com.example.library.entity.Genre;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GenreRepository {

    public void createGenre(Genre genre) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO genres(name, description) " +
                    "VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setGenreFields(statement, genre);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM genres";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Genre genre = new Genre(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                genres.add(genre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }

    public Genre findById(int id) {
        Genre genre = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from genres WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                genre = new Genre(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genre;
    }

    public void updateGenre(int id, Genre genre) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE genres " +
                    "SET name = COALESCE(?, name)," +
                    "description = COALESCE(?, description) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setGenreFields(statement, genre);
            filledStatement.setInt(3, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setGenreFields(PreparedStatement statement, Genre genre) {
        try {
            statement.setString(1, genre.getName());
            statement.setString(2, genre.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
