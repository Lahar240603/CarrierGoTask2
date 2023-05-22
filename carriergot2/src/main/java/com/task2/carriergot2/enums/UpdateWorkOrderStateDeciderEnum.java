package com.task2.carriergot2.enums;

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
        return this.value;
    }

    public static UpdateWorkOrderStateDeciderEnum getEnum(String value) {
        switch (value) {
            case "O": return UpdateWorkOrderStateDeciderEnum.O;
            case "O/R" : return UpdateWorkOrderStateDeciderEnum.OR;
            case "R" : return UpdateWorkOrderStateDeciderEnum.R;
            default: return UpdateWorkOrderStateDeciderEnum.NU;
        }
    }
}
