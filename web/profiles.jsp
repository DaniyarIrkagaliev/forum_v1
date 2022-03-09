<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.company.db.repository.User" %>
<% User currentUser = (User) session.getAttribute("user");%>


<html>
<head>
    <title>Profiles</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container">
<jsp:include page="patterns/navbar.jsp"/>

<table class="table">
    <tr>
        <th>user_id</th>
        <th>login</th>
        <th>username</th>
        <th>pass</th>
    </tr>
    <c:forEach items="${usersC.getAll()}" var="i">
        <tr>
            <td>${i.getID()}</td>
            <td>${i.getLogin()}</td>
            <td>${username = i.getUsername()}</td>
            <td>${username}</td>

            <td align="right"><a class="btn btn-warning"
                                 href="${pageContext.request.contextPath}/profile?id=${i.getID()}">More</a></td>
            <%
                if (currentUser != null) {
                    if (currentUser.getID() == 1) {
            %>
            <td><a class="btn btn-danger"
                   href="${pageContext.request.contextPath}/delete?table=4&id=${id}">Delete</a></td>
            <%
                    }
                }
            %>
        </tr>
    </c:forEach>
</table>
</body>
</html>
