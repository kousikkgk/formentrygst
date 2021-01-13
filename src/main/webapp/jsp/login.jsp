<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<link href="css/login.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
 }

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
</style>
</head>
<body>
	<ul>
		<li><a href="signuplist">Signup List</a></li>
		<li><a href="ewaybill">E-Way Bill</a></li>
	</ul>
	<div class="container">
		<form action="loginservlet" method="post" id="loginform">
			<div class="row">
				<h2 style="text-align: center; color: white">Login or Register
					with Gst Number</h2>
				<div class="vl">
					<span class="vl-innertext">or</span>
				</div>

				<div class="col">
					<input type="text" class="remove" name="gstnumber" placeholder="Gst Number" required> 
					<input type="button" id="loginbtn" value="Login">
					<h2 style="text-align: center; color: white">${loginerror}</h2>
				</div>
				<div class="col"> 
					<input type="text" name="gstnumber" placeholder="Gst Number" required> 
					<input type="text" name="partyname" placeholder="Party Name" required> 
					<input type="button" id="registerbtn" value="Register">
				</div>
			</div>
		</form>
	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="js/login.js"></script>
</body>
</html>
