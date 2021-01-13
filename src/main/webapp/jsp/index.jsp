<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Welcome</title>
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"> -->
	<!-- <link href="css/main.css" rel="stylesheet"> -->
	<script src="bower_components/jqcloud2/dist/jqcloud.min.js"></script>
<link rel="stylesheet" href="bower_components/jqcloud2/dist/jqcloud.min.css">

	<style type="text/css">
body {
	background: #0F2027; /* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #2C5364, #203A43, #0F2027);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #2C5364, #203A43, #0F2027);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

#form_table tr, #form_table td {
	font-size: 13px;
	border: none;
	padding: 5px;
	background: #F8F9FA;
}

.nav-item {
	color: #fff;
	padding-left: 10px;
}

#box {
	display:none;
	
}

.navbar {
	/* background: #563d7c; */
	height: 40px;
}

table td .inv_no {
	table-layout: fixed;
	width: 70px;
}

table td .date {
	table-layout: fixed;
	width: 90px;
}

table td .party_name {
	table-layout: fixed;
	width: 180px;
}

table td .gst_no {
	table-layout: fixed;
	width: 142px;
}

table td .tax_val {
	table-layout: fixed;
	width: 68px;
}

table td .tax_per {
	table-layout: fixed;
	width: 58px;
}

table td .cgst_val {
	table-layout: fixed;
	width: 80px;
}

table td .sgst_val {
	table-layout: fixed;
	width: 80px;
}

table td .igst_val {
	table-layout: fixed;
	width: 80px;
}

table td .total {
	table-layout: fixed;
	width: 80px;
}

table td .gst_status {
	table-layout: fixed;
	width: 60px;
}

table td .state {
	table-layout: fixed;
	width: 70px;
}

#myAlert,#myAlert1,#myAlert2{
	display:none;
}
</style>
<script type="text/javascript">
var words = [
	  {text: "Lorem", weight: 13},
	  {text: "Ipsum", weight: 10.5},
	  {text: "Dolor", weight: 9.4},
	  {text: "Sit", weight: 8},
	  {text: "Amet", weight: 6.2},
	  {text: "Consectetur", weight: 5},
	  {text: "Adipiscing", weight: 5},
	  /* ... */
	];
$('#word_cloud').jQCloud(words);
</script>
</head>
<body>
	<div class="alert alert-success alert-dismissible" role="alert" id="myAlert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
		</button>
		<strong>Success!</strong> Your data has been added!
	</div>
	<div class="alert alert-danger alert-dismissible" role="alert" id="myAlert1">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
		</button>
		<strong>Error!</strong> Please check the data!
	</div>
	<div class="alert alert-danger alert-dismissible" role="alert" id="myAlert2">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
		</button>
		<strong>Error!</strong> Invoice number already present..!
	</div>
	<nav class="navbar navbar-expand-sm  navbar-light navbar-dark fixed-top">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">HOME</a></li>
			<li class="nav-item"><a class="nav-link" href="#" id="purchase">PURCHASE</a></li>
			<li class="nav-item"><a class="nav-link" href="#" id="sales">SALES</a></li>
			<li class="nav-item"><a class="nav-link" href="calculation">CALCULATION</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">LOGOUT</a></li>
			<li class="nav-item" style="pointer-events: none;"><a class="nav-link" href="#">${partyname}</a></li>
		</ul>
	</nav>
 	<div class="fluid-container mx-auto"  id="box" style="margin-top:4%;width:98%;">  
 		<div id="word_cloud"></div>
		<div class="form-group">  
			<form id="myform" method="post" action ="">
				<table class="table table-sm" id="form_table">
					<tbody id="body" class="group">
	                     <tr class="header">
	                         <td><input type="text" name="inv_no[]" id="inv_no" class="form-control form-control-sm inv_no" placeholder="INV_NO"/></td>
	                         <td><input type="text" name="date[]"   id="date" class="form-control form-control-sm date" placeholder="INV_DATE"/></td>
	                         <td><input type="text" name="party_name[]" id="party_name" class="form-control form-control-sm party_name" placeholder="PARTY_NAME"/></td>
	                         <td><input type="text" name="gst_no[]" id="gst_no" placeholder="GST_NO" class="form-control form-control-sm gst_no" /></td>
	                         <td><input type="text" name="tax_val[]" id="tax_val" class="form-control form-control-sm tax_val" placeholder="TAX VAL"/></td>
	                         <td> 
	                         	<div class="custom-control custom-switch">
	                         		<input type="checkbox" class="custom-control-input igst-ebl" id="switch" name="igst[]">
     	 							<label class="custom-control-label" for="switch"></label>
    							</div>
	                         </td>
	                         <td>
	                         	<select name="tax_per[]" class="form-control form-control-sm tax_per" id="tax_per">
									<option value="0">0</option>
									<option value="0.125">2.5</option>
									<option value="2.5">5</option>
									<option value="6">12</option>
									<option value="9">18</option>
									<option value="14">28</option>
  								</select>
  							</td>
	                         <td><input type="text" name="cgst_val[]" id="cgst_val" placeholder="CGST" class="form-control form-control-sm cgst_val" readonly/></td>
	                         <td><input type="text" name="sgst_val[]" id="sgst_val" placeholder="SGST" class="form-control form-control-sm sgst_val" readonly/></td>
	                         <td><input type="text" name="igst_val[]" id="igst_val" placeholder="IGST" class="form-control form-control-sm igst_val" readonly/></td> 
	                         <td><input type="text" name="total[]" id="total" placeholder="TOTAL" class="form-control form-control-sm total" readonly></td>
	                         <td><input type="text" name="gst_status[]" id="gst_status" placeholder="STATUS" class="form-control form-control-sm gst_status" readonly/></td>
	                         <td><input type="text" name="state[]" id="state" placeholder="STATE" class="form-control form-control-sm state" readonly/></td>
	                         
	                         <td><button type="button" name="add" id="add" class="btn btn-success">+</button></td>
	                     <tr>
	                 </tbody>
                 </table>
                 <input type="submit" class="btn btn-info"  id="submit" name="submit" value="Submit" />
                 </form>
			
			<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
                  <script src="js/pur-sal.js"></script>
                  <script src="js/gst_check.js"></script>
            
		</div>  
       </div>  
</body>