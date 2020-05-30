package com.colaborativesaving.demo.users.controllers.contracts;


import com.colaborativesaving.demo.users.model.UsersMapper;

public class ResponseUsers {

    public UsersMapper getUsers() {
        return users;
    }

    public void setUsers(UsersMapper users) {
        this.users = users;
    }

    public ResponseUsers(UsersMapper users) {
        this.users = users;
    }

    private UsersMapper users;
}
