package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;

import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.service.iUpdateServiceGetOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/update")
public class UpdateControllerGetOrg {
    @Autowired
    private iUpdateServiceGetOrg updateService;

    @GetMapping("/{orgCode}")
    public List<UpdateWorkOrderStateDecider> getUpdateByOrgCode(@PathVariable("orgCode") String orgCode ){
        return updateService.findByOrgCode(orgCode);
    }
}
