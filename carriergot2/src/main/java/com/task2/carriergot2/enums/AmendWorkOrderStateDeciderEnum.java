package com.task2.carriergot2.enums;

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
        return this.value;
    }

    public static AmendWorkOrderStateDeciderEnum getEnum(String value) {
        switch (value) {
            case "O": return AmendWorkOrderStateDeciderEnum.O;
            case "O/R" : return AmendWorkOrderStateDeciderEnum.OR;
            case "R" : return AmendWorkOrderStateDeciderEnum.R;
            default: return AmendWorkOrderStateDeciderEnum.NA;
        }
    }
}
