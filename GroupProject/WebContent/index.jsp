<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="MyCss.css"/>
</head>
<body id="inde">
<h1>Study Group Matching</h1>


<button onclick="signUp()" id='s'>SignUp</button>
<button onclick="logIn()" id='l' style="display:none">Login</button><br><br>
<div id="container">
<div>
<fieldset>
<form action = "Login" method="post" id="uiid" >


<input type="text" name="uid" placeholder="UserName" required><br><br>
<input type="password" name="pw" placeholder="Password"required><br><br>
<input type="submit" value="Login">
</form>
<form action = "Signup" method="post" id="signin" style="display:none">
<input type="text" name="username" placeholder="Your Name" required><br><br>
<input type="text" name="userid" placeholder="Create an UserName" required><br><br>
<input type="password" name="pw1" placeholder="Password"required><br><br>
<input type="password" name="pw2" placeholder="Repeat Password" required><br><br>
<select name="gender" placeholder="Gender" required>
<option value="m">Male</option>
<option value="f">Female</option>
</select><br><br>
<input type="submit" value="SignUp">

</fieldset>
</form>
</div>
</div>
<h3>${resu}</h3>
<script>
function signUp(){
	document.getElementById('uiid').style.display='none';
	document.getElementById('s').style.display='none';
	document.getElementById('signin').style.display='';
	document.getElementById('l').style.display='';
}
function logIn(){
	document.getElementById('uiid').style.display='';
	document.getElementById('s').style.display='';
	document.getElementById('signin').style.display='none';
	document.getElementById('l').style.display='none';
}
</script>
</body>
</html>