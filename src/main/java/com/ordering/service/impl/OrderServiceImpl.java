package com.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ordering.dao.OrderDao;
import com.ordering.dao.UserDao;
import com.ordering.model.Orders;
import com.ordering.model.User;
import com.ordering.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Transactional
	public void add(Orders order) {
		// TODO Auto-generated method stub
		orderDao.add(order);
		
	}

	@Transactional
	public void edit(Orders order) {
		// TODO Auto-generated method stub
		orderDao.edit(order);
		
	}

	@Transactional
	public void delete(int OrderId) {
		// TODO Auto-generated method stub
		orderDao.delete(OrderId);
	}
	
	@Transactional
	public void deleteAllOrders() {
		// TODO Auto-generated method stub
		orderDao.deleteAllOrders();
	}

	@Transactional
	public Orders getUser(int OrderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(OrderId);
	}

	@Transactional
	public List getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}

	@Transactional
	public List getCustomerOrder(int user_Id) {
		// TODO Auto-generated method stub
		return orderDao.getCustomerOrder(user_Id);
	}




}
