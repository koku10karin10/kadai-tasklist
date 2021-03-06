<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:choose>
        <c:when test="${task != null}">
        <h2>タスクID:<c:out value="task.id">の編集</c:out></h2>
        <form method="post" action="${pageContext.request.contextPath}/update">
        <c:import url="../layout/form.jsp">
        </c:import>



    </form>
    </c:when>
    <c:otherwise>
        <h2>お探しのデータはございません。</h2>
    </c:otherwise>
</c:choose>
    </c:param>
</c:import>