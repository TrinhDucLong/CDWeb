<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>JSP Page</title>
<style type="text/css">
.error {
	color: red;
	font-weight: bold;
	font-size-adjust: inherit;
}
</style>
</head>
<body>
	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">
				<h2>Manager Product</h2>
				<form:form action="/product/SaveOrUpdate" modelAttribute="PRODUCT"
					method="post" enctype="multipart/form-data">
					<div class="form-group">
						<p class="error">${ERRU}</p>
						<label>Name : </label>
						<form:input type="text" class="form-control" path="name"
							placeholder="Enter Name" />
						<form:errors path="name" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<p class="error">${ERRU}</p>
						<label>Price : </label>
						<form:input type="number"  step="any" class="form-control" path="price"
							placeholder="Enter price" />
						<form:errors path="price" cssClass="error"></form:errors>
					</div>
					<div class="form-group">
						<label>Title Product: </label>
						<form:input type="text" class="form-control" path="titleProduct"
							placeholder="Enter titleProduct" />
						<form:errors path="titleProduct" cssClass="error"></form:errors>

					</div>
					<div class="form-group">
						<label> Description Product : </label>
						<form:input type="text" class="form-control"
							path="descriptionProduct" placeholder="Enter descriptionProduct" />
						<form:errors path="descriptionProduct" cssClass="error"></form:errors>

					</div>
					<div class="form-group">
						<label>Photo : </label> <input type="file" class="form-control"
							name="image" accept="image/png,image/jpeg,image/jpn"
							placeholder="Enter photo" />

						<p class="error">${ERRP}</p>
					</div>
				
					<form:button type="submit" class="btn btn-primary">Submit</form:button>
					<form:button type="reset" class="btn btn-primary">Cancel</form:button>
					<a href="/account/view" class="btn btn-primary">Display Account</a>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>

