package com.iib.gov.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iib.gov.entity.motorweb.Hybrid_hits_details;
import com.iib.gov.entity.motorweb.PolicyDtls;
import com.iib.gov.entity.motorweb.Riskscore;
import com.iib.gov.entity.vahan.VahanVehicleDetails;

import com.iib.gov.exception.CustomException;
import com.iib.gov.repo.motorweb.Hybrid_hit_repo;
import com.iib.gov.service.ClaimHistoryService;
import com.iib.gov.service.SuvahanService;

@RestController
@RequestMapping("/suvahan")
public class SuvahanController2 {

	@Autowired
	private SuvahanService service;

	@Autowired
	private Hybrid_hit_repo repo;


	
	private String rootName;
	private String rootName1;
	private String rootname3;
	private String rootname4;
	private String rootname5;
	
	private String policyres;
	
	private String claimres;
	
	private String riskscoreres;
	
	
	private boolean b3;
	
	private boolean b6;
	private boolean b7;

	

	private final ObjectMapper mapper = new ObjectMapper();

	static Logger log = Logger.getLogger(SuvahanController2.class);

//	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SuvahanController2.class);

	// @SuppressWarnings("unchecked")
	@GetMapping("/getVehicleDetails")
	public String getVehicleDetails(@RequestParam(required = false) String regno,
			@RequestParam(required = false) String chassisno, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		
		        //getting ip address
				String ipAddress = request.getRemoteAddr();
				
				log.info("client IP:"+ipAddress);
				
				//getting username
				String name = SecurityContextHolder.getContext().getAuthentication().getName();
			
				log.info("Username:"+name);
				
				
				
//				if(name.equals("124567") && service.getCount(name)>50000) {
//					
//					
//					throw new CustomException("You have exceeded the limit(50k).");
//					
//				}
				
				//arrays 
				
				if(Arrays.asList("NGI58","NIA90","RGI102","RGI103","ITGI106","TAGI108","BAGI113"
						,"ILGI115","CGI123","FGI132","USGI134","SGI137","RQGI141","SGI144","HDFC146","MGI149","LGI150","KGI152",
						"NGI155","AGI157","GDGI158","ZGI159","UIGI545","OGI556")
						.contains(name) && service.getCount(name)>5000) {
					
					
					throw new CustomException("You have exceeded the limit(5k).");
				}
				
				
				
				
				
		
				//creating hit table object
				
				Hybrid_hits_details hit_details = new Hybrid_hits_details();
				
				hit_details.setChassisno(chassisno);
				hit_details.setIp_address(ipAddress);
				hit_details.setRequest_time(LocalDateTime.now().toString());
				hit_details.setUsernamne(name);
				
			
			
				
				
				if (regno.equals("") && chassisno.equals("") || ! regno.equals("") && ! chassisno.equals("") ) {

					throw new CustomException("You have to pass either registration number or chassis number.");
					
				}
		
				
				if (! regno.equals("") && ! chassisno.equals("")  ) {

					throw new CustomException("You have to pass either registration number or chassis number.");
					
				}

		if (chassisno.length() < 11 && chassisno.length() > 0) {

			throw new CustomException("Chassino. should not be less than 11 digits");
		}

		if (regno.length() < 6 && regno.length() > 0) {

			throw new CustomException("Regno. should not be less than 6 digits");
		}

		
		
         //condition for chassis number
		
if (regno.equals(" ") || regno.equals("") && !chassisno.equals("")) {
		
			log.info("entering to block where only chassisno is there ");
			
			log.info("Chassisno:"+chassisno);

			System.err.println("Entering to block where only chassisno is there ");
			
			

			// policy details
			final List<PolicyDtls> info1 = service.getInfo1(chassisno);

			// claim details
			final List<ClaimHistoryService> claimInfo2 = service.getClaimInfo2(chassisno);
			
			//Vehicle details
			
			VahanVehicleDetails detailsBychassisno = service.getDetailsBychassisno(chassisno);

			//policy
			if (!info1.isEmpty()) {
				
			      

				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(info1));
				
				policyres="Policyfound.";
				
				//hit_details.setRes_sudarshana("Details Available");
				
			} else {

			
				rootName = (mapper.writer().withRootName("PolicyDetails")
						.writeValueAsString(" policy data not found in given chassisno."));
				
				policyres="Policynotfound.";
				
			//	hit_details.setRes_sudarshana("Details not Available");

			}

			//claims
			if (!claimInfo2.isEmpty()) {
				

				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo2));
				
				claimres="ClaimsFound.";
				
