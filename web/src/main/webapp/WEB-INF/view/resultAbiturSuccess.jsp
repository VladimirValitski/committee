<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.page contentType="text/html;
charset=Utf-8" />
<html><head><title>Result</title></head>
<body>
<h3 style="width: 80px; ">${resulto}</h3>
<h3>${congratulationsEnrolled}</h3>
<form name="return" method="POST" action="Controller"
		style="width: 300px;">
		<input type="hidden" name="command" value="commandReturn"
			style="width: 30px;" /> 
		<input type="submit" value="${returnToLoginPage}"
			style="width: 135px;">
	</form>
</body></html>
