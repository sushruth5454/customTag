<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page errorPage="internalError.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    int a = Integer.parseInt(request.getParameter("n1"));
    int b = Integer.parseInt(request.getParameter("n2"));
    int result = a / b;

%>

<h2>Result is :<%= result%>
</h2>

</body>
</html>
