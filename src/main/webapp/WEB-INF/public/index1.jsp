<jsp:include page="header/include.jsp" />

<body>
    <button class="btn btn-large btn-block btn-primary" type="button">This is The Landing Page for Car Sales Application Menu</button>

    <!--<h1 class="header">Hello World!</h1>-->
    <h2> ${msg.welcome}</h2>
    <h4> Today is ${msg.today}</h4>
    
<center>
    <button class="btn btn-success btn-large" type="button"><a href="supplierform">Create Car Supplier</a></button>
    <button class="btn btn btn-success btn-large" type="button"><a href="suppliers">List Car Suppliers</a></button>
    <button class="btn btn btn-success btn-large" type="button"><a href="messaging">Start to Chat</a></button>
</center>


</body>

<jsp:include page="footer/include.jsp" />
