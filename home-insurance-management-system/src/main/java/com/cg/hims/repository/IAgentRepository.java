package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.hims.entities.Agent;

@Repository
public interface IAgentRepository extends JpaRepository<Agent, Integer> {
	
	
}
