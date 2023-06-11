package com.example.library.repository;

import com.example.library.entity.EBook;
import com.example.library.entity.Room;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DashboardRepository {

    public int getAudioBookCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM audio_books";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getEBookCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM e_books";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getPhysicalBookCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM physical_books";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getNewspaperCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM newspapers";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getMaterialCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM materials";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getRoomCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM rooms";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getPublicationCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM publications";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getBorrowedPublicationCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count FROM publications p " +
                    "INNER JOIN borrowings b ON p.id = b.publication_id AND b.return_date is null;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }


    @Data
    public static class PublicationScore {
        int publication_id;
        String title;
        float average_score;

        public PublicationScore(int publication_id, String title, float average_score) {
            this.publication_id = publication_id;
            this.title = title;
            this.average_score = average_score;
        }
    }

    public List<PublicationScore> getHighestRatedPublications() {
        List<PublicationScore> list = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT p.id as publication_id, p.title as publication_title, AVG(r.score) as average_score " +
                    "FROM publications p " +
                    "    INNER JOIN ratings r on p.id = r.publication_id " +
                    "GROUP BY p.id, p.title " +
                    "ORDER BY average_score DESC, p.title " +
                    "LIMIT 5;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PublicationScore ps = new PublicationScore(
                        resultSet.getInt("publication_id"),
                        resultSet.getString("publication_title"),
                        resultSet.getFloat("average_score")
                );
                list.add(ps);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public  List<PublicationScore> getHighestRatedPublicationsInLastThreeMonths() {
        List<PublicationScore> list = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT p.id as publication_id, p.title as publication_title, AVG(r.score) as average_score " +
                    "FROM publications p " +
                    "    INNER JOIN ratings r on p.id = r.publication_id  AND p.publish_date >= CURRENT_DATE - INTERVAL '3 months' " +
                    "GROUP BY p.id, p.title " +
                    "ORDER BY average_score DESC, p.title " +
                    "LIMIT 5;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PublicationScore ps = new PublicationScore(
                        resultSet.getInt("publication_id"),
                        resultSet.getString("publication_title"),
                        resultSet.getFloat("average_score")
                );
                list.add(ps);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
