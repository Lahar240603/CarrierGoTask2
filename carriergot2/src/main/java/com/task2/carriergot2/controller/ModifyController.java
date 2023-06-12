package com.task2.carriergot2.controller;

import com.task2.carriergot2.service.iWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/workorderstate")
public class ModifyController {

    @Autowired
    private iWorkOrderStateDeciderModifyService service;

    @PutMapping("/update/{orgCode}")
    public WorkOrderStateDeciderRequest updateRequest(@RequestBody WorkOrderStateDeciderRequest request, @PathVariable("orgCode") String orgCode, @RequestAttribute("username") String username) {
        return service.updateRequest(request, orgCode, username);
    }
}
