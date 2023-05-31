package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.exceptions.AmendWorkOrderStateDeciderNotFoundException;
import com.task2.carriergot2.exceptions.WorkOrderStateDeciderIdMissing;
import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import com.task2.carriergot2.service.iAmendWorkOrderStateDeciderModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmendWorkOrderStateDeciderModifyService implements iAmendWorkOrderStateDeciderModifyService {
    
    @Autowired
    AmendRepository repository;
    
    @Override
    public List<AmendWorkOrderStateDecider> updateAmendState(List<AmendWorkOrderStateDecider> updatedState, String orgCode) {
        List<AmendWorkOrderStateDecider> updatedList = new ArrayList<AmendWorkOrderStateDecider>();
        for(AmendWorkOrderStateDecider u : updatedState) {
            if(u.getDbId() == null) {
                throw new WorkOrderStateDeciderIdMissing("AmendWorkOrderState");
            }
            AmendWorkOrderStateDecider tempState =  repository.findByDbId(u.getDbId()).orElseThrow(() -> new AmendWorkOrderStateDeciderNotFoundException(u.getDbId()));
            tempState.updateAmendWorkOrderStateDecider(u);
            repository.save(tempState);
            updatedList.add(tempState);
        }

        return repository.findAllByOrgCode(orgCode);
    }
}
