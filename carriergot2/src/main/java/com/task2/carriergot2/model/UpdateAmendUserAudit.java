package com.task2.carriergot2.model;



import com.task2.carriergot2.enums.AmendWorkOrderStateDeciderEnum;
import com.task2.carriergot2.enums.TableNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UpdateAmendUserAudit")
public class UpdateAmendUserAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "PrimaryKey")
    private long primaryKey;


    @Column(name = "DBID")
    private Long dbId;

    @Column(name = "COULMNNAME")
    private String columnName;

    @Column(name = "OLDVALUE")
    private String oldvalue;

    @Column(name = "NEWVALUE")
    private String newvalue;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name ="TABLENAME")
    private TableNameEnum tableName;
    @Column(name = "CREATED_DATE_TIME")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdDateTime;

    public UpdateAmendUserAudit(Long dbId, String columnName, String oldvalue, String newvalue, String createdBy, LocalDateTime createdDateTime) {
        this.dbId = dbId;
        this.columnName = columnName;
        this.oldvalue = oldvalue;
        this.newvalue = newvalue;
        this.createdBy = createdBy;
        this.createdDateTime = createdDateTime;
    }

    public Long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
