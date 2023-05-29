package com.task2.carriergot2.controller;


import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.service.iAmendServiceGetOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/amend")
public class AmendControllerGetOrg {

    @Autowired
    private iAmendServiceGetOrg amendService;

    @GetMapping("/{orgCode}")
    public List<AmendWorkOrderStateDecider> getAmendByOrgCode(@PathVariable("orgCode") String orgCode ){
        return amendService.findByOrgCode(orgCode);
    }

}


