package com.iib.gov.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iib.gov.model.NewVehiclesData;
import com.iib.gov.model.Rtadata;
@Repository
public class InsurerSearchDaoImpl implements InsurerSearchDao{
	@Autowired
	private JdbcTemplate jdbctemplate;
	private final String FETCH_SQL_FROM_RTA="select * from Rtadata where chassisno= ?";

     private final String FETCH_SQL_FROM_NEW_VEHICLE="select * from NewVehiclesData where chassisno=?";

	@Override
	public List<Rtadata> getByChassisNo(String chassisno) {
		
		List<Map<String, Object>> rows;
	
		ArrayList<Rtadata> customers = new ArrayList<Rtadata>();
		rows=//jdbctemplate.queryForList(FETCH_SQL_FROM_RTA,new Object[] {});
				jdbctemplate.queryForList(FETCH_SQL_FROM_RTA , new Object[] {chassisno} );
		for (Map row : rows) {
			Rtadata customer1 = new Rtadata();
			customer1.setChassisno(row.get("chassisno").toString());
			customer1.setEngineno(row.get("engineno").toString());
			customer1.setPolicyno(row.get("policyno").toString());
			customers.add(customer1);
		}
		
		return customers;
	}

	@Override
	public List<NewVehiclesData> getnewVehiclesByChassisNo(String chassisno) {
		List<Map<String, Object>> rows;
		ArrayList<NewVehiclesData> customers = new ArrayList<NewVehiclesData>();
		rows=jdbctemplate.queryForList(FETCH_SQL_FROM_NEW_VEHICLE,new Object[] {chassisno});
		for (Map row : rows) {
			NewVehiclesData customer1 = new NewVehiclesData();
			customer1.setChassisno(row.get("chassisno").toString());
			customer1.setEngineno(row.get("engineno").toString());
			customer1.setPolicyno(row.get("policyno").toString());
			customers.add(customer1);
		}
		return customers;
	}

}
