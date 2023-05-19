package com.example.library.entity;

import java.sql.Timestamp;

public class Rating {
    private int user_id;
    private int publication_id;
    private int score;
    private Timestamp date;

    public Rating(int user_id, int publication_id, int score, Timestamp date) {
        this.user_id = user_id;
        this.publication_id = publication_id;
        this.score = score;
        this.date = date;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
