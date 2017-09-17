<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joah
  Date: 17-9-17
  Time: 上午10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectResult</title>
</head>
<body>
    <table border="1" align="center">
    	<caption>客户列表</caption>
    	
    	<tbody>
    		<tr>
    			<td>name</td>
    			<td>sex</td>
    			<td>birthday</td>
    			<td>phoneNumber</td>
    			<td>email</td>
    			<td style="width: 100px;">description</td>
    			<td>operations</td>
    		</tr>
    		<c:forEach items="${requestScope.selectResults}" var="result" >
                <tr>
                    <td>${result.name}</td>
                    <td>${result.sex}</td>
                    <td>${result.birthday}</td>
                    <td>${result.phoneNumber}</td>
                    <td>${result.email}</td>
                    <td style="width: 100px;">${result.description}</td>
                    <td>
                        <a href="#">edit</a> &nbsp;&nbsp;
                        <a href="#">delete</a>
                    </td>
                </tr>
            </c:forEach>
    	</tbody>
    </table>
</body>
</html>
