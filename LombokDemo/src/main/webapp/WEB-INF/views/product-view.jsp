<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sell phone - Product Manager</title>
<style type="text/css">
th, td {
	border: 1px solid #369;
	padding: 3px;
}

th {
	background: white;
	color: blue;
}

td {
	background: aliceblue;
	height: 100px;
	width: auto;
}

.container {
	padding-right: 0px !important;
	padding-left: 0px !important;
	margin-right: auto;
	margin-left: auto;
}
}
</style>

</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">
		<h2>List Product</h2>
		<br> <br>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th><a href="manager?field=id">ID </a></th>
					<th>Photo</th>
					<th><a href="manager?field=name">Name </a></th>
					<th>Title Product</th>
					<th>Description Product</th>
					<th><a href="manager?field=price">Price</a></th>
					<th>Create Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${PRODUCT}" var="p">
					<tr>

						<td>${p.id}</td>
						<td align="center"><img src="/uploads/${p.image}" width="70"
							height="70" /></td>
						<td>${p.name}</td>
						<td>${p.titleProduct}</td>
						<td>${p.descriptionProduct}</td>
						<td>${p.price}$</td>
						<td>${p.createDate}</td>
						<td><a class="btn btn-danger btn-sm"
							href="?btnDel=&id=${p.id}">Del</a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>
</body>
</html>

