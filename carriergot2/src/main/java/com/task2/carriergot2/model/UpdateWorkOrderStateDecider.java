package com.task2.carriergot2.model;

import com.task2.carriergot2.enums.UpdateWorkOrderStateDeciderEnum;

import javax.persistence.*;

@Entity
@Table(name = "updateworkorderstatedecider")
public class UpdateWorkOrderStateDecider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DBID")
    private Long dbId;

    @Column(name = "ELEMENT_NAME", nullable = false)
    private String elementName;

    @Column(name = "UNASSIGNED", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum unassigned;


    @Column(name = "ASSIGNED", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum assigned;


    @Column(name = "ACCEPTED", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum accepted;

    @Column(name = "REJECTED", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum rejected;


    @Column(name = "CANCELLED", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum cancelled;


    @Column(name = "AMEND_BY_O", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum amendByO;


    @Column(name = "AMEND_BY_R", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum amendByR;


    @Column(name = "ACTIVE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum active;


    @Column(name = "COMPLETED", nullable = false)
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum completed;


    @Column(name = "SOURCE_TYPE")
    @Enumerated(EnumType.STRING)
    private UpdateWorkOrderStateDeciderEnum sourceType;


    @Column(name = "ORGCODE")
    private String orgCode;


    // Constructors, getters, and setters


    public UpdateWorkOrderStateDecider() {
    }

    public UpdateWorkOrderStateDecider(Long dbId, String elementName, UpdateWorkOrderStateDeciderEnum unassigned, UpdateWorkOrderStateDeciderEnum assigned, UpdateWorkOrderStateDeciderEnum accepted, UpdateWorkOrderStateDeciderEnum rejected, UpdateWorkOrderStateDeciderEnum cancelled, UpdateWorkOrderStateDeciderEnum amendByO, UpdateWorkOrderStateDeciderEnum amendByR, UpdateWorkOrderStateDeciderEnum active, UpdateWorkOrderStateDeciderEnum completed, UpdateWorkOrderStateDeciderEnum sourceType, String orgCode) {
        this.dbId = dbId;
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

    public UpdateWorkOrderStateDeciderEnum getUnassigned() {
        return unassigned;
    }

    public void setUnassigned(UpdateWorkOrderStateDeciderEnum unassigned) {
        this.unassigned = unassigned;
    }

    public UpdateWorkOrderStateDeciderEnum getAssigned() {
        return assigned;
    }

    public void setAssigned(UpdateWorkOrderStateDeciderEnum assigned) {
        this.assigned = assigned;
    }

    public UpdateWorkOrderStateDeciderEnum getAccepted() {
        return accepted;
    }

    public void setAccepted(UpdateWorkOrderStateDeciderEnum accepted) {
        this.accepted = accepted;
    }

    public UpdateWorkOrderStateDeciderEnum getRejected() {
        return rejected;
    }

    public void setRejected(UpdateWorkOrderStateDeciderEnum rejected) {
        this.rejected = rejected;
    }

    public UpdateWorkOrderStateDeciderEnum getCancelled() {
        return cancelled;
    }

    public void setCancelled(UpdateWorkOrderStateDeciderEnum cancelled) {
        this.cancelled = cancelled;
    }

    public UpdateWorkOrderStateDeciderEnum getAmendByO() {
        return amendByO;
    }

    public void setAmendByO(UpdateWorkOrderStateDeciderEnum amendByO) {
        this.amendByO = amendByO;
    }

    public UpdateWorkOrderStateDeciderEnum getAmendByR() {
        return amendByR;
    }

    public void setAmendByR(UpdateWorkOrderStateDeciderEnum amendByR) {
        this.amendByR = amendByR;
    }

    public UpdateWorkOrderStateDeciderEnum getActive() {
        return active;
    }

    public void setActive(UpdateWorkOrderStateDeciderEnum active) {
        this.active = active;
    }

    public UpdateWorkOrderStateDeciderEnum getCompleted() {
        return completed;
    }

    public void setCompleted(UpdateWorkOrderStateDeciderEnum completed) {
        this.completed = completed;
    }

    public UpdateWorkOrderStateDeciderEnum getSourceType() {
        return sourceType;
    }

    public void setSourceType(UpdateWorkOrderStateDeciderEnum sourceType) {
        this.sourceType = sourceType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
