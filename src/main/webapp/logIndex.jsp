<%--
  Created by IntelliJ IDEA.
  User: NH55
  Date: 2021/5/31
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.83.1">
    <title>实验室日志</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/offcanvas-navbar/">


    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="css/offcanvas.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Laboratory Log</a>
        <button class="navbar-toggler p-0 border-0" type="button" id="navbarSideCollapse"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="GotoAddLogServlet">添加日志</a>
                </li>


            </ul>
            <form class="d-flex" action="FindFuzzyServlet">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search" required>
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<main class="container">
    <div class="d-flex align-items-center p-3 my-3 text-white bg-purple rounded shadow-sm">
        <img class="me-3" src="img/card-list.svg" alt="" width="48" height="38">
        <div class="lh-1">
            <h1 class="h6 mb-0 text-white lh-1">实验室日志</h1>
            <small>当前日志数：${list.size()}</small>
        </div>
    </div>

    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <h6 class="border-bottom pb-2 mb-0">日志列表</h6>


        <!--这里需要添加一个循环，来调用显示log数据库中的属性-->
        <c:if test="${not empty list}">
            <c:forEach items="${list}" var="logs" varStatus="s">

                <div class="d-flex text-muted pt-3">
                    <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32"
                         xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32"
                         preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#007bff"/>
                        <text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text>
                    </svg>

                    <p class="pb-3 mb-0 small lh-sm border-bottom">
                        <strong class="d-block text-gray-dark">@${logs.username}&nbsp;&nbsp;&nbsp;${logs.date}
                            <a href="DeleteLogServlet?id=${logs.id}">删除</a>
                            <a href="UpdateLogServlet?id=${logs.id}">修改</a>

                        </strong>
                            ${logs.type}:<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${logs.event}
                    </p>
                </div>

            </c:forEach>
        </c:if>

    </div>

</main>


<script src="css/bootstrap.bundle.min.js"></script>

<script src="css/offcanvas.js"></script>
</body>
</html>

