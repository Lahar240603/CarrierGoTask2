package com.task2.carriergot2.model;

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
    private String unassigned;


    @Column(name = "ASSIGNED", nullable = false)
    private String assigned;


    @Column(name = "ACCEPTED", nullable = false)
    private String accepted;

    @Column(name = "REJECTED", nullable = false)
    private String rejected;


    @Column(name = "CANCELLED", nullable = false)
    private String cancelled;


    @Column(name = "AMEND_BY_O", nullable = false)
    private String amendByO;


    @Column(name = "AMEND_BY_R", nullable = false)
    private String amendByR;


    @Column(name = "ACTIVE", nullable = false)
    private String active;


    @Column(name = "COMPLETED", nullable = false)
    private String completed;


    @Column(name = "SOURCE_TYPE")
    private String sourceType;


    @Column(name = "ORGCODE")
    private String orgCode;


    // Constructors, getters, and setters


    public UpdateWorkOrderStateDecider() {
    }

    public UpdateWorkOrderStateDecider(Long dbId, String elementName, String unassigned, String assigned, String accepted, String rejected, String cancelled, String amendByO, String amendByR, String active, String completed, String sourceType, String orgCode) {
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

    public String getUnassigned() {
        return unassigned;
    }

    public void setUnassigned(String unassigned) {
        this.unassigned = unassigned;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getAmendByO() {
        return amendByO;
    }

    public void setAmendByO(String amendByO) {
        this.amendByO = amendByO;
    }

    public String getAmendByR() {
        return amendByR;
    }

    public void setAmendByR(String amendByR) {
        this.amendByR = amendByR;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
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
