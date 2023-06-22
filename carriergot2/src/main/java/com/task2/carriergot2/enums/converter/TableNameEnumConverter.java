package com.task2.carriergot2.enums.converter;

import com.task2.carriergot2.enums.TableNameEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TableNameEnumConverter implements AttributeConverter<TableNameEnum, String> {
    @Override
    public String convertToDatabaseColumn(TableNameEnum attribute) {
        if (attribute == null) {
            return null;
//            TODO: Raise Exception ?
        }

        return attribute.getValue();
    }

    @Override
    public TableNameEnum convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
//            TODO: Raise Exception.
        }
        switch (dbData) {
            case "AmendWorkOrderStateDecider" : return TableNameEnum.AmendWorkOrderStateDecider;
            default: return TableNameEnum.UpdateWorkOrderStateDecider;
        }
    }
}
