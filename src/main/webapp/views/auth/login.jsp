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

<div class="col-md-4 col-md-offset-4 well">
    <form class="form-horizontal" role="form" action="${loginUrl}" method="post">
        <div class="form-group">
            <label for="username" class="col-sm-4 control-label">Username</label>

            <div class="col-sm-8">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-4 control-label">Password</label>

            <div class="col-sm-8">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>
</div>