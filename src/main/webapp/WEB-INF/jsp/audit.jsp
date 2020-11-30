<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Audit</title>
</head>
<body>

<ul>
    <c:forEach var = "elem" items="${audit}">
        <li>${elem.toString()}</li>
    </c:forEach>
</ul>

</body>
</html>