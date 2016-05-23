<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<title>Homepage</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<style>
html,
body {
        background: #3CC;        
		background-image : url("http://indospartans.com/uploads/tk.jpg");
    }

body {
    padding-top: 50px; /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}

.img-portfolio {
    margin-bottom: 30px;
}

.navbar-default {
  background-color:#867979;
  background-image: none;
  background-repeat: no-repeat;
 }

.img-hover:hover {
    opacity: 0.8;
}

/* Home Page Carousel */

header.carousel {
    height: 100%;
}

header.carousel .item,
header.carousel .item.active,
header.carousel .carousel-inner {
    height: 100%;
}

header.carousel .fill {
    width: 100%;
    height: 100%;
    background-position: center;
    background-size: cover;
}

/* 404 Page Styles */

.error-404 {
    font-size: 100px;
}

/* Pricing Page Styles */

.price {
    display: block;
    font-size: 50px;
    line-height: 50px;
}

.price sup {
    top: -20px;
    left: 2px;
    font-size: 20px;
}

.period {
    display: block;
    font-style: italic;
}

/* Footer Styles */

footer {
    margin: 50px 0;
}

/* Responsive Styles */

@media(max-width:991px) {
    .customer-img,
    .img-related {
        margin-bottom: 30px;
    }
}

@media(max-width:767px) {
    .img-portfolio {
        margin-bottom: 15px;
    }

    header.carousel .carousel {
        height: 70%;
    }
}
.navbar-brand{
	        font-size: x-large;
    font-weight: bold;
    font-family: cursive;
</style>




</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- changes made by swati -->
                <a class="navbar-brand" href = "#">TakeOutOrderApp</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                <li>
                        <a href="loginAdmin">LOGIN AS ADMIN</a>
                    </li>
               		<li>
                        <a href="loginCustomer">LOGIN AS CUSTOMER</a>
                    </li>            
                
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>


    </div>
    <!-- /.container -->

    <!-- jQuery -->

    <!-- Script to Activate the Carousel -->
</body>

</html>
