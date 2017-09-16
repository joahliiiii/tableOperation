<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joah
  Date: 17-9-16
  Time: 上午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>select</title>
	<script language="JavaScript" type="text/javascript" src="<c:url value="/JavaScript/checkForm.js"/>"></script>
</head>
<body>
    <form action="<c:url value="/com/joah/tableOperation/web/servlet/selectServlet"/> " method="post">
        <table align="center">
        	<thead>
        		<tr>
        			<th colspan="2" align="center">用户查询</th>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td align="right"><label for="nameI">name:</label></td>
        			<td align="left"><input type="text" name="name" placeholder="用户名" id="nameI" onblur="checkName()"></td>
        			<td style="width: 250px"><span id="nameS"></span></td>
        		</tr>
        		<tr>
        			<td align="center" colspan="2"><button type="submit" onclick="return selectCheck()">搜索</button></td>
        		</tr>
        	</tbody>
        </table>
    </form>
</body>
</html>
