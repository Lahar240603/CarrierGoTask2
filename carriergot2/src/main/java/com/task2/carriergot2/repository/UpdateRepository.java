package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UpdateRepository extends JpaRepository<UpdateWorkOrderStateDecider, Long> {
    public List<UpdateWorkOrderStateDecider> findAllByOrgCode(String orgCode, Sort sort);

    public Optional<UpdateWorkOrderStateDecider> findByDbId(Long dbId);

    public List<UpdateWorkOrderStateDecider> findAllByElementName(String elementName);
}
