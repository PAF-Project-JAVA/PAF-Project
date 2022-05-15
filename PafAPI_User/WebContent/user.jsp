<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Users Management</title>
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<script src="Components/jquery-3.6.0.min.js"></script>
		<script src="Components/user.js"></script>
	</head>
	 <body>
		<div class="container">
			<div class="row">
				<div class="col-6"> 
					<h1>User Service</h1>
					
					<form id="formUser" name="formUser" method="post" action="user.jsp">
					
						 User Name: 
						 <input id="uName" name="uName" type="text" 
						 class="form-control form-control-sm">
						 <br>
						 
						  Address: 
						 <input id="uAddress" name="uAddress" type="text" 
						 class="form-control form-control-sm">
						 <br>
						 
						  Email: 
						 <input id="uEmail" name="uEmail" type="email" 
						 class="form-control form-control-sm">
						 <br>
						 
						  NIC: 
						 <input id="uNIC" name="uNIC" type="text" 
						 class="form-control form-control-sm">
						 <br>
						 
						  Phone No: 
						 <input id="uPhoneNo" name="uPhoneNo" type="text" 
						 class="form-control form-control-sm">
						 <br>
						 
						 <input id="btnSave" name="btnSave" type="button" value="Save" 
						 class="btn btn-primary">
						 
						 <input type="hidden" id="hidUserIDSave" 
						 name="hidUserIDSave" value="">
					</form>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>
					<div id="divUsersGrid">
					<%
						 User userObj = new User(); 
						 out.print(userObj.readUser()); 
						 %>
					</div>
			</div>
		 </div>
 	 </div> 
  </body>
</html>