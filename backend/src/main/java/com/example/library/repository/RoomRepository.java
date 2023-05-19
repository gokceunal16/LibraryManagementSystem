package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Room;
import com.example.library.entity.Room;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {

    public void createRoom(Room room) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO rooms(name, capacity, location) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setRoomFields(statement, room);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM rooms";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Room room = new Room(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("capacity"),
                        resultSet.getString("location")
                );
                rooms.add(room);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public Room findById(int id) {
        Room room = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from rooms WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                room = new Room(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("capacity"),
                        resultSet.getString("location")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }

    public void updateRoom(int id, Room room) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE rooms " +
                    "SET name = COALESCE(?, name), " +
                    "capacity = COALESCE(?, capacity), " +
                    "location = COALESCE(?, location), " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setRoomFields(statement, room);
            filledStatement.setInt(4, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setRoomFields(PreparedStatement statement, Room room) {
        try {
            statement.setString(1, room.getName());
            statement.setInt(2, room.getCapacity());
            statement.setString(3, room.getLocation());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
