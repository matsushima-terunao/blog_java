<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
/**
 * ログインページ。
 * 
 * @author 2013/10/20 matsushima
 */
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/j_spring_security_check" method="post">
		<label for="loginid">ログインID</label>
		<input type="text" id="loginid" name="j_username" value="${user.loginid}" />
		<br />
		<label for="password">パスワード</label>
		<input type="password" id="password" name="j_password" value="${user.password}" />
		<br />
		<div style="color: red;">${message}${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
		<input type="submit" name="login" value="ログイン" />
	</form>
</body>
</html>
