package com.example.library.service;

import com.example.library.entity.Borrowing;
import com.example.library.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;

    @Autowired
    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    public void createBorrowing(Borrowing borrowing) {
        borrowingRepository.createBorrowing(borrowing);
    }

    public List<Object> getBorrowings() {
        return borrowingRepository.getBorrowings();
    }

    public List<Object> getBorrowings(int user_id) {
        return borrowingRepository.getBorrowings(user_id);
    }

    public Borrowing findById(int id) {
        return borrowingRepository.findById(id);
    }

    public void updateBorrowing(int id, Borrowing borrowing) {
        borrowingRepository.updateBorrowing(id, borrowing);
    }
}
