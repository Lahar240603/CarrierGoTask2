package com.task2.carriergot2.model;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mediation_routing")
public class Mediation_routing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private BigInteger Id;

    @Column(name = "KEY_ID")
    private String key_id;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "VERSION")
    private BigInteger version;

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

    @OneToMany(mappedBy = "mediationRouting", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mediation_routing_child> childs = new ArrayList<Mediation_routing_child>();

    public Mediation_routing(){
        super();
    }

    public Mediation_routing(BigInteger id, String key_id, String value, BigInteger version) {
        super();
        this.Id = id;
        this.key_id = key_id;
        this.value = value;
        this.version = version;
    }

    public List<Mediation_routing_child> getChilds() {
        return childs;
    }

    public void setChilds(List<Mediation_routing_child> childs) {
        this.childs = childs;
    }

    public BigInteger getId() {
        return Id;
    }

    public BigInteger setId(BigInteger id) {
        Id = id;
        return id;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
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

    @Override
    public String toString() {
        return "Mediation_routing{" +
                "Id=" + Id +
                ", key_id='" + key_id + '\'' +
                ", value='" + value + '\'' +
                ", version=" + version +
                ", createdBy='" + createdBy + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedDateTime=" + updatedDateTime +
                '}';
    }
}
