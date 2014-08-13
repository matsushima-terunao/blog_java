<%--
/**
 * ユーザー一覧。
 * 
 * @author 2013/10/28 matsushima
 */
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jp.matsushima.servlet.spring_test.model.*" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user" method="get">
	<input type="text" name="name" />
	<input type="submit" name="search" value="検索" />
</form>
${models.size()} 件見つかりました。
<table>
	<thead>
		<tr>
			<th>詳細</th>
			<th>ログインID</th>
			<th>名前</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${models}" varStatus="status">
		<tr>
			<td><c:out value="${user.name}" /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
