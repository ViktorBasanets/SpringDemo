<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Sign Up</title>

    <link href="<c:url value="/resources/static/css/bootstrap.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/static/css/signin.css"/>" rel="stylesheet">

</head>
<body>
    <div class="container">
        <spring:form class="form-signin" action="/signup" modelAttribute="user">
            <h3 class="form-signin-heading">Input your first name</h3>
            <spring:input path="firstName" type="firstName" class="form-control" placeholder="First Name"/>
            <h3 class="form-signin-heading">Input your last name</h3>
            <spring:input path="lastName" type="lastName" class="form-control" placeholder="Last Name"/>
            <h3 class="form-signin-heading">Input email</h3>
            <spring:input path="email" type="email" class="form-control" placeholder="Email address"/>
            <h3 class="form-signin-heading">Enter password</h3>
            <spring:input path="password" type="password" class="form-control" placeholder="Password"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </spring:form>
    </div>
</body>
</html>
