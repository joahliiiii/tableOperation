<%--
  Created by IntelliJ IDEA.
  User: joah
  Date: 17-9-14
  Time: 下午2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base target="main">
    <title>Title</title>
</head>
<body>
    <p>operations</p>
    <div align="center" id="operations">
        <a href="<c:url value="add.jsp"/>">添加客户</a><br>
        <a href="<c:url value="select.jsp"/> ">查询客户</a><br>
        <a href="<c:url value="advancedSelect.jsp"/>">高级查询</a><br>
    </div>
</body>
</html>
