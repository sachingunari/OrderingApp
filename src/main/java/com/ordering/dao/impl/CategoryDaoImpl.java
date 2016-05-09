package com.ordering.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordering.dao.CategoryDao;
@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory session;
	
	@Override
	public List getAllCategories() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Category").list();
	}

}
