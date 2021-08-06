<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Books here</h1>

	<form:form method="post" action="addBook" modelAttribute="book">
		<form:input type="hidden" path="${book.id}"/>
		<table>
			<tr>
				<td>Book Name</td>
				<td><form:input type="text" name="name" path="${book.name}" /></td>
			</tr>
			<tr>
				<td>Book Author</td>
				<td><form:input type="text" name="author" path="${book.author}"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Clear" /></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>