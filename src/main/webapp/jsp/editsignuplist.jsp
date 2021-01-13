<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Welcome</title>
		<link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
		<link href="css/main.css" rel="stylesheet">
	</head>
<body>
	<h1>Edit Employee</h1>
	<form:form method="POST" action="/editsave">
		<table>
			<tr>
				<td>Inv No</td>
				<td><form:input path="inv_no" /></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><form:input path="loclaDate" /></td>
			</tr>
			<tr>
				<td>Party Name :</td>
				<td><form:input path="party_name" /></td>
			</tr>
			<tr>
				<td>GST Number :</td>
				<td><form:input path="gst_no" /></td>
			</tr>

			<tr>
				<td>Tax Val :</td>
				<td><form:input path="tax_val" /></td>
			</tr>

			<tr>
				<td>Tax Per :</td>
				<td><form:input path="tax_per" /></td>
			</tr>

			<tr>
				<td>CGST Val :</td>
				<td><form:input path="cgst_val" /></td>
			</tr>

			<tr>
				<td>SGST VAL :</td>
				<td><form:input path="sgst_val" /></td>
			</tr>

			<tr>
				<td>Total :</td>
				<td><form:input path="total" /></td>
			</tr>

			<tr>
				<td>State :</td>
				<td><form:input path="state" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
