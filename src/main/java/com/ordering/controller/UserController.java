package com.ordering.controller;

import java.util.ArrayList;
import org.springframework.web.servlet.ModelAndView;
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
		
		if(result.hasErrors())
		{
			return "loginCustomer";
		}
		User user = userService.getUser(userForm.getUsername());
		ModelAndView modelandview = new ModelAndView();
		//User u =userService.getUser(user.getUsername()); 
		if(user== null)
		{
			model.put("error", "Wrong Credentials");
			return "loginCustomer";
		}
		
		Item item = new Item();
        Category cat=new Category();
        model.put("item", item);
        
    
		itemList =(ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);
		
	
		categoryList =(ArrayList) categoryservice.getAllCategories();
		model.put("categoryList", categoryList);
		
			
				
	 
		if(user!=null && userForm.getPassword().equals(user.getPassword())&&user.isEnabled()==true){
			session = request.getSession();
			session.setAttribute("username",userForm.getUsername());
			session.setAttribute("accessLevel", userForm.getAccessLevel());
			session.setAttribute("order", order);
			request.getSession().setAttribute("userid",user.getUserId());
			 
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
	  public String addProduct(@ModelAttribute Item item,BindingResult result,@ModelAttribute("order")  List<Item> order, Map<String, Object> model,@RequestParam int quantity,@RequestParam int cooking_Time,Model models) {
		  
		  int total=0;
		  int totaltime=0;
		  boolean b =false;
		  item.setQuantity(quantity);
		  item.setCooking_Time(cooking_Time);
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
		    	totaltime+=i.getCooking_Time();
		    }
		    
		    models.addAttribute("totals",total);
		    models.addAttribute("totalstime",totaltime);




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
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String showRegistrationForm( @Valid @ModelAttribute("user") User userForm,Model model) {
	   // User user = new User();
	   // model.addAttribute("user", user);
	    return "checkout";
	}
	
	
	@RequestMapping(value = "/placeorder",  method = RequestMethod.POST)
    public String doLogins(@ModelAttribute("orders")  ArrayList<Item> orders,BindingResult result,@RequestParam String dates,@RequestParam String times,@RequestParam String total,@RequestParam int totaltime, Model model,HttpSession session,HttpServletRequest request) {
		
	
		

		Orders ord=new Orders();
		int ord_Id=rand.nextInt(10000);
		
		String fulfillment_Starttime = null;
		String pickup_Time = null;
		String ready_Time = null;
	
		
		List os=oservice.getAllOrders();
		
		
		
		System.out.println("");
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		for(Item i:order){
			ord.setOrders_status("in Queue");
			ord.setOrder_Id(ord_Id);
			ord.setItem_Quantity(i.getQuantity());
			ord.setItem_Id(i.getId());
			//ord.setOrder_Id(12);
			ord.setFulfillment_Starttime(dates+" "+times+":00");
			ord.setPickup_Time(dates+" "+times+":00");
			ord.setReady_Time(dates+" "+times+":00");			
			ord.setUser_Id(userid);
			oservice.add(ord);

		}	
		
	
		session.setAttribute("order", null);
		
		
	
			return "checkout";
		}



	   
}