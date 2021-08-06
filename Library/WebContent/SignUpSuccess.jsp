<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>S Library</title>
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
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
}
</style>
</head>
<body>
	<div class="hero-image">
		<div class="hero-text">
			<h1 class="text-center">Welcome To S Library</h1>

			<div class="text-center">
				<img alt="Error"
					src="https://authormasterminds.com/img/D_12872344321.jpg"
					class="text-center">
			</div>
			<h2 class="text-center">SignUP Successful</h2>
			<div class="text-center">
				<a href="LibrarianLogin.jsp"><button type="button"
						class="btn btn-success">Click for Login Page</button></a>


			</div>
		</div>
	</div>
</body>
</html>