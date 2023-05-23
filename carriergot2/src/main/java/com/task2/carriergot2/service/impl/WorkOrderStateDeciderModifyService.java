package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.service.iAmendWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.service.iUpdateWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.service.iWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.utils.WorkOrderStateDeciderUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

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
    public WorkOrderStateDeciderUpdateRequest updateRequest(WorkOrderStateDeciderUpdateRequest request) {
//        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        List<UpdateWorkOrderStateDecider> updatedUpdateState = updateService.updateUpdatedecider(request.getUpdateList());

        List<AmendWorkOrderStateDecider> updatedAmendState = amendService.updateAmendState(request.getAmendList());

        return new WorkOrderStateDeciderUpdateRequest(updatedAmendState , updatedUpdateState);
    }
}
