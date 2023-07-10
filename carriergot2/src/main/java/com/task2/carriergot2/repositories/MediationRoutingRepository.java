package com.task2.carriergot2.repositories;
import com.task2.carriergot2.entities.MediationRouting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediationRoutingRepository extends JpaRepository<MediationRouting, Long> {
}