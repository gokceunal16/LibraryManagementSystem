package com.example.library.entity;

import java.sql.Date; // TODO make all dates sql.Date

public class Publication {
    private int id;
    private String title;
    private int genre_id;
    private int publisher_id;
    private int language_id;
    private String translator;
    private Date publish_date;

    public Publication(int id, String title, int genre_id, int publisher_id, int language_id, String translator, Date publish_date) {
        this.id = id;
        this.title = title;
        this.genre_id = genre_id;
        this.publisher_id = publisher_id;
        this.language_id = language_id;
        this.translator = translator;
        this.publish_date = publish_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }
}
