package com.task2.carriergot2.service;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;

import java.util.List;

public interface AmendServiceClone {
    public List<AmendWorkOrderStateDecider> cloneByOrgCodeAmend(String sourceOrgCode, String newOrgCode, String username);
}