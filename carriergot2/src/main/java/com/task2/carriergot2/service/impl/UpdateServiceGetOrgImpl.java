package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.task2.carriergot2.service.iUpdateServiceGetOrg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateServiceGetOrgImpl implements iUpdateServiceGetOrg{
    @Autowired
    private UpdateRepository updateRepository;

    @Override
    public List<UpdateWorkOrderStateDecider> findByOrgCode(String orgCode) {
        return updateRepository.findAllByOrgCode(orgCode);
    }
}
