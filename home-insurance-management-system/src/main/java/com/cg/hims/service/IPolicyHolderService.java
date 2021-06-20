package com.cg.hims.service;

import java.util.List;
import java.util.Optional;
import com.cg.hims.entities.PolicyHolder;


public interface IPolicyHolderService {
	
	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder);
	public List<PolicyHolder> showAllPolicyHolder();
	public Optional<PolicyHolder> findPolicyHolderById(int id);
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder);
	public void removePolicyHolder(int id);
 
}
