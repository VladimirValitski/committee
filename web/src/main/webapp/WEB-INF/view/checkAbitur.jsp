<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check abiturient</title>
</head>
<body>
	<right>
		<form action="Controller" method="post">
		<input type="hidden" name="command" value="commandCheck" style="width: 30px; "/>
			<fieldset style="width: 400px">
				<center>
					<legend> ${checkResult} </legend>
					<table>
						<tr>
							<td>${passport}</td>
							<td><input type="text" name="pasport" required="required" /></td>
						</tr>
						
						<tr>
							<td><input type="submit" value="${confirm}" /></td>
						</tr>
					</table>
				</center>
			</fieldset>
		</form>
	</right>
</body>
</html>
