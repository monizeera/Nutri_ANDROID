package com.example.app.model;

public class Nutritionist {
    private String name;
    private String email;
    private String password;

    public Nutritionist(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
