package com.example.library.service;

import com.example.library.entity.PhysicalBook;
import com.example.library.repository.PhysicalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalBookService {
    private final PhysicalBookRepository physical_bookRepository;

    @Autowired
    public PhysicalBookService(PhysicalBookRepository physical_bookRepository) {
        this.physical_bookRepository = physical_bookRepository;
    }

    public void createPhysicalBook(PhysicalBook physical_book) {
        physical_bookRepository.createPhysicalBook(physical_book);
    }

    public List<PhysicalBook> getPhysicalBooks() {
        return physical_bookRepository.getPhysicalBooks();
    }

    public PhysicalBook findById(int id) {
        return physical_bookRepository.findById(id);
    }

    public void updatePhysicalBook(int id, PhysicalBook physical_book) {
        physical_bookRepository.updatePhysicalBook(id, physical_book);
    }
}
