<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
<h5>Alterar loja - ${lojas.empresa}</h5>
<form action="alteralojas" method="post">
<fieldset>
	<input type="hidden"name="id" value="${lojas.id}" />
<p>
	<label>Empresa</label><input type="text" name="empresa" value="${lojas.empresa}" size=45/><br />
</p>
<p>
	<label>Loja</label><input type="text" name="loja" value="${lojas.loja}" size=45/><br />
</p>	
<p>
	<label>Razao Social</label><input type="text" name=razaoSocial value="${lojas.razaoSocial}" size=45 /> <br />
</p>
<p>
	<label>CNPJ</label><input type="text" name=cnpj value="${lojas.cnpj}" id=cnpj /><br />
</p>
	<input type="submit" value="Alterar" onclick="alert('Loja alterada com sucesso')"/>
</fieldset>
</form>
</body>
</html>