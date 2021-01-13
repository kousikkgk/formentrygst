$(document).ready(function(){
	
	$('form').submit(function(e){
		e.preventDefault();
		ajaxPost();
	});
	
	function ajaxPost(){
		var form=$('#myform');
//		var formData = {
//				inv_no		:	$("input[name=inv_no]").val(),
//				date		:	$("input[name=date]").val(),
//				party_name	:	$("input[name=party_name]").val(),
//				gst_no		:	$("input[name=gst_no]").val(),
//				tax_val		:	$("input[name=tax_val]").val(),
//				tax_per		:	$("input[name=tax_per]").val(),
//				cgst_val	:	$("input[name=cgst_val]").val(),
//				sgst_val	:	$("input[name=sgst_val]").val(),
//				total		:	$("input[name=total]").val(),
//				state		:	$("input[name=state]").val()
//			}
//		console.log(formData);
		console.log(JSON.stringify($(form).serializeObject()));
		var data = [];
	     $('#container').each(function(index, item) {
	         var $item = $(item);
	         //alert(index);
	         //alert(item);
	         data.push({
	        	 inv_no: $item.find("input[name='inv_no']").val(),
	        	 date: $item.find("input[name='date']").val(),
	        	 party_name: $item.find("input[name='party_name']").val(),
	        	 gst_no: $item.find("input[name='gst_no']").val(),
	        	 tax_val: $item.find("input[name='tax_val']").val(),
	        	 tax_per: $item.find("input[name='tax_per']").val(),
	        	 cgst_val: $item.find("input[name='cgst_val']").val(),
	        	 sgst_val: $item.find("input[name='sgst_val']").val(),
	        	 total: $item.find("input[name='total']").val(),
	        	 state: $item.find("input[name='state']").val()
	        	 
	         });
	     });
	     console.log(data);
		$.ajax({
			
			type		:	form.attr('method'),
			contentType	:	"application/json",
			url			:	form.attr('action'),
			/*data		:	JSON.stringify($(form).serializeObject()),*/
			data		:	JSON.stringify($(form).serializeObject()),
			datatype	:	"json",
			success		:	function(result){
				alert(result.data);
				console.log(result.data);
//				if(result.response=="success"){
//					$('#responseDiv').html(
//							""	+result.data.bookName
//								+"POST SUCCESSFULLY:) <br>"	);
//				}else{
//					
//					$('#responseDiv').html("<strong>Error</strong>");
//				}
			},
			error	:	function(e) {
				alert("error");
				console.log("Error: ",e);
			}
		
		});
	}
	$.fn.serializeObject = function()
	{
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name] !== undefined) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};
});/**
 * 
 */