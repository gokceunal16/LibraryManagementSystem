package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Language;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LanguageRepository {

    public void createLanguage(Language language) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO languages(name) " +
                    "VALUES (?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, language.getName());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Language> getLanguages() {
        List<Language> languages = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM languages";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Language language = new Language(resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                languages.add(language);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return languages;
    }

    public Language findById(int id) {
        Language language = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from languages WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                language = new Language(resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return language;
    }

    public void updateLanguage(int id, Language language) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE languages SET name = COALESCE(?, name) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, language.getName());
            statement.setInt(2, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
