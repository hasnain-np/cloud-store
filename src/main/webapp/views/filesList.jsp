<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 12/2/2014
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="folderName" items="${folders}">
  <div class="list folderList" id="${folderName}" ondblclick="openFolder('${folderName}');">
    <img src="../images/folder.png"/><c:out value="${folderName}" />
  </div>
</c:forEach>

<c:forEach var="fileName" items="${files}">
  <div class="list fileList"  ondblclick="downloadFile('${fileName}');">
    <img src="../images/file.png"/><c:out value="${fileName}" />
  </div>
</c:forEach>

<script>
  $("#pathStr").val('${pathStr}');

  $('.list').click(function() {
    $(this).addClass('listActive').siblings().removeClass('listActive');
  });
</script>