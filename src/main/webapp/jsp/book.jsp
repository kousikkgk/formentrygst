<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script src="js/postreq.js"></script> 
	<script src="js/getreq.js"></script> 
</head>
<body>
<div id="responseDiv" align="center"></div>
	<div class="container">
		<h2>Stacked form</h2>
		<form action="" id="bookForm">
			<div class="form-group">
				<label for="bookId">Book Id:</label> <input type="text"
					class="form-control" id="bookId" placeholder="Enter Book Id"
					name="bookId">
			</div>
			<div class="form-group">
				<label for="bookName">Book Name:</label> <input type="text"
					class="form-control" id="bookName" placeholder="Enter Book Name"
					name="bookName">
			</div>
			<div class="form-group">	
				<label for="author">Author:</label> <input type="text"
					class="form-control" id="author" placeholder="Enter Author Name"
					name="author">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<br />
		
		<div class="col-sm-7" style="margin: 20px 0px 20px 0px">
			<button id="getAllBooks" class="btn btn-primary">Get All Books</button>
			<div id="getResultDiv" style="margin:20px 10px 20px 50px">
				<ul class="list-group">
				</ul>
			</div>	
		</div>
	
	</div>
	
</body>
</html>