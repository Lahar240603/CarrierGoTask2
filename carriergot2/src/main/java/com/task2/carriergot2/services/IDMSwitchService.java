package com.task2.carriergot2.services;

import com.task2.carriergot2.entities.DMSwitch;

import java.util.List;

public interface IDMSwitchService {

    List<DMSwitch> getAllDMSwitches();

    DMSwitch addNewDMSwitch(DMSwitch inputDMSwitch);

    DMSwitch updateSwitch(DMSwitch updatedSwitch);

    List<DMSwitch> getAuditById(Long id);
}
