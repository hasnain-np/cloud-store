<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 11/29/2014
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/secure/submitRegister" var="registerUrl"/>

<form action="${registerUrl}" method="post" commandName="userForm">
  <p>
    <label for="username">Username</label>
    <input type="text" id="username" name="username"/>
  </p>
  <p>
    <label for="password">Password</label>
    <input type="password" id="password" name="password"/>
  </p>
  <p>
    <label for="confirm_password">Confirm Password</label>
    <input type="password" id="confirm_password" name="confirm_password"/>
  </p>
  <button type="submit" class="btn">Register</button>
</form>