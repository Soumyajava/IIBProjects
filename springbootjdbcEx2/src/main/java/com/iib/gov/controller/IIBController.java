package com.iib.gov.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iib.gov.dao.InsurerSearchDao;
import com.iib.gov.model.NewVehiclesData;
import com.iib.gov.model.Rtadata;

@RestController
public class IIBController {
	@Autowired
	InsurerSearchDao dao;
	
	@GetMapping("getdata/{chassisno}")
	public String getById(@PathVariable final String chassisno ) throws IOException,SQLException
 {
		
		List<Rtadata> rtadata=dao.getByChassisNo(chassisno);
		List<NewVehiclesData> newvdata=dao.getnewVehiclesByChassisNo(chassisno);
		String rootName;
		String rootName1;
		ObjectMapper mapper = new ObjectMapper();
		if(rtadata.isEmpty()){
		rootName = (mapper.writer().withRootName("Rtadata").writeValueAsString("No RTA Record Found"));
		}
		else {
		rootName = (mapper.writer().withRootName("Rtadata").writeValueAsString(rtadata));
		}
		if(newvdata.isEmpty()){
		// regDetails.setFound("N");
		    rootName1 = (mapper.writer().withRootName("NewVehicles").writeValueAsString("No Claim Record Found"));
		   
		} else {
		rootName1 = (mapper.writer().withRootName("NewVehicles").writeValueAsString(newvdata));
		}
		
		 String rt = rootName+rootName1;
		 System.out.println(rt);
		// String policydata= rt.replace("}{", ",");
		// return Response.ok(rt).build();
		 return rt;
	//	return Response.ok(policydata).build();
		
	}

}
