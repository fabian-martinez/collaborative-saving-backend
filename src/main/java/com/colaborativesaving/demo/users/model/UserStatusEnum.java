package com.colaborativesaving.demo.users.model;


public enum UserStatusEnum {
    ARREAR(1040),
    FREE(1020),
    PENDING(1030),
    RETAIRED(1050);

    private final int code;

    UserStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static UserStatusEnum fromInteger(int code) throws Exception {
        switch(code) {
            case 1040:
                return ARREAR;
            case 1020:
                return FREE;
            case 1030:
                return PENDING;
            case 1050:
                return RETAIRED;
        }
        throw new Exception("Invalid Status");
    }
}