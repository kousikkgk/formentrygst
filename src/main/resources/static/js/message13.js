$(document).ready(function() {
	$("#purchase").click(function() {        
    $(".box").animate({
      height: 'toggle'
    });     
		 //$(".box").toggle("show");
		// $(".box").slideDown("fast");
		$('#myform').attr('action', 'purchase');
    });
	$("#sales").click(function() {        
          $(".box").animate({
			height: 'toggle'
		}); 
		$('#myform').attr('action', 'sales');		
    });
  $("#add").click(function() {
    var $clone = $('#container .group:first').clone();
    $clone.find('input').val('');
    $clone.find('select').val('2');
    $clone.append('<a href="#" class="remove">X</a>');
    $clone.appendTo('#container');
  });

  $("#container").on('click', '.remove', function() {
    $(this).parent('.group').remove();
  });
  
  $('#container').on('input, change', ".P_tax_per",".P_state", function() {
	  
    var $group = $(this).closest('.group');
    var num1 = parseInt($group.find(".P_tax_val").val(), 10) || 0;
	if (num1==null || num1==0)
	{
		$group.find(".P_tax_val").val("Tax val should not empty and Zero");
	}else
	{
		var num2 = parseInt($group.find(".P_tax_per").val(), 10) || 0;
		var code = $group.find(".P_gst_no").val().substr(0,2);
		var num3 = (num1 * num2) / 100;
		var num4 = num1 + num3 * 2;
   
		$group.find(".P_cgst_val").val(num3);
		$group.find(".P_sgst_val").val(num3);
		$group.find(".P_total").val(num4);	
		var gst = $group.find(".P_gst_no").val();
		var g_st = $group.find(".P_gst_status");
		if (check_gst(gst)==true)
		{
			g_st.css("background-color","green").val("true");
			g_st.css("color","white");
		}
		else
		{
			g_st.css("background-color","red").val("false");
			g_st.css("color","white");
		}
		$group.find(".P_state").val(check_state(code));
	}
	});
  
});