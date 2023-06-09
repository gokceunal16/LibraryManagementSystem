package com.example.library.repository;

import com.example.library.entity.EBook;
import com.example.library.entity.Room;
import lombok.AllArgsConstructor;
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
    @AllArgsConstructor
    public static class PublicationScore {
        int publication_id;
        String title;
        float average_score;
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

    public int getAvailablePublicationCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT COUNT(*) as count " +
                    "FROM publications p " +
                    "WHERE NOT EXISTS ( " +
                    "        SELECT " +
                    "        FROM borrowings b " +
                    "        WHERE b.publication_id = p.id " +
                    "          AND b.return_date is null " +
                    "    );";
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

    public int getAvailableNewspaperCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "WITH np AS (SELECT * " +
                    "    FROM newspapers " +
                    "        INNER JOIN physical_publications ON newspapers.physical_publication_id = physical_publications.id " +
                    "        INNER JOIN publications ON physical_publications.publication_id = publications.id) " +
                    "SELECT COUNT(*) as count FROM " +
                    "np WHERE NOT EXISTS ( " +
                    "    SELECT " +
                    "    FROM borrowings b " +
                    "    WHERE b.publication_id = np.publication_id " +
                    "    AND b.return_date is null " +
                    "    )";
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

    public int getAvailablePhysicalBookCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "WITH np AS (SELECT * " +
                    "       FROM physical_books " +
                    "        INNER JOIN physical_publications ON physical_books.physical_publication_id = physical_publications.id " +
                    "        INNER JOIN publications ON physical_publications.publication_id = publications.id) " +
                    "SELECT COUNT(*) as count FROM " +
                    "np WHERE NOT EXISTS ( " +
                    "    SELECT " +
                    "    FROM borrowings b " +
                    "    WHERE b.publication_id = np.publication_id " +
                    "    AND b.return_date is null " +
                    "    )";
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

    public int getAvailableMaterialCount() {
        int count = 0;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "WITH np AS (SELECT * " +
                    "    FROM   materials " +
                    "        INNER JOIN physical_publications ON materials.physical_publication_id = physical_publications.id " +
                    "        INNER JOIN publications ON physical_publications.publication_id = publications.id) " +
                    "SELECT COUNT(*) as count FROM " +
                    "np WHERE NOT EXISTS ( " +
                    "    SELECT " +
                    "    FROM borrowings b " +
                    "    WHERE b.publication_id = np.publication_id " +
                    "    AND b.return_date is null " +
                    "    )";
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
    @AllArgsConstructor
    public static class RoomName {
        private String name;
    }


    public List<Object> getAvailableRooms() {
        List<Object> list = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT name " +
                    "FROM rooms " +
                    "WHERE NOT EXISTS ( " +
                    "    SELECT " +
                    "    FROM reservations " +
                    "    INNER JOIN time_slots ts on reservations.time_slot_id = ts.id " +
                    "    WHERE reservations.room_id = rooms.id " +
                    "    AND (reservations.date::timestamp + ts.end_time::time) > NOW() " +
                    "    ) ORDER BY name ";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RoomName r = new RoomName(
                        resultSet.getString("name")
                );
                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}
