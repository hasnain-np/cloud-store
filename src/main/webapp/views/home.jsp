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
      <jsp:include page="filesList.jsp"/>
  </div>

  <br/>
  <div class="btnsContainer">
    <button class="greenBtn" onclick="showFolderForm();" id="createDirBtn">Create Folder</button>

    <%--<button class="greenBtn">Download File</button>--%>
    <button class="greenBtn" id="selFileBtn" onclick="selectFile();">Upload File</button>
    <button class="greenBtn" id="startUpBtn" onclick="uploadFile();">Start Uploading</button>
    <button class="greenBtn" id="deleteBtn" onclick="deleteFile();">Delete</button>
    <button class="greenBtn" id="backBtn" onclick="goBack();">Back</button>
    <button class="greenBtn" id="shareLinkBtn" onclick="getDownloadLink();">Share download link</button>

    <img src="../images/loading.gif" id="loadingGif"/>

    <form:form method="POST" commandName="file" action="ajax/file" id ="fileUpForm" enctype="multipart/form-data">
      <div  style='height: 0px;width:0px; overflow:hidden;'><input id="upFile" type="file" name="file" /></div>
      <form:errors path="file" cssStyle="color: #ff0000;" />
    </form:form>
    <br/>
    <span id="createFolderSpan">
      Folder Name: <input id="folderName" type="text" name="folderName" style="height: 27px;"/>
      <button class="greenBtn" onclick="createFolder();" id="saveDirBtn">Save Folder</button>
    </span>
    <input type="hidden" id="pathStr" value=""/>

    <input type="hidden" id="selectedRowName" value=""/>

  </div>

<div id="downloadLink" style="display:none;">Download link: </div>

<%--
  <form:form method="POST" commandName="file" action="file"	enctype="multipart/form-data">
    Upload your file please:
    <input type="file" name="file" />
    <input type="submit" value="upload" />
    <form:errors path="file" cssStyle="color: #ff0000;" />
  </form:form>--%>
