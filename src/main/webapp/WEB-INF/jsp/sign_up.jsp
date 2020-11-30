<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>${message}</div>
<h1>Sign Up</h1>
<form method="post" action="/sign_up">
    Username:&nbsp;<input type="text" name="userName"/><br/>
    Password:&nbsp;<input type="password" name="userPass"/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>