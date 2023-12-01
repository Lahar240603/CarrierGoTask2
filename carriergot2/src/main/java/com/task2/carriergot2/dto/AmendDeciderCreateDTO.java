package com.task2.carriergot2.dto;

import com.task2.carriergot2.entities.AmendDecider;
import com.task2.carriergot2.enums.AmendDeciderEnum;
import com.task2.carriergot2.enums.converters.AmendDeciderEnumConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;

@Setter
@Getter
@NoArgsConstructor
public class AmendDeciderCreateDTO {

    private String elementName;

    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum unassigned;


    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum assigned;


    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum accepted;

    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum rejected;


    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum cancelled;


    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum amendByO;


    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum amendByR;


    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum active;


    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum completed;

    private String sourceType;

    private String orgCode;


    public AmendDecider buildEntity() {
        return AmendDecider.builder()
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
