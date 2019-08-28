<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Commuter Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Request For Carpool
</h1>

<c:url var="requestForCarpool" value="/fetchAvailableVehicles" ></c:url>

       <form:form method="post" action="${requestForCarpool}" commandName="commuterRequest">  
      	<table >  
         <tr>  
          <td>Source : </td> 
          <td><form:input path="source"  /></td>
         </tr>  
         <tr>  
        <tr>  
          <td>Destination : </td> 
          <td><form:input path="destination"  /></td>
         </tr> 
        <tr>  
          <td>Date : </td> 
          <td><form:input path="date"  /></td>
         </tr>  
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Request For pool" /></td>  
         </tr>  
        </table>  
       </form:form>  
<br/>       
<h3>Vehicles List</h3>
<c:if test="${!empty listVehicles}">
	<table class="tg">
	<tr>
		<th width="80">Owner ID</th>
		<th width="120">Owner Name</th>
		<th width="60">Vehicle Name</th>
		<th width="60">Carpool Request</th>
	</tr>
	<c:forEach items="${listVehicles}" var="owner">
		<tr>
			<td>${owner.id}</td>
			<td>${owner.name}</td>
			<td>${owner.vehicle.name}</td>
			<td><a href="<c:url value='/requestForCarpool/${commuter.id}'/>" >Request For Carpool  </a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
