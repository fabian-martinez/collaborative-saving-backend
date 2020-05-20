package com.colaborativesaving.demo.users.controllers.contracts;


import com.colaborativesaving.demo.users.model.User;

import java.util.List;

public class ResponseUsers {

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public ResponseUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;
}
