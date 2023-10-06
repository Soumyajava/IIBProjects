package com.iib.gov.repo.motorweb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import com.iib.gov.entity.motorweb.Riskscore;

@Repository
public interface VchvsRepo5 extends JpaRepository<Riskscore,String> {
	
	@Query(value="SELECT distinct Registration_Number,score,slabs FROM RISK_SCORE_VCHVS_Latest_Phani with(nolock) WHERE Registration_Number=:regno", nativeQuery = true)
	
	public List<Riskscore> findByRegno(String regno);
	
	
	@Query(value="SELECT distinct Registration_Number,score,slabs FROM RISK_SCORE_VCHVS_Latest_Phani with(nolock) WHERE Registration_Number in(:regno1,:regno2)", nativeQuery = true)
	public List<Riskscore> findByRegnos(String regno1, String regno2);

}
