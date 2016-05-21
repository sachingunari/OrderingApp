<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>Customer Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
</head>
<style>

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
		margin-left: 750px;
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

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     
      <a class="navbar-brand" href="/CRUDWebAppMavenized">TakeOutOrder</a>
	  
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      
      <ul class="nav navbar-nav navbar-right">
	  
	  
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     
	 

      <form:form action="loginCust"  method="POST"  class="navbar-form navbar-right"  commandName="user">
	 
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>                 
                            <form:input path="username" id="email" type="email" name="email"   class="form-control" placeholder="User Email Address" />
                                                     
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <form:password path="password" class="form-control" name="password" value="" placeholder="User Password" />
                            
                  </div>

                        <button type="submit" class="btn btn-primary">Login</button>
                        
                        <div>
                        	<form:errors path="username" cssClass="error"/>
                        	<form:errors path="password" cssClass="error"/>
                        </div>
                   </form:form>
                   <div>
                   		<h4 style="color :white">${error}<h4>
                   </div>
     
    			</div>
    
      </ul>
    </div>
  </div>
</nav>


  
<div>
<div class="container" >
    <div class="col-md-56" >
        <div id="logbox"  >
            <form:form action="signup"  method="POST" id="signup" commandName="user">
                <h1>Create an Account</h1>
				<form:input path="username" id="email" type="email" name="email"   class="form-control" placeholder="Email Address" />                                     
                <form:password path="password" class="form-control" name="password" value="" placeholder="Password" />
                <input type="submit" value="Sign me up!" class="inputButton"/>

            </form:form>
        </div>
    </div>
    <!--col-md-6-->


</div>
</div>

</body>
</html>


