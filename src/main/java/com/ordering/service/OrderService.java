package com.ordering.service;

import java.util.List;

import com.ordering.model.Orders;

public interface OrderService {

	public void add(Orders order);
	public void edit(Orders order);
	public void delete(int OrderId);
	public Orders getOrder(int OrderId);
	public List getAllOrders();
	
}