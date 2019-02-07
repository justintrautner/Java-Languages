<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Edit <c:out value="${lang.name}"/></title>
</head>
<body class="pl-3">

<h4 class="pt-2">Edit <c:out value="${lang.name}"/></h4>
<form:form action="/languages/${lang.id }" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator: </form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version: </form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form> 


</body>
</html>