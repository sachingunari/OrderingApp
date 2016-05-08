package com.ordering.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordering.dao.UserDao;
import com.ordering.model.User;
import com.ordering.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void add(User user) {
		
		// validation
		userDao.add(user);
	}

	@Transactional
	public void edit(User user) {
		userDao.edit(user);
	}

	@Transactional
	public void delete(String username) {
		userDao.delete(username);
	}

	@Transactional
	public User getUser(String username) {
		return userDao.getUser(username);
	}

	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}
	
	@Transactional
	public List getAllUser() {
		return userDao.getAllUser();
	}

}
