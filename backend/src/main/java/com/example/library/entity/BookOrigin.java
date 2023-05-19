package com.example.library.entity;

public class BookOrigin {
    private int id;
    private int author_id;
    private String name;

    public BookOrigin(int id, int author_id, String name) {
        this.id = id;
        this.author_id = author_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
