<jsp:include page="../header/include.jsp" />
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

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
          <a class="navbar-brand" href="/cardealership">Car Sales Application </a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
           <li><a href="/cardealership">Home</a></li>
            <li class="active"><a href="supplierform">Create Car Supplier</a></li>
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

    <div class="jumbotron">
      <div class="container">
        </br>
        <div class="span6">
  <center>
    <f:form id="form" method="post" modelAttribute="carSupplierModel" class="form-horizontal" action="createsupplier">

        <div class="control-group warning" hidden="true">
            <label class="control-label" for="inputWarning">Input with warning</label>
            <div class="controls">
                <f:input path="id"/>
            </div>
        </div>
          <h2>Create  Supplier </h2>
        <div class="control-group warning">
            <label class="control-label" for="supplierAddress">Supplier Address</label>
            <div class="controls">
                <f:input path="supplierAddress"  type="text" id="supplierAddress" />
            </div>
        </div>

        <div class="control-group warning">
            <label class="control-label" for="supplierCode">Supplier Code </label>
            <div class="controls">
                <f:input path="supplierCode" type="text" id="supplierCode"/>
            </div>
        </div>
            
        <div class="control-group warning">
            <label class="control-label" for="supplierContact">Supplier Contact </label>
            <div class="controls">
                <f:input path="supplierContact" type="text" id="supplierContact"/>
            </div>
        </div>
            
        <div class="control-group warning">
            <label class="control-label" for="supplierEmail">Supplier Email </label>
            <div class="controls">
                <f:input path="supplierEmail" type="text" id="supplierEmail"/>
            </div>
        </div>
            
        <div class="control-group warning">
            <label class="control-label" for="supplierName">Supplier Name </label>
            <div class="controls">
                <f:input path="supplierName" type="text" id="supplierName"/>
            </div>
        </div>

        <button type="submit" class="btn btn btn-inverse btn-large">Create Supplier</button>

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

</body>
