<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 11/29/2014
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/secure/addUser" var="registerUrl"/>
<c:url value="/secure/login" var="loginUrl"/>

<br/><br/>
<div id="registerForm">
  <form action="${registerUrl}" method="post" commandName="userForm" onsubmit="return verifyRegisterForm();">
    <p>
      <label for="userName">Username: </label>
      <input type="text" id="userName" name="userName"/>
    </p>
    <p>
      <label for="password">Password: </label>
      <input type="password" id="password" name="password"/>
    </p>
    <p>
      <label for="confirm_password">Password: </label>
      <input type="password" id="confirm_password" name="confirm_password"/>
    </p>
    <button type="submit" class="btn">Register</button>
  </form>
  <p>Already registered? <a href="${loginUrl}">Click here</a> to go to login page!</p>
</div>

<script>
  function verifyRegisterForm(){
    if((!document.getElementById("userName").value) || document.getElementById("userName").value.length==0){
      alert("Please enter username!");
      return false;
    } else if((!document.getElementById("password").value) || document.getElementById("password").value.length==0) {
      alert("Password is empty!");
      return false;
    } else if(document.getElementById("password").value != document.getElementById("confirm_password").value) {
      alert("Password must be same!");
      return false;
    }
    return true;
  }
</script>