package com.cg.hims.entities;

 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

 


@Component
@Entity
public class PolicyHolder {
    
    @Id
    @NotNull
    @Min(1)
    private int policyHolderId;
    


    @NotEmpty(message = "policyHolderName should not be empty")
	@Size(min=6, max=25)
    private String policyHolderName;
    
 
    @NotEmpty(message = "policyName should not be empty")
	@Size(min=6, max=25)
    private String policyName;
 
    @NotEmpty(message = "premiumType should not be empty")
	@Size(min=6, max=25)
    private String premiumType;
    
    @NotEmpty(message = "premiumType should not be empty")
    private String creditCard;

    @Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message="dob is Invalid")
    private String dob;
    
 
    @NotEmpty(message = " occupation should not be empty")
	@Size(min=6, max=25)
    private String occupation;
    
    @NotNull
    @Min(1)
    private int annualIncome;
    
    @NotEmpty(message = "isRetired must specify")
    private String isRetired;
    
    @NotEmpty(message = "ssn is required")
    private String ssn;
    
    @Email(message = "Not a valid Email")
    @NotEmpty(message = "emailId is required")
    private String emailId;
    
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="homeAddressId")
    private HomeAddress homeaddress;
    
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Policy policy ;
    
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="agentId", referencedColumnName = "agentId")
    private Agent agent;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;

 

    public PolicyHolder() {
        super();
    
    }

	public PolicyHolder(@NotNull @Min(1) int policyHolderId,
			@Size(min = 6, max = 25) @NotEmpty(message = "policyHolderName should not be empty") String policyHolderName,
			@Size(min = 6, max = 25)  @NotEmpty(message = "policyName should not be empty") String policyName,
			@Size(min = 6, max = 25) @NotEmpty(message = "premiumType should not be empty") String premiumType,
			@NotEmpty(message = "premiumType should not be empty") String creditCard,
			@Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "dob is Invalid") String dob,
			@Size(min = 3, max = 50) @NotEmpty(message = " occupation should not be empty") String occupation,
			@NotNull @Min(1) int annualIncome, @NotEmpty(message = "isRetired must specify") String isRetired,
			@NotEmpty(message = "ssn is required") String ssn,
			@Email(message = "Not a valid Email") @NotEmpty(message = "emailId is required") String emailId,
			HomeAddress homeaddress, Policy policy, Agent agent, User user) {
		//super();
		this.policyHolderId = policyHolderId;
		this.policyHolderName = policyHolderName;
		this.policyName = policyName;
		this.premiumType = premiumType;
		this.creditCard = creditCard;
		this.dob = dob;
		this.occupation = occupation;
		this.annualIncome = annualIncome;
		this.isRetired = isRetired;
		this.ssn = ssn;
		this.emailId = emailId;
		this.homeaddress = homeaddress;
		this.policy = policy;
		this.agent = agent;
		this.user = user;
	}

	public int getPolicyHolderId() {
		return policyHolderId;
	}

	public void setPolicyHolderId(int policyHolderId) {
		this.policyHolderId = policyHolderId;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getIsRetired() {
		return isRetired;
	}

	public void setIsRetired(String isRetired) {
		this.isRetired = isRetired;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public HomeAddress getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(HomeAddress homeaddress) {
		this.homeaddress = homeaddress;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PolicyHolder [policyHolderId=" + policyHolderId + ", policyHolderName=" + policyHolderName
				+ ", policyName=" + policyName + ", premiumType=" + premiumType + ", creditCard=" + creditCard
				+ ", dob=" + dob + ", occupation=" + occupation + ", annualIncome=" + annualIncome + ", isRetired="
				+ isRetired + ", ssn=" + ssn + ", emailId=" + emailId + ", homeaddress=" + homeaddress + ", policy="
				+ policy + ", agent=" + agent + ", user=" + user + "]";
	}

 

 }