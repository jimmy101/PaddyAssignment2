<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	FInal checkout page
	<s:property value="#session.user.getId()" />
	<div>
		Postal address
		<s:iterator value="userList">
			<br>Name:<s:property value="name" />
			<br>Customer id:<s:property value="id" />
			<br></br>Address Line 1:<s:property value="address1" />
			<br></br>Address Line 2:<s:property value="address2" />
			<br></br>Address Line 3:<s:property value="address3" />
			<br></br>
		</s:iterator>
	</div>
	<div>
		<br>Your Purchases
		<s:iterator value="purchasesList">
			<br>
			<s:property value="ammount" />
			<s:property value="manufacturer" />
			<s:property value="title" />
		@ $<s:property value="price " /> 
		Total cost $<s:property value="price *ammount " />
		Purchases Id:<s:property value="purchases_id" />
		</s:iterator>

	</div>

	<div>
		<br>total price $
		<s:iterator value="fianTotal">
			<s:property value="total" />
		</s:iterator>
	</div>
	<br>
	
	<s:set var="varMsg1" value="%{#session.user.getName()}" />
	<s:property value="varMsg"/>SSSSSSSSSSSSS
	<s:property value="varMsg1"/>SSSSSSSSSSSSS
	
	<s:form action="deletefromdatabase">
	<s:textfield name="purchases_id" label="Enter Item id" value=""/>
	<br><s:submit value="Remove " align="left" />
	</s:form>
	
	<div>
	
	<s:property value="#session.user.getName()"  />lllll
	
	<s:form action="updatedatabases">
	<s:iterator value="userList">
	
	<s:property value="name"  />
	</s:iterator>
	<br><s:submit value="purchases" align="left" />
	</s:form>
	</div>
</body>
</html>