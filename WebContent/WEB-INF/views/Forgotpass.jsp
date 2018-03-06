<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script> 
function validate()
{ 
 var username = document.form.uname.value; 
 var npassword = document.form.npass.value;
 var cpassword = document.form.cpass.value;
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(npassword==null || npassword=="")
 { 
 alert("new Password cannot be blank"); 
 return false; 
 } 
 else if(cpassword==null || cpassword=="")
 { 
 alert("confirm Password cannot be blank"); 
 return false; 
 } 
 else if(npassword!=cpassword)
 { 
 alert("New password and confirm password must be same"); 
 return false; 
 } 
}
</script> 
</head>
<body>
<form name="form" method="post" action="chgpass" onsubmit="return validate()">
Username<input type="text" name="uname">
New Password<input type="text" name="npass">
Confirm Password<input type="text" name="cpass">
<input type="submit" value="submit">
<a href="Login">Cancel</a>
</form>
</body>
</html>