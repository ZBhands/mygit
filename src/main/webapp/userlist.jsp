<%--
  Created by IntelliJ IDEA.
  User: 17717
  Date: 2020/11/9
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--使用el表达式 是否当作字符串来进行处理-->
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

    <a href="insert.jsp">增加</a>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>姓名</th>
            <th>密码</th>
            <th>性别</th>
            <th>E-mail</th>
            <th>操作</th>
        </tr>

        <c:forEach var="user" items="${user}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.pass}</td>
                <td>${user.gender}</td>
                <td>${user.email}</td>
                <td>
                    <a href="/findById?id=${user.id}">修改</a>
                    <a href="/deleteById?id=${user.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>

