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
<s:form action="viewStock">
		<s:submit value="View Stock"></s:submit>
	</s:form>
	<s:form action="addnewstock">
		<s:submit value="Add new Stock"></s:submit>
	</s:form>
	<s:form action="viewusers">
		<s:submit value="View Usere"></s:submit>
	</s:form>
	<s:form action="updateStock">
		<s:submit value="Update Stock"></s:submit>
	</s:form>
	
	
	
</body>
</html>