package com.cg.hims.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.IPolicyRepository;

@SpringBootTest
class IPolicyServiceImplTest {
	
	@Autowired
	private IPolicyServiceImpl serviceImpl;
	
	@MockBean
	private IPolicyRepository policyRepo;

	//Policy addPolicy(Policy policy);
	@Test
	void testAddPolicy() {
		Policy p=new Policy();
			
			Agent a=new Agent();
			a.setAgentId(2);
			
			Quote q=new Quote();
			q.setQuoteId(4);
			
			p.setPolicyEffectiveDate("13/12/2020" );
			p.setPolicyEndDate("13/12/2025");
			p.setPolicyId(1);
			p.setPolicyStatus("Active");
			p.setPolicyTerm(5);
			p.setAgent(a);
			p.setQuote(q);
			
			Mockito.when(policyRepo.save(p)).thenReturn(p);
			assertThat(serviceImpl.addPolicy(p)).isEqualTo(p);
	}
	
	// Policy updatePolicy(Policy p) throws PolicyNotFoundException;
	@Test
	void testUpdatePolicy() throws PolicyNotFoundException {
		Policy p=new Policy();
		
		Agent a=new Agent();
		a.setAgentId(2);
		
		Quote q=new Quote();
		q.setQuoteId(4);
		
		p.setPolicyEffectiveDate("13/12/2020" );
		p.setPolicyEndDate("13/12/2025");
		p.setPolicyId(1);
		p.setPolicyStatus("Active");
		p.setPolicyTerm(5);
		p.setAgent(a);
		p.setQuote(q);
		
		Optional<Policy> op=Optional.of(p);
		
		Mockito.when(policyRepo.findById(1)).thenReturn(op); 
			p.setPolicyEffectiveDate("01/02/2025");
			p.setPolicyEndDate("01/02/2028");
		Mockito.when(policyRepo.save(p)).thenReturn(p);
		assertThat(serviceImpl.updatePolicy(p)).isEqualTo(p);
	}
	
	//Policy findPolicyById(int pId) throws PolicyNotFoundException;
	 @Test
		void testFindPolicyById() throws PolicyNotFoundException {
			Policy p=new Policy();
			
			Agent a=new Agent();
			a.setAgentId(2);
			
			Quote q=new Quote();
			q.setQuoteId(4);
			
			p.setPolicyEffectiveDate("13/12/2020" );
			p.setPolicyEndDate("13/12/2025");
			p.setPolicyId(1);
			p.setPolicyStatus("Active");
			p.setPolicyTerm(5);
			p.setAgent(a);
			p.setQuote(q);
			
			Optional<Policy> op=Optional.of(p);
			
			Mockito.when(policyRepo.findById(1)).thenReturn(op);
			assertThat(serviceImpl.findPolicyById(1)).isEqualTo(op.get());
		}
	 
	 //Policy removePolicyById(int policyId) throws PolicyNotFoundException;
   @Test
	void testRemovePolicyById() {
    	Policy p=new Policy();
		
		Agent a=new Agent();
		a.setAgentId(2);
		
		Quote q=new Quote();
		q.setQuoteId(4);
		
		p.setPolicyEffectiveDate("13/12/2020" );
		p.setPolicyEndDate("13/12/2025");
		p.setPolicyId(1);
		p.setPolicyStatus("Active");
		p.setPolicyTerm(5);
		p.setAgent(a);
		p.setQuote(q);
		
		Optional<Policy> op=Optional.of(p);
		
		Mockito.when(policyRepo.findById(1)).thenReturn(op);
		Mockito.when(policyRepo.existsById(p.getPolicyId())).thenReturn(false);
		
		assertThat(policyRepo.existsById(p.getPolicyId()));
	}
    
    //List<Policy> showAllPolicies();
	 @Test
		void testShowPolicies() {
		 	Policy p=new Policy();
			
			Agent a=new Agent();
			a.setAgentId(2);
			
			Quote q=new Quote();
			q.setQuoteId(4);
			
			p.setPolicyEffectiveDate("13/12/2020" );
			p.setPolicyEndDate("13/12/2025");
			p.setPolicyId(1);
			p.setPolicyStatus("Active");
			p.setPolicyTerm(5);
			p.setAgent(a);
			p.setQuote(q);
			
			Policy p1=new Policy();
			
			Agent a1=new Agent();
			a1.setAgentId(1);
			
			Quote q1=new Quote();
			q1.setQuoteId(3);
			
			p.setPolicyEffectiveDate("1/2/2020" );
			p.setPolicyEndDate("1/2/2026");
			p.setPolicyId(2);
			p.setPolicyStatus("Active");
			p.setPolicyTerm(6);
			p.setAgent(a1);
			p.setQuote(q1);
			
			List<Policy> li=new ArrayList<>();
			li.add(p);
			li.add(p1);
			
			Mockito.when(policyRepo.findAll()).thenReturn(li);
			assertThat(serviceImpl.showAllPolicies()).isEqualTo(li);
		}
}
