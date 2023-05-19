package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Publisher;
import com.example.library.entity.Publisher;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepository {

    public void createPublisher(Publisher publisher) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO publishers(name, local_address, city, country, phone, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";


            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPublisherFields(statement, publisher);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Publisher> getPublishers() {
        List<Publisher> publishers = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM publishers";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Publisher publisher = new Publisher(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("local_address"),
                        resultSet.getString("city"),
                        resultSet.getString("country"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                );
                publishers.add(publisher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publishers;
    }

    public Publisher findById(int id) {
        Publisher publisher = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from publishers WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                publisher = new Publisher(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("local_address"),
                        resultSet.getString("city"),
                        resultSet.getString("country"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publisher;
    }

    public void updatePublisher(int id, Publisher publisher) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE publishers " +
                    "SET name = COALESCE(?, name)," +
                    "local_address  = COALESCE(?, local_address)," +
                    "city   = COALESCE(?, city)," +
                    "country   = COALESCE(?, country)," +
                    "phone   = COALESCE(?, phone)," +
                    "email   = COALESCE(?, email ) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPublisherFields(statement, publisher);
            filledStatement.setInt(7, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setPublisherFields(PreparedStatement statement, Publisher publisher) {
        try {
            statement.setString(1, publisher.getName());
            statement.setString(2, publisher.getLocal_address());
            statement.setString(3, publisher.getCity());
            statement.setString(4, publisher.getCountry());
            statement.setString(5, publisher.getPhone());
            statement.setString(6, publisher.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
