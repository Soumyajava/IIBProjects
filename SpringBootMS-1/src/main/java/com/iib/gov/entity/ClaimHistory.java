package com.iib.gov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="IIW_MOT_CLAIM_HISTORY")
public class ClaimHistory  {

	//@Id
	
	private String  regno;
	
	private String chassisno;
	
	private String enginenum;
	
	private String insurername;
	
	private String claimtype;
	@Id
	
	private String claimnumber;
	
	private String lossdate;
	
	private String intimationdate;
	
	private String  classcode;
	public String getClasscode() {
		return classcode;
	}
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	
	private Integer odlosspaid;
	
	private Integer odexpensespaid;
	
	private String booOdTotalLoss;
	
	private String booTheft;
	
	private Integer totalTpClaimsPaidAmount;
	
	private Integer tpOpenProvision;
	
	private Integer tpCloseProvision;
	
	private String claimStatus;
	@Transient
	
	private String Search_Based_On;
	
	public String getSearch_Based_On() {
		return Search_Based_On;
	}
	public void setSearch_Based_On(String search_Based_On) {
		Search_Based_On = search_Based_On;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getChassisno() {
		return chassisno;
	}
	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}
	public String getEnginenum() {
		return enginenum;
	}
	public void setEnginenum(String enginenum) {
		this.enginenum = enginenum;
	}
	public String getInsurername() {
		return insurername;
	}
	public void setInsurername(String insurername) {
		this.insurername = insurername;
	}
	public String getClaimtype() {
		return claimtype;
	}
	public void setClaimtype(String claimtype) {
		this.claimtype = claimtype;
	}
	public String getClaimnumber() {
		return claimnumber;
	}
	public void setClaimnumber(String claimnumber) {
		this.claimnumber = claimnumber;
	}
	public String getLossdate() {
		return lossdate;
	}
	public void setLossdate(String lossdate) {
		this.lossdate = lossdate;
	}
	public String getIntimationdate() {
		return intimationdate;
	}
	public void setIntimationdate(String intimationdate) {
		this.intimationdate = intimationdate;
	}
	public Integer getOdlosspaid() {
		return odlosspaid;
	}
	public void setOdlosspaid(Integer odlosspaid) {
		this.odlosspaid = odlosspaid;
	}
	public Integer getOdexpensespaid() {
		return odexpensespaid;
	}
	public void setOdexpensespaid(Integer odexpensespaid) {
		this.odexpensespaid = odexpensespaid;
	}
	public String getBooOdTotalLoss() {
		return booOdTotalLoss;
	}
	public void setBooOdTotalLoss(String booOdTotalLoss) {
		this.booOdTotalLoss = booOdTotalLoss;
	}
	public String getBooTheft() {
		return booTheft;
	}
	public void setBooTheft(String booTheft) {
		this.booTheft = booTheft;
	}
	public Integer getTotalTpClaimsPaidAmount() {
		return totalTpClaimsPaidAmount;
	}
	public void setTotalTpClaimsPaidAmount(Integer totalTpClaimsPaidAmount) {
		this.totalTpClaimsPaidAmount = totalTpClaimsPaidAmount;
	}
	public Integer getTpOpenProvision() {
		return tpOpenProvision;
	}
	public void setTpOpenProvision(Integer tpOpenProvision) {
		this.tpOpenProvision = tpOpenProvision;
	}
	public Integer getTpCloseProvision() {
		return tpCloseProvision;
	}
	public void setTpCloseProvision(Integer tpCloseProvision) {
		this.tpCloseProvision = tpCloseProvision;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

		

}
