package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.MasterUserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterUserAuditRepository extends JpaRepository <MasterUserAudit, Long>{
}

