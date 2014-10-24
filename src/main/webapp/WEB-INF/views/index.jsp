<jsp:include page="header/include.jsp" />
<!DOCTYPE html>
<html lang="en">

<body style="background-color:activeborder">

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/carshop"><img src="resources/images/wallpaper.jpg" style="width:100px; height:50px;" /> </a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/carshop">Home</a></li>                     
            <li><a href="/suppliers/createSupplier.html">Add Supplier</a></li>
            <li><a href="suppliers">List Of Suppliers</a></li>
            <li><a href="#">Add Customer</a></li>
            <li><a href="#">List Of Customer</a></li>
            <li><a href="#">About Us</a></li>
          
          </ul>
            <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Search....." class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Search</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </div>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
          <h2 style="margin-left: 150px">Welcome</h2>
        </br>
        <div class="span10">
	<div id="myCarousel" class="carousel slide">
	<ol class="carousel-indicators">
	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	<li data-target="#myCarousel" data-slide-to="1"></li>
	<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	 <!-- Carousel items -->
	<div class="carousel-inner">
	<div class="active item"><img src="resources/images/background.jpg" style="width:1000px; height:400px;" /></div>
	<div class="item"><img src="resources/images/wallpaper.jpg" style="width:650px; height:300px;"/></div>
	<div class="item"><img src="resources/images/car.jpg" style="width:650px; height:300px;"/></div>
	</div>
	<!-- Carousel nav -->
	<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
					
	</div>
    
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>Our Client</h2>
          <p>REMs Auto is a car dealership looking for an
opportunity to sell second-hand vehicles online.  Currently, all
information is captured manually. Our client's current daily issues consists of the following:capturing customer information via book and pen is time
consuming and can cause many mistakes. Manually searching through books for customer or supplier
information.No system in place to manage sales (employees find it difficult to monitor profit and losses).
Requires flexible applications - web-based solution, so that customers are able to purchase from any location.
 </p>
         
        </div>
        <div class="col-lg-4">
          <h2>Information</h2>
          <p>Our proposal is to create a database driven website whereby his
clients can purchase online. For us to fulfill this, we propose an online
shopping cart for customer            interaction, a mobile application for
updated information about the latest offerings to the customer and a
desktop application for employees to manage day-to-day
 activities(i.e. Maintain stock, customers, monitor sales).
. </p>
          
       </div>
        <div class="col-lg-4">
          <h2>Developers</h2>
          <p>Rhulani Baloyi 210188200</p><p> Muneebah Galant 209028572 </p><p> Elton De Jongh 210065990 </p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; REMsAuto.com 2014</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/jumbotron/assets/js/jquery.js"></script>
    <script src="/resources/jumbotron/dist/js/bootstrap.min.js"></script>
  </body>
</html>
