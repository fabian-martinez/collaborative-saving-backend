package com.colaborativesaving.demo.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "share")
public class Share {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "type", unique = true)
    private String type;

    @Column(name = "qty")
    private int qty;

    @Column(name = "contribution")
    private long contribution;

    @Column(name = "value")
    private long value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getContribution() {
        return contribution;
    }

    public void setContribution(long contribution) {
        this.contribution = contribution;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
