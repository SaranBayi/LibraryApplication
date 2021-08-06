<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit the credentials</title>
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
	top: 45%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
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

			<div class="text-center">
				<img alt="Error"
					src="https://authormasterminds.com/img/D_12872344321.jpg"
					class="text-center">
			</div>

			<form action="LibrarianOperator?action=userEdit" method="post">
				<div class="row">
					<div class="col-md-0"></div>
					<div class="col-md-12">
						<input type="hidden" name="id" value="${users.id}">
						<table class="table">
							<tbody>
								<tr>
									<td>User Name</td>
									<td><input type="text" name="num"
										value="${users.userName}" class="form-control"
										readonly="readonly" /></td>
								</tr>
								<tr>
									<td>Ph Number</td>
									<td><input type="text" name="phn"
										value="${users.PHNumber}" class="form-control" /></td>
								</tr>
								<tr>
									<td>Email</td>
									<td><input type="text" name="eid" value="${users.EMAIL}"
										class="form-control" /></td>
								</tr>
								<tr>
									<td>Role</td>
									<td><input type="radio" id="librarian" name="rol"
										value="librarian" >Librarian<input
										type="radio" id="user" name="rol" value="user" required>User</td>
									
								</tr>
								<tr>

									<td><input type="hidden" name="pd"
										value="${users.password}" class="form-control"
										readonly="readonly" /></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="submit" value="Save"
										class="btn btn-success"> &nbsp;&nbsp; <a
										href="LibrarianOperator?action=loginlist"><button
												type="button" class="btn btn-warning">Cancel</button></a></td>
								</tr>

							</tbody>
						</table>
					</div>
					<div class="col-md-0"></div>

				</div>
			</form>

		</div>
	</div>
</body>
</html>