<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Student page</h1>
<form method="post" action="savemarks">
<table>
<tr><td>Enter Rollnumber</td><td><input type="text" name="roll"/></td></tr>
<tr><td>Enter English marks</td><td><input type="text" name="english"/></td></tr>
<tr><td>Enter Maths marks</td><td><input type="text" name="maths"/></td></tr>
<tr><td>Enter Science marks</td><td><input type="text" name="science"/></td></tr>
<tr><td></td><td><input type="submit" value="submit"></td></tr>
</table>
<a href="Home">Back</a>
</form>
</body>
</html>