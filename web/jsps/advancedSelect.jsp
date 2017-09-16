<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joah
  Date: 17-9-16
  Time: 上午9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>advancedSelect</title>
    <script language="javascript" type="text/javascript" src="<c:url value="/tools/My97DatePicker/WdatePicker.js"/>"></script>
    <script language="JavaScript" type="text/javascript" src="<c:url value="/JavaScript/checkForm.js"/>"></script>
</head>
<body>
	<form action="" method="post" accept-charset="utf-8">
		<table align="center">
			<thead>
				<tr>
					<th colspan="2" align="center">高级查询</th>
				</tr>
			</thead>
			<tbody>
                <tr>
                    <td align="right"><label for="nameI">name:</label></td>
                    <td><input type="text" name="nameN" placeholder="用户名" id="nameI" onblur="checkName2()" align="left"></td>
                    <td style="width: 250px"><span id="nameS" ></span></td>
                </tr>
                <tr>
                    <td align="right">sex:</td>
                    <td>
                        <input type="radio" name="male" value="male" id="maleI" align="left"><label for="maleI" >男</label>
                        <input type="radio" name="female" value="female" id="femaleI" align="left"><label for="femaleI">女</label>
                    </td>
                    <td><span id="sexS"></span></td>
                </tr>
                <tr>
                    <td align="right"><label for="birthdayI">birthday:</label></td>
                    <td><input type="text" class="Wdate" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" id="birthdayI" align="left">
                    </td>
                    <td><span id="birthdayS"></span></td>
                </tr>
                <tr>
                    <td align="right"><label for="phoneNumberI">phoneNumber:</label></td>
                    <td><input type="text" name="phoneNumber" placeholder="电话号码" id="phoneNumberI" onblur="checkNumber2()" align="left"></td>
                    <td style="width: 250px"><span id="phoneNumberS" ></span></td>
                </tr>
                <tr>
                    <td align="right"><label for="emailI">email:</label></td>
                    <td><input type="text" name="email" placeholder="邮箱" id="emailI" onblur="checkEmail2()" align="left"></td>
                    <td style="width: 250px"><span id="emailS" ></span></td>
                </tr>
                <tr>
                    <td align="right"><label for="descriptionI">description:</label></td>
                    <td><textarea name="description" id="descriptionI" style="width: 333px; height: 51px;"></textarea></td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <button type="submit" onclick="return selectCheck2()"> search </button>&nbsp;&nbsp;
                        <button type="reset" > reset </button>
                    </td>
                </tr>
                </tbody>
		</table>
	</form>
</body>
</html>
