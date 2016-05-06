package com.ordering.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	

	public Order() {
		super();
	}
	public Order(int order_Id, int user_Id, int item_Id, int item_Quantity) {
		super();
		this.order_Id = order_Id;
		this.user_Id = user_Id;
		this.item_Id = item_Id;
		this.item_Quantity = item_Quantity;
	}
	
	@Id
	@Column
	private int order_Id;
	@Column
	private int user_Id;
	@Column
	private int item_Id;	
	@Column
	private int item_Quantity;
	
	
	
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public int getItem_Id() {
		return item_Id;
	}
	public void setItem_Id(int item_Id) {
		this.item_Id = item_Id;
	}
	public int getItem_Quantity() {
		return item_Quantity;
	}
	public void setItem_Quantity(int item_Quantity) {
		this.item_Quantity = item_Quantity;
	}
	
	
}
