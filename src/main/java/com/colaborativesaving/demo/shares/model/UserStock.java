package com.colaborativesaving.demo.shares.model;

import com.colaborativesaving.demo.users.model.User;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class UserStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private ShareType share;

    @Column(name = "cnt")
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
