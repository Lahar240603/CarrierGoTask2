package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
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

    @PutMapping("/addElement")
        public WorkOrderStateDeciderRequest addRequest(@RequestBody WorkOrderStateDeciderRequest request, @RequestAttribute("username") String username) {
        AmendWorkOrderStateDecider newAmend = request.getAmendList().get(0);
        UpdateWorkOrderStateDecider newUpdate = request.getUpdateList().get(0);
        return service.addRequest(newAmend, newUpdate, username);
    }
}
