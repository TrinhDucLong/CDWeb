<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Item - Sell phone</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>



	<!-- Product section-->
	<
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0" src="/uploads/${p.image}"
						alt="..." />
				</div>
				<div class="col-md-6">
					<h1 class="display-5 fw-bolder">${p.titleProduct}</h1>
					<div class="fs-5 mb-5">
						<span class="">${p.price}$</span> 
					</div>
					<p class="lead">${p.descriptionProduct}</p>
					<form class="d-flex" action="/shopping/views">
						<button class="btn btn-outline-dark" type="submit">
							<i class="bi-cart-fill me-1"></i> Cart 
						</button>
					</form>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
