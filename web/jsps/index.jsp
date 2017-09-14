<%--
  Created by IntelliJ IDEA.
  User: joah
  Date: 17-9-14
  Time: 下午2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ManagePage</title>
</head>
    <frameset rows="5%,15%,70%,10%" frameborder="no">
        <frame src="<c:url value="top.jsp"/>" name="top"/>
        <frame src="<c:url value="title.jsp"/>" name="title">
        <frameset cols="30%,70%" frameborder="no">
            <frame src="<c:url value="operations.jsp"/> " name="operations">
            <frame src="<c:url value="main.jsp"/> " name="main">
        </frameset>
        <frame src="<c:url value="bottom.jsp"/> " name="bottom">
    </frameset>

</html>
