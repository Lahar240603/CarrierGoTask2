package com.task2.carriergot2.service;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;

import java.util.List;

public interface iUpdateWorkOrderStateDeciderModifyService {
    public List<UpdateWorkOrderStateDecider> updateUpdatedecider(List<UpdateWorkOrderStateDecider> updatedState, String orgCode, String username);

    List<UpdateWorkOrderStateDecider> addUpdate(UpdateWorkOrderStateDecider newUpdate, String username, String token);
}
