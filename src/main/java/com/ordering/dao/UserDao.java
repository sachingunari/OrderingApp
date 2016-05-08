package com.ordering.dao;

import java.util.List;

import com.ordering.model.User;

public interface UserDao {
	public void add(User user);
	public void edit(User user);
	public void delete(String username);
	public User getUser(String username);
	public User getUser(int userId);
	public List getAllUser();
}
