package com.colaborativesaving.demo.loans.model;

public enum InstalmentStateEnum {
    PENDING(2030),
    CANCELED(2060);

    private final int code;

    InstalmentStateEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static InstalmentStateEnum fromInteger(int code) throws Exception {
        switch(code) {
            case 2030:
                return PENDING;
            case 2060:
                return CANCELED;
        }
        throw new Exception("Invalid Status");
    }
}
