
package com.cg.hims.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Component
@Entity
public class Admin {
	@Id
	private int adminId;
	private String adminName;
	private String contact;
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="userId")
	private User user;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminName, String contact, User user) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.contact = contact;
		this.user = user;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", contact=" + contact + ", user=" + user
				+ "]";
	}


}