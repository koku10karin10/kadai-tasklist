<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="../layout/app.jsp">
  <c:param name="content">
    <c:choose>
    <c:when test="${tl != null}">
    <h2><c:out value = "${tl.id}" />のタスクの詳細</h2>
    <table>
      <tbody>
        <tr>
            <th>タスク</th>
            <td><c:out value="${tl.content}" /></td>
        </tr>
        <tr>
            <th>作成日時</th>
            <td><fmt:formatDate value="${tl.created_at}"
                            pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
        <tr>
            <th>最新更新日時</th>
            <td><fmt:formatDate value="${tl.updated_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
      </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/edit?id=${tl.id}">修正する</a><br />
    <p><a href="${pageContext.request.contextPath}/index">一覧へ戻る</a></p>



        <form method = "POST" name="destroy" action = "${pageContext.request.contextPath}/destroy?id=${tl.id}">
        <p><input type ="button" onclick = "confirmDestroy();"  value="このタスクを削除する"></p>
            <input type = "hidden" name = "_token" value = "${_token}" />

        </form>
        <script>
        function confirmDestroy(){
            if(confirm("このタスクを削除してよろしいですか？")){

                document.destroy.action="${pageContext.request.contextPath}/destroy?id=${tl.id}";
                document.destroy.method="POST";
                document.destroy.submit();

            }
    }
    </script>
    </c:when>
    <c:otherwise>
        <h2>お探しのデータはございません。</h2>
    </c:otherwise>
    </c:choose>
  </c:param>
</c:import>