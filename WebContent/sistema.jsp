<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>

<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"	src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script type="text/javascript"	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"	src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fnt" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:useBean id="ctl" class="manager.ManagerBean" scope="request"></jsp:useBean>

<script>
	$(document).ready(function() {

		$("#area51").hide();

		$("#btn1").on('click', function() {
			$("#area51").show();
			$("#rodrigo").html("");
		});

		$("#btn2").on('click', function() {
			$("#nome").val("");
			$("#email").val("");
			$("#area51").hide();
		});

	});
</script>

</head>
<body>

	<div class="container-fluid">
		<div class="well">
			<h2>Cadastro de Cliente</h2>
		</div>

		<div id="rodrigo" class="col-md-8 col-md-offset-2"><b>${msg}</b></div>
				
		<div class="col-md-8 col-md-offset-2 panel panel-info">			
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>IdCliente</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Exluir</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody>
					<!-- fala com o método doGet passando cmd=excluir e idCliente=valor -->
					<c:forEach items="${ctl.lista}" var="linha">
						<tr>
							<td>${linha.idCliente}</td>
							<td>${linha.nome}</td>
							<td>${linha.email}</td>
							<td><a
								href="Controle?cmd=excluir&idCliente=${linha.idCliente}"
								title="Clique para excluir"> <i class="fa fa-trash"></i></a></td>
							<td><a
								href="Controle?cmd=editar&idCliente=${linha.idCliente}"
								title="Clique para editar"> <i class="fa fa-pencil"></i></a></td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
						<button id="btn1" type="button" class="btn btn-info" title="Clique para Cadastrar">
						Cadastro &nbsp;<i class="fa fa-cog"></i></button>
					</tr>

				</tfoot>
			</table>
		</div>

		<div id="area51" class="col-md-8 col-md-offset-2 panel panel-info" style="padding: 10px;">
			<form method="post" action="Controle?cmd=cadastrar" id="form1" name="form1" class="form-inline">
				<label for="nome">Nome:</label> 
				<input 	type="text" name="nome" id="nome" placeholder="Digite o Nome"
						title="Digite o Nome" class="form-control" required="required"/> 
				
				<label for="email">Email:</label>
				<input 	type="email" name="email" id="email" placeholder="Digite o Email"
						title="Digite o Email" class="form-control" required="required"/>
				
				<input type="submit" value="Enviar os Dados" class="btn btn-info" title="Clique para gravar"/> 
				<input id="btn2" type="reset" value="Voltar" class="btn btn-success" title="Clique para Fechar"/>
			</form>
		</div>

		
	</div>

</body>
</html>
