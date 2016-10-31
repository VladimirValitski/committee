<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.page contentType="text/html;
charset=Utf-8" />
<html><head><title>Welcome</title></head>
<body><h3>${congratulations}</h3>
<h4>${checkResultLater}<br></h4>
<form name="return" method="POST" action="Controller"
		style="width: 300px;">
		<input type="hidden" name="command" value="commandReturn"
			style="width: 30px;" /> 
		<input type="submit" value="${returnToLoginPage}"
			style="width: 135px;">
	</form>
</body></html>
