<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
index page<br />
<%--<% if (null != request.getAttribute("user")) { %>
${user.name} さんこんにちは。
<% } %>--%>
<%=((org.springframework.security.core.userdetails.UserDetails)
		org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername() %>
さんこんにちは。
</body>
</html>
