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
<script type="text/javascript">
 
	$(document).ready(function() {
		
		$("#select_all").change(function(){
           if(this.checked){
           $(":checkbox").each(function(){
               this.checked=true;
           });             
       }else{
           $(":checkbox").each(function(){
               this.checked=false;
           });              
       }
   });
 
	$(":checkbox").click(function () {
        if (!$(this).is(":checked")){
            $("#select_all").prop("checked", false);
        }else{
            var flag = 0;
            $(":checkbox").each(function(){
                if(!this.checked)
                flag=1;
            });              
            if(flag == 0){ 
            	$("#select_all").prop("checked", true);
            }
        }
    	});	
	
	    //Validate if all checkbox is checked	
		var allChecked = $(':checkbox:checked').length == $(':checkbox').length - 1;
		if (allChecked) {
			$("#select_all").prop("checked", true);
		} else {
			$("#select_all").prop("checked", false);
		}
	});
</script>
<s:head />
</head>

<body>
	
 You are viewing the <s:property value="Category" /> page 
			<s:property value="#session.user.getEmail()" />




	<div style="height: 300px; overflow: auto;">
		<h2 style="color: green">
			<s:text name="label.welcome" />
		</h2>

		<table cellspacing="0" cellpadding="0" border="3" width="500">
			<tr style="font-weight: bold">

				<td><s:text name="Item ID" /></td>
				<td><s:text name="Title" /></td>
				<td><s:text name="Manufacturer" /></td>
				<td><s:text name="The Price" /></td>
				<td><s:text name="Category" /></td>
				<td><s:text name="Available Stock" /></td>
				<td><s:text name="Image" /></td>
				<td><s:checkbox name="Select All" id="select_all"
						theme="simple" /></td>

			</tr>
			<s:iterator value="itemList" status="stat">
				<tr>

					<td><s:property value="item_id" />
						<td><s:property value="title" /></td>
						<td><s:property value="manufacturer" /></td>
						<td><s:property value="price" /></td>
						<td><s:property value="category" /></td>
						<td><s:property value="quantity" /></td>
						<td><img alt="" src='<s:property value="image" />'
							height="100" width="200" /></td>
						<td><s:checkbox name="checkboxes[%{#stat.index}]"
								theme="simple" /></td></td>
				</tr>
			</s:iterator>
		</table>
		<br></br>


		<div>
			<!--<marquee onMouseover="this.scrollAmount=3" onMouseout="this.scrollAmount=6">Scrolling text here. Scrolling text here</marquee>-->

		</div>


		<table>


		</table>
	</div>
	
	<s:form action="addtobasket">
	 <s:textfield name="id" label="Item id" value=""/>
	  <s:textfield name="ammount" label="Amount" value="" />	
	<s:submit value="Add to basdket" align="left"/>
	</s:form>
	
	<s:form action= "proceedtocheckout">
	 	  
	<s:submit value="More products" align="left" />	
	</s:form>
	
	
	

</body>
</html>