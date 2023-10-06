package com.iib.gov.entity.motorweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="Sudarshana_Hits")
@Table(name="Hybrid_hits_Details")
public class Hybrid_hits_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	
	public int id;
	
	public String usernamne;
	
	public String regno;
	
	public String chassisno;
	
	public String request_time;
	
	public String ip_address;
	
	public String res_sudarshana;
	
	public String res_udayan;
	
	public String resGiven_time;
	
	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getUsernamne() {
		return usernamne;
	}




	public void setUsernamne(String usernamne) {
		this.usernamne = usernamne;
	}




	public String getRegno() {
		return regno;
	}




	public void setRegno(String regno) {
		this.regno = regno;
	}




	public String getChassisno() {
		return chassisno;
	}




	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}




	public String getRequest_time() {
		return request_time;
	}




	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}




	public String getIp_address() {
		return ip_address;
	}




	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}




	public String getRes_sudarshana() {
		return res_sudarshana;
	}




	public void setRes_sudarshana(String res_sudarshana) {
		this.res_sudarshana = res_sudarshana;
	}




	public String getRes_udayan() {
		return res_udayan;
	}




	public void setRes_udayan(String res_udayan) {
		this.res_udayan = res_udayan;
	}




	public String getResGiven_time() {
		return resGiven_time;
	}




	public void setResGiven_time(String resGiven_time) {
		this.resGiven_time = resGiven_time;
	}




	public Hybrid_hits_details() {
		
		System.out.println("Hybrid_hits_details.Hybrid_hits_details()");
		
	}

}
