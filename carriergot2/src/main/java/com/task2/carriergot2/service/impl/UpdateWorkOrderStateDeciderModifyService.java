package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.service.iUpdateWorkOrderStateDeciderModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateWorkOrderStateDeciderModifyService implements iUpdateWorkOrderStateDeciderModifyService {

    @Autowired
    private UpdateRepository repository;

    @Override
    public List<UpdateWorkOrderStateDecider> updateUpdatedecider(List<UpdateWorkOrderStateDecider> updatedState) {
        List<UpdateWorkOrderStateDecider> updatedList = new ArrayList<UpdateWorkOrderStateDecider>();
        for(UpdateWorkOrderStateDecider u : updatedState) {
            UpdateWorkOrderStateDecider tempState =  repository.findByDbId(u.getDbId());
            tempState.updateUpdateWorkOrderStateDecider(u);
            repository.save(tempState);
            updatedList.add(tempState);
        }
        return updatedList;
    }
}
