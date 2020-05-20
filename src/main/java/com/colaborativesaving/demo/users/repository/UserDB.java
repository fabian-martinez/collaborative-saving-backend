package com.colaborativesaving.demo.users.repository;

import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.model.UserStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "userName", unique = true)
    private String userName;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @Column(name = "update")
    private long update;


    public User getUser() throws Exception {
        User user = new User(this.userName, this.name);
        user.setStatus(UserStatusEnum.fromInteger(this.status));
        user.setUpdate(new Date(this.update));

        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUpdte() {
        return update;
    }

    public void setUpdte(long updte) {
        this.update = updte;
    }

    public long getUpdate() { return update; }

    public void setUpdate(long update) { this.update = update; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setUser(User user) {
        this.userName = user.getUserName();
        this.name = user.getName();
        this.status = user.getStatus().getCode();
        this.update = user.getUpdate().getTime();
    }
}


