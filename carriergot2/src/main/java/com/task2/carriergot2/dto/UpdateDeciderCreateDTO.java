package com.task2.carriergot2.dto;

import com.task2.carriergot2.entities.UpdateDecider;
import com.task2.carriergot2.enums.UpdateDeciderEnum;
import com.task2.carriergot2.enums.converters.UpdateDeciderEnumConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;

@Setter
@Getter
@NoArgsConstructor
public class UpdateDeciderCreateDTO {

    private String elementName;

    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum unassigned;


    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum assigned;


    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum accepted;

    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum rejected;


    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum cancelled;


    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum amendByO;


    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum amendByR;


    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum active;


    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum completed;


    private String sourceType;

    private String orgCode;

    public UpdateDecider buildEntity() {
        return UpdateDecider.builder()
                .elementName(this.elementName)
                .unassigned(this.unassigned)
                .assigned(this.assigned)
                .accepted(this.accepted)
                .rejected(this.rejected)
                .cancelled(this.cancelled)
                .amendByO(this.amendByO)
                .amendByR(this.amendByR)
                .active(this.active)
                .completed(this.completed)
                .sourceType(this.sourceType)
                .orgCode(this.orgCode)
                .build();
    }
}
