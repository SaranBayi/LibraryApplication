<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Book</title>
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
	color: red;
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

				<div class="text-center">
					<img alt="Error"
						src="https://authormasterminds.com/img/D_12872344321.jpg"
						class="text-center">
				</div>

				<h1 class="text-center" style="color: white">Add Books Here</h1>
				<form action="LibrarianOperator?action=add" method="post">
					<%
						Object a = request.getParameter("message");
					if (a != null) {
						out.println(a);
					}
					%>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<table class="table">
								<tbody class="success"  style="color: white">
									<tr>
										<td>Book Title</td>
										<td><input type="text" name="title" class="form-control"
											required /></td>
									</tr>
									<tr>
										<td>Book author</td>
										<td><input type="text" name="author" class="form-control" /></td>
									</tr>
									<tr>
										<td>Book genre</td>
										<td><input type="text" name="genre" class="form-control" /></td>
									</tr>
									<tr>
										<td>Book ISBN</td>
										<td><input type="text" name="ISBN" class="form-control"
											required /></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="submit" value="Submit"
											class="btn btn-success"> &nbsp;&nbsp; <input
											type="reset" value="Clear" class="btn btn-danger"></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-4"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>