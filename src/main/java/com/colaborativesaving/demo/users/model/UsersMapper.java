package com.colaborativesaving.demo.users.model;

import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersMapper implements Serializable {

    public UsersMapper(List<User> users) {
        List<UserMapper> userMappers = new ArrayList<>();
        users.forEach(user -> {
            try {
                userMappers.add(new UserMapper(user));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.users = userMappers;
    }

    private List<UserMapper> users;

    public List<UserMapper> getUsers() {
        return users;
    }

    public void setUsers(List<UserMapper> users) {
        this.users = users;
    }
}
