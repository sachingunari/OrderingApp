package com.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ordering.dao.ItemDao;
import com.ordering.dao.UserDao;
import com.ordering.model.Item;
import com.ordering.model.User;
import com.ordering.service.ItemService;

public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	@Transactional
	public void add(Item item) {
		// TODO Auto-generated method stub
		itemDao.add(item);
		
	}

	@Transactional
	public void edit(Item item) {
		// TODO Auto-generated method stub
		itemDao.edit(item);
		
	}

	@Transactional
	public void delete(int ItemId) {
		// TODO Auto-generated method stub
		itemDao.delete(ItemId);
		
	}

	@Transactional
	public User getUser(int ItemId) {
		// TODO Auto-generated method stub
		return itemDao.getUser(ItemId);
	}

	@Transactional
	public List getAllItems() {
		// TODO Auto-generated method stub
		return itemDao.getAllItems();
	}

}
