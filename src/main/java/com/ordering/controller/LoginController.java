package com.ordering.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ordering.dao.UserDao;
import com.ordering.model.User;
import com.ordering.service.UserService;

@Controller
public class LoginController {
	
	UserDao userDao;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
    public String loginAdmin(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "adminLogin";
    }
	
	@RequestMapping(value = "/loginCustomer", method = RequestMethod.GET)
    public String loginCustomer(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "loginCustomer";
    }
	
	 @RequestMapping(value = "/loginAdmin", params={ "username" , "password"}, method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("user") User userForm,
	            BindingResult result, Map<String, Object> model) {
		 	
		 User user = userService.getUser(userForm.getUsername());
		 
		 if (user!=null && userForm.getPassword().equals(user.getPassword())&&user.isEnabled()==true){
			 
			 return "user";
			 
		 }
		 else
			 return "tokenverify";
	       
	    }
	
}