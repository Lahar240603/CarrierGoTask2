package com.task2.carriergot2.controllers;
import com.task2.carriergot2.dto.MediationRoutingDTO;
import com.task2.carriergot2.entities.MediationRouting;
import com.task2.carriergot2.services.IMediationRoutingService;
//import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private IMediationRoutingService mediationRoutingService;

    @GetMapping("/getAll")
//    @ApiOperation(value = "Get all routing mediation entries", produces = "application/json")
    public ResponseEntity<List<MediationRouting>> getAllMediationRoutings() {
        return new ResponseEntity<List<MediationRouting>>(mediationRoutingService.getAllMediationRoutings(), HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Add new routing mediation entry", produces = "application/json")
    public ResponseEntity<MediationRouting> addNewRoutingMediation(@RequestBody MediationRoutingDTO inputMediationRouting, HttpServletRequest request) {
        MediationRouting mediationRouting = mediationRoutingService.addNewRoutingMediation(inputMediationRouting);
        return new ResponseEntity<MediationRouting>(mediationRouting, HttpStatus.OK);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Update the routing mediation entry", produces = "application/json")
    public ResponseEntity<MediationRouting> updateMediationRouting(@RequestBody MediationRoutingDTO inputMediationRouting, HttpServletRequest request) {
        MediationRouting mediationRouting = mediationRoutingService.updateMediationRouting(inputMediationRouting);
        return new ResponseEntity<MediationRouting>(mediationRouting, HttpStatus.OK);
//        System.out.println("Inside");
//        return new ResponseEntity<MediationRouting>((MediationRouting) null, HttpStatus.OK);
    }

    @GetMapping("/audit/{id}")
//    @ApiOperation(value = "Get audit of the routing mediation entry by Id", produces = "application/json")
    public ResponseEntity<List<MediationRouting>> getAuditById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mediationRoutingService.getAuditById(id), HttpStatus.OK);
    }
}