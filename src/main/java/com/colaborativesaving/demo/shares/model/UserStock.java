package com.colaborativesaving.demo.shares.model;

import com.colaborativesaving.demo.users.model.User;

public class UserStock {
    private User user;
    private ShareType share;
    private int cnt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShareType getShare() {
        return share;
    }

    public void setShare(ShareType share) {
        this.share = share;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
