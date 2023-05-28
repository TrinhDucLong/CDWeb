<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sell phone - Shopping Cart</title>

</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	<br>
	<br>
	<div class="container">
		<h2>List Products</h2>
		<div class="rows">
			<div class="col-sm-9">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Amount</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="item" items="${CART_ITEMS}">
							<form action="/shopping/update" method="post">
								<input type="hidden" name="id" value="${item.productId}" />
								<tr>
									<td>${item.productId }</td>
									<td>${item.name }</td>
									<td>${item.price}</td>
									<td><input name="qty" value="${item.qty}"
										onblur="this.form.submit()" style="width: 50px;"></td>
									<td>${item.price*item.qty}</td>
									<td><a class="btn btn-primary btn-sm"
										href="/shopping/del/${item.productId }">Remove</a></td>
								</tr>
							</form>
						</c:forEach>


					</tbody>
				</table>
				<p>Total:${TOTAL} $</p>
				<hr />
				<a class="btn btn-primary btn-sm" href="/shopping/clear">Clear
					Cart</a> <a class="btn btn-primary btn-sm" href="/product/views/page">Add
					more</a> <a class="btn btn-primary btn-sm" href="/shopping/form">Pay
					form</a>
			</div>
		</div>
	</div>
	

</body>
</html>