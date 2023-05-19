package com.example.library.service;

import com.example.library.model.Table;
import com.example.library.repository.DBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private final DBRepository repository;

    @Autowired
    public DBService(DBRepository repository) {
        this.repository = repository;
    }

    public List<Table> getTables() {
        return repository.getTables();
    }

}
