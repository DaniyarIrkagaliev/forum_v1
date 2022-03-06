<%@ page import="com.company.db.repository.User" %>
<% User currentUser = (User) session.getAttribute("user");%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <span class="navbar-brand"><a class="nav-link" href="${pageContext.request.contextPath}/">KAZforum</a></span>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="${pageContext.request.contextPath}/">Menu</a>--%>
<%--            </li>--%>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/topics.jsp">Topics</a>
            </li>
    <% if (currentUser == null) {%>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
            </li>
    <% } else { %>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/profile">My Profile</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/logout">LogOut</a>
    </li>
    <% } %>
        </ul>
    </div>
</nav>
