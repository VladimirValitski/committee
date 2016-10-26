<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:c=http://java.sun.com/jsp/jstl/core
version="2.0">
<jsp:directive.page contentType="text/html;
charset=Utf-8" />
<html><head><title>Result</title></head>
<body>
<h3 style="width: 80px; ">${resulto}</h3>
<h3>${sorry}</h3>
<form name="return" method="POST" action="Controller"
		style="width: 300px;">
		<input type="hidden" name="command" value="commandReturn"
			style="width: 30px;" /> 
		<input type="submit" value="${returnToLoginPage}"
			style="width: 135px;">
	</form>
</body></html>
</jsp:root>