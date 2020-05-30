package com.colaborativesaving.demo.users.model;

public class UserMapperWithGeneralInfo extends UserMapper {

    private double totalLoans;
    private double totalStocks;

    public UserMapperWithGeneralInfo(User user) throws Exception {
        super(user);
    }

    public UserMapperWithGeneralInfo(User user, double totalLoans, double totalStocks) throws Exception {
        super(user);
        this.totalLoans = totalLoans;
        this.totalStocks = totalStocks;
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
