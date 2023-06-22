package com.task2.carriergot2.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;

public enum TableNameEnum {
    AmendWorkOrderStateDecider("AmendWorkOrderStateDecider"),
    UpdateWorkOrderStateDecider("UpdateWorkOrderStateDecider");;

    private String value;

    TableNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonValue
    public String getEnumValue() {
        return this.value;
    }
}
