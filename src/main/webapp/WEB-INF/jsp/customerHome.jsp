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
body {
        background: #3CC;        
		background-image : url("http://indospartans.com/uploads/tk.jpg");
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
  <li><a class="active" href="#">Home</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction()">Menu Category</a>
    <div class="dropdown-content" id="myDropdown">
      <a href="#" id ="appetizer" onclick="showAppetizer()">Appetizer</a>
      <a href="#" id ="desert" onclick="showDesert()">Desert</a>
      <a href="#" id ="drink" onclick="showDrink()">Drink</a>
      <a href="#" id ="maincourse" onclick="showMainCourse()">MainCourse</a>
    </div>
  </li>
  <li><a href="customerOrders">My Orders</a></li>
  <li><a href = "logout" style="
    border-left-width: 100px;
    margin-left: 800px;
">Logout</a></li>
</ul>

<div id ="shoppingCart">
	<h3>Your Order Details</h3>		
			<table border="0">
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
				<tr>
					<td>${message}</td>	
				</tr>
				<tr>
				<td>${etime}</td>
				</tr>	

			</table>		

			<form:form method="post"  action="placeorder" >
					<tr>
					<td> <input value="${order}" style="display :none" name="orders"></input></td>
					<td> <input value="${totals}" style="display :none" name="total"></input></td>
					<td> <input value="${totalstime}" style="display :none" name="totaltime"></input></td>
					
					<td>
		<input name="times" type=time min="06:00" max="21:00" step="01" value="10:00">
		  </td>

		  <td>
			<%  java.util.Date date= new java.util.Date();
            		java.util.Calendar cal = java.util.Calendar.getInstance();
cal.setTime(date);

int maxmonth = cal.get(java.util.Calendar.MONTH);
maxmonth = maxmonth +2;
int maxyear = cal.get(java.util.Calendar.YEAR);
maxyear = maxyear +0;
int maxday = cal.get(java.util.Calendar.DAY_OF_MONTH);
maxday = maxday +0;
int minmonth = cal.get(java.util.Calendar.MONTH);
minmonth = minmonth +1;
int minyear = cal.get(java.util.Calendar.YEAR);
minyear = minyear +0;
int minday = cal.get(java.util.Calendar.DAY_OF_MONTH);
minday = minday +0;

System.out.println("month: " +maxmonth +" day: "+maxday+" maxyear: "+maxyear);
%>
<input type="date" name="dates" max="<%=maxyear %>-0<%=maxmonth %>-<%=maxday %>" min="<%=minyear %>-0<%=minmonth %>-<%=minday %>"><br><br>
			</td>	
										
                  					        									
					<td> <input type="submit" value="PLACEORDER"></input></td> 
					</tr>
			</form:form>

</div>
<div id = "first">
	<h3>
		<p>Click on the "Menu Category" link to see the menu.</p>
	</h3>
	<table id= "app" border="0" style="display:none">
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
					<td><input value="${item.id}" name="id" readonly = "true"></td>
					<td><input value="${item.name}" name="name" readonly = "true"></td>
					<td><img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png" height="42" width="42"></img></td>
					<td><input value="${item.cost}" name="cost" readonly = "true"></td>
					<td><input value="${item.calories}" name="calories"  readonly = "true"></td> 
					<td style="display :none"><input value="${item.cooking_Time}" name="cooking_Time" ></td>
					
					<td ><select class="1-100" name="quantity"></select></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
	<table id= "des" border="0" style="display:none">
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
					<td><input value="${item.id}" name="id" readonly = "true"></td>
					<td><input value="${item.name}" name="name" readonly = "true"></td>
					<td><img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png" height="42" width="42"></img></td>
					<td><input value="${item.cost}" name="cost" readonly = "true"></td>
					<td><input value="${item.calories}" name="calories" readonly = "true"></td>
					<td style="display :none"><input value="${item.cooking_Time}" name="cooking_Time" ></td>
					<td><select class="1-100" name="quantity"></select></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
	<table id= "dri" border="0" style="display:none">
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
					<td><input value="${item.id}" name="id" readonly = "true"></td>
					<td><input value="${item.name}" name="name" readonly = "true"></td>
					<td><img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png" height="42" width="42"></img></td>
					<td><input value="${item.cost}" name="cost" readonly = "true"></td>
					<td><input value="${item.calories}" name="calories" readonly = "true"></td>
					<td style="display :none"><input value="${item.cooking_Time}" name="cooking_Time" ></td>
					<td><select class="1-100" name="quantity"></select></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
	<table id= "mai" border="0" style="display:none">
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
					<td><input value="${item.id}" name="id" readonly = "true"></td>
					<td><input value="${item.name}" name="name" readonly = "true"></td>
					<td><img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png" height="42" width="42"></img></td>
					<td><input value="${item.cost}" name="cost" readonly = "true"></td>
					<td><input value="${item.calories}" name="calories" readonly = "true"></td>
					<td style="display :none"><input value="${item.cooking_Time}" name="cooking_Time" ></td>
					<td><select class="1-100" name="quantity"></select></td>
					<td>
					<input type="submit" value="addproducts"/>
					</td>		
				</tr>
				</form:form>



			</c:if>
			</c:forEach>
	</table>
</div>

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

$(function(){
    var $select = $(".1-100");
    for (i=1;i<=100;i++){
        $select.append($('<option></option>').val(i).html(i))
    }
});
</script>

</body>
</html>


