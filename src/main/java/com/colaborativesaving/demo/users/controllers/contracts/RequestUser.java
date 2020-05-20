package com.colaborativesaving.demo.users.controllers.contracts;

import com.colaborativesaving.demo.users.model.User;

public class RequestUser {

    private String userName;
    private String primaryName;
    private String lastName;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPrimaryName() { return primaryName; }
    public void setPrimaryName(String primaryName) { this.primaryName = primaryName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }


    public User getUser() {
        return new User(this.userName, this.lastName + " " + this.primaryName);
    }
}
