<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018-11-14
  Time: 오후 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
    <title>1ilsang.blog.me</title>
</head>
<body>
    <h1>Lougout Page</h1>
    <form action="/customLogout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button>로그아웃</button>
    </form>
</body>
</html>
