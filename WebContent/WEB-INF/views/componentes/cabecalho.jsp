<%@ page language="java" contentType="text/html"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/cabecalho.css" />
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/upload.js"></script>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="estoriaUsuario"> <span
					class="glyphicon glyphicon-home"></span> Estória de Usuário
				</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<form method="POST" enctype="multipart/form-data" action="upload"
					class="navbar-form navbar-left">
					<div class="form-group">
						<input type="file" name="arquivo" class="form-control"> <input
							type="hidden" id="extensao" name="extensao" value="">
					</div>
					<button type="button" name="Submit" class="btn btn-default"
						onclick="comprova_extensao(this.form, this.form.arquivo.value)">
						<span class="glyphicon glyphicon-upload"></span> Upload
					</button>
				</form>
			</div>
		</div>
	</nav>
</body>
</html>