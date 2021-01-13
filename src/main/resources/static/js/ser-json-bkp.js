$(document).ready(function() {
	var form=$('#myform');
$("form").submit(function(e) {
	e.preventDefault();
	/*var $group = $(this).closest('.group');
	 var result = {
			 inv_no:$(".P_inv_no").val(),
			 date:$(".P_date").val(),
			 party:$("P_party_name").val(),
			 gstno:$("P_gst_no").val(),
			 taxval:$("P_tax_val").val(),
			 taper:$("P_tax_per").val(),
			 cgst_val:$("P_cgst_val").val(),
			 cgst_val:$("P_sgst_val").val(),
			 total:$("P_total").val(),
			 state:$("P_state").val()
			 
	            name: $("#id-name").val(),
	            address:$("#id-address").val(),
	            phone:$("#id-phone").val()
			 }*/
	var myJSON = JSON.stringify($(form).serialize);
	console.log(JSON.stringify($(form).serializeObject()));

//	console.log(JSON.stringify($(form)));
	$.ajax({
         type:form.attr('method'),
         url:form.attr('action'),
         dataType:'json',
//         data:{JSON.stringify($(form).serializeObject())},
         data:JSON.stringify($(form).serializeObject()),
         success:function(data){
        	 console.log(data);
        	 $('#jsonVal').val(data); 
         }
     });

});
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
});
