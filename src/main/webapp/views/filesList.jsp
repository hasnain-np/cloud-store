<%--
  Created by IntelliJ IDEA.
  User: Hasnain
  Date: 12/2/2014
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="fileListing.jsp"/>

<script>
  $("#pathStr").val('${pathStr}');

  $('.list').click(function() {
    $(this).addClass('listActive').siblings().removeClass('listActive');
  });
</script>