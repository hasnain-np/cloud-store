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
    <span id="headerInfo">
        <span id="headerTitle" onclick="window.location.href = 'http://'+window.location.host">My Cloud Store </span>
        <img id="headerLogo" src="http://3.bp.blogspot.com/-IXUidTVie5o/Tlj4IcxHnYI/AAAAAAAAAB4/BRl41uyY9_s/s1600/fast.png"/>
    </span>
    <sec:authorize access="isAuthenticated()">
        <span id="loginInfo">
            <c:url value="/logout" var="logoutUrl"/>
            ${pageContext.request.userPrincipal.name}: <a href="${logoutUrl}">Logout</a>
        </span>
    </sec:authorize>
</div>
</div>