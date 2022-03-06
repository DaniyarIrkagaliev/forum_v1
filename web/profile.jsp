<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>profile page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<table class="table">
    <h1>Your profile</h1>
    <tr>
        <th>user_id</th>
        <th>login</th>
        <th>username</th>
        <th>pass</th>
        <th></th>
    </tr>
    <c:forEach items="${usersC.getByUserID(id)}" var="i">
        <tr>
            <td>${i.getID()}</td>
            <td>${i.getLogin()}</td>
            <td>${username = i.getUsername()}</td>
            <td>${i.getPassword()}</td>
        </tr>
    </c:forEach>

</table>
</div>

<div class="section">
    <table class="table">
        <h1>${username}'s topics</h1>
        <tr>
            <th>topic_id</th>
            <th>title</th>
            <th>description</th>
            <th>date</th>
            <th></th>
        </tr>
        <c:forEach items="${topicsC.getByUserID(id)}" var="i">
            <tr>
                <td>${i.getID()}</td>
                <td>${i.getTitle()}</td>
                <td>${i.getDescription()}</td>
                <td>${i.getDate()}</td>
                <td align="right"><a class="btn btn-warning"
                                     href="${pageContext.request.contextPath}/topic?id=${i.getID()}">More</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
