package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.enums.UpdateWorkOrderStateDeciderEnum;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.service.UpdateServiceClone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateServiceImplClone implements UpdateServiceClone {
    @Autowired
    private UpdateRepository updateRepository;

    @Override
    public List<UpdateWorkOrderStateDecider> cloneByOrgCodeUpdate(String sourceOrgCode, String newOrgCode, String username) {
        List<UpdateWorkOrderStateDecider> t = updateRepository.findAllByOrgCode(sourceOrgCode);
        List<UpdateWorkOrderStateDecider> fin = new ArrayList<UpdateWorkOrderStateDecider>();
        for(UpdateWorkOrderStateDecider i : t) {
            UpdateWorkOrderStateDecider tempObject =  i.getCloneUpdate(newOrgCode, username);
            fin.add(tempObject);
        }
        return updateRepository.saveAllAndFlush(fin);
    }
}
