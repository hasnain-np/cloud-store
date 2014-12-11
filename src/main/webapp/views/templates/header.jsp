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
<div class="row">
    <div class="col-md-12">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header"><h2>My Cloud Store</h2></div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#" onclick="window.location.href = 'http://'+window.location.host">Home</a></li>
                        <sec:authorize access="isAuthenticated()">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false">${pageContext.request.userPrincipal.name} <span
                                        class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <c:url value="/logout" var="logoutUrl"/>
                                    <li><a href="${logoutUrl}">Logout</a></li>
                                </ul>
                            </li>
                        </sec:authorize>
                    </ul>
                </div>
                <%--<p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>--%>
            </div>
        </nav>
    </div>
</div>
