<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Jstl Examples
</h1>



<%--out tag--%>
<c:out value=""></c:out>

<%--set tag--%>
<c:set var="name" value="sushruth" scope="application"></c:set>
<h1><c:out value="${name}"></c:out></h1>
<c:set var="i" value="23"></c:set>

<%---remove tag --%>
<c:remove var="name"></c:remove>

<%-- If tag --%>
<c:if test="${i>20}">
    <h1>Yes i is Greater than 20</h1>
</c:if>

<%--redirect--%>
<c:url var="myurl" value="https://www.google.com/search">
    <c:param name="q" value="sushruth"></c:param>
</c:url>
<h1><c:out value="${myurl}"></c:out></h1>
<%--<c:redirect url="${myurl}"></c:redirect>--%>









<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="page3.jsp">Go to page3</a>
</body>
</html>
