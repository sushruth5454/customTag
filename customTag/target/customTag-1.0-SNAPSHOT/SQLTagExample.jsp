<%--
  Created by IntelliJ IDEA.
  User: NSUSHRUT
  Date: 3/16/2022
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All users are:</h1>
<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/sushdb" user="root" password="Tada@5454" var="dataSource"></sql:setDataSource>
<sql:query var="rs" dataSource="${dataSource}">select * from users</sql:query>
<table border="2px" cellpadding="2px">
    <tr>
        <td>User ID</td>
        <td>User Name</td>
        <td>User Email</td>
    </tr>
    <c:forEach items="${rs.rows}" var="row">
        <tr>
            <td><c:out value="${row.id}"></c:out></td>
            <td><c:out value="${row.name}"></c:out></td>
            <td><c:out value="${row.email}"></c:out></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
