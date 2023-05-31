package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.service.AmendServiceClone;
import com.task2.carriergot2.service.UpdateServiceClone;
import com.task2.carriergot2.service.iUpdateWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.service.iWorkOrderStateDeciderCloneService;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkOrderStateDeciderCloneService implements iWorkOrderStateDeciderCloneService{
    @Autowired
    private UpdateServiceClone updateService;

    @Autowired
    private AmendServiceClone amendService;

    @Override
    @Transactional
    public WorkOrderStateDeciderRequest cloneRequest(String sourceOrgCode, String newOrgCode) {
        List<UpdateWorkOrderStateDecider> t = updateService.cloneByOrgCodeUpdate(sourceOrgCode, newOrgCode);
        List<AmendWorkOrderStateDecider> t1 = amendService.cloneByOrgCodeAmend(sourceOrgCode, newOrgCode);

        return new WorkOrderStateDeciderRequest(t1 , t);
    }
}
