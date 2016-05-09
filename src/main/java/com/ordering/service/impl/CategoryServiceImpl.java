package com.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ordering.dao.CategoryDao;
import com.ordering.dao.ItemDao;
import com.ordering.service.CategoryService;


public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Transactional
	public List getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategories();
	}
		

}
