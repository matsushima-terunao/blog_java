<%--
/**
 * ユーザー編集。
 * 
 * @author 2013/10/30 matsushima
 */
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${action}" method="post">
	<table border="1">
		<thead>
			<tr>
				<th><label for="loginid_new">ログインID</label></th>
				<th><label for="name">名前</label></th>
				<th><label for="password">パスワード</label></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<input type="text" id="loginid_new" name="loginid_new" value="${model.loginid}${param.loginid_new}" />
				</td>
				<td>
					<input type="text" id="name" name="name" value="${model.name}${param.name}" />
				</td>
				<td>
					<input type="password" id="password" name="password" value="${model.password}${param.password}" />
				</td>
			</tr>
		</tbody>
	</table>
	<input type="submit" name="confirm" value="確認" />
</form>
</body>
</html>
