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
		<input type="hidden" name="command" value="commandTwo" style="width: 30px; "/>
			<fieldset style="width: 400px">
				<center>
					<legend> ${enterYourScores} </legend>
					<table>
						<tr>
							<td>${passport}</td>
							<td><input type="text" name="pasport" required="required" /></td>
						</tr>
						<tr>
							<td>${subjectOne}</td>
							<td><input type="text" name="subject_one" required="required" /></td>
						</tr>
						<tr>
							<td>${subjectTwo}</td>
							<td><input type="text" name="subject_two" required="required" /></td>
						</tr>
						<tr>
							<td>${schoolCertificate}</td>
							<td><input type="text" name="school_certificate" required="required" /></td>
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
