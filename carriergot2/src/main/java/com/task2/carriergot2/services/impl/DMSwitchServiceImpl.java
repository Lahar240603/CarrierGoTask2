package com.task2.carriergot2.services.impl;



import com.task2.carriergot2.entities.DMSwitch;
import com.task2.carriergot2.repositories.DMSwitchRepository;
import com.task2.carriergot2.services.IDMSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DMSwitchServiceImpl implements IDMSwitchService {

    @Autowired
    private DMSwitchRepository dmSwitchRepository;

    @Override
    public List<DMSwitch> getAllDMSwitches() {
        return dmSwitchRepository.findAll();
    }

    @Override
    public DMSwitch addNewDMSwitch(DMSwitch dmSwitch) {
        return dmSwitchRepository.save(dmSwitch);
    }

    @Override
    public DMSwitch updateSwitch(DMSwitch dmSwitch) {
        Optional<DMSwitch> existingSwitch = dmSwitchRepository.findById(dmSwitch.getId());
        if (existingSwitch.isPresent()) {
            existingSwitch.get().setEnabled(dmSwitch.isEnabled());
            return dmSwitchRepository.save(existingSwitch.get());
        }
        return null;
    }

}

