<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Admin Management</title>
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
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="#news">News</a></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction()">Menu Category</a>
  </li>
</ul>

<div class ="row">
	<div align="center">
		<h3>Admin Item Management</h3>
	</div>
</div>

<div class="container" >
    <div class="row" align="center">
        <form:form action="addremove" commandName="item">
            <div class="col-lg-12">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="InputId">Item  Id</label>
                    <div class="input-group">
                        <form:input path="Id" type="text" class="form-control" placeholder="Enter Id" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputName">Item  Name</label>
                    <div class="input-group">
                        <form:input path="name" type="text" class="form-control" placeholder="Enter Name" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputCookingTime">Item Cooking time:</label>
                    <div class="input-group">
                        <form:input path="cooking_Time" type="text" class="form-control" id="InputCookingTime" name="InputCookingTime" placeholder="Enter Cooking Time" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputItemCost">Item Cost:</label>
                    <div class="input-group">
                        <form:input path="cost" type="text" class="form-control" id="InputCost" name="InputCost" placeholder="Enter Item Cost" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputPicUrl">Pic Url:</label>
                    <div class="input-group">
                        <form:input path="pic_Url" type="text" class="form-control" id="pic_Url" name="pic_Url" placeholder="Enter Picture Url" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputCalories:">Calories:</label>
                    <div class="input-group">
                        <form:input path="calories" type="text" class="form-control" id="Calories" name="Calories" placeholder="Enter Calories" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputCategoryId">Category Id:</label>
                    <div class="input-group">
                        <select name="Category" class="form-control">
						<c:forEach items="${catList}" var="Category">
						    <option value="${Category.category_Id}">${Category.category_Name}</option>
						</c:forEach>
						</select>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div>
                	<input type="submit" name="action" id="submit" value="Create" class="btn btn-info pull-center">
                	<input type="submit" name="action" id="submit" value="Delete" class="btn btn-info pull-center">
            	</div>                	
            </div>
        </form:form>
    </div>
</div>

<div class ="row">
	<div align="center">
		<h3>Item Details</h3>
	</div>
</div>

<div class="container" >
    <div class="row" align="center">
            <div class="col-lg-12">
                 <table style = "width:70%">
							<th>item Id</th>
							<th>item.name</th>
							<th>item.category_Id</th>
							<th>item.cooking_Time</th>
							<th>item.cost</th>
							<th>item.pic_Url</th>
							<th>item.calories</th>
							
					<c:forEach items="${studentList}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.category_Id}</td>
							<td>${item.cooking_Time}</td>
							<td>${item.cost}</td>
							<td>${item.pic_Url}</td>
							<td>${item.calories}</td>
							
						</tr>
					</c:forEach>
				</table>
			</div>
	</div>
</div>

</body>
</html>


