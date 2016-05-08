package com.ordering.service;

import java.util.List;

import com.ordering.model.Order;
import com.ordering.model.User;

public interface OrderService {

	public void add(Order order);
	public void edit(Order order);
	public void delete(int OrderId);
	public Order getUser(int OrderId);
	public List getAllOrders();
	
}
