package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.ElectronicPublication;
import com.example.library.entity.ElectronicPublication;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ElectronicPublicationRepository {

    public void createElectronicPublication(ElectronicPublication electronic_publication) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO electronic_publications(link, size, publication_id) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setElectronicPublicationFields(statement, electronic_publication);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ElectronicPublication> getElectronicPublications() {
        List<ElectronicPublication> electronic_publications = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM electronic_publications";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ElectronicPublication electronic_publication = new ElectronicPublication(
                        resultSet.getInt("id"),
                        resultSet.getString("link"),
                        resultSet.getInt("size"),
                        resultSet.getInt("publication_id")
                );
                electronic_publications.add(electronic_publication);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return electronic_publications;
    }

    public ElectronicPublication findById(int id) {
        ElectronicPublication electronic_publication = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from electronic_publications WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                electronic_publication = new ElectronicPublication(
                        resultSet.getInt("id"),
                        resultSet.getString("link"),
                        resultSet.getInt("size"),
                        resultSet.getInt("publication_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return electronic_publication;
    }

    public void updateElectronicPublication(int id, ElectronicPublication electronic_publication) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE electronic_publications " +
                    "SET link  = COALESCE(?, link )," +
                    "size   = COALESCE(?, size  )," +
                    "publication_id  = COALESCE(?, publication_id ) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setElectronicPublicationFields(statement, electronic_publication);
            filledStatement.setInt(4, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setElectronicPublicationFields(PreparedStatement statement, ElectronicPublication electronic_publication) {
        try {
            statement.setString(1, electronic_publication.getLink());
            statement.setInt(2, electronic_publication.getSize());
            statement.setInt(3, electronic_publication.getPublication_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
