//package com.task2.carriergot2.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.math.BigInteger;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name="mediation_routing_child")
//public class Mediation_routing_child {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="Child_ID", columnDefinition = "BIGINT")
//    private BigInteger child_id;
//
//    @Column(name = "Child_KEY_ID")
//    private String child_key_id;
//
//    @Column(name = "Child_VALUE")
//    private String child_value;
//
//    @Column(name = "Child_VERSION", columnDefinition = "BIGINT")
//    private BigInteger child_version;
//
//    @Column(name = "Child_CREATED_BY")
//    private String child_createdBy;
//
//    @Column(name = "Child_CREATED_DATE_TIME")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private LocalDateTime child_createdDateTime;
//
//    @Column(name = "Child_UPDATED_BY")
//    private String child_updatedBy;
//
//    @Column(name = "Child_UPDATED_DATE_TIME")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private LocalDateTime child_updatedDateTime;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="Parent_ID")
//    private Mediation_routing mediationRouting;
//
//    public Mediation_routing_child(){
//        super();
//    }
//
//    public Mediation_routing_child(BigInteger id, String key_id, String value, BigInteger version) {
//        super();
//        this.child_id = id;
//        this.child_key_id = key_id;
//        this.child_value = value;
//        this.child_version = version;
//    }
//
//    @JsonIgnore
//    public void setMediationRouting(Mediation_routing mediationRouting) {
//        this.mediationRouting = mediationRouting;
//    }
//
//    public Mediation_routing getMediationRouting() {
//        return mediationRouting;
//    }
//
//    //    public Parent getParent() {
////        return par;
////    }
//    public BigInteger getId() {
//        return child_id;
//    }
//
//    public BigInteger setId(BigInteger id) {
//        child_id = id;
//        return child_id;
//    }
//
//    public String getKey_id() {
//        return child_key_id;
//    }
//
//    public void setKey_id(String key_id) {
//        this.child_key_id = key_id;
//    }
//
//    public String getValue() {
//        return child_value;
//    }
//
//    public void setValue(String value) {
//        this.child_value = value;
//    }
//
//    public BigInteger getVersion() {
//        return child_version;
//    }
//
//    public void setVersion(BigInteger version) {
//        this.child_version = version;
//    }
//
//    public String getCreatedBy() {
//        return child_createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.child_createdBy = createdBy;
//    }
//
//    public LocalDateTime getCreatedDateTime() {
//        return child_createdDateTime;
//    }
//
//    public void setCreatedDateTime(LocalDateTime createdDateTime) {
//        this.child_createdDateTime = createdDateTime;
//    }
//
//    public String getUpdatedBy() {
//        return child_updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.child_updatedBy = updatedBy;
//    }
//
//    public LocalDateTime getUpdatedDateTime() {
//        return child_updatedDateTime;
//    }
//
//    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
//        this.child_updatedDateTime = updatedDateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "Child{" +
//                "Id=" + child_id +
//                ", key_id='" + child_key_id + '\'' +
//                ", value='" + child_value + '\'' +
//                ", version=" + child_version +
//                ", createdBy='" + child_createdBy + '\'' +
//                ", createdDateTime=" + child_createdDateTime +
//                ", updatedBy='" + child_updatedBy + '\'' +
//                ", updatedDateTime=" + child_updatedDateTime +
//                '}';
//    }
//}