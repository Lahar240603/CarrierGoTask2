package com.task2.carriergot2.services;

import com.task2.carriergot2.dto.DeciderConfigurationDTO;
import com.task2.carriergot2.entities.AmendDecider;
import com.task2.carriergot2.entities.UpdateDecider;

import java.util.List;

public interface IDeciderConfigurationService {
    DeciderConfigurationDTO getDeciderConfigurationByOrgCode(String orgCode);

    List<?> getAudit(String type, Long id);

    DeciderConfigurationDTO addConfiguration(DeciderConfigurationDTO request);

    DeciderConfigurationDTO addElement(AmendDecider amendDecider, UpdateDecider updateDecider);
}
