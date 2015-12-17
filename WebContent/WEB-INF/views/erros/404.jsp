<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>404</title>
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css" />
</head>
<body>
	<c:import url="../componentes/cabecalho.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1>A p�gina acessada n�o existe.</h1>
		</div>
	</div>

	<c:import url="../componentes/rodape.jsp" />

	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>