package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.service.UpdateServiceClone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UpdateServiceImplClone implements UpdateServiceClone {
    @Autowired
    private UpdateRepository updateRepository;

    @Override
    public List<UpdateWorkOrderStateDecider> cloneByOrgCodeUpdate(String sourceOrgCode, String newOrgCode, String username, List<UpdateWorkOrderStateDecider> updateList) {
        List<UpdateWorkOrderStateDecider> t = updateRepository.findAllByOrgCode(sourceOrgCode, Sort.by(Sort.Direction.ASC, "dbId"));
        List<UpdateWorkOrderStateDecider> fin = new ArrayList<UpdateWorkOrderStateDecider>();
        Collections.sort(updateList);
        int j = 0;
        for(UpdateWorkOrderStateDecider i : t) {
            UpdateWorkOrderStateDecider tempObject;
            if(updateList.size() !=0 && Objects.equals(i.getDbId(), updateList.get(j).getDbId())) {
                System.out.println("i.getDbId() = " + updateList.get(j).getDbId());
                tempObject =  i.getCloneUpdate(newOrgCode, username, updateList.get(j));
                fin.add(tempObject);
                if(j < updateList.size() - 1) {
                    j++;
                }
            } else {
                tempObject =  i.getCloneUpdate(newOrgCode, username, null);
            }
            fin.add(tempObject);
        }
        updateRepository.saveAllAndFlush(fin);
        return updateRepository.findAllByOrgCode(newOrgCode, Sort.by(Sort.Direction.ASC, "elementName"));
    }
}
