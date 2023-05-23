package com.task2.carriergot2.model;

import com.task2.carriergot2.enums.AmendWorkOrderStateDeciderEnum;
import com.task2.carriergot2.enums.converter.AmendWorkOrderStateDeciderEnumConverter;

import javax.persistence.*;

@Entity
@Table(name = "amendworkorderstatedecider")
public class AmendWorkOrderStateDecider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DBID")
    private int dbId;

    @Column(name = "ELEMENT_NAME", nullable = false)
    private String elementName;

    @Column(name = "UNASSIGNED", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum unassigned;
    @Column(name = "ASSIGNED", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum assigned;

    @Column(name = "ACCEPTED", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum accepted;
    @Column(name = "REJECTED", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum rejected;
    @Column(name = "CANCELLED", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum cancelled;
    @Column(name = "AMEND_BY_O", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum amendByO;
    @Column(name = "AMEND_BY_R", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum amendByR;
    @Column(name = "ACTIVE", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum active;

    @Column(name = "COMPLETED", nullable = false)
    
    @Convert(converter = AmendWorkOrderStateDeciderEnumConverter.class)
    private AmendWorkOrderStateDeciderEnum completed;
    @Column(name = "SOURCE_TYPE")
    private String sourceType;
    @Column(name = "ORGCODE")
    private String orgCode;
    // Constructors, getters, and setters

    protected AmendWorkOrderStateDecider() {}

    public AmendWorkOrderStateDecider(int dbId, String elementName, String unassigned, String assigned, String accepted, String rejected, String cancelled, String amendByO, String amendByR, String active, String completed, String sourceType, String orgCode) {
        this.dbId = dbId;
        this.elementName = elementName;
        this.unassigned = AmendWorkOrderStateDeciderEnum.getEnum(unassigned);
        this.assigned = AmendWorkOrderStateDeciderEnum.getEnum(assigned);
        this.accepted = AmendWorkOrderStateDeciderEnum.getEnum(accepted);
        this.rejected = AmendWorkOrderStateDeciderEnum.getEnum(rejected);
        this.cancelled = AmendWorkOrderStateDeciderEnum.getEnum(cancelled);
        this.amendByO = AmendWorkOrderStateDeciderEnum.getEnum(amendByO);
        this.amendByR = AmendWorkOrderStateDeciderEnum.getEnum(amendByR);
        this.active = AmendWorkOrderStateDeciderEnum.getEnum(active);
        this.completed = AmendWorkOrderStateDeciderEnum.getEnum(completed);
        this.sourceType = sourceType;
        this.orgCode = orgCode;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
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
}
