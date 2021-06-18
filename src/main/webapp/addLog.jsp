<%--
  Created by IntelliJ IDEA.
  User: NH55
  Date: 2021/5/31
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.83.1">
    <title>Checkout example · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/checkout/">


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
    <link href="css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container" align="center">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="img/clipboard-plus.svg" alt="" width="72" height="57">
            <h2>添加日志信息</h2>
        </div>

        <div class="col-md-7 col-lg-8">
            <form class="needs-validation" action="AddLogServlet" novalidate>
                <div class="row g-3">


                    <div class="col-12">
                        <label for="username" class="form-label">用户名</label>
                        <div class="input-group has-validation">
                            <span class="input-group-text">@</span>
                            <input type="text" class="form-control" id="username" placeholder="Username" name="username"
                                   required>
                            <div class="invalid-feedback">
                                用户名不能为空!
                            </div>
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="country" class="form-label">日志类型</label>
                        <select class="form-select" id="country" name="type" required>
                            <option value="">Choose...</option>
                            <option value="出勤记录">出勤记录</option>
                            <option value="借取器材">借取器材</option>
                            <option value="归还器材">归还器材</option>
                            <option value="器材报修">器材报修</option>
                            <option value="实验成果">实验成果</option>
                            <option value="其他">其他...</option>
                        </select>
                        <div class="invalid-feedback">
                            日志类型不能为空!
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="address" class="form-label">日志内容</label>
                        <input type="text" class="form-control" id="address" placeholder="请在此输入" name="event" required>
                        <div class="invalid-feedback">
                            日志不能为空!
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="address" class="form-label">时间</label>
                        <input type="datetime-local" class="form-control" id="time" placeholder="1234 Main St"
                               name="date"
                               required>
                        <div class="invalid-feedback">
                            时间不能为空!
                        </div>
                    </div>
                    <hr class="my-4">

                </div>


                <button class="w-100 btn btn-primary btn-lg" type="submit">添加</button>
            </form>
        </div>

    </main>
</div>
<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2021 SongXuanYi</p>

</footer>
</div>

<script src="css/bootstrap.bundle.min.js"></script>

<script src="css/form-validation.js"></script>

<%
    String failed = (String) request.getAttribute("addLogFailed");
    if (failed != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=failed%>");
</script>
<%
    }
%>
</body>
</html>

