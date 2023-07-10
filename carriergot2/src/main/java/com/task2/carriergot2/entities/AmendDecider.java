package com.task2.carriergot2.entities;

import com.task2.carriergot2.enums.AmendDeciderEnum;
import com.task2.carriergot2.enums.converters.AmendDeciderEnumConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Audited
@Table(name = "amendworkorderstatedecider")
public class AmendDecider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DBID")
    private Long dbId;

    @Column(name = "ELEMENT_NAME", nullable = false)
    private String elementName;

    @Column(name = "UNASSIGNED", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum unassigned;

    @Column(name = "ASSIGNED", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum assigned;

    @Column(name = "ACCEPTED", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum accepted;

    @Column(name = "REJECTED", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum rejected;

    @Column(name = "CANCELLED", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum cancelled;

    @Column(name = "AMEND_BY_O", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum amendByO;

    @Column(name = "AMEND_BY_R", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum amendByR;

    @Column(name = "ACTIVE", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum active;

    @Column(name = "COMPLETED", nullable = false, length = 3)
    @Convert(converter = AmendDeciderEnumConverter.class)
    private AmendDeciderEnum completed;

    @Column(name = "SOURCE_TYPE")
    private String sourceType;

    @Column(name = "ORGCODE")
    private String orgCode;

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

}
