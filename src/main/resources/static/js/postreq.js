$(document).ready(function(){
	
	$('#bookForm').submit(function(e){
		e.preventDefault();
		ajaxPost();
	});
	
	function ajaxPost(){
		
		var formData={
				bookId		:	$('#bookId').val(),
				bookName	:	$('#bookName').val(),
				author		:	$('#author').val()
		}
		
		$.ajax({
			
			type		:	"POST",
			contentType	:	"application/json",
			url			:	"saveBook",
			data		:	JSON.stringify(formData),
			datatype	:	"json",
			success		:	function(result){
				alert(result.response);
				if(result.response=="success"){
					$('#responseDiv').html(
							""	+result.data.bookName
								+"POST SUCCESSFULLY:) <br>"	);
				}else{
					
					$('#responseDiv').html("<strong>Error</strong>");
				}
			},
			error	:	function(e) {
				alert("error");
				console.log("Error: ",e);
			}
		
		});
	}
});