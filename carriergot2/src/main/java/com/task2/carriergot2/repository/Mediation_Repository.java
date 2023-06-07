package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.Mediation_routing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface Mediation_Repository extends JpaRepository<Mediation_routing, BigInteger> {
    // public List<Mediation_routing> findByKeyId(String key_id);
}
