package com.task2.carriergot2.controller;

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

    @GetMapping("/orgCodes")
    public List<String> getAllOrgCodes(@RequestHeader("Authorization") String token){
        return service.findAllOrgCodes(token);
    }

    @GetMapping("/{orgCode}")
    public WorkOrderStateDeciderRequest getOrgRequest (@PathVariable ("orgCode") String orgCode){
        return service.getOrgRequest(orgCode);
    }

}
