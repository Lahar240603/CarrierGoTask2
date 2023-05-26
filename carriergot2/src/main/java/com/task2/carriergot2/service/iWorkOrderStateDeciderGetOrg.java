package com.task2.carriergot2.service;

import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;

import javax.transaction.Transactional;

public interface iWorkOrderStateDeciderGetOrg {

    public WorkOrderStateDeciderRequest getOrgRequest(String getOrg);

}
