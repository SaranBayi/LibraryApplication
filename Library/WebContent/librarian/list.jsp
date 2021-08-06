<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Library List</title>
<jsp:include page="bootstrapLinks.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.hero-image {
	background:
		url("https://images.unsplash.com/photo-1481627834876-b7833e8f5570?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80")
		no-repeat center;
	background-size: cover;
	height: 825px;
	width: 1365px;
	position: relative;
}

.hero-text {
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: green;
}
</style>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<%
		if (session.getAttribute("num") == null) {
		response.sendRedirect("Fail.jsp");
	}
	%>

	<div class="hero-image">
		
			<div class="hero-text">
				<div class="container">
				<h1 class="text-center"
					style="color: white; font-family: star wars;">WELCOME TO S
					LIBRARY</h1>


				<div class="text-center">
					<img alt="Error"
						src="https://authormasterminds.com/img/D_12872344321.jpg"
						class="text-center">
				</div>

				<h2 class="text-center" style="color: white">Book List</h2>
				<div class="row">
				<div class="col-md-0"></div>
				<div class="colmd-12">

				<table class="table">
					<thead>
						<tr class="text-primary">
							<th style="color: white" class="text-center">ID</th>
							<th style="color: white" class="text-center">TITLE</th>
							<th style="color: white" class="text-center">AUTHOR</th>
							<th style="color: white" class="text-center">GENRE</th>
							<th style="color: white" class="text-center">ISBN</th>
							<th><a href="LibrarianOperator?action=add"><button
										type="button" class="btn btn-success">Add</button></a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${books}" var="book">
							<tr class="success">
								<td><c:out value="${book.id}"></c:out></td>
								<td><c:out value="${book.title}"></c:out></td>
								<td><c:out value="${book.author}"></c:out></td>
								<td><c:out value="${book.genre}"></c:out></td>
								<td><c:out value="${book.ISBN}"></c:out></td>
								<td><a
									href="LibrarianOperator?action=edit&id=<c:out value="${book.id}"/>"><button
											type="button" class="btn btn-warning">Edit</button></a></td>
								<td><a
									href="LibrarianOperator?action=delete&id=<c:out value="${book.id}"/>"><button
											type="button" class="btn btn-danger">Delete</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
				<div class="col-md-0"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>