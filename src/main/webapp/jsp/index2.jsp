<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Welcome</title>
    <link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">   
</head>
<body>
		<header>
		<div class="row">
			<ul class="main-nav">
				<li class="active"><a href="#">HOME</a></li>
				<li><a href="#" id="purchase">PURCHASE</a></li>
				<li><a href="#" id="sales">SALES</a></li>
				<li><a href="calculation">CALCULATION</a></li>
				<li><a href="logout">LOG OUT</a></li>
				<li style="pointer-events: none;"><a href="#">${partyname}</li>
			</ul>
</header>
<form id="myform" class="box" action="ActionServlet" method="post" >
<p class="noscroll">
<input type="button" id="add" value="ADD" />
</p>	
	<div id ="container">
	<div class="group">
		<input type="text" name="inv_no" id="P_inv_no" class="P_inv_no" size="6" placeholder="Invno" value=""  autocomplete="off" />
		<input type="text" name="date"   id="P_date" class="P_date" size="9"   placeholder="DD/MM/YYYY"  autocomplete="off"/>
		<input type="text" name="party_name" id="P_party_name" class="P_party_name"  size="20" placeholder="Party" autocomplete="off" />
		<input type="text" name="gst_no"  class="P_gst_no" size="10" placeholder="No" autocomplete="off" />
		<input type="text" name="tax_val" class="P_tax_val" size="10" placeholder="Val" value="" autocomplete="off"/>
		<select name="tax_per" class="P_tax_per" >
			<option readonly selected value>GST %</option>
			<option value="0">0</option>
			<option value="0.125">2.5</option>
			<option value="2.5">5</option>
			<option value="6">12</option>
			<option value="9">18</option>
			<option value="14">28</option>
		</select>
		<input type="text" name="cgst_val"   class="P_cgst_val" size="3"placeholder="cs" value=""  />
		<input type="text" name="sgst_val"   class="P_sgst_val" size="3"placeholder="gs" value=""  readonly />
		<input type="text" name="total"      class="P_total" size="5" placeholder="total" value="" readonly />
		<input type="text" name="gst_status" class="P_gst_status" size="5" placeholder="gstatus" readonly />
		<input type="text" name="state"      class="P_state" size="5"placeholder="state" readonly />
		<input type="hidden" name="jsonVal" id="jsonVal"/>
	</div>
	</div>
	<input type="submit" id='submit_btn' name="SUBMIT" />
</form>
	<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script src="js/message13.js"></script>	
        <script src="js/gst_check.js"></script>  
		<script src="js/state_check.js"></script> 
		<script src="js/ser-json.js"></script> 
</body>
</html>