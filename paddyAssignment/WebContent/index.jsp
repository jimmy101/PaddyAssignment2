<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="css/bootstrap.css" rel="stylesheet"media="screen">
 <body  bgcolor ="#E6E6FA">
<title>Login</title>
</head>
<body bgcolor = "#E6E6FA" >


<s:form action="register">  
<s:textfield name="name" label="Name"></s:textfield>
<s:textfield name="address1" label="Addlree line 1"></s:textfield>
<s:textfield name="address2" label="Address line 2"></s:textfield>
<s:textfield name="address3" label="Address line 3"></s:textfield> 
<s:textfield name="email" label="Email"></s:textfield>  
<s:textfield name="userName" label="UserName"></s:textfield>
<s:password name="password" label="Password"></s:password>
<s:submit value="Register"></s:submit>
</s:form>

<div class="container">
<div class="row" id ="main-content">
<div class="span6" id="sidebar">
<div class="well">



   <form action="loginaction" method="post" >
   <legend>Login</legend>
      User:<br/><input type="text" name="userName"/><br/>
      Password:<br/><input type="text" name="password"/><br/>
      <input type="submit" value="Login"/>		
   </form>
 
</body>
</html>