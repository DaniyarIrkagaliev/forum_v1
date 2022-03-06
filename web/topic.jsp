<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.company.db.repository.User" %>
<% User currentUser = (User) session.getAttribute("user");%>

<html>
<head>
    <title>Topic</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>

<table class="table">
    <tr>
        <th>topic_id</th>
        <th>title</th>
        <th>description</th>
        <th>date</th>
        <th></th>
    </tr>

    <c:forEach items="${topicsC.getByTopID(id)}" var="i">
        <tr>
            <td>${i.getID()}</td>
            <td>${i.getTitle()}</td>
            <td>${i.getDescription()}</td>
            <td>${i.getDate()}</td>
        </tr>
    </c:forEach>
</table>
<table class="table">
    <tr>
        <th>message</th>
        <th>mes_time</th>
        <th>user</th>
        <%--        TODO вывод имени юзера--%>
        <th></th>
    </tr>

    <c:forEach items="${answersC.getByTopId(id)}" var="i">
    <tr>
        <td>${i.getMessage()}</td>
        <td>${i.getMes_time()}</td>
        <td>${i.getUser_id()}</td>
        </c:forEach>

            <% if (currentUser != null) {%>
    <tr>
        <td><a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=1&topic=${id}">Add
            answ</a></td>
    </tr>
    <% }%>

</table>
</body>
</html>

