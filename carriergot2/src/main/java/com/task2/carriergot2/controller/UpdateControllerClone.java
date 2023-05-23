package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UpdateControllerClone {
    @Autowired
    private UpdateRepository updateRepository;

    @PostMapping("/update")
    UpdateWorkOrderStateDecider newUpdate(@RequestBody UpdateWorkOrderStateDecider newUpdate) {
        return updateRepository.save(newUpdate);
    }

    @GetMapping("/updates")
    List<UpdateWorkOrderStateDecider> getAllUpdates() {
        return updateRepository.findAll();
    }
}
