package com.task2.carriergot2.model;

import com.task2.carriergot2.enums.UpdateWorkOrderStateDeciderEnum;
import com.task2.carriergot2.enums.converter.UpdateWorkOrderStateDeciderEnumConverter;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Audited
@Table(name = "updateworkorderstatedecider")
public class UpdateWorkOrderStateDecider implements Comparable<UpdateWorkOrderStateDecider> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DBID")
    private Long dbId;

    @Column(name = "ELEMENT_NAME", nullable = false)
    private String elementName;

    @Column(name = "UNASSIGNED", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum unassigned;


    @Column(name = "ASSIGNED", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum assigned;


    @Column(name = "ACCEPTED", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum accepted;

    @Column(name = "REJECTED", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum rejected;


    @Column(name = "CANCELLED", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum cancelled;


    @Column(name = "AMEND_BY_O", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum amendByO;


    @Column(name = "AMEND_BY_R", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum amendByR;


    @Column(name = "ACTIVE", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum active;


    @Column(name = "COMPLETED", nullable = false)
    @Convert(converter = UpdateWorkOrderStateDeciderEnumConverter.class)
    private UpdateWorkOrderStateDeciderEnum completed;


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
    public UpdateWorkOrderStateDecider() {}

    public UpdateWorkOrderStateDecider(String elementName, UpdateWorkOrderStateDeciderEnum unassigned, UpdateWorkOrderStateDeciderEnum assigned, UpdateWorkOrderStateDeciderEnum accepted, UpdateWorkOrderStateDeciderEnum rejected, UpdateWorkOrderStateDeciderEnum cancelled, UpdateWorkOrderStateDeciderEnum amendByO, UpdateWorkOrderStateDeciderEnum amendByR, UpdateWorkOrderStateDeciderEnum active, UpdateWorkOrderStateDeciderEnum completed, String sourceType, String orgCode, String createdBy) {
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

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public UpdateWorkOrderStateDecider getCloneUpdate(String newOrgCode, String username, UpdateWorkOrderStateDecider changes) {
        UpdateWorkOrderStateDecider newObject = new UpdateWorkOrderStateDecider();
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
        if (changes != null) {
            if (changes.getAccepted() != null) {
                newObject.setAccepted(changes.getAccepted());
            }
            if (changes.getActive() != null) {
                newObject.setActive(changes.getActive());
            }
            if (changes.getAssigned() != null) {
                newObject.setAssigned(changes.getAssigned());
            }
            if (changes.getAmendByO() != null) {
                newObject.setAmendByO(changes.getAmendByO());
            }
            if (changes.getAmendByR() != null) {
                newObject.setAmendByR(changes.getAmendByR());
            }
            if (changes.getCancelled() != null) {
                newObject.setCancelled(changes.getCancelled());
            }
            if (changes.getCompleted() != null) {
                newObject.setCompleted(changes.getCompleted());
            }
            if (changes.getElementName() != null) {
                newObject.setElementName(changes.getElementName());
            }
            if (changes.getRejected() != null) {
                newObject.setRejected(changes.getRejected());
            }
            if (changes.getSourceType() != null) {
                newObject.setSourceType(changes.getSourceType());
            }
            if (changes.getUnassigned() != null) {
                newObject.setUnassigned(changes.getUnassigned());
            }
        }
        return newObject;

    }

    public void updateUpdateWorkOrderStateDecider(UpdateWorkOrderStateDecider newObject, String updatedBy){
        LocalDateTime tempTime = LocalDateTime.now();

        if (newObject.getUnassigned() != null) {
            this.unassigned = newObject.getUnassigned();
        }

        if (newObject.getAssigned() != null) {
            this.assigned = newObject.getUnassigned();
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
        this.updatedDateTime = tempTime;

//        if (newObject.getOrgCode() != null) {
//            this.orgCode = newObject.getOrgCode();
    }


    @Override
    public int compareTo(UpdateWorkOrderStateDecider o) {
        return this.dbId.compareTo(o.getDbId());
    }
}
