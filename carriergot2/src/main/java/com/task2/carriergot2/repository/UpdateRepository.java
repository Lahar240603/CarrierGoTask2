package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateRepository extends JpaRepository<UpdateWorkOrderStateDecider, Long> {

}
