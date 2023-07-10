package com.task2.carriergot2.repositories;

import com.task2.carriergot2.entities.AmendDecider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AmendDeciderRepository extends JpaRepository<AmendDecider, Long> {
    List<AmendDecider> findAllByOrgCode(String orgCode);

    @Query("SELECT DISTINCT a.orgCode FROM AmendDecider a")
    List<String> findDistinctOrgCode();

    Optional<AmendDecider> findByDbId(Long dbId);

    List<AmendDecider> findAllByElementName(String elementName);
}
