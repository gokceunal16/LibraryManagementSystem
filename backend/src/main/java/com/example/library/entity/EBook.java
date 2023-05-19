package com.example.library.entity;

public class EBook {
    private int id;
    private int electronic_publication_id;
    private int book_origin_id;

    public EBook(int id, int electronic_publication_id, int book_origin_id) {
        this.id = id;
        this.electronic_publication_id = electronic_publication_id;
        this.book_origin_id = book_origin_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getElectronic_publication_id() {
        return electronic_publication_id;
    }

    public void setElectronic_publication_id(int electronic_publication_id) {
        this.electronic_publication_id = electronic_publication_id;
    }

    public int getBook_origin_id() {
        return book_origin_id;
    }

    public void setBook_origin_id(int book_origin_id) {
        this.book_origin_id = book_origin_id;
    }
}
