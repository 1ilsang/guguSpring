<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2018-10-31
  Time: 오후 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>1ilsang.blog.me</title>
</head>
<body>
    <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>
