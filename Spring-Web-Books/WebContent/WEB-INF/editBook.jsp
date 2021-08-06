<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" action="editBook" modelAttribute="book">

		<input type="hidden" name="id" value="${books.id}" path="${book.id}">
		<table>
			<tr>
				<td>Book Name</td>
				<td><input type="text" name="name" value="${books.name}" path="${book.name}"/></td>
			</tr>
			<tr>
				<td>Book Author</td>
				<td><input type="text" name="author" value="${books.author}" path="${book.author}"/></td>
			</tr>
			<tr>
				<td><a href="viewBook"><button>Cancel</button></a></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>

	</form:form>


</body>
</html>