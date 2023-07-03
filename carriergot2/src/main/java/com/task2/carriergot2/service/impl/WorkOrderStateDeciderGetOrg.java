package com.task2.carriergot2.service.impl;


import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.service.iAmendServiceGetOrg;
import com.task2.carriergot2.service.iUpdateServiceGetOrg;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task2.carriergot2.service.iWorkOrderStateDeciderGetOrg;

import java.util.List;

@Service
public class WorkOrderStateDeciderGetOrg implements iWorkOrderStateDeciderGetOrg {

    @Autowired
    private iAmendServiceGetOrg amendedService ;

    @Autowired
    private iUpdateServiceGetOrg updatedService;

    @Autowired
    private AuditReader auditReader;


    @Override
//    @Transactional
    public WorkOrderStateDeciderRequest getOrgRequest(String getOrg){
        List<UpdateWorkOrderStateDecider> updatedByOrgCode = updatedService.findByOrgCode(getOrg);
        List<AmendWorkOrderStateDecider> amendedByOrgCode = amendedService.findByOrgCode(getOrg);

        return new WorkOrderStateDeciderRequest(amendedByOrgCode , updatedByOrgCode);
    }

    @Override
    public List<String> findAllTableOrgCodes(String token) {
        return amendedService.findAllTableOrgCodes();
    }

    @Override
    public List<String> findAllOrgCodes(String token) {
        return amendedService.findAllOrgCodes(token);
    }

    @Override
    public List<?> getUpdateAudit(Long id) {
        return auditReader.createQuery()
                .forRevisionsOfEntity(UpdateWorkOrderStateDecider.class, true, true)
                .add(AuditEntity.id().eq(id))
                .getResultList();
    }

    @Override
    public List<?> getAmendAudit(Long id) {
        return auditReader.createQuery()
                .forRevisionsOfEntity(AmendWorkOrderStateDecider.class, true, true)
                .add(AuditEntity.id().eq(id))
                .getResultList();
    }


}
