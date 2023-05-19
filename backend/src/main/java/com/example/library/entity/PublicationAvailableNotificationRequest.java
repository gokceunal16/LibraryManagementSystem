package com.example.library.entity;

public class PublicationAvailableNotificationRequest {
    private int user_id;
    private int publication_id;

    public PublicationAvailableNotificationRequest(int user_id, int publication_id) {
        this.user_id = user_id;
        this.publication_id = publication_id;
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
}
