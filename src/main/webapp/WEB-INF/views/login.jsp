<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Login</title>

        <link href="<c:url value="/resources/static/css/bootstrap.css"/>" rel="stylesheet">

        <link href="<c:url value="/resources/static/css/signin.css"/>" rel="stylesheet">

        <%--action="/signup"--%>
    </head>
    <body>
        <div class="container">
            <spring:form class="form-signin" action="/login" modelAttribute="user">
                <h2 class="form-signin-heading">Please login</h2>
                <spring:input path="email" type="email" class="form-control" placeholder="Email address"/>
                <spring:input path="password" type="password" class="form-control" placeholder="Password"/>
                <label class="checkbox">
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </spring:form>
        </div>
    </body>
</html>
