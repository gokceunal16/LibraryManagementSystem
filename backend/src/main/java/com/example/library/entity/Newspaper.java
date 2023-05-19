package com.example.library.entity;

public class Newspaper {
    private int id;
    private int physical_publication_id;
    private String publication_frequency;
    private String circulation;

    public Newspaper(int id, int physical_publication_id, String publication_frequency, String circulation) {
        this.id = id;
        this.physical_publication_id = physical_publication_id;
        this.publication_frequency = publication_frequency;
        this.circulation = circulation;
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

    public String getPublication_frequency() {
        return publication_frequency;
    }

    public void setPublication_frequency(String publication_frequency) {
        this.publication_frequency = publication_frequency;
    }

    public String getCirculation() {
        return circulation;
    }

    public void setCirculation(String circulation) {
        this.circulation = circulation;
    }
}
