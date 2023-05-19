package com.example.library.service;

import com.example.library.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class GenericService {
    private final GenericRepository genericRepository;
    // keep the name of the tables that implements soft delete in an arraylist
    private static final ArrayList<String> softDeletes = new ArrayList<>(Arrays.asList("users", "reservations", "reviews"));
    @Autowired
    public GenericService(GenericRepository genericRepository) {
        this.genericRepository = genericRepository;
    }

    public void deleteRecordById(int id, String entityName) {
        if (softDeletes.contains(entityName)) {
            this.genericRepository.softDeleteRecordById(id, entityName);
        } else {
            this.genericRepository.hardDeleteRecordById(id, entityName);
        }

    }
}
