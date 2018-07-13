<%--
  Created by IntelliJ IDEA.
  User: developer
  Date: 11.07.18
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome "${user.email}"</h1>
    <h2>  - you're "${user.firstName}" "${user.lastName}"</h2>
    <h2>  - your password - "${user.password}"</h2>
</body>
</html>
