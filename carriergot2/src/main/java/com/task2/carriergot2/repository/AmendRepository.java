package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmendRepository extends JpaRepository<AmendWorkOrderStateDecider, Long> {
}
