<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Default decorator</title>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../css/style.css">

    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="../scripts/myScript.js"></script>
</head>
<body>
    <jsp:include page="/views/templates/header.jsp"></jsp:include>

    <br/><br/>

    <sitemesh:write property='body'/>

    <br/><br/><br/>

    <jsp:include page="/views/templates/footer.jsp"></jsp:include>
</body>
</html>