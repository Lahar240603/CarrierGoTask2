package com.task2.carriergot2.services.impl;

import com.task2.carriergot2.dto.MediationRoutingDTO;
import com.task2.carriergot2.entities.MediationRouting;
import com.task2.carriergot2.repositories.MediationRoutingRepository;
import com.task2.carriergot2.services.IMediationRoutingService;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public MediationRouting addNewRoutingMediation(MediationRoutingDTO mediationRoutingdto) {
        if(mediationRoutingRepository.findByKeyId(mediationRoutingdto.getKeyId())!=null){
            return null;
        }
        return mediationRoutingRepository.save(mediationRoutingdto.buildEntity(0L, null, null, null));
    }

    @Override
    public MediationRouting updateMediationRouting( MediationRoutingDTO mediationRoutingdto) {
            MediationRouting existingMediationRouting = mediationRoutingRepository.findByKeyId(mediationRoutingdto.getKeyId());
            return mediationRoutingRepository.save(mediationRoutingdto.buildEntity(existingMediationRouting.getVersion() + 1, existingMediationRouting.getId(), existingMediationRouting.getCreatedBy(), existingMediationRouting.getCreationTime()));
    }

    @Override
    public List<MediationRouting> getAuditById(Long Id) {
        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(MediationRouting.class, true, true)
                .add(AuditEntity.id().eq(Id));
        return auditQuery.getResultList();
    }

}