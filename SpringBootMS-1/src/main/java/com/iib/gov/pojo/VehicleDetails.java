package com.iib.gov.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleDetails {
	
	@JsonProperty("Owner_Serial_No")
	
	private String ownerserialno;
	@JsonProperty("Hypothecation_Name")
	
	private String hypothecationname;
	
	@JsonProperty("Registration_Number")
	
	private String regno;
	@JsonProperty("Date_of_Registration")
	
	private String dateofreg;
	@JsonProperty("Chassis_Number")
	
	private String chassisno;
	@JsonProperty("Year_of_Manufacture")
	
	private String yof;
	@JsonProperty("Engine_Number")
	
	private String	enginenum;
	@JsonProperty("Tax_From")
	
	private String taxfrom;
	@JsonProperty("Tax_Up_to")
	
	private String taxupto;
	@JsonProperty("Manufacturer_of_the_Vehicle")
	
	private String mov;
	
	@JsonProperty("Model_Variant_of_the_Vehicle")
	
	private String modelvariant;
	
	@JsonProperty("Fitness_Up_to_Validity")
	
	private String fitnessupto;
	
	@JsonProperty("PUC_Up_to_Validity")
	
	private String pucupto;
	@JsonProperty("Class_of_the_Vehicle")
	
	private String classvehicle;
	@JsonProperty("State_Name")
	
	private String state;
	
	@JsonProperty("RTO_Office_Name")
	
	private String rtoname;
	@JsonProperty("Cubic_Capacity")
	
	private String cubiccapacity;
	@JsonProperty("Permit_Type")
	
	private String permittype;
	@JsonProperty("Gross_Vehicle_Weight")
	
	private String grossvehicleweight;
	@JsonProperty("Permit_validity")
	
	private String permitvalidity;
	@JsonProperty("Registration_Permit_category")
	
	private String permitcatg;
	@JsonProperty("Seating_Capacity")
	
	private String seatingcap;
	@JsonProperty("HP_KW_For_Electric_vehicles")
	
	private String hpforelectric;
	@JsonProperty("Fuel_Type")
	
	private String fueltype;
	
	@JsonProperty("Body_type_Open_Closed_SUV_Sedan_etc")
	
	private String bodytype;
	
	@JsonProperty("IIB_Manufacturer_Code")
	
	private String iibmanufacturercode;
	
	
	
	

	@Override
	public String toString() {
		return "VehicleDetails [ownerserialno=" + ownerserialno + ", hypothecationname=" + hypothecationname
				+ ", regno=" + regno + ", dateofreg=" + dateofreg + ", chassisno=" + chassisno + ", yof=" + yof
				+ ", enginenum=" + enginenum + ", taxfrom=" + taxfrom + ", taxupto=" + taxupto + ", mov=" + mov
				+ ", modelvariant=" + modelvariant + ", fitnessupto=" + fitnessupto + ", pucupto=" + pucupto
				+ ", classvehicle=" + classvehicle + ", state=" + state + ", rtoname=" + rtoname + ", cubiccapacity="
				+ cubiccapacity + ", permittype=" + permittype + ", grossvehicleweight=" + grossvehicleweight
				+ ", permitvalidity=" + permitvalidity + ", permitcatg=" + permitcatg + ", seatingcap=" + seatingcap
				+ ", hpforelectric=" + hpforelectric + ", fueltype=" + fueltype + ", bodytype=" + bodytype
				+ ", iibmanufacturercode=" + iibmanufacturercode + "]";
	}

	public String getOwnerserialno() {
		return ownerserialno;
	}

	public void setOwnerserialno(String ownerserialno) {
		this.ownerserialno = ownerserialno;
	}

	public String getHypothecationname() {
		return hypothecationname;
	}

	public void setHypothecationname(String hypothecationname) {
		this.hypothecationname = hypothecationname;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getDateofreg() {
		return dateofreg;
	}

	public void setDateofreg(String dateofreg) {
		this.dateofreg = dateofreg;
	}

	public String getChassisno() {
		return chassisno;
	}

	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}

	public String getYof() {
		return yof;
	}

	public void setYof(String yof) {
		this.yof = yof;
	}

	public String getEnginenum() {
		return enginenum;
	}

	public void setEnginenum(String enginenum) {
		this.enginenum = enginenum;
	}

	public String getTaxfrom() {
		return taxfrom;
	}

	public void setTaxfrom(String taxfrom) {
		this.taxfrom = taxfrom;
	}

	public String getTaxupto() {
		return taxupto;
	}

	public void setTaxupto(String taxupto) {
		this.taxupto = taxupto;
	}

	public String getMov() {
		return mov;
	}

	public void setMov(String mov) {
		this.mov = mov;
	}

	public String getModelvariant() {
		return modelvariant;
	}

	public void setModelvariant(String modelvariant) {
		this.modelvariant = modelvariant;
	}

	public String getFitnessupto() {
		return fitnessupto;
	}

	public void setFitnessupto(String fitnessupto) {
		this.fitnessupto = fitnessupto;
	}

	public String getPucupto() {
		return pucupto;
	}

	public void setPucupto(String pucupto) {
		this.pucupto = pucupto;
	}

	public String getClassvehicle() {
		return classvehicle;
	}

	public void setClassvehicle(String classvehicle) {
		this.classvehicle = classvehicle;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRtoname() {
		return rtoname;
	}

	public void setRtoname(String rtoname) {
		this.rtoname = rtoname;
	}

	public String getCubiccapacity() {
		return cubiccapacity;
	}

	public void setCubiccapacity(String cubiccapacity) {
		this.cubiccapacity = cubiccapacity;
	}

	public String getPermittype() {
		return permittype;
	}

	public void setPermittype(String permittype) {
		this.permittype = permittype;
	}

	public String getGrossvehicleweight() {
		return grossvehicleweight;
	}

	public void setGrossvehicleweight(String grossvehicleweight) {
		this.grossvehicleweight = grossvehicleweight;
	}

	public String getPermitvalidity() {
		return permitvalidity;
	}

	public void setPermitvalidity(String permitvalidity) {
		this.permitvalidity = permitvalidity;
	}

	public String getPermitcatg() {
		return permitcatg;
	}

	public void setPermitcatg(String permitcatg) {
		this.permitcatg = permitcatg;
	}

	public String getSeatingcap() {
		return seatingcap;
	}

	public void setSeatingcap(String seatingcap) {
		this.seatingcap = seatingcap;
	}

	public String getHpforelectric() {
		return hpforelectric;
	}

	public void setHpforelectric(String hpforelectric) {
		this.hpforelectric = hpforelectric;
	}

	public String getFueltype() {
		return fueltype;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}

	public String getBodytype() {
		return bodytype;
	}

	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}

	public String getIibmanufacturercode() {
		return iibmanufacturercode;
	}

	public void setIibmanufacturercode(String iibmanufacturercode) {
		this.iibmanufacturercode = iibmanufacturercode;
	}
	

}
