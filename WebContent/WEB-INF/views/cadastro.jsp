<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SitefManager</title>

<style type="text/css">
@import url("css/form.css");
</style>

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/maskedinput.js" type="text/javascript"></script>
<script>
	jQuery(function($) {
		$("#telefone").mask("(999) 9999-9999"); //Aqui montamos a máscara que queremos
		$("#cep").mask("99999-999");
		$("#cpf").mask("999.999.999/99");
		$("#cnpj").mask("99.999.999/9999-99");
	});
</script>

</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<form action="adicionaloja" method="post">
		<fieldset>
			<p>
				<label>Empresa</label><input type="text" size="45" name="empresa"
					value="" placeholder="empresa" /><br />
			</p>
			<p>
				<label>Loja</label><input type="text" size="45" name="loja" value=""
					placeholder="loja" /><br />
			</p>
			<p>
				<label>Razao Social</label><input type="text" size="45"
					name="razaoSocial" value="" placeholder="razao social" /><br />
			</p>
			<p>
				<label>CNPJ</label><input type="text" name="cnpj" id="cnpj" value=""
					placeholder="cnpj" /><br />
			</p>
			<p>
				<input type="submit" value="Enviar" />
			</p>
		</fieldset>
	</form>
</body>
</html>