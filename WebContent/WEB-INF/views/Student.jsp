<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student Details</title>
</head>
<body>
<h2>Student details</h2>
<table border='1'>
<tr><td>Roll Number</td><td>${student.rollnumber}</td></tr>
<tr><td>Student Name</td><td>${student.studentname}</td></tr>
<tr><td>Gender</td><td>${student.gender}</td></tr>
<tr><td>Grade</td><td>${student.grade}</td></tr>

</table>
<h2>Student Marks</h2>
<table border='1'>
<tr><td>English marks</td><td>Maths marks</td><td>science marks</td></tr>
<tr><td>${marks.english}</td><td>${marks.maths}</td><td>${marks.science}</td></tr>
</table>
<a href="Home">Back</a>
</body>
</html>