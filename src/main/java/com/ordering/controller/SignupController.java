package com.ordering.controller;

import java.util.Map;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordering.dao.UserDao;
import com.ordering.model.MailClient;
import com.ordering.model.User;
import com.ordering.service.UserService;

@Controller
public class SignupController {
	
	UserDao userDao;
	@Autowired
	private UserService userService;
	Random rg=new Random();
	MailClient mailclient=new MailClient();
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "signup";
    }
	
	 @RequestMapping(value = "/signup", params={ "username" , "password"}, method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("tokenverify") User userForm,
	            BindingResult result, Map<String, Object> model) {
		 	
		
		 
		 User user = new User();
         user.setUsername(userForm.getUsername());
         user.setPassword(userForm.getPassword());
         user.setUserId(rg.nextInt(100000));
         user.setAccessLevel(1);
         user.setEnabled(false);
         
         userService.add(user);
         
         mailclient.sendMail(userForm.getUsername(),"Restuarant@SJSU275.edu",userForm.getUsername(),Integer.toString(user.getUserId()));             
                
        return "tokenverify";
	 }
	 
	 @RequestMapping(value = "/enable/{username}/{userId}", method=RequestMethod.GET)
     public String doEnable(@PathVariable("username") String username,@Valid @ModelAttribute("user") User userForm , BindingResult result,@PathVariable("userId") String userId,Model model){
         
System.out.println(userId);
     User users = new User();
     if(userService.getUser(username)!=null){
     users=userService.getUser(username);
     }
         users.setEnabled(true);
        // users.setUserIserID);
         
         userService.edit(users);
         System.out.println("final Block");
         return "user";
	 }
	 
	 @RequestMapping(value = "/tokenverify", params={ "userId"}, method = RequestMethod.POST)
	    public String doEnable(@Valid @ModelAttribute("user") User userForm,
	            BindingResult result, Map<String, Object> model) {
		 	
		
		// System.out.println(userId);
	     User users = new User();
	     if(userService.getUser(userForm.getUserId())!=null){
	     users=userService.getUser(userForm.getUserId());
	     
	         users.setEnabled(true);
	        // users.setUserIserID);
	         
	         userService.edit(users);
	     }
	         System.out.println("final Block");
          
     return "user";
	 }
	 
	 
	 
	 
	 
	
}