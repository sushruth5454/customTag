<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Page Directive -->
<%@ page import="java.util.Random,java.io.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcone</h1>

<!--Declarative Tag  -->
<%!
int a=30;
int b=49;
public int doSum(){
	return a+b;
}

%>

<!-- Scriplet Tag -->
<%

out.println(doSum());

%>
<!--  Expression Tag-->
<h1>Sum is : <%= doSum() %></h1>
<h1>Random number is:
<%

Random r=new Random();
int n=r.nextInt(10);

%>
<%=n %></h1>
<%-- <c:set var="name" value="sushruth"></c:set>
<c:out value="${name}"></c:out> --%>
<c:out value="${name }"></c:out>


</body>
</html>