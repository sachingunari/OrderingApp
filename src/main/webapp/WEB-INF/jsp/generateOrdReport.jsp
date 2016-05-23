<%@page import="org.springframework.ui.Model"%>
<%@page import="com.ordering.model.Orders"%>
<%@ page import ="java.util.*" %>
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
<title>OrderStatus</title>
</head>
<style>
body {
        background: #3CC;        
		background-image : url("http://indospartans.com/uploads/tk.jpg");
    }
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

#logbox {

        padding: 10px;
        margin: 50px auto;
		margin-left: 750px;
        width: 340px;
        background-color: #fff;
        -webkit-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
        -moz-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
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

::selection {
        background-color: #b5e2e7;
    }

    ::-moz-selection {
        background-color: #8ac7d8;
    }

    body {
        background: #3CC;        
		background-image : url("http://indospartans.com/uploads/tk.jpg");
    }

    .container {
        display: -webkit-flex;
        display: flex;
        height: 100%;
    }

    #logbox {

        padding: 10px;
        margin: 50px auto;
		margin-left: 350px;
        width: 340px;
        background-color: #fff;
        -webkit-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
        -moz-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
        box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
    }

    h1 {
        text-align: center;
        font-size: 175%;
        color: #757575;
        font-weight: 300;
    }

    h1, input {
        font-family: "Open Sans", Helvetica, sans-serif;
    }

    .input {
        width: 75%;
        height: 50px;
        display: block;
        margin: 0 auto 15px;
        padding: 0 15px;
        border: none;
        border-bottom: 2px solid #ebebeb;
    }
    .input:focus {
        outline: none;
        border-bottom-color: #3CC !important;
    }
    .input:hover {
        border-bottom-color: #dcdcdc;
    }
    .input:invalid {
        box-shadow: none;
    }

    .pass:-webkit-autofill {
        -webkit-box-shadow: 0 0 0 1000px white inset;
    }

    .inputButton {
        position: relative;
        width: 85%;
        height: 50px;
        display: block;
        margin: 30px auto 30px;
        color: white;
        background-color: #3CC;
        border: none;
        -webkit-box-shadow: 0 5px 0 #2CADAD;
        -moz-box-shadow: 0 5px 0 #2CADAD;
        box-shadow: 0 5px 0 #2CADAD;
    }
    .inputButton:hover {
        top: 2px;
        -webkit-box-shadow: 0 3px 0 #2CADAD;
        -moz-box-shadow: 0 3px 0 #2CADAD;
        box-shadow: 0 3px 0 #2CADAD;
    }
    .inputButton:active {
        top: 5px;
        box-shadow: none;
    }
    .inputButton:focus {
        outline: none;
    }

    .navbar-brand{
	        font-size: xx-large;
    font-weight: bold;
    font-family: cursive;
	
	}
    .error {
    	margin-top:200px;
        color: white;
        font-weight: bold;
    }
</style>
<body>
<ul>
  <li><a class="active" href="adminHome">Home</a></li>
   <li><a href = "logout" style="
    border-left-width: 100px;
    margin-left: 1200px;
">Logout</a></li>
 
</ul>


<div class="container" >
    <div class="col-md-80" >
        <div id="logbox"  >
            <form:form action="orderReport"  method="POST">
                <h1>Generate Order Report</h1>
                From Date:
				<input type="date" name="fromdate"   class="form-control" placeholder="From date" required /> 
				<br>
				<br>
				To Date:                                    
                <input type="date" class="form-control" name="todate" placeholder="To Date" required />
                <input type="submit" value="Generate Report!" class="inputButton"/>

            </form:form>
        </div>
    </div>
    <!--col-md-6-->


</div>
</body>
</html>