
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        </tr>
    </c:forEach>
</table>
