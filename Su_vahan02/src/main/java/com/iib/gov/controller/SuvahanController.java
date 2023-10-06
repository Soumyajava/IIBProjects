//package com.iib.gov.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.slf4j.LoggerFactory;
////import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.iib.gov.entity.motorweb.PolicyDtls;
//import com.iib.gov.entity.motorweb.Riskscore;
//import com.iib.gov.entity.vahan.VahanVehicleDetails;
//import com.iib.gov.exception.CustomException;
//import com.iib.gov.service.ClaimHistoryService;
//import com.iib.gov.service.SuvahanService;
//
//@RestController
//@RequestMapping("/suvahan")
//public class SuvahanController {
//
//	@Autowired
//	private SuvahanService service;
//
//
//
//	
//	private String rootName;
//	private String rootName1;
//	private String rootname3;
//	private String rootname4;
//	private String rootname5;
//	
//	
//	private boolean b3;
//	
//	private boolean b6;
//	private boolean b7;
//
//	
//
//	private final ObjectMapper mapper = new ObjectMapper();
//
//	static Logger log = Logger.getLogger(SuvahanController.class);
//
//	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SuvahanController.class);
//
//	// @SuppressWarnings("unchecked")
//	@GetMapping("/getVehicleDetails")
//	public String getVehicleDetails(@RequestParam(required = false, defaultValue = "") String regno,
//			@RequestParam(required = false, defaultValue = "") String chassisno, HttpServletRequest request,
//			HttpServletResponse res) throws Exception {
//		
//		//getting ip address
//				String ipAddress = request.getRemoteAddr();
//				
//				log.info("client IP:"+ipAddress);
//				
//		
//			
//			
//				
//				
//		
//		
//
//		if (chassisno.length() < 11 && chassisno.length() > 0) {
//
//			throw new CustomException("Chassino. should not be less than 11 digits");
//		}
//
//		if (regno.length() < 6 && regno.length() > 0) {
//
//			throw new CustomException("Regno. should not be less than 6 digits");
//		}
//
//		if (regno.equals("") && chassisno.equals("")) {
//
//			throw new CustomException("You have to pass either registration number or chassis number or both");
//			
//		}
//		
//////////////////////////////////////chassisno and registration number////////////////////////////////////////////////////////////////////////
//		
//		if (!regno.equals("") && !chassisno.equals("")) {
//			
//		
//			
//			log.info("entering to block where chassisno and regno both are there ");
//			
//			log.info("Regno:"+regno+"/////"+"Chassisno:"+chassisno);
//			
//			System.out.println("entering to block where chassisno and regno both are there ");
//			
//			System.out.println("getting policy details");
//		final List<PolicyDtls> info4 = service.getInfo4(regno, chassisno);
//			
//		  System.out.println("getting claim details");
//		final   List<ClaimHistoryService> claimInfo3 = service.getClaimInfo3(regno, chassisno);
//		
//		//policy
//		if (!info4.isEmpty()) {
//			
//			
//
//			rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(info4));
//		} else {
//			
//			
//
//			rootName = (mapper.writer().withRootName("PolicyDetails")
//					.writeValueAsString(" policy data not found in given chassisno."));
//
//		}
//         //Claims
//		if (!claimInfo3.isEmpty()) {
//			
//			
//
//			rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo3));
//		} else {
//			
//			
//			rootName1 = (mapper.writer().withRootName("ClaimDetails")
//					.writeValueAsString("Claim Record not found in given chassisno."));
//
//		}
//		rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Chassis Number AND Registration Number"));
//	final String resultString = rootName.concat(rootName1).concat(rootname4);
//
//	final String data = resultString.replace("}{", ",");
//	
//	
//		return data;
//
//		
//		
//		}
//		
//		////////////////////////////////////chassisno Only////////////////////////////////////////////////////////////////////////
//
//		if (regno.equals(" ") || regno.equals("") && !chassisno.equals("")) {
//			
//			
//		//	hits_details.setRegno(regno);
//
//			log.info("entering to block where only chassisno is there ");
//			
//			log.info("Chassisno:"+chassisno);
//
//			System.err.println("Entering to block where only chassisno is there ");
//
//			// policy details
//			final List<PolicyDtls> info1 = service.getInfo1(chassisno);
//
//			// claim details
//			final List<ClaimHistoryService> claimInfo2 = service.getClaimInfo2(chassisno);
//
//			//policy
//			if (!info1.isEmpty()) {
//				
//				
//
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(info1));
//			} else {
//
//				
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString(" policy data not found in given chassisno."));
//
//			}
//
//			//claims
//			if (!claimInfo2.isEmpty()) {
//				
//
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo2));
//			} else {
//				
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString("Claim Record not found in given chassisno."));
//
//			}
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Chassis Number"));
//		final String resultString = rootName.concat(rootName1).concat(rootname4);
//
//		final String data = resultString.replace("}{", ",");
//		
//		
//			return data;
//		}
//		
//	////////////////////////////////////////////////////registration number///////////////////	
//
//		// ** condition registration no. is there but chassisno is empty
//
//		// condition for DL registration number(val1)
//		if ((regno.startsWith("DL") || regno.startsWith("dl")) && !regno.substring(2, 3).equals("0")
//				&& !regno.substring(2, 4).matches("(^\\d{2})")) { // && !regno.substring(2,4).matches("(^\\d{2})")
//			
//			
//              System.out.println("Entering block DL regno validation1");
//			
//			
//			log.info("Entering block DL regno validation1 ");
//			
//			log.info("DLregno val1:"+regno);
//
//			String concatreg1 = "DL" + 0 + regno.substring(2);
//			// calling service method policy details
//			final List<PolicyDtls> dlVehicleDetails = service.getDlVehicleDetails(concatreg1, regno);
//			// calling service method for claim details
//			final List<ClaimHistoryService> claimDetailsforDl = service.getClaimDetailsforDl(concatreg1, regno);
//			// calling service for risk score details
//
//			final List<Riskscore> score = service.getScore1(concatreg1, regno);
//			// policy
//
//			if (!dlVehicleDetails.isEmpty()) {
//				
//				
//
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dlVehicleDetails));
//			} else {
//				
//				
//
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString(" policy data not found in given regno."));
//
//			}
//			// claims
//
//			if (!claimDetailsforDl.isEmpty()) {
//
//				
//				
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimDetailsforDl));
//			} else {
//				
//				
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString(" Claim Record not found in given regno."));
//
//			}
//			// riskscore
//
//			if (!score.isEmpty()) {
//				
//				
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(score));
//			} else {
//
//				
//				
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
//						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
//
//			}
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
//		final	String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname4);
//
//		final	String data = resultString.replace("}{", ",");
//		
//		
//		  
//		  log.info("Exiting block DL regno validation1 ");
//
//			return data;
//
//		} // condition for DL registration number(val1) end
//
//		// condition for DL registration number(val2) start
//		else if (regno.startsWith("DL") || regno.startsWith("dl") && regno.substring(2, 3).equals("0")) {
//			
//			System.out.println("Entering block DL regno validation2");
//
//			log.info("Entering block DL regno validation2 ");
//
//			log.info("DLregno val2:"+regno);
//			String concatreg2 = regno.substring(0, 2) + regno.substring(3);
//
//			// calling service method policy details
//			final List<PolicyDtls> dlVehicleDetails = service.getDlVehicleDetails(concatreg2, regno);
//			// calling service method for claim details
//			final List<ClaimHistoryService> claimDetailsforDl = service.getClaimDetailsforDl(concatreg2, regno);
//			// calling service method for riskscore details
//
//			final List<Riskscore> score = service.getScore1(concatreg2, regno);
//
//			// policy
//
//			if (!dlVehicleDetails.isEmpty()) {
//				
//				
//
//				System.err.println("policy data found");
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(dlVehicleDetails));
//			} else {
//
//				
//				
//				
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString(" policy data not found in given regno."));
//
//			}
////claims
//
//			if (!claimDetailsforDl.isEmpty()) {
//				
//				
//
//				System.err.println("claims data found");
//				rootName1 = (mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimDetailsforDl));
//			} else {
//
//				
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString(" Claim Record not found in given regno."));
//
//			}
//			// riskscore
//
//			if (!score.isEmpty()) {
//				
//				
//
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(score));
//			} else {
//
//				
//				
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
//						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
//
//			}
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
//
//		final	String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname4);
//
//		final	String data = resultString.replace("}{", ",");
//		
//		  
//		  log.info("Exiting block DL regno validation2 ");
//
//			return data;
//
//		} // condition for DL registration number(val2) end
//		
//		
//		
//		
//		
//
//		// for rest of all regno
//		else {
//			
//		  
//			
//			log.info("Entering to block-general regnos ");
//			
//			log.info("General regnos:"+regno);
//			
//			System.out.println("Entering to block-general regnos");
//			// policy details
//			final List<PolicyDtls> regnolist = service.getDlVehicleDetails(regno,regno);
//			// claim details
//			final List<ClaimHistoryService> claimInfo1 = service.getClaimInfo1(regno);
//			// riskscore details
//			final List<Riskscore> collectscore = service.getScore(regno);
//			//vehicle details
//			
//			VahanVehicleDetails detailsByregno = service.getDetailsByregno(regno);
//
//			
//			//System.err.println(regnolist.isEmpty());
//			if (!regnolist.isEmpty()) {
//				
//			
//
//				rootName = (mapper.writer().withRootName("PolicyDetails").writeValueAsString(regnolist));
//
//			} else {
//				
//			
//
//				rootName = (mapper.writer().withRootName("PolicyDetails")
//						.writeValueAsString("policy data not found in given regno"));
//
//			}
//
//			// claim details
//
//			b6 = (!claimInfo1.isEmpty());
//
//			
//
//			if (b6) {
//				
//				
//
//				rootName1 = mapper.writer().withRootName("ClaimDetails").writeValueAsString(claimInfo1);
//
//			}
//
//			else {
//				
//			
//
//				rootName1 = (mapper.writer().withRootName("ClaimDetails")
//						.writeValueAsString("Claim Record not Found in given reg no"));
//
//			}
//
//			// risk score details
//			b7 = (collectscore.isEmpty());
//
//			if (b7) {
//				
//				
//
//				rootname3 = (mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(
//						"This Vehicle may not be a private car or no risk score generated for this vehicle"));
//
//			}
//
//			else {
//				
//				
//
//				rootname3 = mapper.writer().withRootName("RiskScoreDetails").writeValueAsString(collectscore);
//
//			}
//			
//			//Vahanvehicle Details
//			if( detailsByregno ==null) {
//				System.out.println("*************");
//				rootname5 = (mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(
//						"Vehicle details not found"));
//				
//			}
//			
//			else {
//				rootname5 = mapper.writer().withRootName("VahanVehicleDetails").writeValueAsString(detailsByregno);
//			}
//
//			rootname4 = (mapper.writer().withRootName("SEARCH_BASED_ON").writeValueAsString("Registration Number"));
//			String resultString = rootName.concat(rootName1).concat(rootname3).concat(rootname5).concat(rootname4);
//
//			String data = resultString.replace("}{", ",");
//			
//			
//			  
//			  log.info("Exiting to block-general regnos ");
//
//			return data;
//		}
//
//	}
//
//}
