package model;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private String bio;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(String name, String userName, String email, String phoneNumber, String bio) {
        this();
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return " Name --> " + name + " \n"
        + " Phone number --> " + phoneNumber + " \n"
        + " Email --> " + email + " \n"
        + " Bio --> " + bio;
    }
}
