<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SitefManager</title>
<script>
function Function()
{
	var x;
	var r=confirm("Press a button!");
	if (r==true)
	  {
	  x="You pressed OK!";
	  }
	else
	  {
	  x="You pressed Cancel!";
	  }
}
</script>
</head>
<body>
<c:import url="cabecalho.jsp"></c:import>
<table>
<tr>
			<th>Id</th>
			<th>Empresa</th>
			<th>Loja</th>
			<th>Razao Social</th>
			<th>CNPJ</th>
			<th>Remover</th>
		</tr>
	<c:forEach items="${lojas}" var="lojas">
			<tr>
				<td>${lojas.id}</td>
				<td>${lojas.empresa}</td>
				<td>${lojas.loja}</td>
				<td>${lojas.razaoSocial}</td>
				<td>${lojas.cnpj}</td>
				<td><a href="remove?id=${lojas.id}" onclick="return confirm('Você tem certeza que quer remover essa loja?')" >Remover</a></td>
				<td><a href="mostralojas?id=${lojas.id}">Alterar</a>
			</tr>
	</c:forEach>
</table>
</body>
</html>