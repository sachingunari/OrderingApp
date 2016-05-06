package com.ordering.dao;

import java.util.List;

import com.ordering.model.Item;
import com.ordering.model.User;

public interface ItemDao {
	

	public void add(Item item);
	public void edit(Item item);
	public void delete(int ItemId);
	public User getUser(int ItemId);
	public List getAllItems();


}
