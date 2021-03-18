package com.iib.gov.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iib.gov.model.NewVehiclesData;
import com.iib.gov.model.Rtadata;

@Repository
public interface InsurerSearchDao {
	
	public List<Rtadata> getByChassisNo(String chassisno);
	public List<NewVehiclesData> getnewVehiclesByChassisNo(String chassisno);

}
