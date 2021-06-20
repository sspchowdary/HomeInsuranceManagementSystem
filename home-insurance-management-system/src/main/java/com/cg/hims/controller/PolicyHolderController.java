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
//import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.service.IPolicyHolderService;

@RestController
public class PolicyHolderController {
	
	@Autowired
	private IPolicyHolderService policyHolderService;
	
	@RequestMapping(value="/PolicyHolder/all", method=RequestMethod.GET)
	public List<PolicyHolder> getAllPolicyHolder(){
		return policyHolderService.showAllPolicyHolder();
	}
	
	@RequestMapping(value= "/PolicyHolder/{id}", method= RequestMethod.GET)
    public PolicyHolder getPolicyHolderByPolicyHolderNameById(@PathVariable int id) throws PolicyHolderNotFoundException {
    Optional<PolicyHolder> policyHolder =  policyHolderService.findPolicyHolderById(id);
    
         if(!policyHolder.isPresent()) {
        	 throw new PolicyHolderNotFoundException("PolicyHolder not found for this id : " + id);  
            
        }
        else
             return policyHolder.get();        
    }

	
	@RequestMapping(value= "/PolicyHolder/add", method= RequestMethod.POST)
	public PolicyHolder addPolicyHolder(@Valid @RequestBody PolicyHolder newpolicyHolder) {       
	        return policyHolderService.addPolicyHolder(newpolicyHolder);
	}
	
	@RequestMapping(value= "/PolicyHolder/update/{id}", method= RequestMethod.PUT)
    public PolicyHolder updatePolicyHolder(@Valid @RequestBody PolicyHolder updpolicyHolder, @PathVariable int id) throws PolicyHolderNotFoundException{
        Optional<PolicyHolder> policyHolder =  policyHolderService.findPolicyHolderById(id);
        
        if (!policyHolder.isPresent()) {
                //     System.out.println("Could not find PolicyHolder with id - " + id);
                     throw new PolicyHolderNotFoundException("PolicyHolder not found for this id : " + id);
                    

        }
        else  {
                     updpolicyHolder.setPolicyHolderId(id);
                     return policyHolderService.updatePolicyHolder(updpolicyHolder);
        }
        }
	
	@RequestMapping(value= "/PolicyHolder/remove/{id}", method= RequestMethod.DELETE)
	public void deletePolicyHolder(@PathVariable int id) throws PolicyHolderNotFoundException {

	        Optional<PolicyHolder> policyHolder =  policyHolderService.findPolicyHolderById(id);
	        
	        if(!policyHolder.isPresent()) {
	    //            System.out.println("Could not find PolicyHolder with id - " + id);
	        throw new PolicyHolderNotFoundException("PolicyHolder not found for this id : " + id);
	        }
	        else   
	        
	        	policyHolderService.removePolicyHolder(id);
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

