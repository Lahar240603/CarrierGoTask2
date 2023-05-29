package com.task2.carriergot2.service;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.service.impl.WorkOrderStateDeciderGetOrg;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;

import javax.transaction.Transactional;
import java.util.List;

public interface iWorkOrderStateDeciderGetOrg {

    public WorkOrderStateDeciderRequest getOrgRequest(String getOrg);

    List<String> findAllOrgCodes();
}
