<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome ${name}</title>
</head>
<body>

	<table border="1" style="width: 580px; ">
		<tr>
			<th style="width: 141px; "><b>${nameFaculty}</b></th>
			<th><b>${enrollment}<b></b></th>
			<th><b>${passport}</b></th>
			<th><b>${totalScore}</b></th>
		</tr>
	</table>
	<table border="1" style="width: 580px; ">		
		<c:forEach var="res" items="${result}">
		<tr>
				<th>${res.name_faculty}</th>
				<th>${res.enrollment}</th>
				<th>${res.pasport}</th>
				<th>${res.total_score}</th>
		</tr>	
		</c:forEach>
	</table>
	<form action="Controller" method="post">
	<input type="hidden" name="command" value="commandApprove" style="width: 30px; "/>
			<fieldset style="width: 400px">
				<center>
					<legend> ${approveOfAbiturient} </legend>
					<table>
						<tr>
							<td>${numberOfPassport}</td>
							<td><input type="text" name="pasport" required="required" /></td>
						</tr>
						<tr>
							<td>${result}</td>
							<td><input type="text" name="accept" required="required" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="${approve}" /></td>
						</tr>
					</table>
				</center>
			</fieldset>
		</form>
<form name="return" method="POST" action="Controller"
		style="width: 300px;">
		<input type="hidden" name="command" value="commandReturn"
			style="width: 30px;" /> 
		<input type="submit" value="Return to login page"
			style="width: 135px;">
	</form>
</body>
</html>