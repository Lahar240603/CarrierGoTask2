package com.task2.carriergot2.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UpdateDeciderEnum {
    O("O"),
    OR("O/R"),
    R("R"),
    NU("NU");

    private String value;

    UpdateDeciderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UpdateDeciderEnum getEnum(String value) {
        switch (value) {
            case "O": return UpdateDeciderEnum.O;
            case "O/R" : return UpdateDeciderEnum.OR;
            case "R" : return UpdateDeciderEnum.R;
            default: return UpdateDeciderEnum.NU;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @JsonValue
    public String getEnumValue() {
        return this.value;
    }
}