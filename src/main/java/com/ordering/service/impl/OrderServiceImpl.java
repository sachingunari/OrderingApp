package com.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ordering.dao.OrderDao;
import com.ordering.dao.UserDao;
import com.ordering.model.Order;
import com.ordering.model.User;
import com.ordering.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Transactional
	public void add(Order order) {
		// TODO Auto-generated method stub
		orderDao.add(order);
		
	}

	@Transactional
	public void edit(Order order) {
		// TODO Auto-generated method stub
		orderDao.edit(order);
		
	}

	@Transactional
	public void delete(int OrderId) {
		// TODO Auto-generated method stub
		orderDao.delete(OrderId);
	}

	@Transactional
	public Order getUser(int OrderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(OrderId);
	}

	@Transactional
	public List getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}

}
