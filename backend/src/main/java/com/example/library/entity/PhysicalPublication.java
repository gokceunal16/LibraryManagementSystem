package com.example.library.entity;

public class PhysicalPublication {
    private int id;
    private int floor_number;
    private int section_number;
    private int shelf_number;
    private int publication_id;

    public PhysicalPublication(int id, int floor_number, int section_number, int shelf_number, int publication_id) {
        this.id = id;
        this.floor_number = floor_number;
        this.section_number = section_number;
        this.shelf_number = shelf_number;
        this.publication_id = publication_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public int getSection_number() {
        return section_number;
    }

    public void setSection_number(int section_number) {
        this.section_number = section_number;
    }

    public int getShelf_number() {
        return shelf_number;
    }

    public void setShelf_number(int shelf_number) {
        this.shelf_number = shelf_number;
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
    }
}
