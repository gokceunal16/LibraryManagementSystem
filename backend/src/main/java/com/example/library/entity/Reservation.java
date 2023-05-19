package com.example.library.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Reservation {
    private int id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
    private int user_id;
    private int time_slot_id;
    private int room_id;
    private Date date;

    public Reservation(int id, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at, int user_id, int time_slot_id, int room_id, Date date) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.user_id = user_id;
        this.time_slot_id = time_slot_id;
        this.room_id = room_id;
        this.date = date;
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

    public int getTime_slot_id() {
        return time_slot_id;
    }

    public void setTime_slot_id(int time_slot_id) {
        this.time_slot_id = time_slot_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
