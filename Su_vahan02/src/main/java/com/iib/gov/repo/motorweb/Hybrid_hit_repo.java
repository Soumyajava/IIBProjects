package com.iib.gov.repo.motorweb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iib.gov.entity.motorweb.Hybrid_hits_details;

@Repository
public interface Hybrid_hit_repo extends JpaRepository<Hybrid_hits_details, Integer> {

}
