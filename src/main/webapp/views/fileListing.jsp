<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 12/9/14
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach var="folderName" items="${folders}">
    <div class="list folderList" id="${folderName}" ondblclick="openFolder('${folderName}');" onclick="selectRow('${folderName}', this);">
        <img src="../images/folder.png"/><c:out value="${folderName}" />
    </div>
</c:forEach>

<c:forEach var="fileName" items="${files}">
    <div class="list fileList"  ondblclick="downloadFile('${fileName}');" onclick="selectRow('${fileName}', this, true);">
        <img src="../images/file.png"/><c:out value="${fileName}" />
    </div>
</c:forEach>