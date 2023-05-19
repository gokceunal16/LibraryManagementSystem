package com.example.library.entity;

import java.sql.Timestamp;

public class Borrowing {
    private int id;
    private int user_id;
    private int publication_id;
    private Timestamp loan_date;
    private Timestamp return_date;

    public Borrowing(int id, int user_id, int publication_id, Timestamp loan_date, Timestamp return_date) {
        this.id = id;
        this.user_id = user_id;
        this.publication_id = publication_id;
        this.loan_date = loan_date;
        this.return_date = return_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Timestamp getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Timestamp loan_date) {
        this.loan_date = loan_date;
    }

    public Timestamp getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Timestamp return_date) {
        this.return_date = return_date;
    }
}
