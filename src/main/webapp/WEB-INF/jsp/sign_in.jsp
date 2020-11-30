<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<div>${message}</div>
<h1>Sign In</h1>
<form method="post" action="/">
    Username:&nbsp;<input type="text" name="userName"/><br/>
    Password:&nbsp;<input type="password" name="userPass"/><br/>
    <input type="submit" value="Login"/>
</form>
<form method="get" action="/sign_up">
    <button>Sign Up</button>
</form>
</body>
</html>