<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<html>
<head>
    <title>Welcome</title>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!--link href="css/main.css" rel="stylesheet"-->   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>	
  <script defer src="https://use.fontawesome.com/releases/v5.0.9/js/all.js" integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl" crossorigin="anonymous"></script>
  
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
	<form method="post" action="editpurchase" id="editform">
		<div class="row w-25 mx-auto mt-2 mb-2" style="background: white">
			<div class="input-group date">
				<div class="col-6">
					<label for="gstr3bdate">Select date:</label>
				</div>
				<div class="col-6">
					<input type="text" class="form-control" name="editformdate" 
						id="datepicker" placeholder="MM/YYYY" autocomplete="off">
				</div>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio"
					name="invoicetyperadios" id="gridRadios1" value="Purchase" checked>
				<label class="form-check-label" for="gridRadios1"> Purchase
				</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio"
					name="invoicetyperadios" id="gridRadios2" value="Sales"> <label
					class="form-check-label" for="gridRadios2"> Sales </label>
			</div>
			<div class="d-flex justify-content-center">
				<div class="p-2">
					<input type="button" id="editsubmit" class="btn btn-outline-success btn-sm" value="Submit">
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
	<div class="table-responsive-sm">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Inv No</th>
					<th scope="col">Date</th>
					<th scope="col">Party Name</th>
					<th scope="col">Gst Number</th>
					<th scope="col">Taxable Value</th>
					<th scope="col">Tax Percentage</th>
					<th scope="col">IGST Val</th>
					<th scope="col">CGST Val</th>
					<th scope="col">SGST Val</th>
					<th scope="col">Total</th>
					<th scope="col">State</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody class="bg-light">
				<c:forEach var="purchase" items="${purchase}">
					<tr>
						<td>${purchase.inv_no}</td>
						<td>${purchase.loclaDate}</td>
						<td>${purchase.party_name}</td>
						<td>${purchase.gst_no}</td>
						<td>${purchase.tax_val}</td>
						<td>${purchase.tax_per}</td>
						<td>${purchase.igst_val}</td>
						<td>${purchase.cgst_val}</td>
						<td>${purchase.sgst_val}</td>
						<td>${purchase.total}</td>
						<td>${purchase.state}</td>
						<td><a href="edit/${purchase.inv_no}"><i class="fas fa-edit"></i></a></td>
						<td><a href="delete/${purchase.inv_no}"><i class="fas fa-trash"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
	<script src="js/login.js"></script>
</body>
<%-- <h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
	<thead>
		<tr>
			<th>Inv No</th>
			<th>Date</th>
			<th>Party Name</th>
			<th>Gst Number</th>	
			<th>Taxable Value</th>
			<th>Tax Percentage</th>
			<th>CGST Val</th>
			<th>SGST Val</th>
			<th>Total</th>
			<th>State</th>
		</tr>
	</thead>
	<c:forEach var="purchase" items="${purchase}">
		<tr>
			<td>${purchase.inv_no}</td>
			<td>${purchase.loclaDate}</td>
			<td>${purchase.party_name}</td>
			<td>${purchase.gst_no}</td>
			<td>${purchase.tax_val}</td>
			<td>${purchase.tax_per}</td>
			<td>${purchase.cgst_val}</td>
			<td>${purchase.sgst_val}</td>
			<td>${purchase.total}</td>
			<td>${purchase.state}</td>
			<td><a href="edit/${purchase.inv_no}">Edit</a></td>
			<td><a href="delete/${purchase.inv_no}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />

<p>
	<a href="/home">Home</a>
</p>
</div> --%>
</html>
