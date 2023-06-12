package com.example.library.service;

import com.example.library.repository.BookDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailService {

    private final BookDetailRepository bookDetailRepository;

    public BookDetailService(BookDetailRepository bookDetailRepository) {
        this.bookDetailRepository = bookDetailRepository;
    }

    public List<Object> getBookDetails() {
        return bookDetailRepository.getBookDetails();
    }

    public List<Object> getBookDetails(int user_id) {
        return bookDetailRepository.getBookDetails(user_id);
    }
}
