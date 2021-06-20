 package com.cg.hims.service;
 
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.hims.entities.Agent;
import com.cg.hims.repository.IAgentRepository;
import com.cg.hims.service.IAgentService;

@SpringBootTest
class AgentTest {
	
	@Autowired
	IAgentService agentService;
	
	@MockBean
	IAgentRepository agentRepo;
	@Test
	void testaddAgent() {
		Agent e1=new Agent();
		e1.setAgentId(1);
		e1.setAgentName("virinchi");
		e1.setAddress("1-67");
		e1.setDesignation("software");
		e1.setEmail("viri@gmail.com");
		e1.setMobileNo("789");
		e1.setSalary("100000");
		
		
		   
		Agent e2=new Agent();
		e2.setAgentId(2);
		e2.setAgentName("va");
		e2.setAddress("1.36");
		e2.setDesignation("senior software");
		e2.setEmail("varui@gmail.com");
		e2.setMobileNo("7894564569");
		e2.setSalary("1300000");
		
		List<Agent> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		
		Mockito.when(agentRepo.findAll()).thenReturn(empList);
		
		//assertThat( agentRepo.addAgent()).isEqualTo(empList);
		
	}

	@Test
	void testfindAgentById() {
		Agent e1=new Agent();
		e1.setAgentId(1);
		e1.setAgentName("virinchi");
		e1.setAddress("1-67");
		e1.setDesignation("software");
		e1.setEmail("viri@gmail.com");
		e1.setMobileNo("78");
		e1.setSalary("100000");
		
		 
		Optional<Agent> e2=Optional.of(e1);
   Mockito.when(agentRepo.findById(1)).thenReturn(e2);
   assertThat(agentService.findAgentById(1)).isEqualTo(e2);
	}
	
	@Test
	void testupdateAgent() throws Exception {
		Agent e1=new Agent();
		e1.setAgentId(1);
		e1.setAgentName("virinchi");
		e1.setAddress("1-67");
		e1.setDesignation("software");
		e1.setEmail("viri@gmail.com");
		e1.setMobileNo("7894561230");
		e1.setSalary("100000");
		e1.setEmail("abc@gmail.com");
		
		 
		Optional<Agent> e2 = Optional.of(e1);
		Mockito.when(agentRepo.findById((int)1)).thenReturn(e2);
		e1.setAgentName("virinchi");
		Mockito.when(agentRepo.save(e1)).thenReturn(e1);
		assertThat(agentService.updateAgent(e1)).isEqualTo(e1);
	}
	@Test
	void testremoveAgent() {
		Agent e1=new Agent();
		e1.setAgentId(1);
		e1.setAgentName("virinchi");
		e1.setAddress("1-67");
		e1.setDesignation("software");
		e1.setEmail("viri@gmail.com");
		e1.setMobileNo("7894561230");
		e1.setSalary("100000");
		e1.setEmail("abc@gmail.com");
		
		Optional<Agent> e2=Optional.of(e1);
		Mockito.when(agentRepo.findById(1)).thenReturn(e2);
		 Mockito.when(agentRepo.existsById(e1.getAgentId())).thenReturn(false);
		   assertFalse(agentRepo.existsById(e1.getAgentId()));
	}
	
	@Test
	void testviewAllAgents() {
		Agent e1=new Agent();
		e1.setAgentId(1);
		e1.setAgentName("virinchi");
		e1.setAddress("1-67");
		e1.setDesignation("software");
		e1.setEmail("viri@gmail.com");
		e1.setMobileNo("7894561230");
		e1.setSalary("100000");
		e1.setEmail("abc@gmail.com");
		List<Agent> ls = new ArrayList<>();
		ls.add(e1);
		Mockito.when(agentRepo.findAll()).thenReturn(ls);
		assertThat(agentService.viewAllAgents()).isEqualTo(ls);	
	}
			

}
