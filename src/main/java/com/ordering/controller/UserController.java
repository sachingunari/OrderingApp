package com.ordering.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.ordering.model.MailClient;
import com.ordering.model.Orders;
import com.ordering.model.OrdersId;
import com.ordering.model.User;
import com.ordering.service.CategoryService;
import com.ordering.service.ItemService;
import com.ordering.service.OrderService;
import com.ordering.service.UserService;

@SessionAttributes({ "order" })
@Controller
public class UserController {

	ArrayList categoryList = new ArrayList<>();
	ArrayList itemList = new ArrayList<>();
	ArrayList<Item> order = new ArrayList<Item>();
	Random rand = new Random();
	UserDao userDao;
	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryservice;

	@Autowired
	private ItemService itemservice;

	@Autowired
	private OrderService oservice;

	MailClient mailclient = new MailClient();

	@RequestMapping("/")
	public String setupForm(Map<String, Object> map) {
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

	@RequestMapping(value = "/loginCust", params = { "username", "password" }, method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("user") User userForm, BindingResult result, Map<String, Object> model,
			HttpSession session, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "loginCustomer";
		}
		User user = userService.getUser(userForm.getUsername());
		if (user == null) {
			model.put("error", "Wrong Credentials");
			return "loginCustomer";
		} else {
			String pass = userService.getUser(user.getUsername()).getPassword();
			if (!userForm.getPassword().equals(pass)) {
				model.put("error", "Wrong Credentials");
				return "loginCustomer";
			}

		}

		Item item = new Item();
		Category cat = new Category();
		model.put("item", item);

		itemList = (ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);

		categoryList = (ArrayList) categoryservice.getAllCategories();
		model.put("categoryList", categoryList);

		if (user != null && userForm.getPassword().equals(user.getPassword()) && user.isEnabled() == true) {
			session = request.getSession();
			session.setAttribute("username", userForm.getUsername());
			session.setAttribute("accessLevel", userForm.getAccessLevel());
			session.setAttribute("order", order);
			session.setAttribute("userid", user.getUserId());

			System.out.print("User is is " + Integer.parseInt(session.getAttribute("userid").toString()));

			return "customerHome";
		} else {
			return "loginCustomer";
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		if (!model.containsAttribute("cart")) {
			model.addAttribute("order", new ArrayList<Item>());
		}
		return "customerHome";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Item item, BindingResult result, @ModelAttribute("order") List<Item> order,
			Map<String, Object> model, @RequestParam int quantity, @RequestParam int cooking_Time, Model models) {

		int total = 0;
		int totaltime = 0;
		boolean b = false;
		item.setQuantity(quantity);
		item.setCooking_Time(cooking_Time);
		for (Item i : order) {

			if (i.getId() == item.getId()) {

				i.setQuantity(i.getQuantity() + item.getQuantity());
				System.out.println(i.getQuantity());
				b = true;
				break;
			}
		}
		if (b == false) {
			order.add(item);
		}

		for (Item i : order) {
			total += i.getCost() * i.getQuantity();
			totaltime += i.getCooking_Time();
		}

		models.addAttribute("totals", total);
		models.addAttribute("totalstime", totaltime);

		ArrayList itemList = new ArrayList<>();
		itemList = (ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);

		return "customerHome";
	}

	@RequestMapping(value = "/loginCust", method = RequestMethod.GET)
	public String doLogins(Map<String, Object> model, HttpSession session, HttpServletRequest request) {
		if(request.getSession().getAttribute("username")==null){
			return "index";
		}
	  
	  Item item = new Item();
        Category cat=new Category();
        model.put("item", item);
        
    
		itemList =(ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);
		
	
		categoryList =(ArrayList) categoryservice.getAllCategories();
		model.put("categoryList", categoryList);
		//Jason
		   
	  	int total=0;
		int totaltime=0;
		for (Item i: order){
	    	total+= i.getCost()*i.getQuantity();
	    	totaltime+=i.getCooking_Time();
	    }
	    
	    ((Model) model).addAttribute("totals",total);
	    ((Model) model).addAttribute("totalstime",totaltime);

	    
	    ArrayList itemList = new ArrayList<>();
		itemList =(ArrayList) itemservice.getAllItems();
		model.put("itemList", itemList);
	    
		return "customerHome";
		
	}

	

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		User userResult = new User();
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
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
			userResult = searchedUser != null ? searchedUser : new User();
			break;
		}
		map.put("user", userResult);
		map.put("userList", userService.getAllUser());
		map.put("minombre", "Jose");

