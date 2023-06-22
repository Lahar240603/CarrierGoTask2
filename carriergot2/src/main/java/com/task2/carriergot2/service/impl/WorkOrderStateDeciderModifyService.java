package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.service.iAmendWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.service.iUpdateWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.service.iWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WorkOrderStateDeciderModifyService implements iWorkOrderStateDeciderModifyService {

    @Autowired
    private iUpdateWorkOrderStateDeciderModifyService updateService;

    @Autowired
    private iAmendWorkOrderStateDeciderModifyService amendService;

    @Override
    @Transactional
    public WorkOrderStateDeciderRequest updateRequest(WorkOrderStateDeciderRequest request, String orgCode, String username) {
//        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        List<UpdateWorkOrderStateDecider> updatedUpdateState = updateService.updateUpdatedecider(request.getUpdateList() , orgCode, username);

        List<AmendWorkOrderStateDecider> updatedAmendState = amendService.updateAmendState(request.getAmendList(), orgCode, username);

        return new WorkOrderStateDeciderRequest(updatedAmendState , updatedUpdateState);
    }

    @Override
    @Transactional
    public WorkOrderStateDeciderRequest addRequest(AmendWorkOrderStateDecider newAmend, UpdateWorkOrderStateDecider newUpdate, String username, String token) {
        List<UpdateWorkOrderStateDecider> newUpdateState = updateService.addUpdate(newUpdate, username, token);
        List<AmendWorkOrderStateDecider> newAmendState = amendService.addAmend(newAmend, username, token);
        return new WorkOrderStateDeciderRequest(newAmendState, newUpdateState);
    }
}
