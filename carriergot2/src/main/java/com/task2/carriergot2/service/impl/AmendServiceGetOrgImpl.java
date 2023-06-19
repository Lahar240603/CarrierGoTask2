package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.task2.carriergot2.service.iAmendServiceGetOrg;

import java.util.List;

@Service
public class AmendServiceGetOrgImpl implements iAmendServiceGetOrg {

    @Autowired
    private AmendRepository amendRepository;

    @Override
    public List<AmendWorkOrderStateDecider> findByOrgCode(String orgCode) {
        return amendRepository.findAllByOrgCode(orgCode, Sort.by(Sort.Direction.ASC, "elementName"));
    }

    @Override
    public List<String> findAllOrgCodes() {
        return amendRepository.findDistinctOrgCode();
    }

    
}
