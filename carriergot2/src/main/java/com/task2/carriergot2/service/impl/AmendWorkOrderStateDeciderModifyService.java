package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.exceptions.AmendWorkOrderStateDeciderNotFoundException;
import com.task2.carriergot2.exceptions.WorkOrderStateDeciderIdMissing;
import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import com.task2.carriergot2.repository.MasterUserAuditRepository;
import com.task2.carriergot2.service.iAmendWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.service.iWorkOrderStateDeciderGetOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmendWorkOrderStateDeciderModifyService implements iAmendWorkOrderStateDeciderModifyService {

    @Autowired
    private MasterUserAuditRepository userAudit;

    @Autowired
    AmendRepository repository;

    @Autowired
    private iWorkOrderStateDeciderGetOrg orgCodeService;
    
    @Override
    public List<AmendWorkOrderStateDecider> updateAmendState(List<AmendWorkOrderStateDecider> updatedState, String orgCode, String username) {
        List<AmendWorkOrderStateDecider> updatedList = new ArrayList<AmendWorkOrderStateDecider>();
        for(AmendWorkOrderStateDecider u : updatedState) {
            if(u.getDbId() == null) {
                throw new WorkOrderStateDeciderIdMissing("AmendWorkOrderState");
            }
            AmendWorkOrderStateDecider tempState =  repository.findByDbId(u.getDbId()).orElseThrow(() -> new AmendWorkOrderStateDeciderNotFoundException(u.getDbId()));
            tempState.updateAmendWorkOrderStateDecider(u, username,userAudit);
            repository.save(tempState);
            updatedList.add(tempState);
        }

        return repository.findAllByOrgCode(orgCode, Sort.by(Sort.Direction.ASC, "elementName"));
    }

    @Override
    public List<AmendWorkOrderStateDecider> addAmend(AmendWorkOrderStateDecider newAmend, String username, String token) {
        List<String> orgCodes = orgCodeService.findAllOrgCodes(token);
        String elementName = newAmend.getElementName();
//        List<AmendWorkOrderStateDecider> fin = new ArrayList<AmendWorkOrderStateDecider>();
        if(newAmend.getDbId()==null) {
            for(String orgCode : orgCodes) {
                AmendWorkOrderStateDecider tempState = newAmend.getCloneAmend(orgCode, username, null);
                repository.save(tempState);
            }
        }
        return repository.findAllByElementName(elementName);
    }

}
