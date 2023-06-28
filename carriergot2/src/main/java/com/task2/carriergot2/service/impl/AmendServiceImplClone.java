package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import com.task2.carriergot2.service.AmendServiceClone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class AmendServiceImplClone implements AmendServiceClone {
    @Autowired
    private AmendRepository amendRepository;

    @Override
    public List<AmendWorkOrderStateDecider> cloneByOrgCodeAmend(String sourceOrgCode, String newOrgCode, String username, List<AmendWorkOrderStateDecider> amendList) {
        List<AmendWorkOrderStateDecider> t = amendRepository.findAllByOrgCode(sourceOrgCode, Sort.by(Sort.Direction.ASC, "dbId"));
        List<AmendWorkOrderStateDecider> fin = new ArrayList<AmendWorkOrderStateDecider>();
        Collections.sort(amendList);
        int j = 0;
        for(AmendWorkOrderStateDecider i : t) {
            AmendWorkOrderStateDecider tempObject;
            if(amendList.size() != 0 && Objects.equals(i.getDbId(), amendList.get(j).getDbId())) {
                tempObject =  i.getCloneAmend(newOrgCode, username, amendList.get(j));
                fin.add(tempObject);
                if(j < amendList.size() - 1) {
                    j++;
                }

            } else {
                tempObject =  i.getCloneAmend(newOrgCode, username, null);
            }
            fin.add(tempObject);
        }
        amendRepository.saveAllAndFlush(fin);

        return amendRepository.findAllByOrgCode(newOrgCode, Sort.by(Sort.Direction.ASC, "elementName"));
    }
}
