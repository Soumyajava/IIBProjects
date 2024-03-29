package com.iib.gov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.iib.gov.entity.vchvsEntityOld.VchvsEntity;
import com.iib.gov.entity.vchvsEntityOld.VchvsEntity6;
import com.iib.gov.repo.old.VchvsRepo;

import com.iib.gov.repo.old.VchvsRepo4;
import com.iib.gov.repo.old.VchvsRepo5;

@Service
public class VchvsService {
	@Autowired
	private VchvsRepo vchvsrepo;
	


	@Autowired
	private VchvsRepo4 vchvsrepo4;

	@Autowired
	private VchvsRepo5 vchvsrepo5;
	

	

	
	public   List<VchvsEntity> getInfo(String regno) {
		System.out.println("Policy Details based on generalregnos.");

		return vchvsrepo.findByRegno(regno);
	}

	

	public List<VchvsEntity> getInfo1(String chassisno) {
		System.out.println("Policy Details based on chassisnos.");

		return vchvsrepo.findByChassisno(chassisno);
	}


	
	public  List<VchvsEntity> getInfo4(String regno, String chassisno) {
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
	
	public List<VchvsEntity6> getScore(String regno) {
		
		System.out.println("Get risk score details based on regno");
		
		return vchvsrepo5.findByRegno(regno);
		
	}
	
	//for Dl,GJ,BR,KL registration number policy details
	
	public  List<VchvsEntity> getDlVehicleDetails(String regno1,String regno2){
		
		System.out.println("Policy details Based on Dl,GJ,BR,KL regnos.");
		
		return vchvsrepo.basedOnBothRegnos(regno1, regno2);
		
	}
	
	//for Dl,GJ,BR,KL registration number claim details
	
	public  List<ClaimHistoryService> getClaimDetailsforDl(String regno1,String regno2) {
		System.out.println("Claim details Based on Dl,GJ,BR,KL regnos.");

		return vchvsrepo4.basedOnDLRegnos(regno1, regno2);
	}
	
	
	//for Dl,GJ,BR,KL registration number Risk score details
	
public List<VchvsEntity6> getScore1(String regno1,String regno2) {
		
		System.out.println("Riskscore details Based on Dl,GJ,BR,KL regnos.");
		
		return vchvsrepo5.findByRegnos(regno1, regno2);
		
	}
	
}
