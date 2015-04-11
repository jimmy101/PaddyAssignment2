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
update Stopk page

<s:form action="registerItem">  
<s:textfield name="title" label="Title"></s:textfield>  
<s:textfield name="manufacturer" label="Manufacturer"></s:textfield>
<s:textfield name="price" label="Price"></s:textfield>
<s:textfield name="category" label="Category"></s:textfield>
<s:textfield name="image" label="Image"></s:textfield>
<s:textfield name="quantity" label="Quantity"></s:textfield>
<s:submit value="Register Item"></s:submit>
</s:form>

<s:form action= "home">	 	  
	<s:submit value="home" align="left" />	
	</s:form>
</body>
</html>