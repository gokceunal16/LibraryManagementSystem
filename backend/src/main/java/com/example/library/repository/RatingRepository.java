package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Rating;
import com.example.library.entity.Rating;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RatingRepository {

    public void createRating(Rating rating) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO ratings(user_id, publication_id, score, date) " +
                    "VALUES (?, ?, ?, NOW()::date)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rating.getUser_id());
            statement.setInt(2, rating.getPublication_id());
            statement.setInt(3, rating.getScore());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rating> getRatings() {
        List<Rating> ratings = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM ratings";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Rating rating = new Rating(resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id"),
                        resultSet.getInt("score"),
                        resultSet.getTimestamp("date")
                );
                ratings.add(rating);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ratings;
    }

    public Rating find(int user_id, int publication_id) {
        Rating rating = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from ratings WHERE user_id = ? AND publication_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, user_id);
            statement.setInt(2, publication_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                rating = new Rating(resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id"),
                        resultSet.getInt("score"),
                        resultSet.getTimestamp("date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rating;
    }

    public void updateRating(int userId, int publicationId, Rating rating) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE ratings " +
                    "SET score  = COALESCE(?, score )," +
                    "date  = NOW()::date " +
                    "WHERE user_id = ? AND publication_id = ?";


            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, rating.getScore());
            statement.setInt(2, userId);
            statement.setInt(3, publicationId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRating(int userId, int publicationId) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "DELETE FROM ratings " +
                    "WHERE user_id = ? AND publication_id = ?";


            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setInt(2, publicationId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
