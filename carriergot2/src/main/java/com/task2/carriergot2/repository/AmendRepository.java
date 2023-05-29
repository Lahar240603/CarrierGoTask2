package com.task2.carriergot2.repository;
import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AmendRepository extends JpaRepository<AmendWorkOrderStateDecider, Long> {
    public List<AmendWorkOrderStateDecider> findAllByOrgCode(String orgCode);

    @Query("SELECT DISTINCT a.orgCode FROM AmendWorkOrderStateDecider a")
    List<String> findDistinctOrgCode();

    public Optional<AmendWorkOrderStateDecider> findByDbId(Long dbId);
}
