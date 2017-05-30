<!DOCTYPE html>
<html>
<head>

<!-- Quando for editar deve ter um value, além do value  deve ter o idCliente -->
<!-- Só pode Alterar deve ser sempre pelo idCliente -->

<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"	src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script type="text/javascript"	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"	src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

</head>

<body>

<div class="container-fluid">
	<div class="well">
		<h2>Alteração do Cliente</h2>
	</div>
	
	<div class="col-md-6 col-md-offset-3 panel panel-info" style="padding: 15px;">
		<form method="post" action="Controle?cmd=alterar" id="form1" name="form1" role="form">
			<label for="idCliente">idCliente:</label> 
			<input 	type="number" name="idCliente" id="idCliente" value="${cliente.idCliente}" 
					readonly="readonly" class="form-control"/> 
					
			<label for="nome">Nome:</label> 
			<input 	type="text" name="nome" id="nome" value="${cliente.nome}" class="form-control"
					title="Altere o Nome"/> 
			
			<label for="email">Email:</label>
			<input 	type="email" name="email" id="email" value="${cliente.email}" class="form-control"
					title="Altere o Email"/>
			<br>
			<input type="submit" value="Alterar os Dados" class="btn btn-primary" title="Clique para Alterar"/>
			&nbsp; ${msg}
		</form>	
	</div>
	
</div>

</body>
</html>