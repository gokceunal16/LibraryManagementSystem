package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.model.Table;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DBRepository {

    public List<Table> getTables() {
        List<Table> tables = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT relname " +
                    "FROM pg_stat_all_tables " +
                    "WHERE schemaname = 'public' "; // TODO
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String tableName = resultSet.getString("relname");

                Table table = new Table(tableName);
                tables.add(table);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tables;
    }


}
