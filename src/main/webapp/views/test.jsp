<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 11/26/14
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
This is the test output. ${name}
<ul>
<c:forEach var="name" items="${names}">
    <li> <c:out value="${name}" /> </li>
</c:forEach>
</ul>
</body>
</html>
