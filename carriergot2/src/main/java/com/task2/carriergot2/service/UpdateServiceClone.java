package com.task2.carriergot2.service;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;

import java.util.List;

public interface UpdateServiceClone {
    public List<UpdateWorkOrderStateDecider> cloneByOrgCodeUpdate(String sourceOrgCode, String newOrgCode, String username);
}
