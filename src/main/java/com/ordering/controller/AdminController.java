package com.ordering.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ordering.dao.ItemDao;
import com.ordering.dao.UserDao;
import com.ordering.model.Item;
import com.ordering.model.User;
import com.ordering.service.ItemService;
//import com.ordering.service.UserService;
import com.ordering.service.impl.ItemServiceImpl;

@Controller
public class AdminController {
	
	ItemDao itemDao;
	@Autowired
	private ItemService itemservice;
	@RequestMapping(value = "/a", method = RequestMethod.GET)
//	@RequestMapping(value = "/signup", params={ "username" , "password"}, method = RequestMethod.POST)
    public String doLogin(Map<String, Object> model) {
	 	
        Item item = new Item();
        model.put("item", item);
        return "addOrRemoveItem";
    }
	
	@RequestMapping(value = "/a", params={ "name" , "cooking_Time", "cost", "pic_Url", "calories"}, method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("user") Item itemForm,
            BindingResult result, Map<String, Object> model) {
	 	//itemservice = new ItemServiceImpl();
		//Item item = userService.getUser(userForm.getUsername());
		Item item = new Item();
		item.setName(itemForm.getName());
		item.setCalories(itemForm.getCalories());
		item.setCooking_Time(itemForm.getCooking_Time());
		item.setCost(itemForm.getCost());
		item.setPic_Url(itemForm.getPic_Url());
		item.setCategory_Id(itemForm.getCategory_Id());
		item.setId(105);
		
		
		try {
			itemservice.add(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Item item = new Item();
        model.put("item", item);
        return "addOrRemoveItem";
//	 if (user!=null && userForm.getPassword().equals(user.getPassword())&&user.isEnabled()==true){
//		 return "user";
//	 }
//	 else
//		 return "login";
//    }
	}
	
}
