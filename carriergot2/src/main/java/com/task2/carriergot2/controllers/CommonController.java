package com.task2.carriergot2.controllers;
import com.task2.carriergot2.services.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    public ICommonService commonService;

    @GetMapping("/get/existing-orgcodes")
    public List<String> getAllExistingOrgCodes() {
        return commonService.getAllExistingOrgCodes();
    }

    @GetMapping("/get/allorgcodes")
    public List<String> getAllOrgCodes(){
        return commonService.findAllOrgCodes();
    }

}
