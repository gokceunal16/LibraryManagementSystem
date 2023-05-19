package com.example.library.entity;

import java.sql.Timestamp;

public class Review {
    private int id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
    private int user_id;
    private int publication_id;
    private String comment;


    public Review(int id, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at, int user_id, int publication_id, String comment) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.user_id = user_id;
        this.publication_id = publication_id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
