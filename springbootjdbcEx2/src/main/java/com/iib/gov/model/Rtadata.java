package com.iib.gov.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Rtadata")
public class Rtadata implements Serializable {
	
	private String policyno;
	private String engineno;
    private String chassisno;
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getEngineno() {
		return engineno;
	}
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	public String getChassisno() {
		return chassisno;
	}
	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}

}
