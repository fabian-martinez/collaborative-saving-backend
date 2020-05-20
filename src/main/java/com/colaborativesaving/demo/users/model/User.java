package com.colaborativesaving.demo.users.model;

import java.util.Date;

public class User {

    private String userName;
    private String name;
    private UserStatusEnum status;
    private Date update;

    public User(String userName, String name) {
        this.userName = userName;
        this.name = name;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public UserStatusEnum getStatus() { return status; }
    public void setStatus(UserStatusEnum status) { this.status = status; }
    public Date getUpdate() { return update; }
    public void setUpdate(Date update) { this.update = update; }


}
