package com.colaborativesaving.demo.users.controllers.contracts;

import com.colaborativesaving.demo.users.model.User;

public class ResponseUser {

    private String userName;
    private String name;

    public ResponseUser(User user) {
        this.userName = user.getUserName();
        this.name = user.getName();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
