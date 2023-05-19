package com.example.library.service;

import com.example.library.entity.BookOrigin;
import com.example.library.repository.BookOriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOriginService {
    private final BookOriginRepository book_originRepository;

    @Autowired
    public BookOriginService(BookOriginRepository book_originRepository) {
        this.book_originRepository = book_originRepository;
    }

    public void createBookOrigin(BookOrigin book_origin) {
        book_originRepository.createBookOrigin(book_origin);
    }

    public List<BookOrigin> getBookOrigins() {
        return book_originRepository.getBookOrigins();
    }

    public BookOrigin findById(int id) {
        return book_originRepository.findById(id);
    }

    public void updateBookOrigin(int id, BookOrigin book_origin) {
        book_originRepository.updateBookOrigin(id, book_origin);
    }
}
