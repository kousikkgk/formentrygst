$(document).ready(function(){
	
	$('#getAllBooks').click(function(e){
		e.preventDefault();
		ajaxGet();
	});
	
	function ajaxGet(){
		
		$.ajax({
			
			type		:	"GET",
			url			:	"getAllBooks",
			success		:	function(result){
//				alert(result.data.bookName);
				if(result.response=="success"){
					$('#getResultDiv ul').empty();
					var resList="";
					
					$.each(result.data,function(K,V){
//						alert(V.bookName);
					var resList= "Book Name : " + V.bookName
							+ ", Author : "+ V.author+"<br>";
					alert(resList);
//						$.each(V,function(Key,Value){
//							alert(Key + "=" + Value);	
//						});
						
//						var user= "Book Name : "+book.bookName
//								+",Author : "+book.author+"<br>";
						$('#getResultDiv .list-group').append(resList);
					});
					console.log("Success : ", result);
				}else{
					$('#getResultDiv').html("<strong>Error</strong>");
					console.log("Fail : ", result);
				}
			},
			error	:	function(e) {
				$('#getResultDiv').html("<strong>Error</strong>");
				console.log("error : ", e);
			}
		
		});
	}
});