<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="height: 150px; overflow: auto;">
		<p id="contact"><table class="table table-stripec" "id="contact" border= data-height="100">
		 <thead>
			<tr>
				<th>Item Id</th>
				<th>Title</th>
				<th>Manufacturer</th>
				<th>Price.</th>
				<th>Category.</th>
				<th>Quantity.</th>
				<th>Image.</th>
				
		</tr></p>

			<s:iterator value="itemList">
				<tr>
				
					<td><s:property value="item_id" /></td>
				  <td><s:property value="title" /></td>
					<td><s:property value="manufacturer" /></td>
					<td><s:property value="price" /></td>
					<td><s:property value="category" /></td>
					<td><s:property value="quantity" /></td>
					<td><s:property value="image" /></td>
					

				</tr>
				</s:iterator>
				
				
			
			 </thead>
		</table>
</body>
</html>