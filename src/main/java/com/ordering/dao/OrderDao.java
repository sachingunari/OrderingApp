package com.ordering.dao;

import java.util.List;

import com.ordering.model.Orders;
import com.ordering.model.User;

public interface OrderDao {


		public void add(Orders order);
		public void edit(Orders order);
		public void delete(int OrderId);
		public Orders getOrder(int OrderId);
		public List getAllOrders();
	
	
}
