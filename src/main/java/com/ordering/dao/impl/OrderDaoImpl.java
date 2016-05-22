package com.ordering.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ordering.dao.OrderDao;
import com.ordering.model.Orders;
import com.ordering.model.OrdersId;
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
	public void delete(int OrderId,int itemId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getOrder(OrderId,itemId));
		
	}
	
	@Override
	public void deleteAllOrders() {
		// TODO Auto-generated method stub
	//	ArrayList<Orders> tempList = new ArrayList<Orders>();
		//tempList = (ArrayList<Orders>) getAllOrders();
		//((Session) session).createQuery("delete from Orders").executeUpdate();
		//((Session) session).createQuery("delete from User_Role").executeUpdate();
		Query query = session.
			      getCurrentSession().
			      createQuery("delete from Orders");
			    //query.setParameter("user_Id", user_Id);
			    query.executeUpdate();
		System.out.println("Reached here successfully");
//		session.getCurrentSession().delete(tempList);		
	}

	@Override
	public Orders getOrder(int OrderId,int itemId) {
		// TODO Auto-generated method stub
		OrdersId ord=new OrdersId(OrderId,itemId);
		return (Orders)session.getCurrentSession().get(Orders.class, ord);
	}

	@Override
	public List getAllOrders() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Orders").list();
	}

	@Override
	public List<Orders> getCustomerOrder(int user_Id) {
		// TODO Auto-generated method stub
		Query query = session.
			      getCurrentSession().
			      createQuery("from Orders where user_Id = :user_Id");
			    query.setParameter("user_Id", user_Id);
			  
			    List templist =query.list();
			    return templist;
		//return (List)session.getCurrentSession().get(Orders.class, user_Id);
	}

	@Override
	public List getOrderReport(String fromdate, String todate) {
		// TODO Auto-generated method stub
		Query query = session.getCurrentSession().createQuery("from Orders where order_Time >= :fromdate AND order_Time <= :todate");
			    query.setParameter("fromdate", fromdate);
			    query.setParameter("todate", todate);
			  
			    List templist =query.list();
			    return templist;
	}

	
	@Override
	public List getOrderByMenu(String fromdate, String todate) {
		// TODO Auto-generated method stub
		Query query = session.getCurrentSession().createQuery("from Orders where order_Time >= :fromdate AND order_Time <= :todate");			  
			    
				query.setParameter("fromdate", fromdate);
				query.setParameter("todate", todate);
				List templist =query.list();
			    return templist;
	}



	
	
	
}
