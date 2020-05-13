package com.colaborativesaving.demo.models;


public enum MemberStatusEnum {
    ARREAR(1040),
    FREE(1020),
    PENDING(1030),
    RETAIRED(1050);

    private final int code;

    MemberStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}