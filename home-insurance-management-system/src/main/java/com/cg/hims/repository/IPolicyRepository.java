package com.cg.hims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.hims.entities.Policy;



@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Integer> {

   List<Policy> findByPolicyStatus(String status);

	
	

}
