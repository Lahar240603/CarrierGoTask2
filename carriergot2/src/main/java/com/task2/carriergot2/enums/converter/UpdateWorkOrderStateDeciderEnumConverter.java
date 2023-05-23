package com.task2.carriergot2.enums.converter;

import com.task2.carriergot2.enums.UpdateWorkOrderStateDeciderEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UpdateWorkOrderStateDeciderEnumConverter implements AttributeConverter<UpdateWorkOrderStateDeciderEnum, String> {
    @Override
    public String convertToDatabaseColumn(UpdateWorkOrderStateDeciderEnum attribute) {
        if (attribute == null) {
            return null;
//            TODO: Raise Exception ?
        }

        return attribute.name();
    }

    @Override
    public UpdateWorkOrderStateDeciderEnum convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "O": return UpdateWorkOrderStateDeciderEnum.O;
            case "O/R" : return UpdateWorkOrderStateDeciderEnum.OR;
            case "R" : return UpdateWorkOrderStateDeciderEnum.R;
            default: return UpdateWorkOrderStateDeciderEnum.NU;
        }
    }
}
