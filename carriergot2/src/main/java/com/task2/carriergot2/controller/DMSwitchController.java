/*package com.example.demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.entity.DMSwitches;
import com.example.demo3.service.DMSwitchService;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/dmswitches")
public class DMSwitchController {
	@Autowired
	private DMSwitchService dmswitchService;
	@GetMapping("/allDMSwitches")
	public ResponseEntity<List<DMSwitches>> getAllDMSwitches(){
		List<DMSwitches> dmswitches = null;
		try {
			dmswitches= dmswitchService.getALLDMSwitches();
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<DMSwitches>>(dmswitches,HttpStatus.OK);
	}

@GetMapping("/getByName/{name}")
public ResponseEntity<DMSwitches> getDMSwitchbyName(@PathVariable("name") String switchName){
	DMSwitches dmswitches = null;
	try {
		dmswitches= dmswitchService.getDMSwitchByName(switchName);
	}
	catch(Exception ex) {
		ex.getMessage();
	}
	return new ResponseEntity<DMSwitches>(dmswitches,HttpStatus.OK);
}
/*@PostMapping("/addorUpdate")
public ResponseEntity<DMSwitches> addOrUpdate(@RequestBody DMSwitches dmswitch){
	DMSwitches dmswitches = null;
	try {
		dmswitches= dmswitchService.addOrUpdateDMSwitch(dmswitch);
	}
	catch(Exception ex) {
		ex.getMessage();
	}
	return new ResponseEntity<DMSwitches>(dmswitches,HttpStatus.OK);
}*/
/*@PostMapping("/addorUpdate")
public ResponseEntity<DMSwitches> addOrUpdate(@RequestBody DMSwitches dmswitch) {
    DMSwitches savedSwitch = dmswitchService.addOrUpdateDMSwitch(dmswitch);
    if (savedSwitch != null) {
        return new ResponseEntity<>(savedSwitch, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}*/
/*@PostMapping("/add")
public ResponseEntity<DMSwitches> addSwitch(@RequestBody DMSwitches dmswitch) {
    DMSwitches savedSwitch = dmswitchService.addSwitch(dmswitch);
    if (savedSwitch != null) {
        return new ResponseEntity<>(savedSwitch, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}

@PutMapping("/update")
public ResponseEntity<DMSwitches> updateSwitch(@RequestBody DMSwitches dmswitch) {
    DMSwitches updatedSwitch = dmswitchService.updateSwitch(dmswitch);
    if (updatedSwitch != null) {
        return new ResponseEntity<>(updatedSwitch, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}

@DeleteMapping("/delete/{name}")
public ResponseEntity<DMSwitches> addOrUpdate(@PathVariable("name") String dmswitchName){
	DMSwitches dmswitches = null;
	try {
		dmswitches= dmswitchService.deleteDMSwitch(dmswitchName);
	}
	catch(Exception ex) {
		ex.getMessage();
	}
	return new ResponseEntity<DMSwitches>(dmswitches,HttpStatus.OK);
}


}*/

package com.task2.carriergot2.controller;

import java.util.List;

import com.task2.carriergot2.model.DMSwitches;
import com.task2.carriergot2.service.DMSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/dmswitches")
public class DMSwitchController {
    @Autowired
    private DMSwitchService dmswitchService;
    

    @GetMapping("/allDMSwitches")
    public ResponseEntity<List<DMSwitches>> getAllDMSwitches() {
        try {
            List<DMSwitches> dmswitches = dmswitchService.getALLDMSwitches();
            return new ResponseEntity<>(dmswitches, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<DMSwitches> getDMSwitchbyName(@PathVariable("name") String switchName) {
        try {
            DMSwitches dmswitch = dmswitchService.getDMSwitchByName(switchName);
            if (dmswitch != null) {
                return new ResponseEntity<>(dmswitch, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
    @PostMapping("/add")
    public ResponseEntity<DMSwitches> addSwitch(@RequestBody DMSwitches newSwitch) {
      try {
        DMSwitches savedSwitch = dmswitchService.addSwitch(newSwitch);
        return new ResponseEntity<>(savedSwitch, HttpStatus.CREATED);
      } catch (Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<DMSwitches> updateSwitch(@PathVariable("name") String switchName, @RequestBody DMSwitches updatedSwitch) {
      try {
        DMSwitches existingSwitch = dmswitchService.getDMSwitchByName(switchName);
        if (existingSwitch != null) {
          existingSwitch.setSwitchName(switchName);
          existingSwitch.setIsEnabled(updatedSwitch.getIsEnabled());
          DMSwitches savedSwitch = dmswitchService.updateSwitch(existingSwitch);
          return new ResponseEntity<>(savedSwitch, HttpStatus.OK);
        } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }



    @DeleteMapping("/delete/{name}")
    public ResponseEntity<DMSwitches> deleteSwitch(@PathVariable("name") String switchName) {
        try {
            DMSwitches deletedSwitch = dmswitchService.deleteDMSwitch(switchName);
            if (deletedSwitch != null) {
                return new ResponseEntity<>(deletedSwitch, HttpStatus.OK);
            } else
            {
            	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            	}
            	} catch (Exception ex) {
            	ex.printStackTrace();
            	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            	}
            	}
            	}




