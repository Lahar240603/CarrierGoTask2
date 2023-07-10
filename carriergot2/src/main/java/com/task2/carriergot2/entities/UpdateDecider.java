package com.task2.carriergot2.entities;

import com.task2.carriergot2.enums.UpdateDeciderEnum;
import com.task2.carriergot2.enums.converters.UpdateDeciderEnumConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Audited
@Getter
@Setter
@NoArgsConstructor
@Table(name = "updateworkorderstatedecider")
public class UpdateDecider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DBID")
    private Long dbId;

    @Column(name = "ELEMENT_NAME", nullable = false)
    private String elementName;

    @Column(name = "UNASSIGNED", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum unassigned;


    @Column(name = "ASSIGNED", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum assigned;


    @Column(name = "ACCEPTED", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum accepted;

    @Column(name = "REJECTED", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum rejected;


    @Column(name = "CANCELLED", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum cancelled;


    @Column(name = "AMEND_BY_O", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum amendByO;


    @Column(name = "AMEND_BY_R", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum amendByR;


    @Column(name = "ACTIVE", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum active;


    @Column(name = "COMPLETED", nullable = false)
    @Convert(converter = UpdateDeciderEnumConverter.class)
    private UpdateDeciderEnum completed;


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