		return "user";
	}

	@RequestMapping(value = "/placeorderz", method = RequestMethod.GET)
	public String showRegistrationForms(@Valid @ModelAttribute("user") User userForm, Model model) {
		return "customerHome";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String showRegistrationForm(@Valid @ModelAttribute("user") User userForm, Model model) {
		return "checkout";
	}

	// Changed Place Order

	@RequestMapping(value = "/placeorder", method = RequestMethod.POST)
	public String doLogins(@ModelAttribute("orders") ArrayList<Item> orders, BindingResult result,
			@RequestParam String dates, @RequestParam String times, @RequestParam int total,
			@RequestParam int totaltime, Model model, HttpSession session, HttpServletRequest request) {

		Orders ord = new Orders();
		OrdersId ords = new OrdersId();
		int ord_Id = rand.nextInt(10000);
		String orderRelatedMessage = "";

		Calendar fulfillment_Starttime = Calendar.getInstance();
		Calendar pickup_Time = Calendar.getInstance();
		Calendar ready_Time = Calendar.getInstance();
		Calendar day_Start_Time = Calendar.getInstance();
		Calendar day_End_Time = Calendar.getInstance();

		int cooking_Time = 0;

		System.out.println(dates + times);
		// Get Total cooking Time of order
		for (Item i : order) {

			cooking_Time += i.getCooking_Time() * i.getQuantity();

		}
		// Initialize Pickup , ready and cooking start time assuming no Orders
		// are present
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			pickup_Time.setTime(sdf.parse(dates + " " + times + ":00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			day_Start_Time.setTime(sdf.parse(dates + " 05:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			day_End_Time.setTime(sdf.parse(dates + " 18:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fulfillment_Starttime.setTime(sdf.parse(dates + " " + times + ":00"));
			fulfillment_Starttime.add(Calendar.MINUTE, -cooking_Time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ready_Time = pickup_Time;

		int count = 0;
		boolean found = true;

		int userid = Integer.parseInt(session.getAttribute("userid").toString());

		List<Orders> oss = oservice.getAllOrders();
		List<Orders> os = new ArrayList<Orders>();

		for (Orders ordz : oss) {

			boolean b = true;
			for (Orders ordzs : os) {

				if (ordz.getOrdersId() == ordzs.getOrdersId()) {
					b = false;
					break;
				}

			}
			if (b == true) {
				os.add(ordz);
			}

		}

		for (int j = 0; j < 60; j++) {

			count = 0;
			found = true;
			fulfillment_Starttime.add(Calendar.MINUTE, -1);
			ready_Time.add(Calendar.MINUTE, -1);

			for (Orders ordz : os) {

				Calendar fulfillment_Starttimes = Calendar.getInstance();
				Calendar ready_Times = Calendar.getInstance();
				try {
					fulfillment_Starttimes.setTime(sdf.parse(ordz.getFulfillment_Starttime()));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					ready_Times.setTime(sdf.parse(ordz.getReady_Time()));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if ((((fulfillment_Starttimes.after(fulfillment_Starttime))
						|| (fulfillment_Starttimes.equals(fulfillment_Starttime)))
						&& (fulfillment_Starttimes.before(ready_Time) || fulfillment_Starttimes.equals(ready_Time)))
						|| ((ready_Times.after(fulfillment_Starttime) || ready_Times.equals(fulfillment_Starttime))
								&& (ready_Times.before(ready_Time) || ready_Times.equals(ready_Time)))
						|| (fulfillment_Starttimes.before(fulfillment_Starttime) && ready_Times.after(ready_Time))) {

					count++;
					if (count >= 3) {
						found = false;
						break;
					}

				}

			}

			if (found == true && (fulfillment_Starttime.after(day_Start_Time))) {

				int counts = 0;
				for (Item i : order) {
					ord.setOrders_status("In Queue");
					ords.setItem_Id(i.getId());
					ords.setOrder_Id(ord_Id);
					ord.setUser_Id(userid);
					ord.setItem_Quantity(i.getQuantity());
					ord.setFulfillment_Starttime(sdf.format(fulfillment_Starttime.getTime()));
					ord.setPickup_Time(sdf.format(pickup_Time.getTime()));
					ord.setReady_Time(sdf.format(ready_Time.getTime()));
					ord.setCooking_Times(cooking_Time);
					ord.setOrdersId(ords);
					ord.setOrder_Total(total);
					oservice.add(ord);

					orderRelatedMessage += "\n \n" + counts++ + ": ";
					orderRelatedMessage += "\n Order_id: " + ord_Id;
					orderRelatedMessage += "\n Order_quantity: " + i.getQuantity();
					orderRelatedMessage += "\n Item_id: " + i.getId();
					orderRelatedMessage += "\n Order_fulfillment time: " + sdf.format(fulfillment_Starttime.getTime());
					orderRelatedMessage += "\n Pickup time: " + sdf.format(pickup_Time.getTime());
					orderRelatedMessage += "\n Ready time: " + sdf.format(ready_Time.getTime());
					orderRelatedMessage += "\n userid: " + userid;

				}
				String from = request.getSession().getAttribute("username").toString();
				System.out.println(from);
				mailclient.sendMailWithOrderDetails(from, "Restuarant@SJSU275.edu", orderRelatedMessage);
				session.setAttribute("order", null);
				order.clear();
				found = true;
				break;

			}
			if (fulfillment_Starttime.before(day_Start_Time) || fulfillment_Starttime.equals(day_Start_Time)) {
				count = 4;
				break;
			}
			// break;

		}

		if (count >= 3 || found == false) {

			fulfillment_Starttime.setTimeInMillis(day_Start_Time.getTimeInMillis());
			;
			ready_Time.setTimeInMillis(day_Start_Time.getTimeInMillis());
			ready_Time.add(Calendar.MINUTE, cooking_Time);

			while (ready_Time.before(day_End_Time)) {

				count = 0;
				found = true;
				fulfillment_Starttime.add(Calendar.MINUTE, 30);
				ready_Time.add(Calendar.MINUTE, 30);

				for (Orders ordz : os) {

					Calendar fulfillment_Starttimes = Calendar.getInstance();
					Calendar ready_Times = Calendar.getInstance();
					try {
						fulfillment_Starttimes.setTime(sdf.parse(ordz.getFulfillment_Starttime()));

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						ready_Times.setTime(sdf.parse(ordz.getReady_Time()));

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if ((((fulfillment_Starttimes.after(fulfillment_Starttime))
							|| (fulfillment_Starttimes.equals(fulfillment_Starttime)))
							&& (fulfillment_Starttimes.before(ready_Time) || fulfillment_Starttimes.equals(ready_Time)))
							|| ((ready_Times.after(fulfillment_Starttime) || ready_Times.equals(fulfillment_Starttime))
									&& (ready_Times.before(ready_Time) || ready_Times.equals(ready_Time)))
							|| (fulfillment_Starttimes.before(fulfillment_Starttime)
									&& ready_Times.after(ready_Time))) {

						count++;
						if (count >= 3) {
							found = false;
							break;
						}

					}

				}
				if (found == true)
					break;

			}

			if (found == true) {
				if(ready_Time.before(day_Start_Time))
				{
					ready_Time.setTimeInMillis(day_Start_Time.getTimeInMillis());
				}	
				String s= ( sdf.format( ready_Time.getTimeInMillis() ));
				model.addAttribute("etime"," Order not possible at the requested time."+ s+"is the earliest possible pickup time today");

			} else {
				model.addAttribute("message", "OOPS..Order not possible on this day !!");
			}

			count = 0;
			return "customerHome";

		}

		order.clear();
		return "checkout";
	}

	// Parveen New changes

	@RequestMapping(value = "/customerOrders", method = RequestMethod.GET)
	public String getCustomerOrders(Map<String, Object> model, HttpSession session, HttpServletRequest request) {

		ArrayList<Orders> customerOrders = new ArrayList<>();
		customerOrders = (ArrayList) oservice
				.getCustomerOrder(Integer.parseInt(session.getAttribute("userid").toString()));
		model.put("CustomerOrders", customerOrders);

		for (Orders o : customerOrders) {
			System.out.print("View Orders: User Id " + o.getUser_Id());
		}
		System.out.print(customerOrders);
		return "customerOrders";
	}

	@RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
	public String customerDelete(HttpServletRequest request, @RequestParam String action, @RequestParam int order_Id,
			Map<String, Object> model) {

		try {

			switch (action.toLowerCase()) { // only in Java7 you can put String
											// in switch
			case "cancel":

				ArrayList<Orders> orderList = new ArrayList<>();
				orderList = (ArrayList) oservice.getAllOrders();
				for (Orders ord : orderList) {
					if (ord.getOrdersId().getOrder_Id() == order_Id) {
						oservice.delete(order_Id, ord.getOrdersId().getItem_Id());
					}
				}
				Orders newOrders = new Orders();
				model.put("newOrders", newOrders);
				model.put("message","Ordered Cancelled");
				break;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}

		return "customerHome";

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Map<String, Object> model,HttpSession session,HttpServletRequest request) {
		request.getSession().setAttribute("order", null);
		session.invalidate();
		order.clear();
         return "index";
    }


}