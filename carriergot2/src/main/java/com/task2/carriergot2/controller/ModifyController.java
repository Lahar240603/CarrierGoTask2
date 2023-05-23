package com.task2.carriergot2.controller;

import com.task2.carriergot2.service.iWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workorderstate")
public class ModifyController {

    @Autowired
    private iWorkOrderStateDeciderModifyService service;

    @PutMapping("/update")
    public WorkOrderStateDeciderRequest updateRequest(@RequestBody WorkOrderStateDeciderRequest request) {
        return service.updateRequest(request);
    }
}
