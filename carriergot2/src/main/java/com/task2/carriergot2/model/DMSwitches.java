/*package com.example.demo3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dmswitch")
public class DMSwitches {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SWITCHNAME")
     private String switchName;
	
	@Column(name="ISENABLED")
    private boolean isEnabled;

	public DMSwitches() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DMSwitches(String switchName, boolean isEnabled) {
		super();
		this.switchName = switchName;
		this.isEnabled = isEnabled;
	}

	public String getSwitchName() {
		return switchName;
	}

	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "DMSwitches [switchName=" + switchName + ", isEnabled=" + isEnabled + "]";
	}
}*/
package com.task2.carriergot2.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="dmswitch")
public class DMSwitches {
	
	@Id
	@Column(name="SWITCHNAME")
	private String switchName;
	
	@Column(name="ISENABLED")
	private boolean isEnabled;

	public DMSwitches() {
		super();
	}

	public DMSwitches(String switchName, boolean isEnabled) {
		super();
		this.switchName = switchName;
		this.isEnabled = isEnabled;
	}

	public String getSwitchName() {
		return switchName;
	}

	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}

	public boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "DMSwitches [switchName=" + switchName + ", isEnabled=" + isEnabled + "]";
	}
}

