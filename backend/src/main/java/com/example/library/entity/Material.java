package com.example.library.entity;

public class Material {
    private int id;
    private int physical_publication_id;
    private String format;

    public Material(int id, int physical_publication_id, String format) {
        this.id = id;
        this.physical_publication_id = physical_publication_id;
        this.format = format;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
