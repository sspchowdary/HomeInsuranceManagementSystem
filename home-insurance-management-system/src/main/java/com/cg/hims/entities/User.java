package com.cg.hims.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="User_Details")
public class User {
	

@Id
@GeneratedValue
    private int userid;

 @NotEmpty(message = "User name is required")
 @NotNull
 @Size(min=3,max=6)
 //@Pattern(regexp="^[A-Z][a-z]",message="length must be 3") 
	private String userName;
 
 @NotEmpty(message = "Password is required")
// @Pattern(regexp="^[A-Z][a-z]",message="length must be 3") 
 @NotNull
 private String password;
 
 @NotEmpty(message = "Role is required")
 @NotNull
 @Size(min=3,max=6)
	private String role;
 
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int userid,
			@NotEmpty(message = "User name is required") @NotNull @Size(min=3,max = 6) String userName,
			@NotEmpty(message = "Password is required")  @NotNull String password,
			@NotEmpty(message = "Role is required") @NotNull @Size(min=3,max = 6) String role) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}