<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Struts2 multiple checkbox example</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.1.min.js"></script>

<s:head />

</head>
<body bgcolor="#E6E6FA">


	<h3>User home page</h3>



	<div style="height: 150px; overflow: auto;">
		<p id="contact"></p>
		<table class="table table-stripec" "id="contact" border="data-height=""100">
			<thead>
				<tr>
					<th> Id</th>
					<th>Name</th>
					<th>Street number</th>
					<th>Town.</th>
					<th>Country</th>
					<th>Email</th>
					<th>Username.</th>
					<th>Password.</th>
					
				</tr>
				<p></p>

				<s:iterator value="userList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="address1" /></td>
						<td><s:property value="address2" /></td>
						<td><s:property value="address3" /></td>						
						<td><s:property value="Email" /></td>
						<td><s:property value="userName" /></td>
						<td><s:property value="password" /></td>
						
					</tr>
				</s:iterator>
				</thead>
				</table>
				</div>
			<br>To view Customer Purchases History enter details below 
	<br></br><s:form action="userHistory">
	<s:textfield name="userName" label ="Customer User name"/>
	<s:submit value ="Enter"/>	
	</s:form>
	

</body>
</html>