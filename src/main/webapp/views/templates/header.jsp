<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 12/2/14
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <sec:authorize access="isAuthenticated()">
        <span id="headerInfo">
            My Cloud Store
        </span>
        <span id="loginInfo">
            <c:url value="/logout" var="logoutUrl"/>
            ${pageContext.request.userPrincipal.name}: <a href="${logoutUrl}">Logout</a>
        </span>
    </sec:authorize>
</div>