package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.TimeSlot;
import com.example.library.entity.TimeSlot;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TimeSlotRepository {

    public void createTimeSlot(TimeSlot time_slot) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO time_slots(start_time, end_time) " +
                    "VALUES (?, ?)";


            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setTimeSlotFields(statement, time_slot);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TimeSlot> getTimeSlots() {
        List<TimeSlot> time_slots = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM time_slots";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TimeSlot time_slot = new TimeSlot(resultSet.getInt("id"),
                        resultSet.getTime("start_time"),
                        resultSet.getTime("end_time")
                );
                time_slots.add(time_slot);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return time_slots;
    }

    public TimeSlot findById(int id) {
        TimeSlot time_slot = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from time_slots WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                time_slot = new TimeSlot(resultSet.getInt("id"),
                        resultSet.getTime("start_time"),
                        resultSet.getTime("end_time")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return time_slot;
    }

    public void updateTimeSlot(int id, TimeSlot time_slot) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE time_slots " +
                    "SET start_time = COALESCE(?, start_time), " +
                    "end_time = COALESCE(?, end_time) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setTimeSlotFields(statement, time_slot);
            filledStatement.setInt(3, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setTimeSlotFields(PreparedStatement statement, TimeSlot time_slot) {
        try {
            statement.setTime(1, time_slot.getStart_time());
            statement.setTime(2, time_slot.getEnd_time());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }
}
