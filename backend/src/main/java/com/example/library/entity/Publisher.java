package com.example.library.entity;

public class Publisher {
    private int id;
    private String name;
    private String local_address;
    private String city;
    private String country;
    private String phone;
    private String email;

    public Publisher(int id, String name, String local_address, String city, String country, String phone, String email) {
        this.id = id;
        this.name = name;
        this.local_address = local_address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal_address() {
        return local_address;
    }

    public void setLocal_address(String local_address) {
        this.local_address = local_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
