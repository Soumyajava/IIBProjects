package com.iib.gov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iib.gov.dto.ResponseDto;
import com.iib.gov.service.ClaimService;

@RestController
public class MsController {
	
	@Autowired
	private ClaimService service;
	
	
	@GetMapping("/getVehcileDetails/{regno}")
	public ResponseDto getClaimDetails(@PathVariable String regno) {
		
		ResponseDto claimDetailsdto = service.getClaimAndVehicleDetails(regno);
		
		return claimDetailsdto;
		
	}


}
