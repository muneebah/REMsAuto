<jsp:include page="./header/include.jsp" />
<body>

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
            <li><a href="/carshop">Home</a></li>                     
            <li><a href="supplierform">Add Supplier</a></li>
            <li><a href="suppliers">List Of Suppliers</a></li>
            <li class="active"><a href="customerform">Add Customer</a></li>
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

    <div class="jumbotron">
      <div class="container">
        </br>
        <div class="span6">
  <center>
    <f:form id="form" method="post" modelAttribute="CustomerModel" class="form-horizontal" action="createcustomer">

        <div class="control-group warning" hidden="true">
            <label class="control-label" for="inputWarning">Input with warning</label>
            <div class="controls">
                <f:input path="id"/>
            </div>
        </div>
          <h2>Create  Customer </h2>
        <div class="control-group warning">
            <label class="control-label" for="custNumber">Customer Number</label>
            <div class="controls">
                <f:input path="custNumber"  type="text" id="custNumber" />
            </div>
        </div>

        <div class="control-group warning">
            <label class="control-label" for="firstName">First Name </label>
            <div class="controls">
                <f:input path="firstName" type="text" id="firstName"/>
            </div>
        </div>
            
        <div class="control-group warning">
            <label class="control-label" for="lastname">Last Name </label>
            <div class="controls">
                <f:input path="lastname" type="text" id="lastname"/>
            </div>
        </div>
            
        <div class="control-group warning">
            <label class="control-label" for="gender">Gender</label>
            <div class="controls">
                <f:input path="gender" type="text" id="gender"/>
            </div>
        </div>
            
        <div class="control-group warning">
            <label class="control-label" for="dob">Date Of Birth </label>
            <div class="controls">
                <f:input path="dob" type="text" id="dob"/>
            </div>
        </div>
          
          <div class="control-group warning">
            <label class="control-label" for="phone">Phone Number </label>
            <div class="controls">
                <f:input path="phone" type="text" id="phone"/>
            </div>
        </div>
        <div class="control-group warning">
            <label class="control-label" for="cell">Cell Number</label>
            <div class="controls">
                <f:input path="cell" type="text" id="cell"/>
            </div>
        </div>
        <div class="control-group warning">
            <label class="control-label" for="streetAddress">Street Address </label>
            <div class="controls">
                <f:input path="streetAddress" type="text" id="streetAddress"/>
            </div>
        </div>
          <div class="control-group warning">
            <label class="control-label" for="postalAddress">Postal Address </label>
            <div class="controls">
                <f:input path="postalAddress" type="text" id="postalAddress"/>
            </div>
        </div>

        <button type="submit" class="btn btn btn-inverse btn-large">Create Customer</button>

    </f:form>
    
</center>

					
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
         <p>&copy; REMsAuto.com 2014</p>
          
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
