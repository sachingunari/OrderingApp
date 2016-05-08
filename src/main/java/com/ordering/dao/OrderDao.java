package com.ordering.dao;

import java.util.List;

import com.ordering.model.Order;
import com.ordering.model.User;

public interface OrderDao {


		public void add(Order order);
		public void edit(Order order);
		public void delete(int OrderId);
		public Order getOrder(int OrderId);
		public List getAllOrders();
	
	
}
