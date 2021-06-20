package com.cg.hims.entities;

import java.util.HashSet;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Agent {
	
	@Id
	@NotNull
    @Min(1)
	private int agentId;
	
	@NotEmpty(message = "Name Should not be empty")
	@Size(min=6, max=25)
	private String agentName;
	
	@NotEmpty(message = "Designation must be entered")
	@Size(min=3, max=25)
	private String designation;
	
	@NotEmpty(message = "Salary must be entered")
	private String salary;
	
	@NotEmpty(message = "Address must be entered")
	@Size(min=3, max=25)
	private String address;
	
	@NotEmpty(message = "Email must be entered")
	@Email(message = "Email is Not Valid")
	private String email;
	
	@NotEmpty(message = "Mobile number must be entered")
    @NotNull
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Mobile number is invalid")
	private String mobileNo;
	
	
	@OneToMany(mappedBy="agent",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Policy> policies = new HashSet<>();
	
	
	@OneToMany(mappedBy="agent",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<PolicyHolder> policyholders = new HashSet<>();
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user; 
	
	public Agent() {
		super();
	}

	public Agent(@NotNull @Min(1) int agentId,
			@NotEmpty(message = "Name Should not be empty") @Size(min = 6, max = 25) @Pattern(regexp = "^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$", message = "Name is invalid") String agentName,
			@NotEmpty(message = "Designation must be entered") @Size(min = 3, max = 25) String designation,
			@NotEmpty(message = "Salary must be entered") String salary,
			@NotEmpty(message = "Address must be entered") @Size(min = 3, max = 25) String address,
			@NotEmpty(message = "Email must be entered") @Email(message = "Email is Not Valid") String email,
			@NotEmpty(message = "Mobile number must be entered") @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Mobile number is invalid") String mobileNo,
			Set<Policy> policies, Set<PolicyHolder> policyholders, User user) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
		this.email = email;
		this.mobileNo = mobileNo;
		this.policies = policies;
		this.policyholders = policyholders;
		this.user = user;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}

	public Set<PolicyHolder> getPolicyholders() {
		return policyholders;
	}

	public void setPolicyholders(Set<PolicyHolder> policyholders) {
		this.policyholders = policyholders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agentName=" + agentName + ", designation=" + designation + ", salary="
				+ salary + ", address=" + address + ", email=" + email + ", mobileNo=" + mobileNo + ", policies="
				+ policies + ", policyholders=" + policyholders + ", user=" + user + "]";
	}

	

	
}