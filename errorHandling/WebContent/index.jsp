<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ page errorPage="error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>

<%!
    int a = 20;
    int b = 0;

%>

<%
    int division = a / b;

%>

<h1>Division is :<%=division %>
</h1>

</body>
</html>
