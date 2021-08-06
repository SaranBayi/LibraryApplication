<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="bootstrapLinks.jsp"></jsp:include>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="btn-group btn-group-justified">
		<a href="user/Useropen.jsp" class="btn btn-primary">Home<span
			class="glyphicon glyphicon-home"></span></a> <a
			href="UserOperator?action=list" class="btn btn-primary">List of
			BOOKS<span class="glyphicon glyphicon-book"></span>
		</a> <a href="UserOperator?action=listU" class="btn btn-primary">Books
			LIST IN THE CART</a>

		<div class="btn-group">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown">
				Settings <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li style="overflow: visible;"><a
					href="LibrarianOperator?action=profile">Profile</a></li>
				<li class="dropdown" style="overflow: visible;"><a class=""
					href="LibrarianOperator?action=changepd">Change Password</a></li>
			</ul>
		</div>

		<a href="LogOut" class="btn btn-primary">LOG OUT<span
			class="glyphicon glyphicon-off"></span></a> 
	</div>

</body>
</html>