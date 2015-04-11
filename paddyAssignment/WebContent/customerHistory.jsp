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
					<th>Product title</th>
					<th>manufacturer</th>
					<th>Product price</th>
					<th>quantity.</th>
					<th>Purchases Date</th>
					
					
				</tr>
				<p></p>

				<s:iterator value="historyList">
					<tr>
						<td><s:property value="title" /></td>
						<td><s:property value="manufacturer" /></td>
						<td><s:property value="price" /></td>
						<td><s:property value="quantity" /></td>												
						<td><s:property value="ModifiedTime" /></td>
						
						
					</tr>
				</s:iterator>
				</thead>
				</table>
				</div>
				
		<s:form action= "home">	 	  
	<s:submit value="home" align="left" />	
	</s:form>
		
	

</body>
</html>