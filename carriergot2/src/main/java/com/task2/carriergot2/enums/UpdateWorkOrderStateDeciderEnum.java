package com.task2.carriergot2.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UpdateWorkOrderStateDeciderEnum {
    O("O"),
    OR("O/R"),
    R("R"),
    NU("NU");

    private String value;

    UpdateWorkOrderStateDeciderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UpdateWorkOrderStateDeciderEnum getEnum(String value) {
        switch (value) {
            case "O": return UpdateWorkOrderStateDeciderEnum.O;
            case "O/R" : return UpdateWorkOrderStateDeciderEnum.OR;
            case "R" : return UpdateWorkOrderStateDeciderEnum.R;
            default: return UpdateWorkOrderStateDeciderEnum.NU;
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
