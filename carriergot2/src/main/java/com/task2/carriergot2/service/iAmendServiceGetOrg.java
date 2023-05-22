package com.task2.carriergot2.service;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;

import java.util.List;

public interface iAmendServiceGetOrg {

    public List<AmendWorkOrderStateDecider> findByOrgCode(String orgCode);
}
