package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.service.UpdateServiceClone;
import com.task2.carriergot2.service.iWorkOrderStateDeciderCloneService;
import com.task2.carriergot2.service.iWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000") 
@RequestMapping("/clone")
public class CloneController {

    @Autowired
    private iWorkOrderStateDeciderCloneService service;

    @PutMapping("/{sourceOrgCode}/{newOrgCode}")
    public WorkOrderStateDeciderRequest cloneRequest(@PathVariable("sourceOrgCode") String sourceOrgCode, @PathVariable("newOrgCode") String newOrgCode) {
        return service.cloneRequest(sourceOrgCode, newOrgCode);
    }
}
