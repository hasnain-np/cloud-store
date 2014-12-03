<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Default decorator</title>
</head>
<body>
    <jsp:include page="/views/templates/header.jsp"></jsp:include>

    <sitemesh:write property='body'/>

    <jsp:include page="/views/templates/footer.jsp"></jsp:include>
</body>
</html>