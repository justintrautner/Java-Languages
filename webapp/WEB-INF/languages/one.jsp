<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title><c:out value="${lang.name}"/></title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<h5>Name : <c:out value="${lang.name}"/></h5>
	<h5> Created by: <c:out value="${lang.creator}"/></h5>
	<h5> Version : <c:out value="${lang.currentVersion}"/></h5>
	<form action="/languages/${lang.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
</body>
</html>