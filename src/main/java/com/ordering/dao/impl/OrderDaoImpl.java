package com.ordering.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordering.dao.OrderDao;
import com.ordering.model.Order;
import com.ordering.model.User;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Order order) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(order);
		
	}

	@Override
	public void edit(Order order) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(order);
		
	}

	@Override
	public void delete(int OrderId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getUser(OrderId));
		
	}

	@Override
	public User getUser(int OrderId) {
		// TODO Auto-generated method stub
		return (User)session.getCurrentSession().get(User.class, OrderId);
	}

	@Override
	public List getAllOrders() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Order").list();
	}

	
	
	
	
	
}
