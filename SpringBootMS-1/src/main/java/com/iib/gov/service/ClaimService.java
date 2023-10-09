package com.iib.gov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iib.gov.dao.ClaimRepo;
import com.iib.gov.dto.ResponseDto;
import com.iib.gov.pojo.VehicleDetails;


@Service
public class ClaimService {
	
	@Autowired
	private ClaimRepo repo;
	
	
	@Autowired
	private RestTemplate template;
	
//	@Autowired
//	private LoadBalancerClient lBalancerClient;
	
	
//	 public ClaimService(RestTemplateBuilder restTemplateBuilder) {
//	      this. template = restTemplateBuilder
//	                    .basicAuthentication("testadmin", "iibadmin@123")
//	                    .build();
//	    }
	
	
	
	
	
	
	public ResponseDto getClaimAndVehicleDetails(String regno) {
		
//	ServiceInstance choose = lBalancerClient.choose("udayan");
//		
//		String uri = choose.getUri().toString();
//		
//		System.err.println(uri);
		
		String url="http://UDAYAN"+"/accessToIIB/getVehicleDetails?Regno={regno}&&Chassisno=";
		
		ResponseDto resdto=new ResponseDto();
		
		
		List<ClaimHistoryServiceProjection> total = repo.getTotal(regno);
		resdto.setProjection(total);
		
	//	 VehicleDetails forObject=new VehicleDetails();
	
		VehicleDetails     forObject = template.getForObject(url, VehicleDetails.class,regno);
	       
	       System.err.println(forObject);
	       
	       resdto.setDetails(forObject);
	      

		
		return resdto;
		
	}
	
	
	
	

}
