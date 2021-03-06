
<%@page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <c:if test="${form != null}">
        <form action="${pageContext.request.contextPath}/add?table=${table}&topic_id=${topic_id}" method="post">
            <%= (String) request.getAttribute("form") %>
            <input class="btn btn-success" type="submit" value="Add">
        </form>
    </c:if>
</div>
</body>
</html>
