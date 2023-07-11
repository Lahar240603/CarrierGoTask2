package com.task2.carriergot2.controllers;
import com.task2.carriergot2.entities.DMSwitch;
import com.task2.carriergot2.services.IDMSwitchService;
//import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/dm-switches")
public class DMSwitchController {

    public static final String USER_NAME = "userName";
    @Autowired
    private IDMSwitchService dmSwitchService;

    @GetMapping("/getAll")
//    @ApiOperation(value = "Get all DM Switches ", produces = "application/json")
    public ResponseEntity<List<DMSwitch>> getAllDMSwitches() {
        return new ResponseEntity<List<DMSwitch>>(dmSwitchService.getAllDMSwitches(), HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Add new DM Switch", produces = "application/json")
    public ResponseEntity<DMSwitch> addNewDMSwitch(@RequestBody DMSwitch inputDMSwitch, HttpServletRequest request) {
        DMSwitch dmSwitch = dmSwitchService.addNewDMSwitch(inputDMSwitch);
        return new ResponseEntity<DMSwitch>(dmSwitch, HttpStatus.OK);
    }

    @PutMapping("/update")
//    @ApiOperation(value = "Update DM Switch status", produces = "application/json")
    public ResponseEntity<DMSwitch> updateSwitch(@RequestBody DMSwitch switchTobeUpdated, HttpServletRequest request) {
        DMSwitch updatedSwitch = dmSwitchService.updateSwitch(switchTobeUpdated);
        return new ResponseEntity<>(updatedSwitch, HttpStatus.OK);
    }

}