				hit_details.setRes_sudarshana(policyres+claimres);
				
			} else {
				
				rootName1 = (mapper.writer().withRootName("ClaimDetails")
						.writeValueAsString("Claim Record not found in given chassisno."));
				
				claimres="ClaimsnotFound.";
				
				hit_details.setRes_sudarshana(policyres+claimres);

			}
			
		
			//Vehicle details
			if( detailsBychassisno ==null) {
				System.out.println("*************");
				rootname5 = (mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(
						"Vehicle details not found"));
				
				hit_details.setRes_udayan("VehicleDetailsFound.");
				
				
			}
			
			else {
				rootname5 = mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(detailsBychassisno);
				
				hit_details.setRes_udayan("VehicleDetailsNotFound.");
			}
			
			
			
			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Chassis Number"));
			
			
			
		final String resultString = rootName.concat(rootName1).concat(rootname5).concat(rootname4);

		final String data = resultString.replace("}{", ",");
		
		hit_details.setResGiven_time(LocalDateTime.now().toString());
		//saving hit details into database
		repo.save(hit_details);
		
			return data;
		}
	




		// condition for DL registration number(val1)
		
		if ((regno.startsWith("DL") || regno.startsWith("dl") || regno.startsWith("BR") || regno.startsWith("GJ")) 
				&& !(regno.substring(2, 3).equals("0")) 
				&& (!regno.substring(2, 4).matches("(^\\d{2})"))) { 
			
			
			// && !regno.substring(2,4).matches("(^\\d{2})")
			
			
              System.out.println("Entering block DL regno validation1");
			
			
              System.err.println(regno.substring(0,2));
			log.info("Entering block DL regno validation1 ");
			
			log.info("DLregno val1:"+regno);
			
			hit_details.setRegno(regno);

			String concatreg1 = regno.substring(0,2) + 0 + regno.substring(2);
			
			System.err.println("after validation regno:"+ concatreg1);
			// calling service method policy details
			final List<PolicyDtls> dlVehicleDetails = service.getDlVehicleDetails(concatreg1, regno);
			// calling service method for claim details
			final List<ClaimHistoryService> claimDetailsforDl = service.getClaimDetailsforDl(concatreg1, regno);
			// calling service for risk score details
			final List<Riskscore> score = service.getScore1(concatreg1, regno);
			//calling service for Vehicle Details
			
			VahanVehicleDetails detailsBySpecificregno = service.getDetailsBySpecificregno(concatreg1, regno);
			
			// policy

			if (!dlVehicleDetails.isEmpty()) {
				
				

				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dlVehicleDetails));
				
				policyres="Policyfound.";
				
			} else {
				
				

				rootName = (mapper.writer().withRootName("PolicyDetails")
						.writeValueAsString(" policy data not found in given regno."));
				
				policyres="Policynotfound.";

			}
			// claims

			if (!claimDetailsforDl.isEmpty()) {

				
				
				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimDetailsforDl));
				claimres="ClaimsFound.";
				
			//	hit_details.setRes_sudarshana("Details Available");
				
			} else {
				
				
				rootName1 = (mapper.writer().withRootName("ClaimDetails")
						.writeValueAsString(" Claim Record not found in given regno."));
				
				claimres="ClaimsnotFound.";
				
			//	hit_details.setRes_sudarshana("Details not Available");

			}
			// riskscore

			if (!score.isEmpty()) {
				
				
				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(score));
				
				riskscoreres="scorefound.";
				
				hit_details.setRes_sudarshana(policyres+claimres+riskscoreres);
				
			} else {

				
				
				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
				
				riskscoreres="scorenotfound.";
				
				hit_details.setRes_sudarshana(policyres+claimres+riskscoreres);

			}
			
			//Vehicle Details
			
			if( detailsBySpecificregno ==null) {
				System.out.println("*************");
				rootname5 = (mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(
						"Vehicle details not found"));
				
				hit_details.setRes_udayan("VehicleDetailsNotFound.");
				
			}
			
			else {
				rootname5 = mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(detailsBySpecificregno);
				hit_details.setRes_udayan("VehicleDetailsFound.");
			}
			
			
			
			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
		final	String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname5).concat(rootname4);

		final	String data = resultString.replace("}{", ",");
		
		hit_details.setResGiven_time(LocalDateTime.now().toString());
		
		//saving data to hit table
		
		repo.save(hit_details);
		
		  
		  log.info("Exiting block DL regno validation1 ");

			return data;

		} // condition for DL registration number(val1) end

		// condition for DL registration number(val2) start
		else if (regno.startsWith("DL") || regno.startsWith("dl") || (regno.startsWith("BR") || regno.startsWith("GJ")) && regno.substring(2, 3).equals("0")) {
			
			System.out.println("Entering block DL regno validation2");

			log.info("Entering block DL regno validation2 ");

			log.info("DLregno val2:"+regno);
			
			hit_details.setRegno(regno);
			
			String concatreg2 = regno.substring(0, 2) + regno.substring(3);

			// calling service method policy details
			final List<PolicyDtls> dlVehicleDetails = service.getDlVehicleDetails(concatreg2, regno);
			// calling service method for claim details
			final List<ClaimHistoryService> claimDetailsforDl = service.getClaimDetailsforDl(concatreg2, regno);
			// calling service method for riskscore details
			final List<Riskscore> score = service.getScore1(concatreg2, regno);
			//Calling service method for Vehicle details
			
			VahanVehicleDetails detailsBySpecificregno = service.getDetailsBySpecificregno(concatreg2, regno);

			// policy

			if (!dlVehicleDetails.isEmpty()) {
				
				

				System.err.println("policy data found");
				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dlVehicleDetails));
				policyres="Policyfound.";
				
			} else {

				
				
				
				rootName = (mapper.writer().withRootName("PolicyDetails")
						.writeValueAsString(" policy data not found in given regno."));
				
				policyres="Policynotfound.";

			}
