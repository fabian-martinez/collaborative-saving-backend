package com.colaborativesaving.demo.shares.repository;

import com.colaborativesaving.demo.shares.model.ShareType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shares")
public class ShareTypeDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "value")
    private double value;

    @Column(name = "contribution")
    private double contribution;

    @Column(name = "cnt")
    private int cnt;

    public void setShareType(ShareType shareType) {
        this.name = shareType.getShareName();
        this.value = shareType.getValue();
        this.contribution = shareType.getContribution();
        this.cnt = shareType.getCnt();
    }

    public ShareType getshareType() {
        ShareType shareType = new ShareType();
        shareType.setValue(this.value);
        shareType.setShareName(this.name);
        shareType.setContribution(this.contribution);
        shareType.setCnt(this.cnt);
        return shareType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
