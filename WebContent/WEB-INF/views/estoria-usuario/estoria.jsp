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

	<c:set var="editar" value="false" />

	<c:if
		test="${estoria.xmi != null and estoria.codigoJava != null and estoria.imagemDiagramaDeClasse != null}">
		<c:set var="editar" value="true" />
	</c:if>

	<div class="jumbotron">
		<div class="container">
			<h1>Estória de Usuário</h1>
			<p>Escreva sua estória abaixo ou faça Upload dela nos
				seguintes formatos: Documento de texto (.txt), Estoria JBehave
				(.story), Documento Word (.doc) ou Portable Document Format (.pdf)</p>
		</div>
	</div>

	<div class="container">
		<form class="form-horizontal" action="adicionaEstoriaUsuario"
			method="post">
			<fieldset>
				<div class="form-group col-lg-12">
					<textarea class="form-control" rows="17" name="estoriaUsuario"
						placeholder="Título: Título da estória de usuário

Narrativa:
Como um [o papel]
Desejo [recurso]
De modo que [benefício]

Cenário: Título
Dado que [contexto]
E [pouco mais de contexto] ...
Quando [evento]
Então [resultado]
E [outro resultado] ...

Cenário: ..."
						required><c:if
							test="${not empty estoria.estoriaInicial}">${estoria.estoriaInicial}</c:if></textarea>
				</div>

				<div class="form-group col-lg-12 col-lg-offset-2">
					<c:if test="${editar}">
						<button type="reset" class="btn btn-default" data-toggle="modal"
							data-target="#modalCancela">
							<span class="glyphicon glyphicon-remove"></span> Cancelar
						</button>
					</c:if>
					<c:if test="${not editar}">
						<button type="reset" class="btn btn-default">
							<span class="glyphicon glyphicon-remove"></span> Cancelar
						</button>
					</c:if>
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-ok"></span> Enviar
					</button>
				</div>
				<!-- Modal -->
				<div class="modal fade" id="modalCancela" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Fechar</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Cancelar edição</h4>
							</div>
							<div class="modal-body">Deseja realmente cancelar a edição
								da estoria de usuário?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">
									<span class="glyphicon glyphicon-log-out"></span> Não
								</button>
								<a href="exibirEstoriaUsuario" class="btn btn-primary"><span
									class="glyphicon glyphicon-share-alt"></span> Sim</a>
							</div>
						</div>
					</div>
				</div>
			</fieldset>
		</form>

		<c:if
			test="${estoria.xmi != null and estoria.codigoJava != null and estoria.imagemDiagramaDeClasse != null}">
			<ul class="pager">
				<li class="next"><a href="" data-toggle="modal"
					data-target="#modalCancela"> <span
						class="glyphicon glyphicon-chevron-right"></span> Avançar
				</a></li>
			</ul>
		</c:if>

	</div>

	<c:import url="../componentes/rodape.jsp" />

</body>
</html>