package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Property;
import com.cg.hims.repository.IPropertyRepository;

@Service

public class IPropertyServiceImp implements IPropertyService{
	
	@Autowired
	
	private IPropertyRepository propertyRepo;
	
	@Override
	
	public Property addProperty(Property property) {
		return propertyRepo.save(property);
	}
	
	@Override
	public List<Property> viewProperty() {
		return propertyRepo.findAll();
	}

	@Override
	public Optional<Property> findPropertyById(int propertyId) {
		// TODO Auto-generated method stub
		return propertyRepo.findById(propertyId);
	}

}
