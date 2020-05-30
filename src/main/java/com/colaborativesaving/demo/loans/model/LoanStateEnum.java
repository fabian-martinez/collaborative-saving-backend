package com.colaborativesaving.demo.loans.model;

public enum LoanStateEnum {
    PAYING_OUT(2120),
    PAYING(2130),
    ARREARS(2150),
    PAID(2160);

    private final int code;

    LoanStateEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static LoanStateEnum fromInteger(int code) throws Exception {
        switch(code) {
            case 2120:
                return PAYING_OUT;
            case (2130):
                return PAYING;
            case (2150):
                return ARREARS;
            case (2160):
                return PAID;

        }
        throw new Exception("Invalid Status");
    }
}
