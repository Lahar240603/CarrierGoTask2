package com.task2.carriergot2.enums.converters;


import com.task2.carriergot2.enums.AmendDeciderEnum;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
@Converter
public class AmendDeciderEnumConverter implements AttributeConverter<AmendDeciderEnum, String> {
    @Override
    public String convertToDatabaseColumn(AmendDeciderEnum attribute) {
        if (attribute == null) {
            return null;
//            TODO: Raise Exception ?
        }

        return attribute.getValue();
    }

    @Override
    public AmendDeciderEnum convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
//            TODO: Raise Exception.
        }
        switch (dbData) {
            case "O": return AmendDeciderEnum.O;
            case "O/R" : return AmendDeciderEnum.OR;
            case "R" : return AmendDeciderEnum.R;
            default: return AmendDeciderEnum.NA;
        }
    }
}