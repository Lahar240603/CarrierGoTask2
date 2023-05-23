package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;

import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.service.UpdateServiceClone;
import com.task2.carriergot2.service.iUpdateServiceGetOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/updates")
public class UpdateControllerClone {
    @Autowired
    private UpdateServiceClone updateServiceClone;

    @PostMapping("/cloneUpdate/{sourceOrgCode}/{newOrgCode}")
    public List<UpdateWorkOrderStateDecider> cloneByOrgCodeUpdate(@PathVariable("sourceOrgCode") String sourceOrgCode, @PathVariable("newOrgCode") String newOrgCode){
        return updateServiceClone.cloneByOrgCodeUpdate(sourceOrgCode, newOrgCode);
    }
}
