package com.praktikum.users;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Abstract methods that must be implemented by subclasses
    public abstract boolean login(String inputUsername, String inputPassword);
    public abstract void displayAppMenu();
}