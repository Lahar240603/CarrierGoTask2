package com.task2.carriergot2.repositories;

import com.task2.carriergot2.entities.AmendDecider;
import com.task2.carriergot2.entities.UpdateDecider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UpdateDeciderRepository extends JpaRepository<UpdateDecider, Long> {
    List<UpdateDecider> findAllByOrgCode(String orgCode);

    Optional<UpdateDecider> findByDbId(Long dbId);
}
