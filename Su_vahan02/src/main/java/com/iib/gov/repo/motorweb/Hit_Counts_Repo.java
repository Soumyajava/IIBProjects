package com.iib.gov.repo.motorweb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iib.gov.entity.motorweb.Hybrid_hits_details;

public interface Hit_Counts_Repo extends JpaRepository<Hybrid_hits_details, Integer>  {
	
	@Query( value="select count(*) from Hybrid_hits_Details with(nolock) where usernamne=:username", nativeQuery = true  )
	public Integer getCount(String username);
	
	
	

}
