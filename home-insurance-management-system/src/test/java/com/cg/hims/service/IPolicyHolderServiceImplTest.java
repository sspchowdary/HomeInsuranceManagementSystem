 package com.cg.hims.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hims.repository.IPolicyHolderRepository;
import com.cg.hims.service.IPolicyHolderService;
import com.cg.hims.entities.PolicyHolder;
 


@SpringBootTest
class PolicyHolderTest {
	
	@Autowired
	IPolicyHolderService policyHolderService; 
	
	@MockBean
	IPolicyHolderRepository policyHolderRepo;

	@Test
	void testAddPolicyHolder() {
		PolicyHolder e1=new PolicyHolder();
		e1.setPolicyHolderId(1);
		e1.setPolicyHolderName("Raja");
		e1.setPolicyName("life insurance");
		e1.setPremiumType("quartely");
		e1.setCreditCard("yes");
		e1.setDob("2/2/1990");
		e1.setOccupation("software");
		e1.setAnnualIncome(1200000);
		e1.setIsRetired("no");
		e1.setSsn("123");
		e1.setEmailId("abc@gmail.com");
		
		
		   
		PolicyHolder e2=new PolicyHolder();
		e2.setPolicyHolderId(2);
		e2.setPolicyHolderName("ajay");
		e2.setPolicyName("life insurance");
		e2.setPremiumType("annualy");
		e2.setCreditCard("yes");
		e2.setDob("22/12/1990");
		e2.setOccupation("senior analyst");
		e2.setAnnualIncome(5000000);
		e2.setIsRetired("no");
		e2.setSsn("456");
		e2.setEmailId("xyz@gmail.com");
		
		
		 
		
		List<PolicyHolder> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		
		Mockito.when(policyHolderRepo.findAll()).thenReturn(empList);
		
		//assertThat(policyHolderRepo.addPolicyHolder()).isEqualTo(empList);
		
	}

	@Test
	void testFindPolicyHolderById() {
		PolicyHolder e1=new PolicyHolder();
		e1.setPolicyHolderId(1);
		e1.setPolicyHolderName("Raja");
		e1.setPolicyName("life insurance");
		e1.setPremiumType("quartely");
		e1.setCreditCard("yes");
		e1.setDob("2/2/1990");
		e1.setOccupation("software");
		e1.setAnnualIncome(1200000);
		e1.setIsRetired("no");
		e1.setSsn("123");
		e1.setEmailId("abc@gmail.com");
		 
		Optional<PolicyHolder> e2=Optional.of(e1);
   Mockito.when(policyHolderRepo.findById(1)).thenReturn(e2);
   assertThat(policyHolderService.findPolicyHolderById(1)).isEqualTo(e2);
	}
	@Test
	void testUpdatePolicyHolder() throws Exception {
		PolicyHolder e1=new PolicyHolder();
		e1.setPolicyHolderId(1);
		e1.setPolicyHolderName("Raja");
		e1.setPolicyName("life insurance");
		e1.setPremiumType("quartely");
		e1.setCreditCard("yes");
		e1.setDob("2/2/1990");
		e1.setOccupation("software");
		e1.setAnnualIncome(1200000);
		e1.setIsRetired("no");
		e1.setSsn("123");
		e1.setEmailId("abc@gmail.com");
		
		 
		Optional<PolicyHolder> e2 = Optional.of(e1);
		Mockito.when(policyHolderRepo.findById((int)1)).thenReturn(e2);
		e1.setPolicyHolderName("Raja");;
		Mockito.when(policyHolderRepo.save(e1)).thenReturn(e1);
		assertThat(policyHolderService.updatePolicyHolder(e1)).isEqualTo(e1);
	}
     @Test
	void testRemovePolicyHolder() {
		PolicyHolder e1=new PolicyHolder();
		e1.setPolicyHolderId(1);
		e1.setPolicyHolderName("Raja");
		e1.setPolicyName("life insurance");
		e1.setPremiumType("quartely");
		e1.setCreditCard("yes");
		e1.setDob("2/2/1990");
		e1.setOccupation("software");
		e1.setAnnualIncome(1200000);
		e1.setIsRetired("no");
		e1.setSsn("123");
		e1.setEmailId("abc@gmail.com");
		
		Optional<PolicyHolder> e2=Optional.of(e1);
		Mockito.when(policyHolderRepo.findById(1)).thenReturn(e2);
		 Mockito.when(policyHolderRepo.existsById(e1.getPolicyHolderId())).thenReturn(false);
		   assertFalse(policyHolderRepo.existsById(e1.getPolicyHolderId()));
	}
}