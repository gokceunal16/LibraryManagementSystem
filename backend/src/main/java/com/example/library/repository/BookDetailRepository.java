package com.example.library.repository;

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
public class BookDetailRepository {

    @Data
    @AllArgsConstructor
    public static class BookDetailDto {
        private int physical_book_id;
        private int book_origin_id;
        private int page_number;
        private int physical_publication_id;
        private int floor_number;
        private int section_number;
        private int shelf_number;
        private int publication_id;
        private String title;
        private String genre;
        private String language;
        private String translator;
        private String description;
        private float score;
        private String author_first_name;
        private String author_last_name;
        private String image_name;
        private boolean is_available;
    }

    public List<Object> getBookDetails() {
        String query = "SELECT * FROM book_details_view";
        return getBookDetails(query);
    }

    public List<Object> getBookDetails(int publication_id) {
        String query = String.format("SELECT * FROM book_details_view " +
                "WHERE publication_id = %d ", publication_id);
        return getBookDetails(query);
    }


    public List<Object> getBookDetails(String query) {
        List<Object> bookDetails = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BookDetailDto bookDetailDto = new BookDetailDto(
                        resultSet.getInt("physical_book_id"),
                        resultSet.getInt("book_origin_id"),
                        resultSet.getInt("page_number"),
                        resultSet.getInt("physcial_publication_id"),
                        resultSet.getInt("floor_number"),
                        resultSet.getInt("section_number"),
                        resultSet.getInt("shelf_number"),
                        resultSet.getInt("publication_id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getString("language"),
                        resultSet.getString("translator"),
                        resultSet.getString("description"),
                        resultSet.getFloat("score"),
                        resultSet.getString("author_first_name"),
                        resultSet.getString("author_last_name"),
                        resultSet.getString("image_name"),
                        resultSet.getBoolean("is_available")

                );
                bookDetails.add(bookDetailDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookDetails;
    }

}
