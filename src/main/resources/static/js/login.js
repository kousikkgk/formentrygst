$(document).ready(function() {
	
	$("#loginbtn").click(function() {
		$("#loginform").attr("action", "home");
//		$("#loginform").action.replace(",", "");
//		form.action = form.action.replace(",", "");
		$("#loginform").submit();
	});
	$("#registerbtn").click(function() {
		$("#loginform").attr("action", "register");
//		 form.action = form.action.replace(",", "");
		$("#loginform").submit();
	});
	
	$("#editsubmit").click(function() {
		var invval=$('input[name="invoicetyperadios"]:checked').val();
		if (invval=="Purchase"){
			$("#editform").attr("action", "editpurchase");
			$("#type").text(invval);
		}
		else{
			$("#editform").attr("action", "editsales");
			$("#type").text(invval);
		}
		alert(invval);
		$("#editform").submit();
	});
	
	$("#datepicker").datepicker({
		format : "mm-yyyy",
		viewMode : "months",
		minViewMode : "months"
	});
});