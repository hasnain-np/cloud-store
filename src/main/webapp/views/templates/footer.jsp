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
<sec:authorize access="isAuthenticated()">
</sec:authorize>

<div class="row">
    <footer>
        <div class="col-md-12">
            <div class="col-md-1 pull-right">
                <img src="http://3.bp.blogspot.com/-IXUidTVie5o/Tlj4IcxHnYI/AAAAAAAAAB4/BRl41uyY9_s/s1600/fast.png"/>
            </div>
        </div>
    </footer>
</div>