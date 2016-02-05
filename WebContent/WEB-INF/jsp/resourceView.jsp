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
	        <th>ResourceId</th>
	        <th>Luogo</th>
	        <th>Nome</th>
	        <th>Color</th>
	    </tr> 
	    </thead>
	    <c:forEach var="res" items="${resourceList.rows}">
	    <tr>
	        <td><a href="${request.contextPath}/rest/events/${res.id}">${res.id}</a></td>
	        <td>${res.luogo}</td>
	        <td>${res.nome}</td>
	        <td>${res.eventColor}</td>
	    </tr>
	    </c:forEach>
	</table>
	
	
	
</body>
</html>
