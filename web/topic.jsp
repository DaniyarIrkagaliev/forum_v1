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
<%if (currentUser != null) {if (currentUser.getID() == 1) {%>
<td><a class="btn btn-danger"
       href="${pageContext.request.contextPath}/delete?table=3&id=${id}">Delete Topic</a></td>
<%}}%>
<table>

</table>

<table class="table">
    <tr>
        <th>topic_id</th>
        <th>date</th>
        <th></th>
    </tr>
    <th> Всего ответов на эту тему:</th>
    <td>
        ${answersC.getAnswCountByTop(id)}
    </td>
    <c:forEach items="${topicsC.getByTopID(id)}" var="i">
        <h1>${i.getTitle()}</h1>
        <p>${i.getDescription()}</p>
        <tr>
            <td>${i.getID()}</td>
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
            <td>${usID = i.getUser_id()}</td>

            <% if (currentUser != null) { if (currentUser.getID() == 1) {%>
            <td><a class="btn btn-danger"
                   href="${pageContext.request.contextPath}/delete?table=1&id=${i.getID()}">Delete</a></td>
            <%}}%>
        </tr>
    </c:forEach>


    <% if (currentUser != null) {%>
    <tr>
        <td><a class="btn btn-success" href="${pageContext.request.contextPath}/add?table=1&topic=${id}">Add answ</a></td>
    </tr>
    <%}%>


</table>
</body>
</html>

