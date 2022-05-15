<%@page import="demo.Emplooyee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>emplooyee Management</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src=jquery-3.6.0.js"></script>
<script src="Emplooyee.js"></script>

</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h1>emplooyee Management </h1>
<form id="formEmplooyee" name="formEmplooyee">
 emplooyee Name: 
 <input id="emplooyeeName" name="emplooyeeName" type="text" 
 class="form-control form-control-sm">
 <br> emplooyee Address: 
 <input id="emplooyeeAddr" name="emplooyeeAddr" type="text" 
 class="form-control form-control-sm">
 <br> emplooyee Nic: 
 <input id="emplooyeeNic" name="emplooyeeNic" type="text" 
 class="form-control form-control-sm">
 <br> emplooyee Age: 
 <input id="emplooyeeAge" name="emplooyeeAge" type="text" 
 class="form-control form-control-sm">
 <br>
 <br> emplooyee Phone Number: 
 <input id="emplooyeePhoneNo" name="emplooyeePhoneNo" type="text" 
 class="form-control form-control-sm">
 <br>
 <br> emplooyee E-mail: 
 <input id="emplooyeeEmail" name="emplooyeeEmail" type="text" 
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidEmplooyeeIDSave" 
 name="hidEmplooyeeIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divEmplooyeesGrid">
 <%
 Emplooyee emplooyeeObj = new Emplooyee();
	 out.print(emplooyeeObj.readEmplooyee()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>
