<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="org.springframework.ui.Model"%>
    <%@page import="java.util.*"%>
<%@page import="com.ordering.model.Orders"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>My Orders</title>
</head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

table, td, th {    
    border: 1px solid #ddd;
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 15px;
}
</style>
<body>
<ul>
  <li><a class="active" href="adminHome">Home</a></li>
   <li><a href = "logout" style="
    border-left-width: 100px;
    margin-left: 800px;
">Logout</a></li>
 
</ul>

<div class ="row">
	<div align="center">
		<h3>Order Details</h3>
	</div>
</div>

<div class="container" >
    <div class="row" align="center">
            <div class="col-lg-12">
           		<form:form action="cancelOrder" method="post" commandName="orders">
                 <table style = "width:70%">
							<th>Order Id</th>
							<th>Item Id</th>
							<th>Item Quantity</th>
							<th>Pick Up Time</th>
							<th>Order Status</th>
							
					<% ArrayList<Orders> CustomerOrders = new ArrayList<>();
						CustomerOrders =(ArrayList)request.getAttribute("CustomerOrders");
					%>
					<%
						String cancelString = "";
						for(Orders o :CustomerOrders){
						 	if(o.getOrders_status().equals("in Queue")){
								cancelString = "CANCEL";
							} else{
								cancelString = "";
								
							}
						%>
						<tr>
							<td><input value="<%=o.getOrdersId().getOrder_Id()%>" style="display:none" name="order_Id"></input><%=o.getOrdersId().getOrder_Id()%></td>
							<td><%=o.getOrdersId().getItem_Id()%></td>
							<td><%=o.getItem_Quantity() %></td>
							<td><%=o.getPickup_Time() %></td>
							<td><%=o.getOrders_status()%></td>
							<td><input type="submit" name="action" value=<%=cancelString %> /></td>			
						</tr>
						<%	} %>
				</table>
				</form:form>
			</div>
	</div>
</div>
</body>
</html>
