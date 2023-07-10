package com.task2.carriergot2.repositories;

import com.task2.carriergot2.entities.UpdateDecider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UpdateDeciderRepository extends JpaRepository<UpdateDecider, Long> {
    List<UpdateDecider> findAllByOrgCode(String orgCode);
}
