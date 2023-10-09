package com.iib.gov.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iib.gov.pojo.VehicleDetails;
import com.iib.gov.service.ClaimHistoryServiceProjection;

public class ResponseDto {
	
	@JsonProperty("ClaimDetails")
	//@JsonIgnore
	private List<ClaimHistoryServiceProjection> projection;
	
	@JsonProperty("VehicleDetails")
	private VehicleDetails details;

	public VehicleDetails getDetails() {
		return details;
	}

	public void setDetails(VehicleDetails forObject) {
		this.details = forObject;
	}

	public List<ClaimHistoryServiceProjection> getProjection() {
		return projection;
	}

	
	public void setProjection(List<ClaimHistoryServiceProjection> projection) {
		this.projection = projection;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
