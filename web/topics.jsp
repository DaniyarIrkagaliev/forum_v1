<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.company.db.repository.User" %>
<% User currentUser = (User) session.getAttribute("user");%>

<html>
<head>
    <title>Topics</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>
<h1>List of topics</h1>
<% if (currentUser != null) {%>
<tr>

    <td align="right"><a class="btn btn-success"
                         href="${pageContext.request.contextPath}/add?table=3">Add
        top</a></td>
</tr>
<% }%>
<table class="table">
    <tr>
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
<%--            todo отображения кол-ва ответов--%>

                <td align="right"><a class="btn btn-warning"
                                     href="${pageContext.request.contextPath}/topic?id=${i.getID()}">More</a></td>
            <%if(currentUser != null){
                if (currentUser.getID() == 1) {%>
            <td><a class="btn btn-danger"
                   href="${pageContext.request.contextPath}/delete?table=3&id=${id}">Delete</a></td>
            <%}}%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
