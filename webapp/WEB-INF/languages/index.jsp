<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body class="pl-3">
	<h1 class="pt-2">Languages</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${langs}" var="lang">
        <tr>
            <td>
            	<a href="/languages/<c:out value='${lang.id}'/>">
            	<c:out value="${lang.name}"/>
            	</a>
            </td>
            <td><c:out value="${lang.creator}"/></td>
            <td><c:out value="${lang.currentVersion}"/></td>
            <td>
           		<form action="/languages/${lang.id}" method="post">
   					<input type="hidden" name="_method" value="delete">
   					<input type="submit" value="Delete">
				</form>
				<a href="/languages/edit/<c:out value='${lang.id }'/>"><input type="submit" value="Edit"></a>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>

	<h1>New Language</h1>
<form:form action="/languages" method="post" modelAttribute="language">
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
    <input class="mb-3" type="submit" value="Submit"/>
</form:form> 


</body>
</html>