<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
 <script defer src="https://use.fontawesome.com/releases/v5.0.9/js/all.js" integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl" crossorigin="anonymous"></script>

	<!-- <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"> -->
	<!-- <link href="css/main.css" rel="stylesheet"> -->
<body>
	<div class="fluid-container mx-auto"  id="box" style="width:98%;">  
		<div class="d-flex">
  			<div class="p-2 flex-fill"><h3>Signup List</h3></div>
  			<div class="p-2 flex-fill"><a href="addSignuplist"><i class="fa fa-plus" aria-hidden="true"></i>ADD	</a></div>
		</div>
				<div class="table-responsive-sm">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Party Name</th>
					<th scope="col">Mobile No</th>
					<th scope="col">Gst User ID</th>
					<th scope="col">Gst Password</th>
					<th scope="col">Email</th>
					<th scope="col">Email Pass</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody class="bg-light">
				<c:forEach var="signup" items="${signuplist}">
					<tr>
						<td>${signup.partyName}</td>
						<td>${signup.mobileNo}</td>
						<td>${signup.gstId}</td>
						<td>${signup.gstPass}</td>
						<td>${signup.email}</td>
						<td>${signup.emailPass}</td>
						<td><a href="edit/${signup.gstId}"><i class="fas fa-edit"></i></a></td>
						<td><a href="delete/${signup.gstId}"><i class="fas fa-trash"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>