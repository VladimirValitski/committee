<%@ page language="java" contentType="text/html;
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html><head><title>Login</title></head>
<body><h3>${enterYourLogin}</h3>
<hr/>
	<form name="loginForm" method="POST" action="Controller"
		style="width: 300px;">
		<input type="hidden" name="command" value="commandLogin"
			style="width: 30px;" /> ${loginPassport}<br /> 
		<input	type="text" name="login" value="" style="width: 230px;"><br />
		${password}<br /> 
		<input type="password" name="password" value=""	style="width: 230px;"> <br /> 
		<input type="submit" value="${enter}" style="width: 90px;">
	</form>
	<form name="signUp" method="POST" action="Controller"
		style="width: 300px;">
		<input type="hidden" name="command" value="commandSignUp"
			style="width: 30px;" /> 
		<input type="submit" value="${signUp}"
			style="width: 120px;">
	</form>
	<form action="Controller" method="post" name="language" class="login">
		<p align="left">
			<input type="hidden" name="command" value="language" /> 
			<input	name="language" type="submit" value="EN"> 
			<input name="language" type="submit" value="RU">
		</p>
	</form>
</body></html>