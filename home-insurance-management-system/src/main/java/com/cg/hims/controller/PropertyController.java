package com.cg.hims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.cg.hims.entities.Property;
import com.cg.hims.service.IPropertyService;


@RestController
public class PropertyController{
	
	@Autowired
	
	private IPropertyService propertyService;
	
	@GetMapping("/")
    public String home() {
        return "<h1>Welcome to SpringRESTful Web Services</h1>";
    }
	@RequestMapping(value="/property/all", method=RequestMethod.GET)
	public List<Property> getProperty(){
		return propertyService.viewProperty();
	}
	
	
	@RequestMapping(value= "/property/{propertyId}", method= RequestMethod.GET)
    public Property getProperty(@PathVariable int propertyId) {
        Optional<Property> property = propertyService.findPropertyById(propertyId);
        if(!property.isPresent()) {
             return new Property();       
        }
        else
            return property.get();       
    }
	
	@RequestMapping(value= "/property/add", method= RequestMethod.POST)
	public Property addProperty(@Valid @RequestBody Property newproperty) {       
	        return propertyService.addProperty(newproperty);
	}
	
	@RequestMapping(value= "/property/update/{propertyId}", method= RequestMethod.PUT)
    public Property updateProperty(@Valid @RequestBody Property updproperty, @PathVariable int propertyId) {
        Optional<Property> ppt =  propertyService.findPropertyById(propertyId);
        if (!ppt.isPresent()) {
                     System.out.println("Could not find property with propertyId - " + propertyId);
                     return new Property();
        }
        else  {
                     updproperty.setPropertyId(propertyId);
                     return propertyService.addProperty(updproperty);
        }
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
