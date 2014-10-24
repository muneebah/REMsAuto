<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./header/include2.jsp" />

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
            <li><a href="#">Add Customer</a></li>
            <li class="active"><a href="customers">List Of Customer</a></li>
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
        </br>
        <div class="span12">
            <center>
    <table class="table table-hover">
    <h2>Customers</h2>
    </br>
        <thead>
            <tr>
                <th>Customer Number</th>
                <th>First Name </th>
                <th>Last Name</th>
                <th>Gender </th>
                <th>Date Of Birth </th>
                <th>phone Number </th>
                <th>Cell Number </th>
                <th>Street Address </th>
                <th>Postal Address </th>
                <th>Edit </th>
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.custNumber}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastname}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.dob}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.cell}</td>
                    <td>${customer.streetAddress}</td>
                    <td>${customer.postalAddress}</td>
                    <td><a href="editcustomer?id=${customer.id}"> Edit </a></td>
                    <td><a href="deletecustomer?customerId=${customer.id}"> Delete </a></td>
                </tr>

            </c:forEach>

        </tbody>


    </table>

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

