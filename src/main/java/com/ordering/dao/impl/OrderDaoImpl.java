package com.ordering.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordering.dao.OrderDao;
import com.ordering.model.Orders;
import com.ordering.model.User;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Orders order) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(order);
		
	}

	@Override
	public void edit(Orders order) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(order);
		
	}

	@Override
	public void delete(int OrderId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getOrder(OrderId));
		
	}

	@Override
	public Orders getOrder(int OrderId) {
		// TODO Auto-generated method stub
		return (Orders)session.getCurrentSession().get(Orders.class, OrderId);
	}

	@Override
	public List getAllOrders() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Orders").list();
	}

	
	
	
	
	
}
