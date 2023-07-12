package com.task2.carriergot2.dto;

import com.task2.carriergot2.entities.AmendDecider;
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
public class UpdateDeciderModifyDTO {

    private Long dbId;

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

    public UpdateDecider buildEntity(UpdateDecider updateDecider) {
        updateDecider.setUnassigned(this.unassigned);
        updateDecider.setAccepted(this.accepted);
        updateDecider.setActive(this.active);
        updateDecider.setAssigned(this.assigned);
        updateDecider.setCancelled(this.cancelled);
        updateDecider.setAmendByO(this.amendByO);
        updateDecider.setAmendByR(this.amendByR);
        updateDecider.setCompleted(this.completed);
        updateDecider.setRejected(this.rejected);
        return updateDecider;
    }
}
