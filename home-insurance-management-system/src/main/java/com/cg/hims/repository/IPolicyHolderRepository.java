package com.cg.hims.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.hims.entities.PolicyHolder;

@Repository
public interface IPolicyHolderRepository extends JpaRepository<PolicyHolder,Integer> {
	Optional<PolicyHolder> findBypolicyHolderName(String policyHolderName);
	List<PolicyHolder> findByPolicyName(String policyName);
    List<PolicyHolder> findByPremiumType(String premiumType);
}