//claims

			if (!claimDetailsforDl.isEmpty()) {
				
				

				System.err.println("claims data found");
				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimDetailsforDl));
				claimres="ClaimsFound.";
				
			} else {

				
				rootName1 = (mapper.writer().withRootName("ClaimDetails")
						.writeValueAsString(" Claim Record not found in given regno."));
				
				claimres="ClaimsnotFound.";

			}
			// riskscore

			if (!score.isEmpty()) {
				
				

				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(score));
				
                riskscoreres="scorefound.";
				
				hit_details.setRes_sudarshana(policyres+claimres+riskscoreres);
				
			} else {

				
				
				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
				
                riskscoreres="scorenotfound.";
				
				hit_details.setRes_sudarshana(policyres+claimres+riskscoreres);

			}
			
			
//Vehicle Details
			
			if( detailsBySpecificregno ==null) {
				System.out.println("*************");
				rootname5 = (mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(
						"Vehicle details not found"));
				
				hit_details.setRes_udayan("VehicleDetailsNotFound.");
				
				
				
			}
			
			else {
				rootname5 = mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(detailsBySpecificregno);
				
				hit_details.setRes_udayan("VehicleDetailsFound.");
			}
			
			
			
			
			
			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));

		final	String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname5).concat(rootname4);

		final	String data = resultString.replace("}{", ",");
		
		hit_details.setResGiven_time(LocalDateTime.now().toString());
		
		//saving hit details 
		
		repo.save(hit_details);
		  
		  log.info("Exiting block DL regno validation2 ");

			return data;

		} // condition for DL registration number(val2) end
		
		
		
		
		

		// for rest of all regno
		
			
		  
			
			log.info("Entering to block-general regnos ");
			
			log.info("General regnos:"+regno);
			
			hit_details.setRegno(regno);
			
			System.out.println("Entering to block-general regnos"+regno);
			// policy details
			final List<PolicyDtls> regnolist = service.getInfo(regno);
			// claim details
			final List<ClaimHistoryService> claimInfo1 = service.getClaimInfo1(regno);
			// riskscore details
			final List<Riskscore> collectscore = service.getScore(regno);
			//vehicle details
			
			VahanVehicleDetails detailsByregno = service.getDetailsByregno(regno);

			
			//System.err.println(regnolist.isEmpty());
			if (!regnolist.isEmpty()) {
				
			

				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(regnolist));
				
				policyres="Policyfound.";
				

			} else {
				
			

				rootName = (mapper.writer().withRootName("PolicyDetails")
						.writeValueAsString("policy data not found in given regno"));
				policyres="Policynotfound.";

			}

			// claim details

			b6 = (!claimInfo1.isEmpty());

			

			if (b6) {
				
				

				rootName1 = mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo1);
				
				claimres="ClaimsFound.";

			}

			else {
				
			

				rootName1 = (mapper.writer().withRootName("ClaimDetails")
						.writeValueAsString("Claim Record not Found in given reg no"));
				
				claimres="ClaimsNotFound.";

			}

			// risk score details
			b7 = (collectscore.isEmpty());

			if (b7) {
				
				

				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
				
                riskscoreres="scorenotfound.";
				
				hit_details.setRes_sudarshana(policyres+claimres+riskscoreres);

			}

			else {
				
				

				rootname3 = mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(collectscore);
				
                riskscoreres="scorefound.";
				
				hit_details.setRes_sudarshana(policyres+claimres+riskscoreres);

			}
			
			//Vahanvehicle Details
			if( detailsByregno ==null) {
				System.out.println("*************");
				rootname5 = (mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(
						"Vehicle details not found"));
				
				hit_details.setRes_udayan("Vehicledetails not found.");
				
			}
			
			else {
				rootname5 = mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(detailsByregno);
				hit_details.setRes_udayan("Vehicledetailsfound.");
			}

			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
			String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname5).concat(rootname4);

			String data = resultString.replace("}{", ",");
			
		 	hit_details.setResGiven_time(LocalDateTime.now().toString());
			  //saving hit details into db
		 	
		 	 repo.save(hit_details);
		 	
			  log.info("Exiting to block-general regnos ");

			return data;
		

	}

}
