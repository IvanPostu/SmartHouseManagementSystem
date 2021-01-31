package com.ivan.app.datasource.entity;

public class UserEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserEntity(
            String username,
            String password, 
            String firstName, 
            String lastName
    ) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserEntity() {
        this.username = "";
        this.password = "";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
    
}
