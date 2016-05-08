package com.ordering.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordering.dao.UserDao;
import com.ordering.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(User user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void edit(User user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void delete(String username) {		
		session.getCurrentSession().delete(getUser(username));
	}

	@Override
	public User getUser(String username) {
		//return (User)session.getCurrentSession().get(User.class, username);
		
		
		List<User> userList = new ArrayList<User>();
        Query query = session.getCurrentSession().createQuery("from User u where u.username = :username");
        query.setParameter("username", username);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;	
		
		
	}

	public User getUser(int userId) {
		return (User)session.getCurrentSession().get(User.class, userId);
		
			}

	@Override
	public List getAllUser() {
		return session.getCurrentSession().createQuery("from User").list();
	}

}
