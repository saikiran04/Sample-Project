<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student </title>
</head>
<body>
<h1 align="center">Student Page</h1>
<form method="post" action="save">
<table>
<tr><td>Enter Rollnumber</td><td><input type="text" name="roll"/></td></tr>
<tr><td>Enter Studentname</td><td><input type="text" name="sname"/></td></tr>
<tr><td>Enter Gender</td><td><input type="text" name="gender"/></td></tr>
<tr><td>Enter Grade</td><td><input type="text" name="grade"/></td></tr>
<tr><td></td><td><input type="submit" value="submit"></td></tr>
<a href="Home">Back</a>
</table>
</form>
</body>
</html>