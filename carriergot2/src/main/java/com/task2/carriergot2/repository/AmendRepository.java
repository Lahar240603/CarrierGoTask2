package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmendRepository extends JpaRepository<AmendWorkOrderStateDecider, Long> {
    public List<AmendWorkOrderStateDecider> findAllByOrgCode(String orgCode);

}
