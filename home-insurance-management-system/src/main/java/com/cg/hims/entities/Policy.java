package com.cg.hims.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int policyId;
 
	@NotEmpty(message="policyEffectiveDate should not be empty")
	private String policyEffectiveDate;
	
	@NotEmpty(message="policyEndDate should not be empty")
	private String policyEndDate;
	@Min(1)
	private int policyTerm;
	
	@NotEmpty(message="policyStatus should not be empty")
	private String policyStatus;

    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="quote_id")
    private Quote quote;
    

    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="agentId")
    private Agent agent;
    
    public Policy() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Policy(int policyId,
			@NotEmpty(message = "policyEffectiveDate should not be empty") String policyEffectiveDate,
			 @NotEmpty(message = "policyEndDate should not be empty") String policyEndDate,
			@Min(1) int policyTerm,
			 @NotEmpty(message = "policyStatus should not be empty") String policyStatus,
			Quote quote, Agent agent) {
		super();
		this.policyId = policyId;
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyEndDate = policyEndDate;
		this.policyTerm = policyTerm;
		this.policyStatus = policyStatus;
		this.quote = quote;
		this.agent = agent;
	}


 public int getPolicyId() {
        return policyId;
    }

public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

public String getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

public void setPolicyEffectiveDate(String policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }

public String getPolicyEndDate() {
        return policyEndDate;
    }

public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

public int getPolicyTerm() {
        return policyTerm;
    }

public void setPolicyTerm(int policyTerm) {
        this.policyTerm = policyTerm;
    }

public String getPolicyStatus() {
        return policyStatus;
    }

public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

 public Quote getQuote() {
        return quote;
    }

public void setQuote(Quote quote) {
        this.quote = quote;
    }

public Agent getAgent() {
        return agent;
    }

public void setAgent(Agent agent) {
        this.agent = agent;
    }
 
@Override
    public String toString() {
        return "Policy [policyId=" + policyId + ", policyEffectiveDate=" + policyEffectiveDate + ", policyEndDate="
                + policyEndDate + ", policyTerm=" + policyTerm + ", policyStatus=" + policyStatus + ", quote=" + quote
                + ", agent=" + agent + "]";
    }
    
}