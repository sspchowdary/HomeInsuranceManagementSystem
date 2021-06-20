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
import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.PropertyNotFoundException;
import com.cg.hims.repository.IPropertyRepository;

@SpringBootTest
class IPropertyServiceImplementationTest 
{
	
	@Autowired
	IPropertyService propertyService;
	
	@MockBean
	IPropertyRepository propertyrepo;
	
						//Add Property Testing
	@Test
	void testaddProperty() 
	{
		Property p1=new Property();
		p1.setPropertyId(2);
		p1.setMarketValue(150000);
		p1.setYearBuilt(2004);
		p1.setSquareFootage(150);
		p1.setDwellingStyle(8);
		p1.setRoofMaterial("cement");
		p1.setGarageType("semi-garbage");
		p1.setFullBathCount(5);
		p1.setHalfBathCount(2);
		p1.setHasSwimmingPool(true);
		
		Mockito.when(propertyrepo.save(p1)).thenReturn(p1);
		assertThat(propertyService.addProperty(p1)).isEqualTo(p1);
	}
	
						//View Property Testing
	@Test
	void testviewProperty() 
	{
		Property p1=new Property();
		p1.setPropertyId(2);
		p1.setMarketValue(150000);
		p1.setYearBuilt(2004);
		p1.setSquareFootage(150);
		p1.setDwellingStyle(8);
		p1.setRoofMaterial("cement");
		p1.setGarageType("semi-garbage");
		p1.setFullBathCount(5);
		p1.setHalfBathCount(2);
		p1.setHasSwimmingPool(true);
		
		Property p2=new Property();
		p2.setPropertyId(3);
		p2.setMarketValue(230000);
		p2.setYearBuilt(1999);
		p2.setSquareFootage(245);
		p2.setDwellingStyle(14);
		p2.setRoofMaterial("putty");
		p2.setGarageType("non-garbage");
		p2.setFullBathCount(8);
		p2.setHalfBathCount(4);
		p2.setHasSwimmingPool(false);
		
		List<Property> propertyList = new ArrayList<>();
		propertyList.add(p1);
		propertyList.add(p2);
		
		Mockito.when(propertyrepo.findAll()).thenReturn(propertyList);
		assertThat(propertyService.viewProperty()).isEqualTo(propertyList);
	}
	
						//View Property By Id Testing
	@Test
	void testfindPropertyById() throws PropertyNotFoundException 
	{
		Property p1=new Property();
		p1.setPropertyId(2);
		p1.setMarketValue(150000);
		p1.setYearBuilt(2004);
		p1.setSquareFootage(150);
		p1.setDwellingStyle(8);
		p1.setRoofMaterial("cement");
		p1.setGarageType("semi-garbage");
		p1.setFullBathCount(5);
		p1.setHalfBathCount(2);
		p1.setHasSwimmingPool(true);
		
		Optional<Property> op=Optional.of(p1);
		
		Mockito.when(propertyrepo.findById(2)).thenReturn(op);
		   assertThat(propertyService.findPropertyById(2)).isEqualTo(op.get());
	}

}
