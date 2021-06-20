package com.cg.hims.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.hims.entities.Agent;
import com.cg.hims.repository.IAgentRepository;

@Service
public class IAgentServiceImp implements IAgentService {
	
	@Autowired
	private IAgentRepository agentRepo;

	@Override
	public Agent addAgent(Agent agent) {
		return agentRepo.save(agent);
	}

	@Override
	public List<Agent> viewAllAgents() {
		return agentRepo.findAll();
	}

	@Override
	public Optional<Agent> findAgentById(int agentId) {
		return agentRepo.findById(agentId);
	}

	@Override
	public Agent updateAgent(Agent agent) {
		return agentRepo.save(agent);
	}

	@Override
	public void removeAgent(int agentId) {
		agentRepo.deleteById(agentId);
	}

}
