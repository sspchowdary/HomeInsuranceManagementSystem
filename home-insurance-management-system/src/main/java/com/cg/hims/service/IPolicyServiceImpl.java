package com.cg.hims.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.IPolicyRepository;



@Service
public class IPolicyServiceImpl implements IPolicyService {
	
	@Autowired
	private IPolicyRepository policyRepo;
	
	List<Policy> list;

	@Override
	public Policy addPolicy(Policy policy) {
		Policy p=policyRepo.save(policy);
		return p;
	}

	@Override
	public Policy updatePolicy(Policy p) throws PolicyNotFoundException {
		int pid=p.getPolicyId();
		Supplier<PolicyNotFoundException> pEx=()->new PolicyNotFoundException("Policy with Id: "+pid+" is not present in Data");
		Policy p1=policyRepo.findById(pid).orElseThrow(pEx);
		
		p1.setPolicyStatus(p.getPolicyStatus());
		p1.setAgent(p.getAgent());
		p1.setPolicyEffectiveDate(p.getPolicyEffectiveDate());
		p1.setPolicyEndDate(p.getPolicyEndDate());
		p1.setPolicyTerm(p.getPolicyTerm());
		p1.setQuote(p.getQuote());
		policyRepo.save(p1);
		return p1;
}

	@Override
	public Policy findPolicyById(int pId) throws PolicyNotFoundException{
		Supplier<PolicyNotFoundException> pEx=()->new PolicyNotFoundException("Policy with Id: "+pId+" is not present in Data");
		Policy p1=policyRepo.findById(pId).orElseThrow(pEx);
		return p1;
	}

	@Override
	public String removePolicyById(int policyId) throws PolicyNotFoundException {
		Supplier<PolicyNotFoundException> pEx=()->new PolicyNotFoundException("Policy with Id: "+policyId+" is not present in Data");
		Policy p=policyRepo.findById(policyId).orElseThrow(pEx);
		policyRepo.delete(p);
		return "Deleted";
	}

	@Override
	public List<Policy> showAllPolicies() {
		list=new ArrayList<>();
		list=policyRepo.findAll();
		return list;
	}
}
