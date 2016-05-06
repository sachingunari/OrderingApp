package com.ordering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;

@Entity
public class User {
	
	public User(){}
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
//	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private int userId;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private int accessLevel;
	
	
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
	public int getYearLevel() {
		return accessLevel;
	}
	public void setYearLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
}
