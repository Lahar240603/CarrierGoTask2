package com.task2.carriergot2.service;

import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;

import java.util.List;

public interface iWorkOrderStateDeciderCloneService {
    public WorkOrderStateDeciderRequest cloneRequest(String sourceOrgCode, String newOrgCode, String username);
}
