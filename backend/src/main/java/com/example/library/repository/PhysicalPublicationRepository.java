package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.PhysicalPublication;
import com.example.library.entity.PhysicalPublication;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PhysicalPublicationRepository {

    public void createPhysicalPublication(PhysicalPublication physical_publication) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO physical_publications(floor_number, section_number, shelf_number, publication_id) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPhysicalPublicationFields(statement, physical_publication);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PhysicalPublication> getPhysicalPublications() {
        List<PhysicalPublication> physical_publications = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM physical_publications";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PhysicalPublication physical_publication = new PhysicalPublication(
                        resultSet.getInt("id"),
                        resultSet.getInt("floor_number"),
                        resultSet.getInt("section_number"),
                        resultSet.getInt("shelf_number"),
                        resultSet.getInt("publication_id")
                );
                physical_publications.add(physical_publication);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return physical_publications;
    }

    public PhysicalPublication findById(int id) {
        PhysicalPublication physical_publication = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM physical_publications WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                physical_publication = new PhysicalPublication(
                        resultSet.getInt("id"),
                        resultSet.getInt("floor_number"),
                        resultSet.getInt("section_number"),
                        resultSet.getInt("shelf_number"),
                        resultSet.getInt("publication_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return physical_publication;
    }

    public void updatePhysicalPublication(int id, PhysicalPublication physical_publication) {
        try (Connection connection = DatabaseManager.getConnection()) {

            String query = "UPDATE physical_publications " +
                    "SET floor_number = COALESCE(?, floor_number)," +
                    "section_number = COALESCE(?, section_number)," +
                    "shelf_number = COALESCE(?, shelf_number)," +
                    "publication_id = COALESCE(?, publication_id) " +
                    "WHERE id = ?";


            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPhysicalPublicationFields(statement, physical_publication);
            filledStatement.setInt(5, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setPhysicalPublicationFields(PreparedStatement statement, PhysicalPublication physical_publication) {
        try {
            statement.setInt(1, physical_publication.getFloor_number());
            statement.setInt(2, physical_publication.getSection_number());
            statement.setInt(3, physical_publication.getShelf_number());
            statement.setInt(4, physical_publication.getPublication_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
