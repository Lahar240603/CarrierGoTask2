package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateRepository extends JpaRepository<UpdateWorkOrderStateDecider, Long> {
    public List<UpdateWorkOrderStateDecider> findAllByOrgCode(String orgCode);

    public UpdateWorkOrderStateDecider findByDbId(Long dbId);
}
