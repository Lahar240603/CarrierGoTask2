package com.task2.carriergot2.service;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;

import java.util.List;
import java.util.Optional;

public interface iAmendServiceGetOrg {

    public List<AmendWorkOrderStateDecider> findByOrgCode(String orgCode);

    List<String> findAllTableOrgCodes(String token);
    List<String> findAllOrgCodes(String token);
}
