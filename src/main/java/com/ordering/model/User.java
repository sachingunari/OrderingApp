package com.ordering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	 public User() {
	    }
	public User(int userId, String username, String password,
			int accessLevel) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.accessLevel = accessLevel;
	}
	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		
	}
  
    
	
	@Id
	@Column
	//@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int userId;
	
	@Column
	private boolean enabled;
	
	@NotNull
	@Column
	private String username;
	
	@NotNull
	@Column
	private String password;
	
	@Column
	private int accessLevel=1;
		
	@NotNull
	@Column
	
	
	public String getUsername() {
		return username;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return username;
	}
	public void setFirstname(String username) {
		this.username = username;
	}
	public String getLastname() {
		return password;
	}
	public void setLastname(String password) {
		this.password = password;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
		
}
