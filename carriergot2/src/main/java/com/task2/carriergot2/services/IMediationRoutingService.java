package com.task2.carriergot2.services;

import com.task2.carriergot2.dto.MediationRoutingDTO;
import com.task2.carriergot2.entities.MediationRouting;

import java.util.List;

public interface IMediationRoutingService {

    public List<MediationRouting> getAllMediationRoutings();

    public MediationRouting addNewRoutingMediation(MediationRoutingDTO instance);

    public MediationRouting updateMediationRouting(MediationRoutingDTO instance);

    List<MediationRouting> getAuditById(Long Id);
}