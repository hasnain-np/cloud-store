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

  <p>Files and folders: </p>

  <div id="listingContainer">
    <c:forEach var="folderName" items="${folders}">
      <div class="list folderList"><img src="../images/folder.png"/><c:out value="${folderName}" /> </div>
    </c:forEach>

    <c:forEach var="fileName" items="${files}">
      <div class="list fileList"><img src="../images/file.png"/><c:out value="${fileName}" /> </div>
    </c:forEach>
  </div>

  <br/>
  <div class="btnsContainer">
    <button class="greenBtn">Create Folder</button>
    <button class="greenBtn">Download File</button>
    <button class="greenBtn" id="selFileBtn" onclick="selectFile();">Upload File</button>
    <button class="greenBtn" id="startUpBtn" onclick="uploadFile();">Start Uploading</button>

    <img src="../images/loading.gif" class="loadingGif"/>

    <form:form method="POST" commandName="file" action="ajax/file" id ="fileUpForm" enctype="multipart/form-data">
      <div  style='height: 0px;width:0px; overflow:hidden;'><input id="upFile" type="file" name="file" /></div>
      <form:errors path="file" cssStyle="color: #ff0000;" />
    </form:form>
  </div>

<%--
  <form:form method="POST" commandName="file" action="file"	enctype="multipart/form-data">
    Upload your file please:
    <input type="file" name="file" />
    <input type="submit" value="upload" />
    <form:errors path="file" cssStyle="color: #ff0000;" />
  </form:form>--%>
