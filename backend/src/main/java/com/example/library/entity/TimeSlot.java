package com.example.library.entity;

import java.sql.Time;

public class TimeSlot {
    private int id;
    private Time start_time;
    private Time end_time;

    public TimeSlot(int id, Time start_time, Time end_time) {
        this.id = id;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }
}
