package com.task2.carriergot2.enums.converter;

import com.task2.carriergot2.enums.AmendWorkOrderStateDeciderEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AmendWorkOrderStateDeciderEnumConverter implements AttributeConverter<AmendWorkOrderStateDeciderEnum, String> {
    @Override
    public String convertToDatabaseColumn(AmendWorkOrderStateDeciderEnum attribute) {
        if (attribute == null) {
            return null;
//            TODO: Raise Exception ?
        }

        return attribute.getValue();
    }

    @Override
    public AmendWorkOrderStateDeciderEnum convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "O": return AmendWorkOrderStateDeciderEnum.O;
            case "O/R" : return AmendWorkOrderStateDeciderEnum.OR;
            case "R" : return AmendWorkOrderStateDeciderEnum.R;
            default: return AmendWorkOrderStateDeciderEnum.NA;
        }
    }
}