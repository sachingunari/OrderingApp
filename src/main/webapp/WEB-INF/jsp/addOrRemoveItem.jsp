<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Or Remove JSP</title>
</head>
<body>
<h1>Add Or Remove JSP</h1>

<div align="center">
        <h2> Add Item </h2>
        <table border="0" width="90%">
        <form:form action="a" commandName="item">
                <tr>
                    <td align="left" width="20%">Item Id: </td>
                    <td align="left" width="40%"><form:input path="Id" size="30"/></td>
                    <td align="left"><form:errors path="Id" cssClass="error"/></td>
                </tr>
                <tr>
                    <td align="left" width="20%">Item Name: </td>
                    <td align="left" width="40%"><form:input path="name" size="30"/></td>
                    <td align="left"><form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Item Cooking time: </td>
                    <td><form:input path="cooking_Time" size="30"/></td>
                    <td><form:errors path="cooking_Time" cssClass="error"/></td>
                </tr>
                <tr>
                <tr>
                    <td>Item cost: </td>
                    <td><form:input path="cost" size="30"/></td>
                    <td><form:errors path="cost" cssClass="error"/></td>
                </tr>
                <tr>
                <tr>
                    <td>pic_Url: </td>
                    <td><form:input path="pic_Url" size="30"/></td>
                    <td><form:errors path="pic_Url" cssClass="error"/></td>
                </tr>
                <tr>
                <tr>
                    <td>Calories: </td>
                    <td><form:input path="calories" size="30"/></td>
                    <td><form:errors path="calories" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Category_Id: </td>
                    <td><form:input path="category_Id" size="30"/></td>
                    <td><form:errors path="category_Id" cssClass="error"/></td>
                </tr>
                <tr>
                    <td align="left"><input type="submit"  name="action" value="Create"/></td>
                    <td ><input type="submit" name="action" value="Edit" /></td>
                    <td align="left"><input type="submit" name="action" value="Delete"/></td>
                 
                </tr>
        </form:form>
        </table>
        
        
        </br>
        </br>
        </br>
        <table border="1">
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
</body>
</html>