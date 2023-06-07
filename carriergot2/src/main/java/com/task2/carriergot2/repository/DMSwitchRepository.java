package com.task2.carriergot2.repository;

import com.task2.carriergot2.model.DMSwitches;
import org.springframework.data.repository.CrudRepository;

public interface DMSwitchRepository extends CrudRepository<DMSwitches, String> {

	DMSwitches findBySwitchName(String switchName);

}
