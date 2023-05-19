package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.AudioBook;
import com.example.library.entity.AudioBook;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AudioBookRepository {

    public void createAudioBook(AudioBook audio_book) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "INSERT INTO audio_books(electronic_publication_id, book_origin_id, narrator, duration) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setAudioBookFields(statement, audio_book);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AudioBook> getAudioBooks() {
        List<AudioBook> audio_books = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM audio_books";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AudioBook audio_book = new AudioBook(resultSet.getInt("id"),
                        resultSet.getInt("electronic_publication_id"),
                        resultSet.getInt("book_origin_id"),
                        resultSet.getString("narrator"),
                        resultSet.getInt("duration")
                );
                audio_books.add(audio_book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return audio_books;
    }

    public AudioBook findById(int id) {
        AudioBook audio_book = null;

        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "SELECT * from audio_books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                audio_book = new AudioBook(resultSet.getInt("id"),
                        resultSet.getInt("electronic_publication_id"),
                        resultSet.getInt("book_origin_id"),
                        resultSet.getString("narrator"),
                        resultSet.getInt("duration")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return audio_book;
    }

    public void updateAudioBook(int id, AudioBook audio_book) {
        try (Connection connection = DatabaseManager.getConnection()) {
            String query = "UPDATE audio_books " +
                    "SET electronic_publication_id = COALESCE(?, electronic_publication_id)," +
                    "book_origin_id = COALESCE(?, book_origin_id), " +
                    "narrator = COALESCE(?, narrator), " +
                    "duration = COALESCE(?, duration) " +
                    "WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement filledStatement = setAudioBookFields(statement, audio_book);
            filledStatement.setInt(5, id);

            filledStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement setAudioBookFields(PreparedStatement statement, AudioBook audio_book) {
        try {
            statement.setInt(1, audio_book.getElectronic_publication_id());
            statement.setInt(2, audio_book.getBook_origin_id());
            statement.setString(3, audio_book.getNarrator());
            statement.setInt(4, audio_book.getDuration());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statement;
    }

}
