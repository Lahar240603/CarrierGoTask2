package com.task2.carriergot2.MediationTest;

import com.task2.carriergot2.entities.MediationRouting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediationTestRepository extends JpaRepository<MediationRouting, Long> {

    MediationRouting findByKeyId(String KeyId);
}
