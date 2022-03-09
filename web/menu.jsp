<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.company.db.repository.User" %>
<% User currentUser = (User) session.getAttribute("user");%>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<p>Клиент-северное приложение на тему "Forum". Подготовил студент 3 курса ВГУ ФКН 6 группы Иркагалиев Данияр.</p>
<table class="table">
    <tr>
        <h1 align="centre">ЧАТ</h1>
        <th>mes_id</th>
        <th>user_id</th>
        <th>message</th>
        <th>mes_time</th>
        <th></th>
    </tr>
    <c:forEach items="${messagesC.getAll()}" var="i">
        <tr>

            <td>${i.getID()}</td>
                <%--TODO показывать юзернейм вместо юзер айди--%>
            <td>${i.getUser_id()}</td>
            <td>${i.getMessage()}</td>
            <td>${i.getMes_time()}</td>

            <%if (currentUser != null){
                if (currentUser.getID() == 1) {%>
            <td><a class="btn btn-danger"
                   href="${pageContext.request.contextPath}/delete?table=2&id=${i.getID()}">Delete</a></td>
            <%}}%>
        </tr>
    </c:forEach>
    <% if (currentUser != null) {%>
    <tr>
        <td align="center"><a class="btn btn-success"
                              href="${pageContext.request.contextPath}/add?table=2">Add
            mess</a></td>
    </tr>
    <% }%>
</table>

<table class="table">
    <tr>
        <h1 align="centre">topics </h1>
        <th>topic_id</th>
        <th>title</th>
        <th>description</th>
        <th>date</th>
        <th></th>
    </tr>
    <c:forEach items="${topicsC.getAll()}" var="i">
        <tr>
            <td>${i.getID()}</td>
            <td>${i.getTitle()}</td>
            <td>${i.getDescription()}</td>
            <td>${i.getDate()}</td>
                <%--            todo отображение кол-ва ответов--%>
            <td align="right"><a class="btn btn-warning"
                                 href="${pageContext.request.contextPath}/topic?id=${i.getID()}">More</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
