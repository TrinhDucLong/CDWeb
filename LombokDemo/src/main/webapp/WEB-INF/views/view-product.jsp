<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Sell phone</title>
<style type="text/css">
.container {
	margin: 30px;
}
</style>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="row">

			<c:forEach items="${LIST_PRODUCT.content}" var="p">
				<div class="col-sm-6 col-md-4 col-lg-3">
					<div class="card-body card gy-3 my-3" style="height: 650px">
						<img
							src="/uploads/${p.image}"
							alt="..." class="card-img-top">
						<div class="card-body">
							<a href="/product/detail/${p.id}">
								<h2 class="card-title">${p.name}</h2>
							</a> <a href="/product/detail/${p.id}">
								<p class="card-text">${p.id}</p>
							</a>

							<h5 class="card-title">${p.price}$</h5>
							<p class="card-text">${p.createDate}</p>
							<p class="card-text">${p.titleProduct}</p>
							<a href="/shopping/add/${p.id}" class="btn btn-primary">BUY
								NOW</a>
						</div>
					</div>
				</div>

			</c:forEach>
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link"
						href="/product/views/page?p=0">Fist</a></li>
					<li class="page-item"><a class="page-link"
						href="/product/views/page?p=${LIST_PRODUCT.number - 1}">Previous</a></li>
					<li class="page-item"><a class="page-link"
						href="/product/views/page?p=${LIST_PRODUCT.number + 1}">Next</a></li>
					<li class="page-item"><a class="page-link"
						href="/product/views/page?p=${LIST_PRODUCT.totalPages - 1}">Last</a></li>
				</ul>
			</nav>


		</div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>