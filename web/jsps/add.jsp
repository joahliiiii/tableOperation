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
    <title>add</title>
    <script language="javascript" type="text/javascript" src="<c:url value="/tools/My97DatePicker/WdatePicker.js"/>"></script>
    <script language="JavaScript" type="text/javascript" src="<c:url value="/JavaScript/checkForm.js"/>"></script>
</head>
<body>
    <form action="<c:url value="com/joah/tableOperation/web/servlet/addServlet"/> " method="post">
        <table>
        	<thead>
        		<tr>
        			<th align="center" colspan="2">添加用户</th>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td align="right"><label for="nameI">name:</label></td>
        			<td><input type="text" name="nameN" placeholder="用户名" id="nameI" onblur="checkName()"><span id="nameS"></span></td>
        		</tr>
        		<tr>
        			<td align="right">sex:</td>
        			<td>
                        <input type="radio" name="male" value="male" id="maleI"><label for="maleI">男</label>
        				<input type="radio" name="female" value="female" id="femaleI"><label for="femaleI">女</label>
                        <span id="sexS"></span>
        			</td>
        		</tr>
        		<tr>
        			<td align="right"><label for="birthdayI">birthday:</label></td>
                    <th><input type="text" class="Wdate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" id="birthdayI">
                    <span id="birthdayS"></span>
                    </th>
        		</tr>
                <tr>
                    <th align="right"><label for="phoneNumberI">phoneNumber:</label></th>
                    <th><input type="text" name="phoneNumber" placeholder="电话号码" id="phoneNumberI" onblur="checkNumber()">
                    <span id="phoneNumberS"></span></th>
                </tr>
                <tr>
                    <th align="right"><label for="emailI">email:</label></th>
                    <th><input type="text" name="email" placeholder="邮箱" id="emailI" onblur="checkEmail()">
                    <span id="emailS"></span></th>
                </tr>
                <tr>
                    <th align="right"><label for="descriptionI">description:</label></th>
                    <th><textarea name="description" id="descriptionI" style="width: 333px; height: 51px;"></textarea></th>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <button type="submit" onclick="return check()"> submit </button>&nbsp;&nbsp;
                        <button type="reset" > reset </button>
                    </td>
                </tr>
        	</tbody>
        </table>
    </form>
</body>
</html>
