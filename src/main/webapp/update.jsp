<%--
  Created by IntelliJ IDEA.
  User: 17717
  Date: 2020/11/9
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/update" method="post">
        <input type="hidden" name="id" value="${user.id}"><br>
        姓名:<input type="text" name="name" value="${user.name}"><br>
        密码：<input type="text" name="pass" value="${user.pass}"><br>
        性别:<input type="text" name="gender" value="${user.gender}"><br>
        E-mail:<input type="text" name="email" value="${user.email}"><br>
        <input type="submit" value="保存">
    </form>
</div>
</body>
</html>
