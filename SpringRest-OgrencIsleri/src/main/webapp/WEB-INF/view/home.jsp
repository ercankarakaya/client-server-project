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
		url("https://www.aspitio.com/wp-content/uploads/2017/09/clients-aspitio-akura-school-management-system.jpg");
	height: 200px;
}
</style>
</head>
<body>


	<div class="text-center">
		<h1>STUDENT MANAGEMENT</h1>
		<p>Student graduation procedures...</p>
	</div>
	<div class="container">
		<div class="center">
			<button onclick="window.location.href='ogrenciler'" type="button"
				class="btn btn-warning">Listele</button>

			<button
				onclick="window.location.href='${pageContext.request.contextPath}/api/rest-ogrenciler'"
				class="btn btn-light">JSON FORMAT</button>
		</div>
	</div>

	<div class="container" style="background-color: white;">
		<div class="center">


			<table class="table">

				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">ISIM</th>
						<th scope="col">SOYISIM</th>
						<th scope="col">OGRENCI NO</th>
						<th scope="col">MEZUNİYET DURUMU</th>
						<th scope="col">İŞLEM</th>
					</tr>
				</thead>

				<tbody>


					<c:forEach items="${ogrenciler}" var="ogrenci">
						<c:url var="listeleLink" value="/ogrenciler"></c:url>
						<c:url var="mezunEt" value="/ogrenci-mezun-et">
							<c:param name="ogrenciId" value="${ogrenci.id}" />
						</c:url>
						<tr>
							<td scope="row">${ogrenci.id}</td>
							<td>${ogrenci.isim}</td>
							<td>${ogrenci.soyisim}</td>
							<td>${ogrenci.ogrenciNo }</td>
							<td style="color: green;">${ogrenci.mezuniyet}</td>

							<td>
								<button onclick="window.location.href='${mezunEt}'"
									class="btn btn-success">Mezun Et</button>
							</td>


						</tr>

					</c:forEach>


				</tbody>

			</table>
			<span class="badge badge-warning"
				style="color: #CD5C5C; background-color: #FFE4C4; width: 50%;">${status}</span>
			<br /> <br />
			<hr />

		</div>
	</div>

</body>
</html>