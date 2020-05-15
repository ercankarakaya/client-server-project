<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Home</title>
<style>
body {
	background-image:
		url("https://blog.adgager.com/wp-content/uploads/2019/10/unsplash-basl%C4%B1k.jpg");
	height: 200px;
}
</style>
</head>
<body>


	<div class="text-center" style="height: 90px; background-color: black;">
		<h1 style="color: white;">LIBRARY MANAGEMENT</h1>
		<p style="color: white;">Student library procedures...</p>




	</div>

	<br />
	<br />
	<div class="container">
		<div class="center">
			<button onclick="window.location.href='kitaplar'" type="button"
				class="btn btn-warning">Listele</button>

		</div>


	</div>
	<div class="container" style="background-color: white;">
		<div class="center">
			<table class="table">

				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Kitap Adı</th>
						<th scope="col">Kitap Yazari</th>
						<th scope="col">Ogrenci ID</th>
						<th scope="col">İŞLEM</th>
						<th scope="col"></th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${kitaplar}" var="kitap">
						<c:url var="listeleLink" value="/home/kitaplar"></c:url>
						<c:url var="kitapVer" value="/ogrenci-kitap-form">
							<c:param name="kitapId" value="${kitap.id}" />
						</c:url>
						<tr>
							<td>${kitap.id}</td>
							<td>${kitap.kitap_adi}</td>
							<td>${kitap.kitap_yazari}</td>
							<td>${kitap.ogrenci_id}</td>

							<td>
								<button onclick="window.location.href='${kitapVer}'"
									class="btn btn-success">Kitabı Ver</button>
							</td>


							<td></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	
</body>
</html>