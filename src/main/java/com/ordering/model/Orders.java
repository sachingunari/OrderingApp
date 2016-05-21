package com.ordering.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Orders {
	

	public Orders() {
		super();
	}
	public Orders(OrdersId ordersId, int user_Id,  int item_Quantity,String fulfillment_Starttime,String pickup_Time,String ready_Time,String orders_status) {
		super();
	
		this.user_Id = user_Id;
		this.ordersId =ordersId;
		this.item_Quantity = item_Quantity;
		this.fulfillment_Starttime=fulfillment_Starttime;
		this.pickup_Time=pickup_Time;
		this.ready_Time=ready_Time;
		this.orders_status = orders_status;
	}
	
	@EmbeddedId
    private OrdersId ordersId;
	@Column
	private int user_Id;
		
	@Column
	private int item_Quantity;
	@Column
	private String ready_Time;
	@Column
	private String fulfillment_Starttime;
	@Column
	private String pickup_Time;
	@Column
	private int cooking_Times=0;
	@Column
	private String orders_status;
	
	
	public int getCooking_Times() {
		return cooking_Times;
	}
	public void setCooking_Times(int cooking_Times) {
		this.cooking_Times = cooking_Times;
	}
	public String getReady_Time() {
		return ready_Time;
	}
	public void setReady_Time(String ready_Time) {
		this.ready_Time = ready_Time;
	}
	public String getFulfillment_Starttime() {
		return fulfillment_Starttime;
	}
	public void setFulfillment_Starttime(String fulfillment_Starttime) {
		this.fulfillment_Starttime = fulfillment_Starttime;
	}
	public String getPickup_Time() {
		return pickup_Time;
	}
	public void setPickup_Time(String pickup_Time) {
		this.pickup_Time = pickup_Time;
	}
	
	public OrdersId getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(OrdersId ordersId) {
		this.ordersId = ordersId;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	
	public int getItem_Quantity() {
		return item_Quantity;
	}
	public void setItem_Quantity(int item_Quantity) {
		this.item_Quantity = item_Quantity;
	}
	public String getOrders_status() {
		return orders_status;
	}
	public void setOrders_status(String orders_status) {
		this.orders_status = orders_status;
	}
	
}


