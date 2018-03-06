<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<script> 
function validate()
{ 
 var username = document.form.uname.value; 
 var password = document.form.pwd.value;
 
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(password==null || password=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 } 
}
</script> 
</head>
<body>
<form name="form" method="post" action="login" onsubmit="return validate()">
Username<input type="text" name="uname"/>
Password<input type="password" name="pwd"/>
<input type="submit" value="Login">
<a href="Forgotpass">Forgot Password</a>
</form>
</body>
</html>