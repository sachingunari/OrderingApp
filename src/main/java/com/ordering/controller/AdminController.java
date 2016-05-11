package com.ordering.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordering.dao.ItemDao;
import com.ordering.model.Category;
import com.ordering.model.Item;
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
	
		//if(request.getSession().getAttribute("username") == null)
		//	return("index");
		
		
		
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
		ArrayList orderList = new ArrayList<>();
		orderList =(ArrayList) orderservice.getAllOrders();
		model.put("orderList", orderList);
		  
        return "viewOrders";
    }

	
	
}
