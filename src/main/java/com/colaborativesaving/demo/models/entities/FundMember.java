package com.colaborativesaving.demo.models.entities;

import com.colaborativesaving.demo.models.MemberStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
public class FundMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "user", unique = true)
    private String user;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @Column(name = "update")
    private long update;

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

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }
}


