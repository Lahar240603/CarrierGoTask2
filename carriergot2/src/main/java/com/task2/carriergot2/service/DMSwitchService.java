package com.task2.carriergot2.service;

import java.util.List;
import java.util.Optional;

import com.task2.carriergot2.model.DMSwitches;
import com.task2.carriergot2.repository.DMSwitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DMSwitchService {
	
	@Autowired
	private final DMSwitchRepository dmswitchRepository;

    @Autowired
    public DMSwitchService(DMSwitchRepository dmswitchRepository) {
        this.dmswitchRepository = dmswitchRepository;
    }

    
    public List<DMSwitches> getALLDMSwitches() {
        return (List<DMSwitches>) dmswitchRepository.findAll();
    }

    
    public DMSwitches getDMSwitchByName(String switchName) {
        return dmswitchRepository.findBySwitchName(switchName);
    }

   
    
    /*public DMSwitches addOrUpdateDMSwitch(DMSwitches dmSwitch) {
        return dmswitchRepository.save(dmSwitch);
    }*/

    public DMSwitches addSwitch(DMSwitches dmswitch) {
      DMSwitches newSwitch = new DMSwitches();
              newSwitch.setSwitchName(dmswitch.getSwitchName());
              newSwitch.setIsEnabled(dmswitch.getIsEnabled());       	
         return dmswitchRepository.save(newSwitch);
         }
//        catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
   


    public DMSwitches updateSwitch(DMSwitches dmswitch) {
        Optional<DMSwitches> existingSwitch = dmswitchRepository.findById(dmswitch.getSwitchName());
        if (existingSwitch.isPresent()) {
            return dmswitchRepository.save(dmswitch);
        }
        return null; 
    }

    
    public DMSwitches deleteDMSwitch(String switchName) throws Exception {
        DMSwitches existingSwitch = dmswitchRepository.findBySwitchName(switchName);
        if (existingSwitch != null) {
            dmswitchRepository.delete(existingSwitch);
        } else {
            throw new Exception("Switch not found");
        }
        return existingSwitch;
    }


	


	/*public DMSwitches addSwitch(DMSwitches dmswitch) {
		// TODO Auto-generated method stub
		return null;
	}


	public DMSwitches updateSwitch(DMSwitches dmswitch) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}

