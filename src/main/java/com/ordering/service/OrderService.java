package com.ordering.service;

import java.util.List;

import com.ordering.model.Orders;

public interface OrderService {

	public void add(Orders order);
	public void edit(Orders order);
	public void delete(int OrderId,int itemId);
	//public Orders getOrder(int OrderId);
	public List getAllOrders();
	public List getCustomerOrder(int user_Id);
	public void deleteAllOrders();
	public List getOrderReport(String fromdate, String todate);
	public List getOrderByMenu(String fromdate, String todate);
	
}