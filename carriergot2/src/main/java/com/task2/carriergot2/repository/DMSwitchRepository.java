package com.example.demo3.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.demo3.entity.DMSwitches;

public interface DMSwitchRepository extends CrudRepository<DMSwitches, String> {

	DMSwitches findBySwitchName(String switchName);

}
