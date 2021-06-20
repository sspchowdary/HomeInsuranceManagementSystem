package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;


public interface IPolicyService {
	
	 Policy addPolicy(Policy policy);

	 Policy updatePolicy(Policy p) throws PolicyNotFoundException;

     Policy findPolicyById(int pId) throws PolicyNotFoundException;

	 String removePolicyById(int policyId) throws PolicyNotFoundException;

	 List<Policy> showAllPolicies();

}


