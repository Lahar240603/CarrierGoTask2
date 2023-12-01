package com.task2.carriergot2.controllers;
import com.task2.carriergot2.dto.DeciderConfigurationAddElementRequest;
import com.task2.carriergot2.dto.DeciderConfigurationCreateDTO;
import com.task2.carriergot2.dto.DeciderConfigurationDTO;
import com.task2.carriergot2.dto.DeciderConfigurationModifyDTO;
import com.task2.carriergot2.services.IDeciderConfigurationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/decider-configuration")
public class DeciderConfigurationController {

    public static final String USER_NAME = "userName";

    @Autowired
    private IDeciderConfigurationService iDeciderConfigurationService;

    @GetMapping("/get/{orgCode}")
    public DeciderConfigurationDTO getDeciderConfigurationByOrgCode (@PathVariable("orgCode") String orgCode) {
        return iDeciderConfigurationService.getDeciderConfigurationByOrgCode(orgCode);
    }

    @GetMapping("/getaudit/{type}/{id}")
    public List<?> getAudit(@PathVariable("type") String type, @PathVariable("id") Long id) {
        return iDeciderConfigurationService.getAudit(type, id);
    }

    @PutMapping("/addconfiguration")
    public DeciderConfigurationDTO addConfiguration(@RequestBody DeciderConfigurationCreateDTO deciderConfigurationCreateDTO, HttpServletRequest request) {
        return iDeciderConfigurationService.addConfiguration(deciderConfigurationCreateDTO);
    }

    @PutMapping("/update/{orgCode}")
    public DeciderConfigurationDTO updateDeciderConfiguration(@RequestBody DeciderConfigurationModifyDTO deciderConfigurationModifyDTO, HttpServletRequest request) {

        return iDeciderConfigurationService.modifyConfiguration(deciderConfigurationModifyDTO);
    }

    @PutMapping("/add-element")
    public DeciderConfigurationDTO addElement(@RequestBody DeciderConfigurationAddElementRequest deciderConfigurationAddElementRequest, HttpServletRequest request) {
        return iDeciderConfigurationService.addElement(deciderConfigurationAddElementRequest.getAmendDecider(), deciderConfigurationAddElementRequest.getUpdateDecider());
    }
}