<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profile</title>
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
	top: 42%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
}
</style>
<%
	String m = String.valueOf(session.getAttribute("role"));
%>
<c:set var="s" value="<%=m%>"></c:set>
<c:choose>
	<c:when test="${s ==  'librarian'}">
		<jsp:include page="librarian/header.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="user/userHeader.jsp"></jsp:include>
	</c:otherwise>

</c:choose>
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
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<h1 class="text-center">WELCOME TO S LIBRARY</h1>
						<div class="text-center">
							<img alt="Error"
								src="https://authormasterminds.com/img/D_12872344321.jpg"
								class="text-center">
							<h2 class="text-center">Profile</h2>
						</div>
						<table class="table">
							<tbody style="text-align: center;">
								<c:forEach items="${profile}" var="profile">
									<tr>
										<td>User Name</td>
										<td><c:out value="${profile.userName}"></c:out></td>
									</tr>
									<tr>
										<td>Phone Number</td>
										<td><c:out value="${profile.PHNumber}"></c:out></td>
									</tr>
									<tr>
										<td>Email-ID</td>
										<td><c:out value="${profile.EMAIL}"></c:out></td>
									</tr>
									<tr>
										<td>Role</td>
										<td><c:out value="${profile.role}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>