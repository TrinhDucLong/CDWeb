<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sell phone</title>

</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<div class="container">
		<h2>List Users</h2>
		<a href="/account/register" class="btn btn-primary">Add Users</a> <br>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Photo</th>
					<th>UserName</th>
					<th>Password</th>
					<th>FullName</th>
					<th>Email</th>
					<th>Activated</th>
					<th>Admin</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ACCOUNT}" var="acc">
					<tr>
						<td align="center"><img src="/uploads/${acc.photo}"
							width="60" height="60" /></td>
						<td>${acc.username}</td>
						<td>${acc.password}</td>
						<td>${acc.fullname}</td>
						<td>${acc.email}</td>
						<td>${acc.activated?"online":"offline"}</td>
						<td>${acc.admin?"Admin":"User"}</td>
						<td><a class="btn btn-primary btn-sm"
							href="/account/register/${acc.username}">Edit</a> | <a
							class="btn btn-danger btn-sm"
							href="?btnDel=&username=${acc.username}">Del</a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>

</body>
</html>

