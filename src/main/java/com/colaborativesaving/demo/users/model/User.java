package com.colaborativesaving.demo.users.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

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

    public User(String userName, String name) {
        this.userName = userName;
        this.name = name;
    }

    public User() {

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

    public long getUpdate() { return update; }

    public void setUpdate(long update) { this.update = update; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}


