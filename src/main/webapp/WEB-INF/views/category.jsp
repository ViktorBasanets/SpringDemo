<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Category</title>
    <%@include file="header.jsp"%>
</head>
<body>

    <h1>Category '<c:out value="${category.name}"/>'</h1>

    <p>(<c:out value="${category.description}"/>)</p>

    <h3>Products: </h3>

    <c:forEach var="p" items="${category.productList}">
        <h4>
            <a href="<c:url value="/product?p_id=${p.id}"/>"><c:out value="${p.name}"/></a>
        </h4>
    </c:forEach>

</body>
</html>
