package com.ordering.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordering.dao.ItemDao;
import com.ordering.model.Item;
import com.ordering.model.User;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Item item) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(item);
		
	}

	@Override
	public void edit(Item item) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(item);
		
	}

	@Override
	public void delete(int ItemId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getUser(ItemId));
		
	}

	@Override
	public User getUser(int ItemId) {
		// TODO Auto-generated method stub
		return (User)session.getCurrentSession().get(User.class, ItemId);
	}

	@Override
	public List getAllItems() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Item").list();
	}

}
