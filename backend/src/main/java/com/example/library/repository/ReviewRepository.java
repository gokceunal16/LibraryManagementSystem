package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Review;
import com.example.library.entity.Review;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReviewRepository {

    public void createReview(Review review) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO reviews(created_at, updated_at, user_id, publication_id, comment) " +
                    "VALUES (NOW(), NOW(), ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setReviewFields(statement, review);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM reviews";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Review review = new Review(resultSet.getInt("id"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getTimestamp("deleted_at"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id"),
                        resultSet.getString("comment")
                );
                reviews.add(review);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }

    public Review findById(int id) {
        Review review = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from reviews WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                review = new Review(resultSet.getInt("id"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getTimestamp("deleted_at"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("publication_id"),
                        resultSet.getString("comment")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return review;
    }

    public void updateReview(int id, Review review) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE reviews " +
                    "SET updated_at = NOW()," +
                    "user_id = COALESCE(?, user_id), " +
                    "publication_id = COALESCE(?, publication_id), " +
                    "comment = COALESCE(?, comment) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setReviewFields(statement, review);
            filledStatement.setInt(4, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setReviewFields(PreparedStatement statement, Review review) {
        try {
            statement.setInt(1, review.getUser_id());
            statement.setInt(2, review.getPublication_id());
            statement.setString(3, review.getComment());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
