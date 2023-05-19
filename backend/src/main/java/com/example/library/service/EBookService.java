package com.example.library.service;

import com.example.library.entity.EBook;
import com.example.library.repository.EBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EBookService {
    private final EBookRepository e_bookRepository;

    @Autowired
    public EBookService(EBookRepository e_bookRepository) {
        this.e_bookRepository = e_bookRepository;
    }

    public void createEBook(EBook e_book) {
        e_bookRepository.createEBook(e_book);
    }

    public List<EBook> getEBooks() {
        return e_bookRepository.getEBooks();
    }

    public EBook findById(int id) {
        return e_bookRepository.findById(id);
    }

    public void updateEBook(int id, EBook e_book) {
        e_bookRepository.updateEBook(id, e_book);
    }
}
