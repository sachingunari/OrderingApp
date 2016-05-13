<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


  <title>TakeOutOrder</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
</head>

</head>


<body>                    
<body background="file:///C:/Users/Saurabh/git/OrderingApp/src/main/webapp/WEB-INF/Images/tk.jpg">


    <div align="center">
        <h2>Please check your email inbox and enter the token below</h2>
        <table border="0" width="90%">
        <form:form action="tokenverify" commandName="tokenverify">
                <tr>					
					<h1>Token:</h1>
                    <input type="text" name=userId id ="userId" value="" > 
                </tr>
                    <br>
                    <br>
                    <td></td>
                    <td align="center"><input type="submit" value="submit"/></td>
                    <td></td>
                </tr>
        </form:form>
        </table>
    </div>
</body>
</html>