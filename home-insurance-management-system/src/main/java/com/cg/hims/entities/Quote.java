package com.cg.hims.entities;

import javax.persistence.CascadeType; 
import javax.persistence.Entity; 
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id; 
import javax.persistence.JoinColumn; 
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity 
public class Quote {

	@Id
	private int quoteId;
	
	@NotEmpty(message= "premiumType should not be empty")
	private String premiumType; 
	
	@NotNull
	@Min(100000)
	@Max(10000000)
	private double premium;
	
	@NotNull
	@Min(15000)
	@Max(10000000)
	private double dwellingCoverage; 
	
	@NotNull
	@Min(15000)
	@Max(10000000)
	private double detachedStructureCoverage;
	
	@NotNull
	@Min(15000)
	@Max(10000000)
	private double personalPropertyCoverage; 
	
	@NotNull
	@Min(15000)
	@Max(10000000)
	private double additionalLivingExpense; 
	
	@NotNull
	@Min(15000)
	@Max(10000000)
	private double medicalExpense; 
	
	@NotNull
	@Min(15000)
	@Max(10000000)
	private double deductibleAmount;

	public Quote(int quoteId, @NotEmpty(message = "premiumType should not be empty") String premiumType,
			@NotNull @Min(15000) @Max(10000000) double premium, @NotNull @Min(2) @Max(8) double dwellingCoverage,
			@NotNull @Min(15000) @Max(10000000) double detachedStructureCoverage,
			@NotNull @Min(15000) @Max(10000000) double personalPropertyCoverage,
			@NotNull @Min(15000) @Max(10000000) double additionalLivingExpense, @NotNull @Min(2) @Max(8) double medicalExpense,
			@NotNull @Min(15000) @Max(10000000) double deductibleAmount) {
		super();
		this.quoteId = quoteId;
		this.premiumType = premiumType;
		this.premium = premium;
		this.dwellingCoverage = dwellingCoverage;
		this.detachedStructureCoverage = detachedStructureCoverage;
		this.personalPropertyCoverage = personalPropertyCoverage;
		this.additionalLivingExpense = additionalLivingExpense;
		this.medicalExpense = medicalExpense;
		this.deductibleAmount = deductibleAmount;
		
	}

	public Quote() 
	{ 
		super(); 
	}

	public int getQuoteId() { 
		return quoteId; 
	}

	public void setQuoteId(int quoteId) { 
		this.quoteId = quoteId; 
	}

	public String getPremiumType() { 
		return premiumType; 
	}

	public void setPremiumType(String premiumType) { 
		this.premiumType = premiumType; 
	}

	public double getPremium() { 
		return premium; 
	}

	public void setPremium(double premium) { 
		this.premium = premium; 
	}

	public double getDwellingCoverage() { 
		return dwellingCoverage; 
	}

	public void setDwellingCoverage(double dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage; 
	}

	public double getDetachedStructureCoverage() { 
		return detachedStructureCoverage; 
	}

	public void setDetachedStructureCoverage(double detachedStructureCoverage) {
		this.detachedStructureCoverage = detachedStructureCoverage; 
	}

	public double getPersonalPropertyCoverage() { 
		return personalPropertyCoverage; 
	}

	public void setPersonalPropertyCoverage(double personalPropertyCoverage) {
		this.personalPropertyCoverage = personalPropertyCoverage; 
	}

	public double getAdditionalLivingExpense() { 
		return additionalLivingExpense;
	}

	public void setAdditionalLivingExpense(double additionalLivingExpense) {
		this.additionalLivingExpense = additionalLivingExpense; 
	}

	public double getMedicalExpense() { 
		return medicalExpense; 
	}

	public void setMedicalExpense(double medicalExpense) { 
		this.medicalExpense = medicalExpense; 
	}

	public double getDeductibleAmount() { 
		return deductibleAmount; 
	}

	public void setDeductibleAmount(double deductibleAmount) {
		this.deductibleAmount = deductibleAmount; 
	}
	
//	public Property getProperty() { 
//		return property; 
//	}
//
//	public void setProperty(Property property) { 
//		this.property = property; 
//	}

	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", premiumType=" + premiumType + ", premium=" + premium
				+ ", dwellingCoverage=" + dwellingCoverage + ", detachedStructureCoverage=" + detachedStructureCoverage
				+ ", personalPropertyCoverage=" + personalPropertyCoverage + ", additionalLivingExpense="
				+ additionalLivingExpense + ", medicalExpense=" + medicalExpense + ", deductibleAmount="
				+ deductibleAmount +  "]";
	}

	



}
