package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.exceptions.UpdateWorkOrderStateDeciderNotFoundException;
import com.task2.carriergot2.exceptions.WorkOrderStateDeciderIdMissing;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.MasterUserAuditRepository;
import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.service.iUpdateWorkOrderStateDeciderModifyService;
import com.task2.carriergot2.service.iWorkOrderStateDeciderGetOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateWorkOrderStateDeciderModifyService implements iUpdateWorkOrderStateDeciderModifyService {

    @Autowired
    private MasterUserAuditRepository userAudit;

    @Autowired
    private UpdateRepository repository;

    @Autowired
    private iWorkOrderStateDeciderGetOrg orgCodeService;

    @Override
    public List<UpdateWorkOrderStateDecider> updateUpdatedecider(List<UpdateWorkOrderStateDecider> updatedState, String orgCode, String username) {
        List<UpdateWorkOrderStateDecider> updatedList = new ArrayList<UpdateWorkOrderStateDecider>();
        for(UpdateWorkOrderStateDecider u : updatedState) {
            if(u.getDbId() == null) {
                throw new WorkOrderStateDeciderIdMissing("UpdateWorkOrderState");
            }
            UpdateWorkOrderStateDecider tempState =  repository.findByDbId(u.getDbId()).orElseThrow(() -> new UpdateWorkOrderStateDeciderNotFoundException(u.getDbId()));
            tempState.updateUpdateWorkOrderStateDecider(u,username, userAudit);
            repository.save(tempState);
            updatedList.add(tempState);
        }
        return repository.findAllByOrgCode(orgCode, Sort.by(Sort.Direction.ASC, "elementName"));
    }

    @Override
    public List<UpdateWorkOrderStateDecider> addUpdate(UpdateWorkOrderStateDecider newUpdate, String username, String token) {
        List<String> orgCodes = orgCodeService.findAllOrgCodes(token);
        String elementName = newUpdate.getElementName();
//        List<UpdateWorkOrderStateDecider> fin = new ArrayList<UpdateWorkOrderStateDecider>();
        if(newUpdate.getDbId()==null) {
            for(String orgCode : orgCodes) {
                UpdateWorkOrderStateDecider tempState = newUpdate.getCloneUpdate(orgCode, username, null);
                repository.save(tempState);
            }
        }
        return repository.findAllByElementName(elementName);
    }
}
