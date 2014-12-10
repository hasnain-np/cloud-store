<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 11/29/2014
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/secure/login" var="loginUrl"/>
<c:url value="/secure/register" var="registerUrl"/>

<br/><br/>
<div id="loginForm">
  <form action="${loginUrl}" method="post">
    <c:if test="${param.error != null}">
      <p>
        Invalid username and password.
      </p>
    </c:if>
    <c:if test="${param.logout != null}">
      <p>
        You have been logged out.
      </p>
    </c:if>
    <p>
      <label for="username">Username</label>
      <input type="text" id="username" name="username"/>
    </p>
    <p>
      <label for="password">Password</label>
      <input type="password" id="password" name="password"/>
    </p>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
  </form>

  <br/><br/>

  <p>Not registered? <a href="${registerUrl}">Click here</a> to get a new account</p>
</div>