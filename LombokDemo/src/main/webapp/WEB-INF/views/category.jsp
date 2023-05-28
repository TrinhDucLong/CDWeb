<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
</head>
<body>

	<div class="col-sm-3">
		<div class="card bg-light mb-3">
			<div class="card-header bg-primary text-white text-uppercase">
				<i class="fa fa-list"></i> Categories
			</div>
			<ul class="list-group category_block">
				<c:forEach items="${listCC}" var="o">
					<li class="list-group-item text-black "><a
						style="cursor: pointer" onclick="load(${o.id})">${o.name}</a></li>
				</c:forEach>

			</ul>
		</div>
		<%-- This is JSP comment 
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${p.image}" />
            <h5 class="card-title"><a href="detail?pid=${p.id}" title="View Product">${p.name}</a></h5>
            
            <p class="card-text">${p.title}</p>
            <p class="bloc_left_price">${p.price} $</p>
        </div>
        --%>
	</div>
	</div>

</body>
</html>