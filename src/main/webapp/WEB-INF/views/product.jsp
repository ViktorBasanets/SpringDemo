<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: developer
  Date: 23.06.18
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

<h2>Product: '<c:out value="${product.name}"/>'</h2>
<h3><p> -= price: <c:out value="${product.price}"/> =- </p></h3>

</body>
</html>
