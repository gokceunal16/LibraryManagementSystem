package com.example.library.entity;

public class ElectronicPublication {
    private int id;
    private String link;
    private int size;
    private int publication_id;

    public ElectronicPublication(int id, String link, int size, int publication_id) {
        this.id = id;
        this.link = link;
        this.size = size;
        this.publication_id = publication_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
    }
}
