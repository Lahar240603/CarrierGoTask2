package com.task2.carriergot2.repositories;

import com.task2.carriergot2.entities.DMSwitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DMSwitchRepository extends JpaRepository<DMSwitch, Long> {
}
