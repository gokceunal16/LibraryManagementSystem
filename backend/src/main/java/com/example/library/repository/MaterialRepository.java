package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Material;
import com.example.library.entity.Material;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MaterialRepository {

    public void createMaterial(Material material) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO materials(physical_publication_id, format) " +
                    "VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setMaterialFields(statement, material);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Material> getMaterials() {
        List<Material> materials = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM materials";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Material material = new Material(
                        resultSet.getInt("id"),
                        resultSet.getInt("physical_publication_id"),
                        resultSet.getString("format")
                );
                materials.add(material);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materials;
    }

    public Material findById(int id) {
        Material material = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from materials WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                material = new Material(
                        resultSet.getInt("id"),
                        resultSet.getInt("physical_publication_id"),
                        resultSet.getString("format")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return material;
    }

    public void updateMaterial(int id, Material material) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE materials " +
                    "SET physical_publication_id  = COALESCE(?, physical_publication_id )," +
                    "format  = COALESCE(?, format ) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setMaterialFields(statement, material);
            filledStatement.setInt(3, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setMaterialFields(PreparedStatement statement, Material material) {
        try {
            statement.setInt(1, material.getPhysical_publication_id());
            statement.setString(2, material.getFormat());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
