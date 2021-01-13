$(document).ready(function() {
	var form=$('#myform');
	var gst_st;
	$("#purchase").click(function() {
		
		if ($('#box').css('display') == 'none') {
	        $("#box").show();
	        $('#myform').attr('action', 'purchase');
	    }else{
	    	$("#box").toggle();
	    	$('#myform').attr('action', 'purchase');
	    }
		
	   });
		$("#sales").click(function() {
			
			if ($('#box').css('display') == 'none') {
				$("#box").show();
		        $('#myform').attr('action', 'sales');
		    }else{
		    	$("#box").toggle();
		    	$('#myform').attr('action', 'sales');
		    }
	   });
	var i = 0;
	$('#add').click(function() {
		i++;  
		  $('#form_table').append('<tr id="row'+i+'"> <td><input type="text" name="inv_no[]" id="inv_no'+i+'" class="form-control form-control-sm inv_no" placeholder="INV_NO"/></td><td><input type="text" name="date[]" id="date'+i+'" class="form-control form-control-sm date" placeholder="INV_DATE"/></td><td><input type="text" name="party_name[]" id="party_name'+i+'" class="form-control form-control-sm party_name" placeholder="PARTY_NAME"/></td><td><input type="text" name="gst_no[]" id="gst_no'+i+'" placeholder="GST_NO" class="form-control form-control-sm gst_no" /></td><td><input type="text" name="tax_val[]" id="tax_val'+i+'" class="form-control form-control-sm tax_val" placeholder="TAX VAL"/></td><td><div class="custom-control custom-switch"><input type="checkbox" class="custom-control-input igst-ebl" id="switch'+i+'"name="igst[]"><label class="custom-control-label" for="switch'+i+'"></label></div></td><td><select name="tax_per[]" class="form-control form-control-sm tax_per" placeholder="GST %" id="tax_per'+i+'"><option value="0">0</option><option value="0.125">2.5</option><option value="2.5">5</option><option value="6">12</option><option value="9">18</option><option value="14">28</option></select></td><td><input type="text" name="cgst_val[]" id="cgst_val'+i+'" placeholder="CGST" class="form-control form-control-sm cgst_val" readonly/></td><td><input type="text" name="sgst_val[]" id="sgst_val'+i+'" placeholder="SGST" class="form-control form-control-sm sgst_val" readonly/></td><td><input type="text" name="igst_val[]" id="igst_val'+i+'" placeholder="IGST" class="form-control form-control-sm igst_val" readonly/></td><td><input type="text" name="total[]" id="total'+i+'" placeholder="TOTAL" class="form-control form-control-sm total"/ readonly></td><td><input type="text" name="gst_status[]" id="gst_status'+i+'" placeholder="STATUS" class="form-control form-control-sm gst_status" readonly/></td><td><input type="text" name="state[]" id="state'+i+'" placeholder="STATE" class="form-control form-control-sm state" readonly/></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td><tr>');
	});
	$(document).on('click','.btn_remove', function(){

 	   var button_id=$(this).attr("id");
 	   //id of the clicked button
 	   $('#row'+button_id+'').remove();
 	   });
	
	/*After select the GST% from select box get Gstno,taxval,cgst,sgst,igst,total,state and check the gstno status*/
	$('#form_table').on('input, change', ".tax_per",".state", function() {
		var closestParent = $(this).closest('tr');
		
		var taxVal 	= parseInt(closestParent.find('.tax_val').val()); 
		var igst_ebl= closestParent.find('.igst-ebl');//.is(":checked");
		var taxPer 	= parseInt(closestParent.find('.tax_per').val());
		var gst_no	= closestParent.find('.gst_no').val();
//		alert(taxPer+"-"+igst_ebl);
		//if (taxVal=="NaN" || taxVal==null || taxVal==0)
		//{
			//closestParent.find(".tax_val").val("Tax val should not empty and Zero");
		//}else
	//	{
			var cs_val 	= (taxVal*taxPer) / 100;
			var ig_val 	= ((taxVal*2)*taxPer) / 100;
			var cgstVal	= closestParent.find('.cgst_val');
			var sgstVal	= closestParent.find('.sgst_val');
			var igstVal	= closestParent.find('.igst_val');
			var total	= closestParent.find('.total');
				gst_st	= closestParent.find('.gst_status').val(check_gst(gst_no));
			var	state	= closestParent.find(".gst_no").val().substr(0,2);
						  closestParent.find(".state").val(check_state(state));	
			if(igst_ebl.is(":checked")){
				parseInt(cgstVal.val(0.0));
				parseInt(sgstVal.val(0.0));
				parseInt(igstVal.val(ig_val));
				total.val(taxVal+ig_val);
			}
			else{
				parseInt(cgstVal.val(cs_val));
				parseInt(sgstVal.val(cs_val));
				parseInt(igstVal.val(cs_val));
				parseInt(igstVal.val(0.0));
				total.val(taxVal+cs_val*2);
			}
			
		//}
	});
	$('#myform').submit(function(e){
//		alert("inside submit");
		e.preventDefault();
		//console.log(gst_st.val());
		ajaxPost();
	});
	function ajaxPost(){
//		alert("inside Ajax");
		var data = [];
	    $('#body tr').each(function(index, item) {
	        var $item = $(item);
	        var inv_no=$item.find(".inv_no").val();
//	        alert(inv_no);
	        if(typeof(inv_no)  !== "undefined"){
	        data.push({
//	       	 inv_no: $item.find("input[name='inv_no[]']").val(),
	       	 inv_no: $item.find(".inv_no").val(),
	       	 date:$item.find(".date").val(),
	       	 party_name: $item.find(".party_name").val(),
	       	 gst_no: $item.find(".gst_no").val(),
	       	 tax_val: $item.find(".tax_val").val(),
	       	 tax_per: $item.find(".tax_per").val(),
	       	 cgst_val: $item.find(".cgst_val").val(),
	       	 sgst_val: $item.find(".sgst_val").val(),
	       	 igst_val: $item.find(".igst_val").val(),
	       	 total: $item.find(".total").val(),
	       	 state: $item.find(".state").val()	       	 
	        });
	        }
	      });
	    
	    $.ajax({
			
			type		:	"post",
			contentType	:	"application/json",
			url			:	form.attr('action'),
			data		:	JSON.stringify(data),
			datatype	:	"json",
			success		:	function(result){
//				$("#box").hide();	
				if(result.response=="success"){
					$("#myform")[0].reset();
					$(this).closest('tr').remove();
					$("#myAlert").show();
//					$(':input','#myform')
//					  .not(':button, :submit, :reset, :hidden')
//					  .val('')
//					  .prop('checked', false)
//					  .prop('selected', false);
					
					$("#box").hide();
//					$('#responseDiv').html(
//							""	+result.data.bookName
//								+"POST SUCCESSFULLY:) <br>"	);
//					 window.location.href = result.redirect;
				}else if(result.response=="Error"){
					//alert(result.response);
					$("#myAlert2").show();
				}
			},
			error	:	function(e) {
				$("#myAlert1").show();
//				alert("error");
				console.log("Error: ",e);
			}
		
		});
	}
	function check_state(code)
	{
		var myArray = {1: "Jammu and Kashmir", 2: "Himachal Pradesh", 3: "Punjab", 4: "Chandigarh", 5: "Uttarakhand", 6: "Haryana", 7: "Delhi", 8: "Rajasthan", 9: "Uttar Pradesh", 10: "Bihar", 11: "Sikkim", 12: "Arunachal Pradesh",13: "Nagaland", 14: "Manipur",15 : "Mizoram", 16: "Tripura", 17: "Meghalaya", 18: "Assam", 19: "West Bengal", 20: "Jharkhand", 21: "Odisha", 22: "Chhattisgarh", 23: "Madhya Pradesh", 24: "Gujarat", 25: "Daman and Diu", 26: "Dadra and Nagar Haveli", 27: "Maharashtra", 29: "Karnataka", 30: "Goa", 31: "Lakshadweep", 32: "Kerala", 33: "Tamilnadu",34: "Puducherry",35: "Andaman and Nicobar Islands",36: "Telangana",37: "Andhra Pradesh",97 :"Other Territory"};
		return myArray[code];
	}

});