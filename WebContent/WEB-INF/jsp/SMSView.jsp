<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invio SMS</title>

	<script type="text/javascript" src="<c:url value="/resources/js/invioSms.js" />"></script>
	<%-- <script src="<c:url value="/resources/js/invioSms.js" />"></script> --%>
	
	<%--<spring:url value="/resources/js/invioSms.js" var="invioSms" />	
    <script src="${invioSms}"></script>--%>

    <style type="text/css">
        body { font-family:Verdana,Arial,sans-serif; font-size:100%; }
        td { vertical-align:top; }
        input[type=submit] { padding:5px 10px; }
    </style>


</head>
<body bgcolor="#AFDFAF">
    <h1>Invio SMS</h1>

	
    <c:set var="request" value="${pageContext.request}" />
	<c:set var="model" value="${sms}" />
		
		
    <form:form action="${request.contextPath}/rest/sms/send" method="post" commandName="SMSView"> <%--  modelAttribute="SMSView" --%>

		<%-- Login:<c:out value="${model.username}"/>-<c:out value="${model.password}"/> --%>

	
        <table border="0" cellpadding="5" style="background:#F7F7F7;border:1px solid #CCC;border-radius:5px;-moz-border-radius:5px;">
            <tr>
                <td><label for=username>Username:</label></td>
                <td><form:input type="text" path="username" value="${model.username}" /></td>
            </tr>
            <tr>
                <td><label for=password>Password:</label></td>
                <td><form:input type="text" path="password" value="${model.password}" /></td>
            </tr>
        
            <tr>
                <td><label for="method">tipo SMS:</label></td>
                <td>
                    <form:select path="method">
                        <form:options items="${model.methodList}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><label for="recipients">Destinatario: </label></td>
                <td>
                    <span id="recipients">
                        <form:input type="text" path="recipients" value="${model.recipients[0]}" />
                    </span>
                    <a href="javascript:;" onclick="addRecipient();"><small>Aggiungi destinatario</small></a>
                </td>
            </tr>
            <tr>
                <td><label for="text">Testo messaggio: </label></td>
                <td><form:textarea path="text" id="text" cols="30" rows="10"></form:textarea></td>
            </tr>
			<tr>
				<td></td>
				<td>
					<small>
					caratteri rimanenti: <span id="leftChars" style="color:#F00;">0</span> / 
					<b id="messageMaxLength">765</b> 
					(<span id="numberOfSMS" style="color:#39b54a;">1</span>)
					</small>
				</td>
			</tr>
            <tr>
                <td><label for="sender_number">Destinatario Numerico: </label></td>
                <td><form:input type="text" path="senderNumber" /> <small>Es 393471234567</small></td>
            </tr>
            <tr>
                <td><label for="sender_string">Destinatario Alphanumerico: </label></td>
                <td><form:input type="text" path="senderString" maxlength="11" /> <small>Max 11 caratteri</small></td>
            </tr>
            <tr>
                <td><label for="charset">Charset</label></td>
                <td>
                    <form:select path="charset" id="charset">
                        <option value="ISO-8859-1">ISO-8859-1</option>
                        <option value="UTF-8">UTF-8</option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <form:input type="submit" value="Invia SMS" path="submit" />
                </td>
            </tr>
        </table>

        
    </form:form>





</body>
</html>