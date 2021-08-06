<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>List of Users</title>
<jsp:include page="bootstrapLinks.jsp"></jsp:include>
<style>
.hero-image {
	background:
		url("https://images.unsplash.com/photo-1481627834876-b7833e8f5570?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80")
		no-repeat center;
	background-size: cover;
	height: 625px;
	width: 1365px;
	position: relative;
}

.hero-text {
	text-align: center;
	position: absolute;
	top: 43%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: green;
}
</style>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<%
		String n = String.valueOf(session.getAttribute("num"));
	String m = String.valueOf(session.getAttribute("role"));
	%>
	<div class="hero-image">
		<div class="hero-text">
			<c:set var="s" value="${n}"></c:set>
			<c:choose>
				<c:when test="${s !=  'null'}">

					<div class="container">

						
						<h1 class="text-center" style="color:white">WELCOME TO S LIBRARY</h1>
						<div class="text-center">
							<img alt="Error"
								src="https://authormasterminds.com/img/D_12872344321.jpg"
								class="text-center">
						</div>
						<h2 class="text-center" style="color:white">User's List</h2>
						<table class="table">
							<thead>
								<tr class="text-primary">
									<th style="color:white" class="text-center">UserName</th>
									<th style="color:white" class="text-center">PH Number</th>
									<th style="color:white" class="text-center">Email-ID</th>
									<th style="color:white" class="text-center">Role</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="book">
									<tr class="success">
										<td><c:out value="${book.userName}"></c:out></td>
										<td><c:out value="${book.PHNumber}"></c:out></td>
										<td><c:out value="${book.EMAIL}"></c:out></td>
										<td><c:out value="${book.role}"></c:out></td>
										<td><a
											href="LibrarianOperator?action=userEdit&id=<c:out value="${book.id}"/>"><button
													type="button" class="btn btn-warning">Edit</button></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

				</c:when>
				<c:otherwise>
					<%
						response.sendRedirect("Fail.jsp");
					%>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>