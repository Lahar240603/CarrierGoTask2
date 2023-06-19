package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import com.task2.carriergot2.service.AmendServiceClone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmendServiceImplClone implements AmendServiceClone {
    @Autowired
    private AmendRepository amendRepository;

    @Override
    public List<AmendWorkOrderStateDecider> cloneByOrgCodeAmend(String sourceOrgCode, String newOrgCode, String username) {
        List<AmendWorkOrderStateDecider> t = amendRepository.findAllByOrgCode(sourceOrgCode, Sort.by(Sort.Direction.ASC, "elementName"));
        List<AmendWorkOrderStateDecider> fin = new ArrayList<AmendWorkOrderStateDecider>();
        for(AmendWorkOrderStateDecider i : t) {
            AmendWorkOrderStateDecider tempObject =  i.getCloneAmend(newOrgCode, username);
            fin.add(tempObject);
        }
        return amendRepository.saveAllAndFlush(fin);
    }
}
