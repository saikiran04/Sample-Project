<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home Page</title>
</head>
<body>
<h2>Search Student Details</h2>
<form method="get" action="getdetails">
Enter Student Name or Roll No 		  <input type="text" name="sname"><br><br>

<input  type="submit" value="search">
</form>
<h2> To save Student Details</h2>
<a href="Studentform">Enter student Details</a>
<h2> To save Student marks</h2>
<a href="Marks">student Marks</a>

<h2>Add Bulk details</h2>
<form id="fileuploadForm" action="fileupload" method="POST" enctype="multipart/form-data">
    <label for="file">File</label>
    <input id="file" type="file" name="file" />
    <p><button type="submit">Upload</button></p>        
</form>
</body>
</html>