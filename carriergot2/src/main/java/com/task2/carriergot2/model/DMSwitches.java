package com.task2.carriergot2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Entity
@Table(name="dmswitch")
public class DMSwitches {
	
	@Id
	@Column(name="SWITCHNAME")
	private String switchName;
	
	@Column(name="ISENABLED")
	private boolean isEnabled;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE_TIME")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime createdDateTime;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_DATE_TIME")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime updatedDateTime;

	/*public DMSwitches() {
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
	}*/

	public DMSwitches() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DMSwitches(String switchName, boolean isEnabled, String createdBy, LocalDateTime createdDateTime,
					  String updatedBy, LocalDateTime updatedDateTime) {
		super();
		this.switchName = switchName;
		this.isEnabled = isEnabled;
		this.createdBy = createdBy;
		this.createdDateTime = createdDateTime;
		this.updatedBy = updatedBy;
		this.updatedDateTime = updatedDateTime;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = LocalDateTime.now();
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = LocalDateTime.now();
	}


	@Override
	public String toString() {
		return "DMSwitches [switchName=" + switchName + ", isEnabled=" + isEnabled + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}

}

