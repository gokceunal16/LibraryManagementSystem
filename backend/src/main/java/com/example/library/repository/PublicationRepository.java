package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Publication;
import com.example.library.entity.Publication;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PublicationRepository {

    public void createPublication(Publication publication) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO publications(title, genre_id, publisher_id, language_id, translator, publish_date) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPublicationFields(statement, publication);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Publication> getPublications() {
        List<Publication> publications = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM publications";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Publication publication = new Publication(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("genre_id"),
                        resultSet.getInt("publisher_id"),
                        resultSet.getInt("language_id"),
                        resultSet.getString("translator"),
                        resultSet.getDate("publish_date")
                );
                publications.add(publication);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publications;
    }

    public Publication findById(int id) {
        Publication publication = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from publications WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                publication = new Publication(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("genre_id"),
                        resultSet.getInt("publisher_id"),
                        resultSet.getInt("language_id"),
                        resultSet.getString("translator"),
                        resultSet.getDate("publish_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publication;
    }

    public void updatePublication(int id, Publication publication) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE publications " +
                    "SET title = COALESCE(?, title ), " +
                    "genre_id = COALESCE(?, genre_id ), " +
                    "publisher_id = COALESCE(?, publisher_id ), " +
                    "language_id = COALESCE(?, language_id ), " +
                    "translator =COALESCE(?, translator ), " +
                    "publish_date = COALESCE(?, publish_date ) " +
                    "WHERE id = ?";


            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPublicationFields(statement, publication);
            filledStatement.setInt(7, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setPublicationFields(PreparedStatement statement, Publication publication) {
        try {
            statement.setString(1, publication.getTitle());
            statement.setInt(2, publication.getGenre_id());
            statement.setInt(3, publication.getPublisher_id());
            statement.setInt(4, publication.getLanguage_id());
            statement.setString(5, publication.getTranslator());
            statement.setDate(6, publication.getPublish_date());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
