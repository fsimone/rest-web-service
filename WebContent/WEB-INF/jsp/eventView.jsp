<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<html>
<head>
<title>Spring Server</title>
<style type="text/css">
</style>
</head>

<body bgcolor="#AFDFAF">
<c:set var="request" value="${pageContext.request}" />
	<table>
	    <thead>
	    <tr>
	        <th>EventId</th>
	        <th>ResourceId</th>
	        <th>Start</th>
	        <th>End</th>
	        <th>Title</th>
	        <th>Color</th>
	    </tr> 
	    </thead>
	    <c:forEach var="event" items="${eventList.lavoratori}">
	    <tr>
	        <td><a href="${request.contextPath}/rest/event/${event.id}">${event.id}</a></td>
	        <td>${event.resourceId}</td>
	        <td>${event.start}</td>
	        <td>${event.end}</td>
	        <td>${event.title}</td>
	        <td>${event.color}</td>
	    </tr>
	    </c:forEach>
	</table>
</body>
</html>
