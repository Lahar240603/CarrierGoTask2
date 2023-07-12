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
public class AmendDeciderModifyDTO {

    private Long dbId;

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

    public AmendDecider buildEntity(AmendDecider amendDecider) {
        amendDecider.setUnassigned(this.unassigned);
        amendDecider.setAccepted(this.accepted);
        amendDecider.setActive(this.active);
        amendDecider.setAssigned(this.assigned);
        amendDecider.setCancelled(this.cancelled);
        amendDecider.setAmendByO(this.amendByO);
        amendDecider.setAmendByR(this.amendByR);
        amendDecider.setCompleted(this.completed);
        amendDecider.setRejected(this.rejected);
        return amendDecider;
    }
}
