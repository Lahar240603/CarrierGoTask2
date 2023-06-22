package com.task2.carriergot2.model;



import com.task2.carriergot2.enums.TableNameEnum;
import com.task2.carriergot2.enums.converter.TableNameEnumConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MasterAudit")
public class MasterUserAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "DBID")
    private long dbId;

    @Column(name = "EntityId")
    private Long entityId;

    @Column(name = "Field")
    private String field;

    @Column(name = "OldValue")
    private String oldvalue;

    @Column(name = "NewValue")
    private String newvalue;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name ="EntityName")
    @Convert(converter = TableNameEnumConverter.class)
    private TableNameEnum entityName;
    @Column(name = "UpdatedDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedDateTime;

    protected MasterUserAudit() {};

    public MasterUserAudit(Long entityId, String columnName, String oldvalue, String newvalue, String updatedBy, LocalDateTime updatedDateTime) {
        this.entityId = entityId;
        this.field = columnName;
        this.oldvalue = oldvalue;
        this.newvalue = newvalue;
        this.updatedBy = updatedBy;
        this.updatedDateTime = updatedDateTime;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setEntityName(TableNameEnum entityName) {
        this.entityName = entityName;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue;
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

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }
}
