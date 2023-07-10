package com.task2.carriergot2.services.impl;

import com.task2.carriergot2.entities.MediationRouting;
import com.task2.carriergot2.repositories.MediationRoutingRepository;
import com.task2.carriergot2.services.IMediationRoutingService;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MediationRoutingServiceImpl implements IMediationRoutingService{


    @Autowired
    private MediationRoutingRepository mediationRoutingRepository;

    @Autowired
    private AuditReader auditReader;

    @Override
    public List<MediationRouting> getAllMediationRoutings() {
        return mediationRoutingRepository.findAll();
    }

    @Override
    public MediationRouting addNewRoutingMediation(MediationRouting mediationRouting, String username) {
        return mediationRoutingRepository.save(mediationRouting);
    }

    @Override
    public MediationRouting updateMediationRouting(MediationRouting mediationRouting, String username) {
        MediationRouting existingMediationRouting = mediationRoutingRepository.findById(mediationRouting.getId()).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        existingMediationRouting.setValue(mediationRouting.getValue());
        existingMediationRouting.setVersion(mediationRouting.getVersion() + 1);
        existingMediationRouting.setLastModified(LocalDateTime.now());
        return mediationRoutingRepository.save(existingMediationRouting);
    }

    @Override
    public List<MediationRouting> getAuditById(Long Id) {
        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(MediationRouting.class, true, true)
                .add(AuditEntity.id().eq(Id));
        return auditQuery.getResultList();
    }

}