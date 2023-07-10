package com.task2.carriergot2.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AmendDeciderEnum {
    O("O"),
    OR("O/R"),
    R("R"),
    NA("NA");

    private String value;

    AmendDeciderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmendDeciderEnum getEnum(String value) {
        switch (value) {
            case "O": return AmendDeciderEnum.O;
            case "O/R" : return AmendDeciderEnum.OR;
            case "R" : return AmendDeciderEnum.R;
            default: return AmendDeciderEnum.NA;
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