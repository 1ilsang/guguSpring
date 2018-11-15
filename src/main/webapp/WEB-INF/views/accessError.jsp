<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018-11-14
  Time: 오후 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
    <title>1ilsang.blog.me</title>
</head>
<body>
    <h1>Access Denied Page</h1>
    <h2>Spring Security 403 MSG: <c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></h2>
    <h2>Redirect: <c:out value="${msg}"/></h2>
</body>
</html>
