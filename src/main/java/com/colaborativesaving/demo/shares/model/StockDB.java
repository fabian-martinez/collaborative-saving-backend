package com.colaborativesaving.demo.shares.model;

import com.colaborativesaving.demo.shares.model.UserStock;
import com.colaborativesaving.demo.shares.repository.ShareTypeDB;
import com.colaborativesaving.demo.users.repository.UserDB;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stock")
public class StockDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false)
    private UserDB user;

    @ManyToOne(optional = false)
    private ShareTypeDB share;

    @Column(name = "cnt")
    private int cnt;

    public StockDB(UserStock userStock) throws Exception {
        this.cnt = userStock.getCnt();
        this.share.setShareType(userStock.getShare());
        this.user.setUser(user.getUser());
    }

    public UserStock getUserStock() throws Exception {
        UserStock userStock = new UserStock();
        userStock.setCnt(this.cnt);
        userStock.setShare(this.share.getshareType());
        userStock.setUser(this.user.getUser());
        return userStock;
    }

    public void setUserStock(UserStock userStock) throws Exception {
        this.cnt = userStock.getCnt();
        this.share.setShareType(userStock.getShare());
        this.user.setUser(user.getUser());
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public ShareTypeDB getShare() {
        return share;
    }

    public void setShare(ShareTypeDB share) {
        this.share = share;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
