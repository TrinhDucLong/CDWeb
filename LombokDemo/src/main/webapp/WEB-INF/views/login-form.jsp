<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Sell phone</title>
</head>
<body>

	<div class="container" style="margin-top: 50px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">
				<h3>Login</h3>
				<form action="login" method="post">
					<div class="form-group">
						<label>UserName</label> <input type="text" class="form-control"
							name="username" placeholder="Enter UserName">
					</div>
					<div class="form-group">
						<label>Password:</label> <input type="password"
							class="form-control" name="password" placeholder="Enter password">
					</div>
					<div class="checkbox">
						<label><input type="checkbox" name="chkRemember"> Remember me</label>
					</div>
					<p style="color: red">${MESSAGE}</p>
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-primary">Cancel</button>
					<p style="margin: 10px; font-size: 16px;">
						<a href="/home/register">Register</a>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
