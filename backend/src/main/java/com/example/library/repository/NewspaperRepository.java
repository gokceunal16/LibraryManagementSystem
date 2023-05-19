package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Newspaper;
import com.example.library.entity.Newspaper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NewspaperRepository {

    public void createNewspaper(Newspaper newspaper) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO newspapers(physical_publication_id, publication_frequency, circulation) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setNewspaperFields(statement, newspaper);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Newspaper> getNewspapers() {
        List<Newspaper> newspapers = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM newspapers";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Newspaper newspaper = new Newspaper(
                        resultSet.getInt("id"),
                        resultSet.getInt("physical_publication_id"),
                        resultSet.getString("publication_frequency"),
                        resultSet.getString("circulation")
                );
                newspapers.add(newspaper);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newspapers;
    }

    public Newspaper findById(int id) {
        Newspaper newspaper = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from newspapers WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                newspaper = new Newspaper(
                        resultSet.getInt("id"),
                        resultSet.getInt("physical_publication_id"),
                        resultSet.getString("publication_frequency"),
                        resultSet.getString("circulation")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newspaper;
    }

    public void updateNewspaper(int id, Newspaper newspaper) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE newspapers " +
                    "SET physical_publication_id = COALESCE(?, physical_publication_id)," +
                    "publication_frequency  = COALESCE(?, publication_frequency ), " +
                    "circulation   = COALESCE(?, circulation  ) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setNewspaperFields(statement, newspaper);
            filledStatement.setInt(4, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setNewspaperFields(PreparedStatement statement, Newspaper newspaper) {
        try {
            statement.setInt(1, newspaper.getPhysical_publication_id());
            statement.setString(2, newspaper.getPublication_frequency());
            statement.setString(3, newspaper.getCirculation());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
