package com.task2.carriergot2.services.impl;

import com.task2.carriergot2.dto.DeciderConfigurationDTO;
import com.task2.carriergot2.entities.AmendDecider;
import com.task2.carriergot2.entities.UpdateDecider;
import com.task2.carriergot2.repositories.AmendDeciderRepository;
import com.task2.carriergot2.repositories.UpdateDeciderRepository;
import com.task2.carriergot2.services.ICommonService;
import com.task2.carriergot2.services.IDeciderConfigurationService;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeciderConfigurationService implements IDeciderConfigurationService {
    public static final String UPDATE = "update";
    public static final String USER_NAME = "userName";

    @Autowired
    private AuditReader auditReader;

    @Autowired
    private UpdateDeciderRepository updateDeciderRepository;

    @Autowired
    AmendDeciderRepository amendDeciderRepository;

    @Autowired
    ICommonService commonService;


    @Override
    public DeciderConfigurationDTO getDeciderConfigurationByOrgCode(String orgCode) {
        List<UpdateDecider> updateDeciderList = updateDeciderRepository.findAllByOrgCode(orgCode);
        List<AmendDecider> amendDeciderList = amendDeciderRepository.findAllByOrgCode(orgCode);
        Collections.sort(updateDeciderList, (o1, o2) -> o1.getElementName().compareTo(o2.getElementName()));
        Collections.sort(amendDeciderList, (o1, o2) -> o1.getElementName().compareTo(o2.getElementName()));
        return new DeciderConfigurationDTO(amendDeciderList, updateDeciderList);
    }

    @Override
    public List<?> getAudit(String type, Long id) {
        return type.equalsIgnoreCase(UPDATE) ?
                auditReader.createQuery()
                        .forRevisionsOfEntity(UpdateDecider.class, true, true)
                        .add(AuditEntity.id().eq(id))
                        .getResultList() :
                auditReader.createQuery()
                        .forRevisionsOfEntity(AmendDecider.class, true, true)
                        .add(AuditEntity.id().eq(id))
                        .getResultList();
    }

    @Override
    @Transactional
    public DeciderConfigurationDTO addConfiguration(DeciderConfigurationDTO deciderConfigurationDTO) {
        List<UpdateDecider> updateDeciderList = updateDeciderRepository.saveAll(deciderConfigurationDTO.getUpdateList());
        List<AmendDecider> amendDeciderList = amendDeciderRepository.saveAll(deciderConfigurationDTO.getAmendList());
        Collections.sort(updateDeciderList, (o1, o2) -> o1.getElementName().compareTo(o2.getElementName()));
        Collections.sort(amendDeciderList, (o1, o2) -> o1.getElementName().compareTo(o2.getElementName()));
        return new DeciderConfigurationDTO(amendDeciderList, updateDeciderList);
    }

    @Override
    @Transactional
    public DeciderConfigurationDTO addElement(AmendDecider amendDecider, UpdateDecider updateDecider) {
        List<String> orgCodes = commonService.getAllExistingOrgCodes();
        List<UpdateDecider> updateDeciderList = constructUpdateDeciders(updateDecider, orgCodes);
        List<AmendDecider> amendDeciderList = constructAmendDeciders(amendDecider, orgCodes);
        return new DeciderConfigurationDTO(amendDeciderRepository.saveAll(amendDeciderList), updateDeciderRepository.saveAll(updateDeciderList));
    }

    private List<AmendDecider> constructAmendDeciders(AmendDecider amendDecider, List<String> orgCodes) {
        List<AmendDecider> amendDeciderList = new ArrayList<>();
        orgCodes.forEach(code -> {
            AmendDecider amendDeciderToSave = new AmendDecider();
            BeanUtils.copyProperties(amendDecider, amendDeciderToSave);
            amendDeciderToSave.setOrgCode(code);
            amendDeciderList.add(amendDeciderToSave);
        });
        return amendDeciderList;
    }

    private List<UpdateDecider> constructUpdateDeciders(UpdateDecider updateDecider, List<String> orgCodes) {
        List<UpdateDecider> updateDeciderList = new ArrayList<>();
        orgCodes.forEach(code -> {
            UpdateDecider updateDeciderToSave = new UpdateDecider();
            BeanUtils.copyProperties(updateDecider, updateDeciderToSave);
            updateDeciderToSave.setOrgCode(code);
            updateDeciderList.add(updateDeciderToSave);
        });
        return updateDeciderList;
    }
}
