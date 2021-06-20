package com.cg.hims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hims.entities.Agent;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.service.IAgentService;


@RestController
public class AgentController{

	@Autowired
	private IAgentService agentService;
	
	@RequestMapping(value="/agent/all", method=RequestMethod.GET )
	public List<Agent> getAllAgent() {
		return agentService.viewAllAgents();
	}
	
	@RequestMapping(value= "/agent/add", method= RequestMethod.POST)
	public Agent addAgent(@Valid @RequestBody Agent newagent) {       
	        return agentService.addAgent(newagent);
	}
	
	@RequestMapping(value= "/agent/update/{id}", method= RequestMethod.PUT)
    public Agent updateAgent(@Valid @RequestBody Agent updagent, @PathVariable int id)throws AgentNotFoundException {
        Optional<Agent> agt =  agentService.findAgentById(id);
        if (!agt.isPresent()) {
        	throw new AgentNotFoundException("Could not find agent with id-" +id);  
        }
        else  {
                     updagent.setAgentId(id);
                     return agentService.updateAgent(updagent);
        }
	}
	
	
	@RequestMapping(value= "/agent/delete/{id}", method= RequestMethod.DELETE)
	public void deleteAgent(@PathVariable int id) throws AgentNotFoundException {

	        Optional<Agent> agt =  agentService.findAgentById(id);
	         
	        	if(!agt.isPresent()) {
		        	throw new AgentNotFoundException("Could not find agent with id-" +id);
		        }
		        		
		        else   
		                agentService.removeAgent(id);
	        
	        
	}
	
	@RequestMapping(value= "/agent/{id}", method= RequestMethod.GET)
    public Agent getAgent(@PathVariable int id)throws AgentNotFoundException {
        Optional<Agent> agent = agentService.findAgentById(id);
        if(!agent.isPresent()) {
        	throw new AgentNotFoundException("Could not find agent with id-" +id);      
        }
        else
            return agent.get();       
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
     
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
         
        return errors;
    }
}
