package com.task2.carriergot2.service;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;

import java.util.List;

public interface iAmendWorkOrderStateDeciderModifyService {
    public List<AmendWorkOrderStateDecider> updateAmendState(List<AmendWorkOrderStateDecider> updatedState, String orgCode);
}
