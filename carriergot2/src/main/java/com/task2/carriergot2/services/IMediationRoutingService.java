package com.task2.carriergot2.services;

import com.task2.carriergot2.entities.MediationRouting;

import java.util.List;

public interface IMediationRoutingService {

    public List<MediationRouting> getAllMediationRoutings();

    public MediationRouting addNewRoutingMediation(MediationRouting instance);

    public MediationRouting updateMediationRouting(MediationRouting instance);

    List<MediationRouting> getAuditById(Long Id);
}