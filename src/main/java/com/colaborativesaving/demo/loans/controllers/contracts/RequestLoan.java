package com.colaborativesaving.demo.loans.controllers.contracts;

public class RequestLoan {

    private String userName;
    private String loanType;
    private long total;
    private long advance;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getAdvance() {
        return advance;
    }

    public void setAdvance(long advance) {
        this.advance = advance;
    }
}
