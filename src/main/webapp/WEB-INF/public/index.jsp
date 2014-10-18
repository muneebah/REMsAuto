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
          <a class="navbar-brand" href="/cardealership">Car Sales Application </a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/cardealership">Home</a></li>
            <li><a href="supplierform">Create Car Supplier</a></li>
            <li><a href="suppliers">List Of Suppliers</a></li>
            <li><a href="producer">Producer</a></li>
            <li><a href="consumer">Consumer</a></li>
            
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
          <h2 style="margin-left: 150px">${msg.welcome}</h2>
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
          <h2></h2>
          <p> </p>
          
        </div>
        <div class="col-lg-4">
          <h2></h2>
          <p>&copy; Car Sales.com 2013</p>
          
       </div>
        <div class="col-lg-4">
          <h2></h2>
          <p></p>
        </div>
      </div>

      <hr>

      <footer>
        <p></p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/jumbotron/assets/js/jquery.js"></script>
    <script src="/resources/jumbotron/dist/js/bootstrap.min.js"></script>
  </body>
</html>
