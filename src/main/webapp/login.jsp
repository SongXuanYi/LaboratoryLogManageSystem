<%@ page contentType="text/html;charset=UTF-8" language="java" import=" java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.83.1">
    <title>Sign in</title>

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


    <link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center" background="img/bgimg.jpg">


<main class="form-signin">

    <form action="UserLoginServlet">
        <img class="mb-4" src="img/file-person.svg" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingInput" name="name" placeholder="username" required>
            <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" name="pwd" placeholder="Password" required>
            <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <a href="GotoRegisterServlet">Register</a>

    </form>
</main>

<%
    String succeed = (String) request.getAttribute("succeed");
    if (succeed != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=succeed%>");
</script>
<%
    }
%>

<%
    String failed = (String) request.getAttribute("passwordError");
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