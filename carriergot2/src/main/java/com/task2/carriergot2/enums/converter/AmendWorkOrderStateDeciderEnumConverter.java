package com.task2.carriergot2.enums.converter;

import com.task2.carriergot2.enums.AmendWorkOrderStateDeciderEnum;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
@Converter
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
        if(dbData == null) {
            return null;
//            TODO: Raise Exception.
        }
        switch (dbData) {
            case "O": return AmendWorkOrderStateDeciderEnum.O;
            case "O/R" : return AmendWorkOrderStateDeciderEnum.OR;
            case "R" : return AmendWorkOrderStateDeciderEnum.R;
            default: return AmendWorkOrderStateDeciderEnum.NA;
        }
    }
}
