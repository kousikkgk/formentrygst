<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>	
<style type="text/css">
	body {
	background: #0F2027; /* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #2C5364, #203A43, #0F2027);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #2C5364, #203A43, #0F2027);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}
</style>	
</head>
<body>
	<div class="container">
	<form method="post" action="showgstr3b">
		<div class="row w-25 mx-auto mt-2 mb-2" style="background:white">
			<div class="input-group date">
				<div class="col-6">
					<label for="gstr3bdate">Select date:</label>
				</div>
				<div class="col-6">
					<input type="text" class="form-control" name="gstr3bdate"
						id="datepicker" placeholder="MM/YYYY" autocomplete="off">
				</div>
			</div>
			<div class="d-flex justify-content-center">
				<div class="p-2">
					<input type="submit" class="btn btn-outline-success btn-sm ">
				</div>
			</div>
			<script type="text/javascript">
				 $('#datepicker').datepicker({
					format : "mm-yyyy",
					viewMode : "months",
					minViewMode : "months"
				});  
			</script>
		</div>
		</form>
		<div class="d-flex justify-content-center mt-5">
			<div class="p-2">
				<a href="/home" class="btn btn-outline-light btn btn-block" role="button">HOME</a>
			</div>
		</div>
		<table class="table table-sm">
			<thead class="thead-dark">
				<tr>
					<th>Purchase</th>
					<th>Sales</th>
				</tr>
			</thead>
			<tbody class="table-light">
				<tr>
					<td><h6>Taxable Value: ${purtaxVal}</h6></td>
					<td><h6>Taxable Value: ${saltaxVal}</h6></td>
				</tr>
				<tr>
					<td><h6>IGST Value: ${purigstVal}</h6></td>
					<td><h6>IGST Value: ${saligstVal}</h6></td>
				</tr>
				<tr>
					<td><h6>CGST Value: ${purcgstVal}</h6></td>
					<td><h6>CGST Value: ${salcgstVal}</h6></td>
				</tr>
				<tr>
					<td><h6>SGST Value: ${pursgstVal}</h6></td>
					<td><h6>SGST Value: ${salsgstVal}</h6></td>
				</tr>
				<tr>
					<td><h6>Total: ${purtotal}</h6></td>
					<td><h6>Total: ${saltotal}</h6></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="js/login.js"></script>
</body>
</html>