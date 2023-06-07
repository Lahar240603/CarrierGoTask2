package com.task2.carriergot2.model;
import javax.persistence.*;
import java.math.BigInteger;

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

    @Override
    public String toString() {
        return "Mediation_routing{" +
                "Id=" + Id +
                ", key_id='" + key_id + '\'' +
                ", value='" + value + '\'' +
                ", version=" + version +
                '}';
    }
}
