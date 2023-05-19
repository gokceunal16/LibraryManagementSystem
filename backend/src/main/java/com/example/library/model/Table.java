package com.example.library.model;

import io.r2dbc.spi.Parameter;

import java.time.LocalDate;

public class Table {
    private String name;

    public Table(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
