package com.task2.carriergot2.model;

import com.task2.carriergot2.enums.AmendWorkOrderStateDeciderEnum;
import com.task2.carriergot2.enums.converter.AmendWorkOrderStateDeciderEnumConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "amendworkorderstatedecider")
public class AmendWorkOrderStateDecider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DBID")
    private Long dbId;

    @Column(name = "ELEMENT_NAME", nullable = false)
    private String elementName;

    @Column(name = "UNASSIGNED", nullable = false, length = 3)
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum unassigned;
    @Column(name = "ASSIGNED", nullable = false, length = 3)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum assigned;

    @Column(name = "ACCEPTED", nullable = false, length = 3)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum accepted;
    @Column(name = "REJECTED", nullable = false, length = 3)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum rejected;
    @Column(name = "CANCELLED", nullable = false, length = 3)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum cancelled;
    @Column(name = "AMEND_BY_O", nullable = false, length = 3)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum amendByO;
    @Column(name = "AMEND_BY_R", nullable = false, length = 3)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum amendByR;
    @Column(name = "ACTIVE", nullable = false, length = 3)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum active;

    @Column(name = "COMPLETED", nullable = false, length = 3)
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum completed;
    @Column(name = "SOURCE_TYPE")
    private String sourceType;
    @Column(name = "ORGCODE")
    private String orgCode;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE_TIME")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDateTime;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_DATE_TIME")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedDateTime;
    // Constructors, getters, and setters

    protected AmendWorkOrderStateDecider() {
        this.createdDateTime = LocalDateTime.now();
    }

    public AmendWorkOrderStateDecider(String elementName, AmendWorkOrderStateDeciderEnum unassigned, AmendWorkOrderStateDeciderEnum assigned, AmendWorkOrderStateDeciderEnum accepted, AmendWorkOrderStateDeciderEnum rejected, AmendWorkOrderStateDeciderEnum cancelled, AmendWorkOrderStateDeciderEnum amendByO, AmendWorkOrderStateDeciderEnum amendByR, AmendWorkOrderStateDeciderEnum active, AmendWorkOrderStateDeciderEnum completed, String sourceType, String orgCode, String createdBy){
        this.elementName = elementName;
        this.unassigned = unassigned;
        this.assigned = assigned;
        this.accepted = accepted;
        this.rejected = rejected;
        this.cancelled = cancelled;
        this.amendByO = amendByO;
        this.amendByR = amendByR;
        this.active = active;
        this.completed = completed;
        this.sourceType = sourceType;
        this.orgCode = orgCode;
        this.createdBy = createdBy;
        this.createdDateTime = LocalDateTime.now();
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public AmendWorkOrderStateDeciderEnum getUnassigned() {
        return unassigned;
    }

    public void setUnassigned(AmendWorkOrderStateDeciderEnum unassigned) {
        this.unassigned = unassigned;
    }

    public AmendWorkOrderStateDeciderEnum getAssigned() {
        return assigned;
    }

    public void setAssigned(AmendWorkOrderStateDeciderEnum assigned) {
        this.assigned = assigned;
    }

    public AmendWorkOrderStateDeciderEnum getAccepted() {
        return accepted;
    }

    public void setAccepted(AmendWorkOrderStateDeciderEnum accepted) {
        this.accepted = accepted;
    }

    public AmendWorkOrderStateDeciderEnum getRejected() {
        return rejected;
    }

    public void setRejected(AmendWorkOrderStateDeciderEnum rejected) {
        this.rejected = rejected;
    }

    public AmendWorkOrderStateDeciderEnum getCancelled() {
        return cancelled;
    }

    public void setCancelled(AmendWorkOrderStateDeciderEnum cancelled) {
        this.cancelled = cancelled;
    }

    public AmendWorkOrderStateDeciderEnum getAmendByO() {
        return amendByO;
    }

    public void setAmendByO(AmendWorkOrderStateDeciderEnum amendByO) {
        this.amendByO = amendByO;
    }

    public AmendWorkOrderStateDeciderEnum getAmendByR() {
        return amendByR;
    }

    public void setAmendByR(AmendWorkOrderStateDeciderEnum amendByR) {
        this.amendByR = amendByR;
    }

    public AmendWorkOrderStateDeciderEnum getActive() {
        return active;
    }

    public void setActive(AmendWorkOrderStateDeciderEnum active) {
        this.active = active;
    }

    public AmendWorkOrderStateDeciderEnum getCompleted() {
        return completed;
    }

    public void setCompleted(AmendWorkOrderStateDeciderEnum completed) {
        this.completed = completed;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime() {
        this.createdDateTime = LocalDateTime.now();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime() {
        this.updatedDateTime = LocalDateTime.now();
    }

    public void updateAmendWorkOrderStateDecider(AmendWorkOrderStateDecider newObject, String updatedBy) {
        if (newObject.getUnassigned() != null) {
            this.unassigned = newObject.getUnassigned();
        }
        if (newObject.getAssigned() != null) {
            this.assigned = newObject.getAssigned();
        }
        if (newObject.getAccepted() != null) {
            this.accepted = newObject.getAccepted();
        }
        if (newObject.getRejected() != null) {
            this.rejected = newObject.getRejected();
        }
        if (newObject.getCancelled() != null) {
            this.cancelled = newObject.getCancelled();
        }
        if (newObject.getAmendByO() != null) {
            this.amendByO = newObject.getAmendByO();
        }
        if (newObject.getAmendByR() != null) {
            this.amendByR = newObject.getAmendByR();
        }
        if (newObject.getActive() != null) {
            this.active = newObject.getActive();
        }
        if (newObject.getCompleted() != null) {
            this.completed = newObject.getCompleted();
        }
        if (newObject.getSourceType() != null) {
            this.sourceType = newObject.getSourceType();
        }
        this.updatedBy = updatedBy;
        this.updatedDateTime = LocalDateTime.now();
    }

    public AmendWorkOrderStateDecider getCloneAmend(String newOrgCode, String username) {
        AmendWorkOrderStateDecider newObject = new AmendWorkOrderStateDecider();
        newObject.setAccepted(this.accepted);
        newObject.setActive(this.active);
        newObject.setAssigned(this.assigned);
        newObject.setAmendByO(this.amendByO);
        newObject.setAmendByR(this.amendByR);
        newObject.setCancelled(this.cancelled);
        newObject.setCompleted(this.completed);
        newObject.setElementName(this.elementName);
        newObject.setRejected(this.rejected);
        newObject.setSourceType(this.sourceType);
        newObject.setUnassigned(this.unassigned);
        newObject.setOrgCode(newOrgCode);
        newObject.setCreatedDateTime();
        newObject.setCreatedBy(username);
        return newObject;
    }
}
