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

	<s:property value="id" />
	You have selected
	<s:property value="ammount " />
	<s:iterator value="itemList" status="stat">

		<s:property value="manufacturer" />
		<s:property value="title" />
						@ $<s:property value="price " /> each
						Total cost $<s:property value="price *ammount " />

	</s:iterator>
	
	<s:form action="goback">
	<s:submit value="Chose Item" align="left"/>
	</s:form>
	
	<s:form action="final">
	<s:submit value="proceed to chekout" align="left"/>
	</s:form>
</body>
</html>