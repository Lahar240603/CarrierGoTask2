package com.task2.carriergot2.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AmendWorkOrderStateDeciderEnum {
    O("O"),
    OR("O/R"),
    R("R"),
    NA("NA");

    private String value;

    AmendWorkOrderStateDeciderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmendWorkOrderStateDeciderEnum getEnum(String value) {
        switch (value) {
            case "O": return AmendWorkOrderStateDeciderEnum.O;
            case "O/R" : return AmendWorkOrderStateDeciderEnum.OR;
            case "R" : return AmendWorkOrderStateDeciderEnum.R;
            default: return AmendWorkOrderStateDeciderEnum.NA;
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
