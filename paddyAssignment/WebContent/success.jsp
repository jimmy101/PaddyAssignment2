<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>

</head>
<body bgcolor="#E6E6FA">


	<h3>User home page</h3>

</body>
</html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome
	<s:property value="#session.user.getName()" />
	
	<s:form action="computers">
		<s:submit value="Computing"></s:submit>
	</s:form>
	<s:form action="phones">
		<s:submit value="Phones"></s:submit>
	</s:form>
	<s:form action="tv">
		<s:submit value="T.V"></s:submit>
	</s:form>
	<s:form action="audio">
		<s:submit value="Audio"></s:submit>
	</s:form>
	<s:form action="cable">
		<s:submit value="Cables"></s:submit>
	</s:form>
	
	<s:form action="logout">
		<s:submit value="Logout"></s:submit>
	</s:form>



	
</body>
</html>

