<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018-11-14
  Time: 오후 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
    <title>1ilsang.blog.me</title>
</head>
</bod>
    <h1>Custom Login Page</h1>
    <h2><c:out value="${error}"/></h2>
    <h2><c:out value="${logout}"/></h2>

    <form action="/login" method="post">
        <div>
            <input type="text" name="username" value="admin">
        </div>
        <div>
            <input type="password" name="password" value="admin">
        </div>
        <div>
            <input type="submit">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <h2>/security/all : 모두 접속 가능</h2>
    <h2>/security/member : 로그인 하면 모두 접근 가능</h2>
    <h2>/security/admin : 관리자(Admin)만 접근 가능</h2>
</body>
</html>
