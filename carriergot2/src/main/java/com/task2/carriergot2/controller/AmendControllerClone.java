package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;

import com.task2.carriergot2.repository.AmendRepository;
import com.task2.carriergot2.service.AmendServiceClone;
import com.task2.carriergot2.service.iAmendServiceGetOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amends")
public class AmendControllerClone {
    @Autowired
    private AmendServiceClone amendServiceClone;

    @PostMapping("/cloneAmend/{sourceOrgCode}/{newOrgCode}")
    public List<AmendWorkOrderStateDecider> cloneByOrgCodeAmend(@PathVariable("sourceOrgCode") String sourceOrgCode, @PathVariable("newOrgCode") String newOrgCode){
        return amendServiceClone.cloneByOrgCodeAmend(sourceOrgCode, newOrgCode);
    }
}
