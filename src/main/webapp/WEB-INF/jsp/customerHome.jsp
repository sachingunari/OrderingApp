<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
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
    z-index: 7;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
    z-index: 7;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.show {display:block;}

table, th, td,th {
    padding: 1px;
    
}
table {
    border-spacing: 10px;
    
}
</style>
</head>
<body >

<ul style="
    margin-left: 0px;
">
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
  <li><a href = "logout" style="
    border-left-width: 100px;
    margin-left: 950px;
">Logout</a></li>
</ul>

<div id ="shoppingCart">

	<h1>Your Shopping Cart</h1>
		
			<table>
				<tr>
					<th>Name:</th>
					<th>Price:</th>
					<th>Quantity:</th>
				</tr>
				<c:forEach items="${order}" var="item">
				<tr>
					<td>${item.name} </td>
					<td>${item.cost} </td>
					<td>${item.quantity} </td>
				</tr>
				</c:forEach>
				<tr>
						<td>total</td> 
						<td>${totals}</td>						
					</tr>

			</table>
</div>



		

			<form:form method="post"  action="placeorder" >
					<tr>
					<td> <input value="${order}" style="display :none" name="orders"></input></td>
					<td> <input value="${totals}" style="display :none" name="total"></input></td>
					
					<td>
					<div id="datetimepicker" class="input-append date">
						<style scoped>
						
							@import "http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css";
							@import	"http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css";
						</style>	
				      <input type="text" name="date"></input>
				      <span class="add-on">
				        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
				      </span>
				    </div>
                    </td>
					        									
					<td> <input type="submit" value="placeorderz"></input></td> 
					</tr>
			</form:form>
















<div id = "first">
	<h3>
		<p>Click on the "Menu Category" link to see the menu.</p>
	</h3>
	<table id= "app" border="1" style="display:none">
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
					<td><input type="text" placeholder="quantity" name="quantity"></input></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
	<table id= "des" border="1" style="display:none">
		<c:forEach items="${itemList}" var="item">
			<c:if test="${item.category_Id == 2}"> 
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
					<td><input type="text" placeholder="quantity" name="quantity"></input></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
	<table id= "dri" border="1" style="display:none">
		<c:forEach items="${itemList}" var="item">
			<c:if test="${item.category_Id == 3}"> 
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
					<td><input type="text" placeholder="quantity" name="quantity"></input></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
	<table id= "mai" border="1" style="display:none">
		<c:forEach items="${itemList}" var="item">
			<c:if test="${item.category_Id == 4}"> 
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
					<td><input type="text" placeholder="quantity" name="quantity"></input></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
</div>

<script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="./js/bootstrap-datetimepicker.en.js">
    </script>
    <script type="text/javascript">
      $('#datetimepicker').datetimepicker({
        format: 'dd/MM/yyyy hh:mm:ss',
        language: 'pt-BR'
      });
</script>
<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function showAppetizer(){
	console.log("inside show appetizer");
	document.getElementById("app").style.display= "inherit";
	document.getElementById("des").style.display= "none";
	document.getElementById("dri").style.display= "none";
	document.getElementById("mai").style.display= "none";
}
function showDesert(){
	document.getElementById("app").style.display= "none";
	document.getElementById("des").style.display= "inherit";
	document.getElementById("dri").style.display= "none";
	document.getElementById("mai").style.display= "none";
}
function showDrink(){
	document.getElementById("app").style.display= "none";
	document.getElementById("des").style.display= "none";
	document.getElementById("dri").style.display= "inherit";
	document.getElementById("mai").style.display= "none";
}
function showMainCourse(){
	document.getElementById("app").style.display= "none";
	document.getElementById("des").style.display= "none";
	document.getElementById("dri").style.display= "none";
	document.getElementById("mai").style.display= "inherit";
}

$(document).ready(function(){
    $("#btn1").click(function(){
    	var name = document.getElementById("iname").value;
    	var price = document.getElementById("iprice").value;
    	console.log(name);
        $("p.itemname").append(name);
        $("p.itemprice").append(price);
    });
});

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
