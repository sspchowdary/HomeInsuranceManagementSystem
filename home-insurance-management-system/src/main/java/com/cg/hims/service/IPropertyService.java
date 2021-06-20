package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import com.cg.hims.entities.Property;

public interface IPropertyService {

	public Property addProperty(Property property);

	public List<Property> viewProperty();

	public Optional<Property> findPropertyById(int propertyId);


}
