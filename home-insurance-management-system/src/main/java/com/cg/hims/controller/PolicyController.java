package com.cg.hims.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.service.IPolicyServiceImpl;



@RestController
public class PolicyController {
	
	@Autowired
	private IPolicyServiceImpl serviceImpl;
	
	List<Policy> list;
	
	@PostMapping(value="/policy/add")
	public ResponseEntity<Policy> addPolicy(@Valid @RequestBody  Policy policy) {
		Policy p1=serviceImpl.addPolicy(policy);
		ResponseEntity<Policy> res=new ResponseEntity<>(p1,HttpStatus.CREATED);
		return res;
	}
	
	@PutMapping(value="/policy/update")
	public ResponseEntity<Policy> updatePolicy(@Valid @RequestBody  Policy p ) throws PolicyNotFoundException {
			
			Policy p1=serviceImpl.updatePolicy(p);
			ResponseEntity<Policy> re=new ResponseEntity<>(p1,HttpStatus.ACCEPTED);
			return re;
		}

	
	@RequestMapping(value="/policy/getPolicy/{pId}",method=RequestMethod.GET)
	public ResponseEntity<Policy> findPolicyById(@PathVariable int pId) throws PolicyNotFoundException {
		
		Policy p1=serviceImpl.findPolicyById(pId);
		ResponseEntity<Policy> res=new ResponseEntity<>(p1,HttpStatus.FOUND);
		return res;
	}

	@DeleteMapping(value="/policy/delete/{policyId}")
	public ResponseEntity<String> removePolicyById(@PathVariable int policyId) throws PolicyNotFoundException {
		
		serviceImpl.removePolicyById(policyId);
		ResponseEntity<String> res=new ResponseEntity<>("Deleted",HttpStatus.OK);
		return res;
	}

	@GetMapping(path="/policy/getPolicies")
	public ResponseEntity<List<Policy>> getAllPolicies() {
	
		list=new ArrayList<Policy>();
		list=serviceImpl.showAllPolicies();
		ResponseEntity<List<Policy>> response=new ResponseEntity<>(list,HttpStatus.FOUND);
		return response;
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> MethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
									errors.put(error.getField(),error.getDefaultMessage()));
		return errors;
		}
}
