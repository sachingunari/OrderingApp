package com.ordering.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.ordering.model.Orders;
import com.ordering.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.ordering.service.OrderService;


public class StatusUpdate {			
	
	StatusUpdate(){}
	
	@Autowired
	private OrderService oservice;

	//MailClient mailclient = new MailClient();	
	//List<Orders> ord = oservice.getAllOrders();
	

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
	    @Scheduled(fixedDelay = 5000)
	    public void demoServiceMethod()
	    {
	        //System.out.println("Method executed at every 5 seconds. Current time is :: "+ Calendar.getInstance());
	    	
	    	/*for (Orders ordz : ord) {
	    		
	    		Calendar fulfillment_Starttime = Calendar.getInstance();
	    		Calendar pickup_Time = Calendar.getInstance();
	    		Calendar ready_Time = Calendar.getInstance();
	    		
	    		try {
	    			fulfillment_Starttime.setTime(sdf.parse(ordz.getFulfillment_Starttime()));
	    		} catch (ParseException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		try {
	    		pickup_Time.setTime(sdf.parse(ordz.getPickup_Time()));
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
	    		try {
    		ready_Time.setTime(sdf.parse(ordz.getReady_Time()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    		
	    		if(ready_Time.before(Calendar.getInstance())){
	    			
	    			ordz.setOrders_status("Order Completed");
	    			//oservice.edit(ordz);
	    		}
	    		else if(fulfillment_Starttime.before(Calendar.getInstance())&& ready_Time.before(Calendar.getInstance())){
	    			
	    			ordz.setOrders_status("In Process");
	    			//oservice.edit(ordz);
	     		}
	    		else if(fulfillment_Starttime.after(Calendar.getInstance())){
	    			
	    			ordz.setOrders_status("In Queue");
	    			//oservice.edit(ordz);
	    			
	    		}
	    		
	    		
	    	
	    	}
	    	*/
	    }
	
}
