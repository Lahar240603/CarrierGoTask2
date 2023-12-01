package com.task2.carriergot2.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.slf4j.MDC;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="dmswitches")
@Getter
@Setter
@Audited
public class DMSwitch {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="SWITCHNAME")
    private String switchName;

    @Column(name="ISENABLED")
    private boolean isEnabled;

    @Column(name = "CREATEDBY")
    private String createdBy;

    @Column(name = "CREATIONTIME")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationTime;

    @Column(name = "LASTMODIFIEDBY")
    private String lastModifiedBy;

    @Column(name = "LASTMODIFIED")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime lastModified;

    @PrePersist
    public void onPrePersist() {
        setCreatedBy(MDC.get("userName"));
        setCreationTime(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        setLastModifiedBy(MDC.get("userName"));
        setLastModified(LocalDateTime.now());
    }

}


