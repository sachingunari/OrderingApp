package com.ordering.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String loginAdmin(Map<String, Object> model,HttpSession session,HttpServletRequest request) {

		User user = new User();
        model.put("user", user);
        return "adminLogin";
    }
	
	@RequestMapping(value = "/loginCustomer", method = RequestMethod.GET)
    public String loginCustomer(Map<String, Object> model,HttpSession session,HttpServletRequest request) {
		if(request.getSession().getAttribute("username") != null){
			return "customerHome";
		}
 
        User user = new User();
        model.put("user", user);
        return "loginCustomer";
    }
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
    public String adminHome(Map<String, Object> model,HttpSession session,HttpServletRequest request) {

		User user = new User();
        model.put("user", user);
        return "adminHome";
    }


	
	 @RequestMapping(value = "/loginAdmin", params={ "username" , "password"}, method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("user") User userForm,
	            BindingResult result, Map<String, Object> model,HttpSession session,HttpServletRequest request) {
		 	
		 User user = userService.getUser(userForm.getUsername());
		 
		 if (user!=null && userForm.getPassword().equals(user.getPassword())&&user.isEnabled()==true && user.getAccessLevel()==0){
			 
			 request.getSession().setAttribute("userName",userForm.getUsername());
			 request.getSession().setAttribute("accessLevel",user.getAccessLevel());
			 request.getSession().setAttribute("userid",user.getUserId());
			 
			 return "adminHome";
		 }
		 else
			 return "adminLogin";
	    }
	
}