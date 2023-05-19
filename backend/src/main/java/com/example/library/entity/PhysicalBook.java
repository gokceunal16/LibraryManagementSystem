package com.example.library.entity;

public class PhysicalBook {
    private int id;
    private int physical_publication_id;
    private int book_origin_id;
    private int page_number;

    public PhysicalBook(int id, int physical_publication_id, int book_origin_id, int page_number) {
        this.id = id;
        this.physical_publication_id = physical_publication_id;
        this.book_origin_id = book_origin_id;
        this.page_number = page_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhysical_publication_id() {
        return physical_publication_id;
    }

    public void setPhysical_publication_id(int physical_publication_id) {
        this.physical_publication_id = physical_publication_id;
    }

    public int getBook_origin_id() {
        return book_origin_id;
    }

    public void setBook_origin_id(int book_origin_id) {
        this.book_origin_id = book_origin_id;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }
}
