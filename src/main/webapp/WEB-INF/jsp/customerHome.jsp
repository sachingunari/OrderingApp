<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.show {display:block;}

table, th, td {
    padding: 5px;
}
table {
    border-spacing: 20px;
}
</style>
</head>
<body >

<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="#news">News</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction()">Menu Category</a>
    <div class="dropdown-content" id="myDropdown">
      <a href="#" id ="appetizer" onclick="showAppetizer()">Appetizer</a>
      <a href="#" id ="desert" onclick="showDesert()">Desert</a>
      <a href="#" id ="drink" onclick="showDrink()">Drink</a>
      <a href="#" id ="maincourse" onclick="showMainCourse()">MainCourse</a>
    </div>
  </li>
</ul>

	<div name = "second" style=" width: 40%;float: right; position: relative;" id ="cart">

		<h1>Your Shopping Cart</h1>
			
				<table>
					<tr>
						<td>Name:</td>
						<td>Price:</td>
					</tr>
					<c:forEach items="${order}" var="item">
					<tr>
						<td>${item.name} </td>
						<td>${item.cost} </td>
					</tr>
					</c:forEach>
				</table>
	</div>
	<div name = "first" style=" width: 50%; float: left;">
		<h3>
			<p>Click on the "Menu Category" link to see the menu.</p>
		</h3>
		<table id= "category" border="1" style="display:none">
			<c:forEach items="${itemList}" var="item">
				<c:if test="${item.category_Id == 1}"> 
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Image</th>
					<th>Cost</th>
					<th>Calories</th>
					<th>Quantity</th>
				</tr>
				<form:form method="post" action="addProduct">
				<tr>
					<td><input value="${item.id}" name="id"></td>
					<td><input value="${item.name}" name="name"></td>
					<td><img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png" height="42" width="42"></img></td>
					<td><input value="${item.cost}" name="cost"></td>
					<td><input value="${item.calories}" name="calories"></td>
					<td><input type="text" placeholder="quantity"></input></td>
					<td>
					<input type="submit" value="Add to Cart" onclick="addToCart()"></input>
					</td>		
				</tr>
				</form:form>
				</c:if>
				</c:forEach>
		</table>
	
	</div>
<p>

<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function showAppetizer(){
	document.getElementById("category").style.display= "inherit";
}

function addToCart(){
	
	var cart ={"name":"","price":""};
	
	var name = document.getElementById("itemname").value;
	var price = document.getElementById("itemprice").value;
	
	cart.name = name;
	cart.price = price;
	
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    for (var d = 0; d < dropdowns.length; d++) {
      var openDropdown = dropdowns[d];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>

</body>
</html>
