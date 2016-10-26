<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create abiturient form</title>
</head>
<body>
	<right>
		<form action="Controller" method="post">
		<input type="hidden" name="command" value="commandOne" style="width: 30px; "/>
			<fieldset style="width: 400px">
				<center>
					<legend> ${enterYourData} </legend>
					<table>
						<tr>
							<td>${lastName}</td>
							<td><input type="text" name="last_name" required="required" /></td>
						</tr>
						<tr>
							<td>${fistName}</td>
							<td><input type="text" name="first_name" required="required" /></td>
						</tr>
						<tr>
							<td>${secondName}</td>
							<td><input type="text" name="second_name" required="required" /></td>
						</tr>
						<tr>
							<td>${phone}</td>
							<td><input type="text" name="phone" required="required" /></td>
						</tr>
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
