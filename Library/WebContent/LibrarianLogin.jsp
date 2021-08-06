<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
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
	height: 625px;
	width: 1365px;
	position: relative;
}

.hero-text {
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: red;
}
</style>


</head>

<body>
	<div class="hero-image">
		<div class="Container">
			<div class="hero-text">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<h1 class="text-center" style="color:white">S LIBRARY</h1>
						<div class="text-center">
							<img alt="Error"
								src="https://authormasterminds.com/img/D_12872344321.jpg"
								class="text-center">
						</div>
						<h2 class="text-center" style="color:white">Welcome to Library</h2>
						<form action="LibrarianloginImp" method="get">

							<%
								Object a = request.getParameter("message");
							if (a != null) {
								out.println(a);
							}
							%>
							<table class="table">
								<tbody style="text-align: center;">
									<tr>
										<td style="color:white">UserName</td>
										<td><input type="text" name="num" class="form-control"
											required /></td>
									</tr>
									<tr>
										<td style="color:white">Password</td>
										<td><input type="password" name="pd" class="form-control"
											required /></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="submit" value="Login"
											class="btn btn-success"> &nbsp;&nbsp; <input
											type="reset" value="Clear" class="btn btn-danger"></td>
									</tr>


								</tbody>
							</table>
							<p class="text-center" style="color:white">
								Not Having Account<a href="UserSignUp.jsp" style="color: orange">?
									SignUp Here</a>
						</form>

					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>