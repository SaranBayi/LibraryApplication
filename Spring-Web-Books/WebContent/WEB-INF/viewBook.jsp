<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>Books List</h1>
	<table border="5">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Author</th>

			<th colspan="2">Action &nbsp;<a href="addBook2">Add</a></th>
		</tr>
		<c:forEach items="${books}" var="books">
			<tr>
				<td><c:out value="${books.id}"></c:out></td>
				<td><c:out value="${books.name}"></c:out></td>
				<td><c:out value="${books.author}"></c:out></td>

				<td><a href="editBook?id=<c:out value="${books.id}"/>">Update</a></td>
				<td><a
					href="deleteBook?id=<c:out value="${books.id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>




</body>
</html>