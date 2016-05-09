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
                
                  <td>Select Category</td>
                  <td>	
							<select name="Category">
						<c:forEach items="${catList}" var="Category">
						    <option value="${Category.category_Id}">${Category.category_Name}</option>
						</c:forEach>
						</select>
				</td>
                </tr>
                <tr>
                    <td ><input type="submit" name="action" value="Place Order" /></td>
                    <td align="left"><input type="submit" name="action" value="Delete"/></td>
                 
                </tr>
        </form:form>
        </table>
        
    </div>
</body>
</html>