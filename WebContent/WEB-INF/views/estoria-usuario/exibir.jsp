<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Estória de Usuário</title>
<meta name="viewport" content="width=device-width">

</head>
<body>
	<c:import url="../componentes/cabecalho.jsp" />

	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="glyphicon glyphicon-list"></span> Diagrama de Classes
					<span class="glyphicon glyphicon-chevron-right"></span> ${titulo}
				</div>
				<div class="panel-body" align="center">${imagem}</div>
			</div>
			<div align="center">
				<!-- Cadastrar -->
				<a href="novaEstoriaUsuario" class="btn btn-default"><span
					class="glyphicon glyphicon-plus"></span> Nova Estória</a> <a
					href="estoriaUsuario" class="btn btn-primary"><span
					class="glyphicon glyphicon-edit"></span> Editar</a>
				<!-- Download -->
				<div class="btn-group">
					<button type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-download"></span> Download
					</button>
					<a href="#" class="btn btn-info dropdown-toggle"
						data-toggle="dropdown"><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="downloadXmi21">XMI 2.1 (Padrão)</a></li>
						<li><a href="downloadXmi12">XMI 1.2</a></li>
						<li class="divider"></li>
						<li><a href="downloadJava">Código Java</a></li>
						<li><a href="" data-toggle="modal"
							data-target="#modalDownload">Estória de Usúario</a></li>
						<li class="divider"></li>
						<li><a href="downloadImagem">Imagem</a></li>
					</ul>
				</div>
			</div>

			<!-- Modal Download -->
			<div class="modal fade" id="modalDownload" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Fechar</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Selecione o
								formato de download</h4>
						</div>
						<div class="modal-body">
							<a href="downloadTxt" class="btn btn-primary"> .txt </a> <a
								href="downloadDoc" class="btn btn-info"> .doc </a> <a
								href="downloadStory" class="btn btn-warning"> .story </a> <a
								href="downloadPdf" class="btn btn-danger"> .pdf </a>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-log-out"></span> Cancelar
							</button>
						</div>
					</div>
				</div>
			</div>


			<ul class="pager">
				<li class="previous"><a href="estoriaUsuario"><span
						class="glyphicon glyphicon-chevron-left"></span> Voltar</a></li>
			</ul>
		</div>
	</div>

	<c:import url="../componentes/rodape.jsp" />

</body>
</html>