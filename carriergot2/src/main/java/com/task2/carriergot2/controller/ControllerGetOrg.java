package com.task2.carriergot2.controller;

import com.task2.carriergot2.service.iWorkOrderStateDeciderGetOrg;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UpdateAmendOrder")
public class ControllerGetOrg {

    @Autowired
    private iWorkOrderStateDeciderGetOrg service;

    @GetMapping("/{orgCode}")
    public WorkOrderStateDeciderRequest getOrgRequest (@PathVariable ("orgCode") String orgCode){
        return service.getOrgRequest(orgCode);
    }

}
