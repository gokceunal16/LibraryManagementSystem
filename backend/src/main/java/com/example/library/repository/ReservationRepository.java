package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Reservation;
import com.example.library.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    public void createReservation(Reservation reservation) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO reservations(created_at, updated_at, user_id, time_slot_id, room_id, date) " +
                    "VALUES (NOW(), NOW(), ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setReservationFields(statement, reservation);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM reservations";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation(resultSet.getInt("id"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getTimestamp("deleted_at"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("time_slot_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getDate("date")
                );
                reservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public Reservation findById(int id) {
        Reservation reservation = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from reservations WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                reservation = new Reservation(resultSet.getInt("id"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getTimestamp("deleted_at"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("time_slot_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getDate("date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservation;
    }

    public void updateReservation(int id, Reservation reservation) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE reservations " +
                    "SET updated_at = NOW()," +
                    "user_id = COALESCE(?, user_id), " +
                    "time_slot_id = COALESCE(?, time_slot_id), " +
                    "room_id = COALESCE(?, room_id), " +
                    "date = COALESCE(?, date) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setReservationFields(statement, reservation);
            filledStatement.setInt(5, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setReservationFields(PreparedStatement statement, Reservation reservation) {
        try {
            statement.setInt(1, reservation.getUser_id());
            statement.setInt(2, reservation.getTime_slot_id());
            statement.setInt(3, reservation.getRoom_id());
            statement.setDate(4, reservation.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
