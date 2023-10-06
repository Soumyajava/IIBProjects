package com.iib.gov.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iib.gov.controller.SuvahanController2;
import com.iib.gov.entity.motorweb.PolicyDtls;
import com.iib.gov.entity.motorweb.Riskscore;
import com.iib.gov.entity.vahan.VahanVehicleDetails;
import com.iib.gov.repo.motorweb.Hit_Counts_Repo;
import com.iib.gov.repo.vahan.VahanVehicleDetailsRepo;

@Service
public class SuvahanService {
	
	
	@Autowired
	private VahanVehicleDetailsRepo repo;
	@Autowired
	private com.iib.gov.repo.motorweb.VchvsRepo vchvsrepo;
	


	@Autowired
	private com.iib.gov.repo.motorweb.VchvsRepo4 vchvsrepo4;

	@Autowired
	private com.iib.gov.repo.motorweb.VchvsRepo5 vchvsrepo5;
	
	
	@Autowired
	private Hit_Counts_Repo countrepo;
	
	
	static Logger log = Logger.getLogger(SuvahanService.class);
	
	//Fetch vehicle details

	//Fetch By general regno
	public VahanVehicleDetails getDetailsByregno(String regNo) {
		
		System.err.println("Fetch vehicle details By general regno");
		
		VahanVehicleDetails detailsByregno = repo.getDetailsByregno(regNo);
		
		return detailsByregno;
	}
	
	//fetch by specific regnos
	
public VahanVehicleDetails getDetailsBySpecificregno(String regno1, String regno2) {
		
		System.err.println("Fetch Vehicle details By specific regnos");
		
		VahanVehicleDetails detailsByregno = repo.getDetailsBySpecificregno(regno1,regno2);
		
		return detailsByregno;
	}
	

	//Fetch by chassino
	public VahanVehicleDetails getDetailsBychassisno(String chassisno) {
		
		System.err.println("coming to service getchassisno");
		
		VahanVehicleDetails detailsBychassisno = repo.getDetailsBychassisno(chassisno);
		
		return detailsBychassisno;
	}
	////////////////////////////
	
	

	

	
	public   List<PolicyDtls> getInfo(String regno) {
		System.out.println("Policy Details based on generalregnos.");

		return vchvsrepo.findByRegno(regno);
	}

	

	public List<PolicyDtls> getInfo1(String chassisno) {
		System.out.println("Policy Details based on chassisnos.");

		return vchvsrepo.findByChassisno(chassisno);
	}


	
	public  List<PolicyDtls> getInfo4(String regno, String chassisno) {
		System.out.println("Policy details based on chassisno and regno.");

		return vchvsrepo.RegnoAndChassisno(regno, chassisno);
	}


	public  List<ClaimHistoryService> getClaimInfo1(String regno) {
		System.out.println("Claim details based on regno.");
		
//		vchvsrepo4.findAll().forEach(find->{
//			find.getSearch_Based_On();
//			find.setSearch_Based_On(regno);
//		});
//	
		
	//	vchvsrepo4.findByRegno(regno).forEach(find -> {find.getSearch_Based_On();find.setSearch_Based_On(regno);});
		return vchvsrepo4.findByRegno(regno);
	}


	
	
	public  List<ClaimHistoryService> getClaimInfo2(String chassisno) {
		System.out.println("Claim details based on chassisno.");

		return vchvsrepo4.findByChassisno(chassisno);
	}

	
	
	public List<ClaimHistoryService> getClaimInfo3(String regno, String chassisno) {
		System.out.println("Claim details based on chassisno and registrationno.");
		return vchvsrepo4.findByRegnoAndChassisno(regno, chassisno);
	}
	
	//get risk score details
	
	public List<Riskscore> getScore(String regno) {
		
		System.out.println("Get risk score details based on regno");
		
		return vchvsrepo5.findByRegno(regno);
		
	}
	
	//for Dl,GJ,BR,KL registration number policy details
	
	public  List<PolicyDtls> getDlVehicleDetails(String regno1,String regno2){
		
		System.out.println("Policy details Based on Dl,GJ,BR regnos.");
		
		return vchvsrepo.basedOnBothRegnos(regno1, regno2);
		
	}
	
	//for Dl,GJ,BR,KL registration number claim details
	
	public  List<ClaimHistoryService> getClaimDetailsforDl(String regno1,String regno2) {
		System.out.println("Claim details Based on Dl,GJ,BR regnos.");

		return vchvsrepo4.basedOnDLRegnos(regno1, regno2);
	}
	
	
	//for Dl,GJ,BR,KL registration number Risk score details
	
public List<Riskscore> getScore1(String regno1,String regno2) {
		
		System.out.println("Riskscore details Based on Dl,GJ,BR regnos.");
		
		return vchvsrepo5.findByRegnos(regno1, regno2);
		
	}
	

public Integer getCount(String username) {
	//get counts based on username
	System.err.println("get counts based on username");
	
	Integer count = countrepo.getCount(username);
	
	log.info("Hit count is:" + count);
	System.out.print(count);
	
	return count;
}
	
	

}
