<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>新規タスク作成</h2>

        <form method="post" action="${pageContext.request.contextPath}/create>">
            <c:import url="../layout/form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/index">タスク一覧へ</a></p>


    </c:param>
</c:import>