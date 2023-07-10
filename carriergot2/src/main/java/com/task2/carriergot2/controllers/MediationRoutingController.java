package com.task2.carriergot2.controllers;
import com.task2.carriergot2.entities.MediationRouting;
import com.task2.carriergot2.services.IMediationRoutingService;
//import io.swagger.annotations.ApiOperation;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/mediation-routing")
public class MediationRoutingController {

    public static final String USER_NAME = "userName";

    @Autowired
    private IMediationRoutingService mediationRoutingService;

    @GetMapping("/getAll")
//    @ApiOperation(value = "Get all routing mediation entries", produces = "application/json")
    public ResponseEntity<List<MediationRouting>> getAllMediationRoutings() {
        return new ResponseEntity<List<MediationRouting>>(mediationRoutingService.getAllMediationRoutings(), HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Add new routing mediation entry", produces = "application/json")
    public ResponseEntity<MediationRouting> addNewRoutingMediation(@RequestBody MediationRouting inputMediationRouting, HttpServletRequest request) {
        inputMediationRouting.setLastModifiedBy(MDC.get(USER_NAME));
        MediationRouting mediationRouting = mediationRoutingService.addNewRoutingMediation(inputMediationRouting, MDC.get(USER_NAME));
        return new ResponseEntity<MediationRouting>(mediationRouting, HttpStatus.OK);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Update the routing mediation entry", produces = "application/json")
    public ResponseEntity<MediationRouting> updateMediationRouting(@RequestBody MediationRouting inputMediationRouting, HttpServletRequest request) {
        inputMediationRouting.setLastModifiedBy(MDC.get(USER_NAME));
        MediationRouting mediationRouting = mediationRoutingService.updateMediationRouting(inputMediationRouting, MDC.get(USER_NAME));
        return new ResponseEntity<MediationRouting>(mediationRouting, HttpStatus.OK);
    }

    @GetMapping("/audit/{id}")
//    @ApiOperation(value = "Get audit of the routing mediation entry by Id", produces = "application/json")
    public ResponseEntity<List<MediationRouting>> getAuditById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mediationRoutingService.getAuditById(id), HttpStatus.OK);
    }
}