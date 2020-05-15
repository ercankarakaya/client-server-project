<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>kitap form</title>
<style>
body {
	background-image:
		url("https://blog.adgager.com/wp-content/uploads/2019/10/unsplash-basl%C4%B1k.jpg");
	height: 200px;
}
</style>
</head>
<body>
	<div class="container" style="background-color: white; width: 500px;">
		<div class="center" style="width: 400px; margin-top: 30px;">

			<br />
			<div class="panel panel-default">
				<h2 align="center">Kitap Formu</h2>
				<div class="panel-body">

					<f:form action="kitap-kaydet" modelAttribute="kitap" method="POST">

						<f:hidden path="id" />
						<label>Kitap Adı : </label>
						<f:input path="kitap_adi" class="form-control" />

						<label>Kitap Yazari : </label>
						<f:input path="kitap_yazari" class="form-control" />

						<label>Verilen Öğrenci ID : </label>
						<f:input path="ogrenci_id" class="form-control" />
						<label style="color: red;">${message}</label>
						<br />
						<div class="container">
							<button class="btn btn-success" value="save" name="save">Kaydet</button>
						</div>


					</f:form>
					<br />
				</div>
			</div>
		</div>
		<div class="center">
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/kitaplar'"
				type="button" class="btn btn-danger">BACK HOME</button>
		</div>
	</div>


</body>
</html>