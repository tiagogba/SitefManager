<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SitefManager</title>

<script type="text/javascript" src="js/jquery-1.3.2.js"></script>  
 <script type="text/javascript" src="js/maskedinput-1.1.2.pack.js"></script>  
 
 <script type="text/javascript">  
 $(document).ready(function(){  
 $(function(){  
 $.mask.addPlaceholder("~","[+-]");  
 $("#cnpj").mask("99.999.999/9999-99");  
 });  
 });  
 </script>

<style type="text/css">  
@import url("css/form.css");  
</style> 
</head>
<body>
<c:import url="cabeca.jsp"></c:import>
<form action="cadastro" method="post">
	<fieldset>
	<p><label>Nome</label><input type="text" size="45" name="empresa" value="" placeholder="empresa" /><br /></p>
	<p><label>Loja</label><input type="text" size="45" name="loja" value="" placeholder="loja" /><br /></p>
	<p><label>Razao Social</label><input type="text" size="45" name="razaoSocial" value="" placeholder="razao social" /><br /></p>
	<p><label>Cnpj</label><input type="text" id="cnpj" size="25" name="cnpj" value=""  placeholder="cnpj" /><br /><p>
	<p><input type="submit" value="Enviar" /></p>
	</fieldset>
</form>
</body>
</html>