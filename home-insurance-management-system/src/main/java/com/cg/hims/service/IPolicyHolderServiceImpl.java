package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.repository.IPolicyHolderRepository;
@Service
public class IPolicyHolderServiceImpl implements IPolicyHolderService {
	
	@Autowired
	private IPolicyHolderRepository policyHolderRepo;

	@Override
	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) {
		
		return policyHolderRepo.save(policyHolder);
	}

	@Override
	public List<PolicyHolder> showAllPolicyHolder() {
		
		return policyHolderRepo.findAll();
	}

	@Override
	public Optional<PolicyHolder> findPolicyHolderById(int id) {
		
		return policyHolderRepo.findById(id);
	}

	@Override
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) {
		
		return policyHolderRepo.save(policyHolder);
	}

	@Override
	public void removePolicyHolder(int id) {
		policyHolderRepo.deleteById(id);
		
	}
 

	
}