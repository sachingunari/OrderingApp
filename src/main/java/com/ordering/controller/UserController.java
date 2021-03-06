package com.ordering.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.ordering.dao.UserDao;
import com.ordering.model.Category;
import com.ordering.model.Item;
import com.ordering.model.Orders;
import com.ordering.model.User;
import com.ordering.service.CategoryService;
import com.ordering.service.ItemService;
import com.ordering.service.OrderService;
import com.ordering.service.UserService;

@SessionAttributes({"order"})
@Controller
public class UserController {
	
	
	ArrayList categoryList = new ArrayList<>();
    ArrayList itemList = new ArrayList<>();
	ArrayList<Item> order = new ArrayList<Item>();
	Random rand=new Random();
	UserDao userDao;
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryservice;
	
	@Autowired
	private ItemService itemservice;
	
	@Autowired
	private OrderService oservice;
	
	 	
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
    public String doLogin(@Valid @ModelAttribute("user") User userForm,BindingResult result, Map<String, Object> model,HttpSession session,HttpServletRequest request) {
		//request.getSession().setAttribute("userName",userForm.getUsername());
		//request.getSession().setAttribute("accessLevel",userForm.getAccessLevel());

		Item item = new Item();
        Category cat=new Category();
        model.put("item", item);
        
    
		itemList =(ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);
		
	
		categoryList =(ArrayList) categoryservice.getAllCategories();
		model.put("categoryList", categoryList);
		
			
		User user = userService.getUser(userForm.getUsername());
	 
		if(user!=null && userForm.getPassword().equals(user.getPassword())&&user.isEnabled()==true){
			session = request.getSession();
			session.setAttribute("username",userForm.getUsername());
			session.setAttribute("accessLevel", userForm.getAccessLevel());
			session.setAttribute("order", order);

			return "customerHome";
		}
		else{
			return "loginCustomer";
		}
       
    }
	
	@RequestMapping(method = RequestMethod.GET)
	  public String get(Model model) {
	    if(!model.containsAttribute("cart")) {
	      model.addAttribute("order", new ArrayList<Item>());
	    }
	    return "customerHome";
	  }
	  
	  @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	  public String addProduct(@ModelAttribute Item item,BindingResult result,@ModelAttribute("order")  List<Item> order, Map<String, Object> model,@RequestParam int quantity,Model models) {
		  
		  int total=0;
		  boolean b =false;
		  item.setQuantity(quantity);
		  for(Item i:order){
			  
			if(i.getId()== item.getId()){				
			
				i.setQuantity(i.getQuantity()+item.getQuantity());
				System.out.println(i.getQuantity());
				b=true;
				break;
			}		
		}  
		  	if(b==false){
		  		order.add(item);
		  	}
	    
		  	for (Item i: order){
		    	total+= i.getCost()*i.getQuantity();
		    }
		    
		    models.addAttribute("totals",total);




        ArrayList itemList = new ArrayList<>();
		itemList =(ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);
	    
	    
	    return "customerHome";
	  }
	  
	  
	  @RequestMapping(value = "/loginCust", method = RequestMethod.GET)
	    public String doLogins(Map<String, Object> model,HttpSession session,HttpServletRequest request) {
		    User user = new User();
		  ((Model) model).addAttribute("order", new ArrayList<Item>());
		    return "customerHome";
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
	
	@RequestMapping(value = "/placeorderz", method = RequestMethod.GET)
	public String showRegistrationForms( @Valid @ModelAttribute("user") User userForm,Model model) {
	   // User user = new User();
	   // model.addAttribute("user", user);
	    return "customerHome";
	}
	
	@RequestMapping(value = "/placeorder",  method = RequestMethod.POST)
    public String doLogins(@ModelAttribute("orders")  ArrayList<Item> orders,BindingResult result,@RequestParam String date,@RequestParam String total, Model model,HttpSession session,HttpServletRequest request) {
		
	
		
		System.out.print(total);

		Orders ord=new Orders();
		int ord_Id=rand.nextInt(10000);
		
		for(Item i:order){
			
			System.out.println("ROSSSSSSST");
			ord.setOrder_Id(ord_Id);
			ord.setItem_Quantity(i.getQuantity());
			ord.setItem_Id(i.getId());
			//ord.setOrder_Id(12);
			ord.setFulfillment_Starttime("2013-08-30 19:05:00");
			ord.setPickup_Time("2013-08-30 19:05:00");
			ord.setReady_Time("2013-08-30 19:05:00");
			try{
			oservice.add(ord);
			}
			catch(Exception e)
			{
				System.out.println(e.getCause());
			}

		}	
	
			return "customerHome";
		}



	
	
	
	
	
	 
	   
}
