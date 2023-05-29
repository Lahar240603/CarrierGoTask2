package com.task2.carriergot2.service;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;

import java.util.List;

public interface iUpdateServiceGetOrg {

    public List<UpdateWorkOrderStateDecider> findByOrgCode(String orgCode);


}
