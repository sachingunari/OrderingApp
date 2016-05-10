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

<h3><p>Click on the "Menu Category" link to see the menu.</p></h3>
<p >
	<table id= "category" border="1" style="display:none">
	<c:forEach items="${itemList}" var="item">
	<c:if test="${item.category_Id == 1}"> 
		<tr>
			<td>${item.Id}</td>
			<td>${item.name}</td>
			<td>${item.pic}</td>
			<td>${item.cost}</td>
			<td>${item.calories}</td>			
		</tr>
	</c:if>
	</c:forEach>
	</table>
</p>





<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function showAppetizer(){
	window.alert("hi");
	console.log("inside method");
	//document.getElementById("category").classList.toggle("show");
	document.getElementById("category").style.display= "inherit";
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
