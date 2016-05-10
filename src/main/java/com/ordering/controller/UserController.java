package com.ordering.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.ordering.dao.UserDao;
import com.ordering.model.Category;
import com.ordering.model.Item;
import com.ordering.model.User;
import com.ordering.service.CategoryService;
import com.ordering.service.ItemService;
import com.ordering.service.UserService;

@Controller
public class UserController {
	
	UserDao userDao;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryservice;
	@Autowired
	private ItemService itemservice;
	
	 	
	@RequestMapping("/")
	public String setupForm(Map<String, Object> map){
		User user = new User();
		map.put("user", user);
		map.put("userList", userService.getAllUser());
		return "index";
	}
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    User user = new User();
	    model.addAttribute("user", user);
	    return "registration";
	}
	
	@RequestMapping(value = "/loginCust", params={ "username" , "password"}, method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("user") User userForm,BindingResult result, Map<String, Object> model) {
		
		Item item = new Item();
        Category cat=new Category();
        model.put("item", item);
        
        
        ArrayList itemList = new ArrayList<>();
		itemList =(ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);
		
		ArrayList categoryList = new ArrayList<>();
		categoryList =(ArrayList) categoryservice.getAllCategories();
		model.put("categoryList", categoryList);
		
		User user = userService.getUser(userForm.getUsername());
	 
		if(user!=null && userForm.getPassword().equals(user.getPassword())&&user.isEnabled()==true){
		 
			return "customerHome";
		}
		else{
			return "loginCustomer";
		}
       
    }
	
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map){
		User userResult = new User();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			userService.add(user);
			userResult = user;
			break;
		case "edit":
			userService.edit(user);
			userResult = user;
			break;
		case "delete":
			userService.delete(user.getUsername());
			userResult = new User();
			break;
		case "search":
			User searchedUser = userService.getUser(user.getUsername());
			userResult = searchedUser!=null ? searchedUser : new User();
			break;
		}
		map.put("user", userResult);
		map.put("userList", userService.getAllUser());
		map.put("minombre", "Jose");
		
		return "user";
	}
	
	
	 
	   
}
