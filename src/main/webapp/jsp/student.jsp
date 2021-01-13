<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
  <head>  
       <title>Add Students</title>  
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />  
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>  
       <script>
       $(document).ready(function(){  
    	   var i=0;  
    	   $('#add').click(function(){  
    	        i++;  
    	        $('#student_dynamic_table').append('<tr id="row'+i+'"> <td><input type="text" name="name[]" id="name'+i+'"  placeholder="Enter Name" class="form-control name_list" /></td><td><input type="text" name="age[]" id="age'+i+'"  placeholder="Enter Age" class="form-control age_list" /></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">x</button></td><tr>');  
    	   });
    	   $(document).on('click','.btn_remove', function(){

    	   var button_id=$(this).attr("id");
    	   //id of the clicked button
    	   $('#row'+button_id+'').remove();
    	   });
    	 $('#submit').click(function(){           
    	     var data = [];
    	     $('#b tr').each(function(index, item) {
    	         var $item = $(item);
    	         data.push({
    	             name: $item.find("td input[name='name[]']").val(),
    	             age: $item.find("td input[name='age[]']").val()
    	         });
    	     });
    	 $.ajax({
    	         type : "POST",
    	         url :"submitDynamicForm",
    	         data:JSON.stringify(data),
    	         dataType : 'json',
    	         contentType : 'application/json',
    	         success : function(response) 
    	         {
        	         console.log(response);
    	         }
    	    });  
 	    });
  	    });
       </script>
   </head>
<body>  
       <div class="container">  
            <div class="form-group">  
                  <form id="student_detail" name="student_detail">

                        <table class="table table-bordered" id="student_dynamic_table">
                        	<tbody id="b">
                            <tr>
                                <td><input type="text" name="name[]" id="name" placeholder="Enter Name" class="form-control name_list" /></td>
                                <td><input type="text" name="age[]" id="age" placeholder="Enter Age" class="form-control age_list" /></td>
                                <td><button type="button" name="add" id="add" class="btn btn-success">+</button></td>
                            <tr>
                            </tbody>
                        </table>
                        <input type="button" class="btn btn-info"  id="submit" name="submit" value="Submit" />
                  </form>
            </div>  
       </div>  
  </body> </html>