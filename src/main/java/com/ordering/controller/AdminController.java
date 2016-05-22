package com.ordering.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordering.dao.ItemDao;
import com.ordering.model.Category;
import com.ordering.model.Item;
import com.ordering.model.Orders;
import com.ordering.service.CategoryService;
import com.ordering.service.ItemService;
import com.ordering.service.OrderService;

@Controller
public class AdminController {
	
	ItemDao itemDao;
	@Autowired
	private ItemService itemservice;
	@Autowired
	private CategoryService categoryservice;
	@Autowired
	private OrderService orderservice;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping(value = "/addremove", method = RequestMethod.GET)
    public String doLogin(Map<String, Object> model,HttpServletRequest request) {
		if(!request.getSession().getAttribute("accessLevel").toString().equals("0")){
			 
			return("index"); 
			
		}
        Item item = new Item();
        Category cat=new Category();
        model.put("item", item);
        
        ArrayList tempList = new ArrayList<>();
		tempList =(ArrayList) itemservice.getAllItems();
		model.put("studentList", tempList);
		
		ArrayList categoryList = new ArrayList<>();
		categoryList =(ArrayList) categoryservice.getAllCategories();
		model.put("catList", categoryList);
		  
        return "addOrRemoveItem";
    }
	
	@RequestMapping(value = "/addremove", params={ "name" , "cooking_Time", "cost", "pic_Url", "calories"}, method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("user") Item itemForm,
            BindingResult result,HttpServletRequest request, @RequestParam String action,@RequestParam("Category") String category, Map<String, Object> model) {
	
		
		ArrayList categoryList = new ArrayList<>();
		categoryList =(ArrayList) categoryservice.getAllCategories();
		model.put("catList", categoryList);
		
		Item item = new Item();
		item.setName(itemForm.getName());
		item.setCalories(itemForm.getCalories());
		item.setCooking_Time(itemForm.getCooking_Time());
		item.setCost(itemForm.getCost());
		item.setPic_Url(itemForm.getPic_Url());
		
		item.setCategory_Id(Integer.parseInt(category));
		item.setId(itemForm.getId());
	
		
		
		try {
			
			switch(action.toLowerCase()){	//only in Java7 you can put String in switch
			case "create":
				itemservice.add(item);
//				studentService.add(student);
	//			studentResult = student;
				break;
			case "edit":
				itemservice.edit(item);
	//			studentResult = student;
				break;
			case "delete":
				int idToDelete = item.getId();
				itemservice.delete(idToDelete);
				Item newItem = new Item();
				model.put("item", newItem);
		        break;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println(e.getMessage());			
		}
		
		
		ArrayList tempList = new ArrayList<>();
		tempList =(ArrayList) itemservice.getAllItems();
		model.put("studentList", tempList);
		//Item item = new Item();
        if(!action.toLowerCase().equals("delete")){
        	model.put("item", item);
        }
		return "addOrRemoveItem";

	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrder(Map<String, Object> model,HttpServletRequest request) {
		if(!request.getSession().getAttribute("accessLevel").toString().equals("0")){
			 
			return("index"); 
			
		}
		ArrayList<Orders> orderList = new ArrayList<>();
		orderList =(ArrayList) orderservice.getAllOrders();
		int orderid =0;
		for(Orders o :orderList){
			if(orderid ==0){
				orderid = o.getOrdersId().getOrder_Id();
				
			}
			
			
		}
		model.put("orderList", orderList);
		  
        return "viewOrders";
    }

	@RequestMapping(value = "/deleteallorders", method = RequestMethod.GET)
    public String deleteAllOrders(Map<String, Object> model,HttpServletRequest request) {
		if(!request.getSession().getAttribute("accessLevel").toString().equals("0")){
			return("index"); 	
		}
		
		orderservice.deleteAllOrders();
		  
		model.put("SuccessMessage", "Deleted Orders Successfully.");
		return "adminHome";
    }
	
	
	@RequestMapping(value = "/orderReport", method = RequestMethod.GET)
    public String getOrderReport(Map<String, Object> model,HttpServletRequest request) {
	
		return "generateOrdReport";
	}
	
	@RequestMapping(value = "/menuReport", method = RequestMethod.GET)
    public String getMenuReport(Map<String, Object> model,HttpServletRequest request) {
	
		return "generateMenuReport";
	}
	
	@RequestMapping(value = "/orderReport", method = RequestMethod.POST)
    public String postGenerateReport(Map<String, Object> model,HttpServletRequest request,@RequestParam String fromdate, @RequestParam String todate) {
		
		String fromDate  = fromdate + " 00:00:00";
		String toDate = todate + " 00:00:00";
		
		ArrayList<Orders> orderList = new ArrayList<>();
		ArrayList<Item> itemList = new ArrayList<>();
		orderList = (ArrayList<Orders>)orderservice.getOrderReport(fromDate, toDate);
		for(Orders ord : orderList)
		{
			int itemId = ord.getOrdersId().getItem_Id();
			Item item = itemservice.getItem(itemId);
			itemList.add(item);
			
		}
		model.put("orderList", orderList);
		model.put("itemList", itemList);
		
		return "orderReport";
	}

	@RequestMapping(value = "/menuReport", method = RequestMethod.POST)
    public String getReportByMenu(Map<String, Object> model,HttpServletRequest request,@RequestParam String fromdate, @RequestParam String todate) {
		
		String fromDate  = fromdate + " 00:00:00";
		String toDate = todate + " 00:00:00";
		
		ArrayList<Orders> orderList = new ArrayList<>();
		ArrayList<Category> catList = new ArrayList<>();
		ArrayList<Item> itemList = new ArrayList<>();
		HashMap<Integer, Integer> itemMap = new HashMap<Integer, Integer>();
		
		orderList = (ArrayList<Orders>)orderservice.getOrderByMenu(fromDate, toDate);
		for(Orders ord : orderList)
		{
			int itemId = ord.getOrdersId().getItem_Id();
			Item item = itemservice.getItem(itemId);
			itemList.add(item);
			
		}
		catList = (ArrayList<Category>)categoryservice.getAllCategories();
		
		model.put("orderList", orderList);
		model.put("catList", catList);
		model.put("itemList", itemList);
		
		return "menuReport";
	}
	
	
    @Scheduled(fixedDelay = 60000)
    public void demoServiceMethod()
    {
       // System.out.println("Method executed at every 5 seconds. Current time is :: "+ Calendar.getInstance());
    	ArrayList<Orders> ord = new ArrayList<>();
    	ord = (ArrayList<Orders>)orderservice.getAllOrders();
    	
    	for (Orders ordz : ord) {
    		
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
    			orderservice.edit(ordz);
    		}
    		else if(fulfillment_Starttime.before(Calendar.getInstance())&& ready_Time.before(Calendar.getInstance())){
    			
    			ordz.setOrders_status("In Process");
    			orderservice.edit(ordz);
     		}
    		else if(fulfillment_Starttime.after(Calendar.getInstance())){
    			
    			ordz.setOrders_status("In Queue");
    			orderservice.edit(ordz);
    			
    		}
    		
    		
    	
    	}
    	
    }

	
	
	

	
	
	

}
