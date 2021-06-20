 package com.cg.hims.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Property {
	
	@Id
	@GeneratedValue
	private int propertyId;
	@NotNull
	@Min(10000)
	private int marketValue;
	@NotNull
	@Min(1900)
	private int yearBuilt;
	private int squareFootage;
	@NotNull
	@Min(5)
	private double dwellingStyle;
	@NotEmpty(message="roofnaterial is required!!!")
	private String roofMaterial;
	@NotEmpty(message="garagetype is required!!!")
	private String garageType;
	private int fullBathCount;
	private int halfBathCount;
	private boolean hasSwimmingPool;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="quote_Id") 
	private Quote quote;
	
	public Property() {
		super();
	}



	public Property(int propertyId, @NotNull @Min(10000) int marketValue, @NotNull @Min(1900) int yearBuilt,
			int squareFootage, @NotNull @Min(5) double dwellingStyle,
			@NotEmpty(message = "roofnaterial is required!!!") String roofMaterial,
			@NotEmpty(message = "garbagetype is required!!!") String garageType, int fullBathCount, int halfBathCount,
			boolean hasSwimmingPool,Quote quote) {
		super();
		this.propertyId = propertyId;
		this.marketValue = marketValue;
		this.yearBuilt = yearBuilt;
		this.squareFootage = squareFootage;
		this.dwellingStyle = dwellingStyle;
		this.roofMaterial = roofMaterial;
		this.garageType = garageType;
		this.fullBathCount = fullBathCount;
		this.halfBathCount = halfBathCount;
		this.hasSwimmingPool = hasSwimmingPool;
		this.quote=quote;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public int getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getDwellingStyle() {
		return dwellingStyle;
	}

	public void setDwellingStyle(double dwellingStyle) {
		this.dwellingStyle = dwellingStyle;
	}

	public String getRoofMaterial() {
		return roofMaterial;
	}

	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}

	public String getGarageType() {
		return garageType;
	}

	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}

	public int getFullBathCount() {
		return fullBathCount;
	}

	public void setFullBathCount(int fullBathCount) {
		this.fullBathCount = fullBathCount;
	}

	public int getHalfBathCount() {
		return halfBathCount;
	}

	public void setHalfBathCount(int halfBathCount) {
		this.halfBathCount = halfBathCount;
	}

	public boolean isHasSwimmingPool() {
		return hasSwimmingPool;
	}

	public void setHasSwimmingPool(boolean hasSwimmingPool) {
		this.hasSwimmingPool = hasSwimmingPool;
	}

	public void setQuote(Quote quote) {
		this.quote=quote;
	}
	
	public Quote getQuote() {
		return quote;
	}



	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", marketValue=" + marketValue + ", yearBuilt=" + yearBuilt
				+ ", squareFootage=" + squareFootage + ", dwellingStyle=" + dwellingStyle + ", roofMaterial="
				+ roofMaterial + ", garageType=" + garageType + ", fullBathCount=" + fullBathCount + ", halfBathCount="
				+ halfBathCount + ", hasSwimmingPool=" + hasSwimmingPool + "Quote="+quote+"]";
	}

	

	
	
}
