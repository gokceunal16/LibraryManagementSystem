package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.PublicationAvailableNotificationRequest;
import com.example.library.entity.PublicationAvailableNotificationRequest;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PublicationAvailableNotificationRequestRepository {

    public void createPublicationAvailableNotificationRequest(PublicationAvailableNotificationRequest publication_available_notification_request) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO publication_available_notification_requests(user_id, publication_id) " +
                    "VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setPublicationAvailableNotificationRequestFields(statement, publication_available_notification_request);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PublicationAvailableNotificationRequest> getPublicationAvailableNotificationRequests() {
        List<PublicationAvailableNotificationRequest> publication_available_notification_requests = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM publication_available_notification_requests";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PublicationAvailableNotificationRequest publication_available_notification_request = new PublicationAvailableNotificationRequest(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id")
                );
                publication_available_notification_requests.add(publication_available_notification_request);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publication_available_notification_requests;
    }

    public PublicationAvailableNotificationRequest find(int userId, int publicationId) {
        PublicationAvailableNotificationRequest publication_available_notification_request = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM publication_available_notification_requests WHERE user_id = ? AND publication_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setInt(2, publicationId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                publication_available_notification_request = new PublicationAvailableNotificationRequest(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publication_available_notification_request;
    }

    public void deletePublicationAvailableNotificationRequest(int user_id, int publication_id) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "DELETE FROM publication_available_notification_requests " +
                    "WHERE user_id = ? AND publication_id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, user_id);
            statement.setInt(2, publication_id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setPublicationAvailableNotificationRequestFields(PreparedStatement statement, PublicationAvailableNotificationRequest publication_available_notification_request) {
        try {
            statement.setInt(1, publication_available_notification_request.getUser_id());
            statement.setInt(2, publication_available_notification_request.getPublication_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
