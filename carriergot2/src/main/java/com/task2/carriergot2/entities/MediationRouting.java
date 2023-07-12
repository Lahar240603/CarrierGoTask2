package com.task2.carriergot2.entities;

import lombok.*;
import org.hibernate.envers.Audited;
import org.slf4j.MDC;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Audited
@Table(name = "mediation_routing")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediationRouting {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEYID")
    private String keyId;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "VERSION")
    private Long version;

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