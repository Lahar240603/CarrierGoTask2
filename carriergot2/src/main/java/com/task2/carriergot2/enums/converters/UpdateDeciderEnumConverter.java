package com.task2.carriergot2.enums.converters;

import com.task2.carriergot2.enums.UpdateDeciderEnum;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UpdateDeciderEnumConverter implements AttributeConverter<UpdateDeciderEnum, String> {
    @Override
    public String convertToDatabaseColumn(UpdateDeciderEnum attribute) {
        if (attribute == null) {
            return null;
//            TODO: Raise Exception ?
        }
        return attribute.getValue();
    }

    @Override
    public UpdateDeciderEnum convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
//            TODO: Raise Exception.
        }
        switch (dbData) {
            case "O": return UpdateDeciderEnum.O;
            case "O/R" : return UpdateDeciderEnum.OR;
            case "R" : return UpdateDeciderEnum.R;
            default: return UpdateDeciderEnum.NU;
        }
    }
}
