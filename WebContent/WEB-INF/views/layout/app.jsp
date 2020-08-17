<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="<c:url value = '/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value = '/css/style.css' />">

        <title>タスク管理</title>
    </head>
    <body>
        <div id="header">
            <h1>タスク管理アプリ</h1>
        </div>
        <div id="content">
            ${param.content}
        </div>


        <div id="footer">
            <p>@Tanaka Taro</p>
        </div>
    </body>
</html>