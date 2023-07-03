package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.service.iWorkOrderStateDeciderGetOrg;
import com.task2.carriergot2.service.impl.WorkOrderStateDeciderGetOrg;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/UpdateAmendOrder")
public class ControllerGetOrg {

    @Autowired
    private iWorkOrderStateDeciderGetOrg service;

    @GetMapping("/tableOrgCodes")
    public List<String> getAllTableOrgCodes(@RequestHeader("Authorization") String token){
        return service.findAllTableOrgCodes(token);
    }

    @GetMapping("/orgCodes")
    public List<String> getAllOrgCodes(@RequestHeader("Authorization") String token){
        return service.findAllOrgCodes(token);
    }

    @GetMapping("/{orgCode}")
    public WorkOrderStateDeciderRequest getOrgRequest (@PathVariable ("orgCode") String orgCode){
        return service.getOrgRequest(orgCode);
    }

    @GetMapping("/update/audit/{id}")
    public List<?> getUpdateAudit(@PathVariable("id") Long id) {
        return service.getUpdateAudit(id);
    }

    @GetMapping("/amend/audit/{id}")
    public List<?> getAmendAudit(@PathVariable("id") Long id) {
        return service.getAmendAudit(id);
    }
}
