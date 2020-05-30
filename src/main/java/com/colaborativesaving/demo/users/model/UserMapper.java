package com.colaborativesaving.demo.users.model;

import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.shares.model.UserStock;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserMapper implements Serializable {

    private String userName;
    private String name;
    private UserStatusEnum status;
    private Date update;

    UserMapper(User user) throws Exception {
        this.userName = user.getUserName();
        this.name = user.getName();
        this.status = UserStatusEnum.fromInteger(user.getStatus());
        this.update = new Date(user.getUpdate());
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
}
