package com.colaborativesaving.demo.users.controllers.contracts;

import com.colaborativesaving.demo.users.model.User;
import com.colaborativesaving.demo.users.model.UserMapper;
import com.colaborativesaving.demo.users.model.UserMapperWithGeneralInfo;
import com.colaborativesaving.demo.users.model.UserStatusEnum;

import java.util.Date;

public class ResponseUser {

    private String userName;
    private String name;
    private UserStatusEnum status;
    private Date update;
    private double totalLoans;
    private double totalStocks;

    public ResponseUser(UserMapperWithGeneralInfo user) throws Exception {
        this.userName = user.getUserName();
        this.name = user.getName();
        this.status = user.getStatus();
        this.update = user.getUpdate();
        this.totalStocks = user.getTotalStocks();
        this.totalLoans = user.getTotalLoans();
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

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public double getTotalLoans() {
        return totalLoans;
    }

    public void setTotalLoans(double totalLoans) {
        this.totalLoans = totalLoans;
    }

    public double getTotalStocks() {
        return totalStocks;
    }

    public void setTotalStocks(double totalStocks) {
        this.totalStocks = totalStocks;
    }
}
