<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get list of Abiturients</title>
</head>
<body>
	<right>
		<form action="Controller" method="post">
		<input type="hidden" name="command" value="commandGet" style="width: 30px; "/>
			<fieldset style="width: 400px">
				<center>
					<legend> ${getListByFaculty}  </legend>
					<table>
						<tr>
							<td>${numberOfFaculty}</td>
							<td><input type="text" name="id_faculty" required="required" style="width: 90px; "/></td>
						</tr>
						<tr>
							<td><input type="submit" value="${get}" style="width: 98px; "/></td>
						</tr>
					</table>
				</center>
			</fieldset>
		</form>
	</right>
</body>
</html>
