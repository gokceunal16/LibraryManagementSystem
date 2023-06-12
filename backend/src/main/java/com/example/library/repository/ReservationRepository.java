package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Reservation;
import com.example.library.entity.Reservation;
import lombok.Data;
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
                    "VALUES (NOW()::timestamptz, NOW()::timestamptz, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setReservationFields(statement, reservation);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Data
    public static class ReservationDto {
        private int id;
        private Timestamp created_at;
        private Timestamp updated_at;
        private Timestamp deleted_at;
        private int user_id;
        private int time_slot_id;
        private int room_id;
        private Date date;
        private Time start_time;
        private Time end_time;
        private String room_name;


        public ReservationDto(int id, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at, int user_id, int time_slot_id, int room_id, Date date, Time start_time, Time end_time, String room_name) {
            this.id = id;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.deleted_at = deleted_at;
            this.user_id = user_id;
            this.time_slot_id = time_slot_id;
            this.room_id = room_id;
            this.date = date;
            this.start_time = start_time;
            this.end_time = end_time;
            this.room_name = room_name;
        }
    }

    public List<Object> getReservations() {
        String query = "SELECT re.*, ts.start_time, ts.end_time, ro.name as room_name FROM reservations re " +
                "INNER JOIN time_slots ts on re.time_slot_id = ts.id " +
                "INNER JOIN rooms ro on ro.id = re.room_id ";
        return getReservations(query);
    }

    public List<Object> getReservations(int user_id) {
        String query = String.format("SELECT re.*, ts.start_time, ts.end_time, ro.name as room_name FROM reservations re " +
                "INNER JOIN time_slots ts on re.time_slot_id = ts.id " +
                "INNER JOIN rooms ro on ro.id = re.room_id " +
                "WHERE re.user_id = %d ", user_id);
        return getReservations(query);
    }

    public List<Object> getReservations(String query) {
        List<Object> reservations = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ReservationDto reservation = new ReservationDto(resultSet.getInt("id"),
                        resultSet.getTimestamp("created_at"),
                        resultSet.getTimestamp("updated_at"),
                        resultSet.getTimestamp("deleted_at"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("time_slot_id"),
                        resultSet.getInt("room_id"),
                        resultSet.getDate("date"),
                        resultSet.getTime("start_time"),
                        resultSet.getTime("end_time"),
                        resultSet.getString("room_name")
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
                    "SET updated_at = NOW()::timestamptz," +
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
