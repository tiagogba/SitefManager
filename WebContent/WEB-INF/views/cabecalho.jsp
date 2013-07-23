<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SitefManager</title>
<style type="text/css">
@import url("css/lista.css");
</style>

</head>
<body>
<th align="left"><img src="img/uoldiveo.png" width="150"></th>
<th align="righ" width="150%">&nbsp;<b><font color="#c0c0c0" face="arial" size=4>Sistemas Finaceiros</font></b></th>
<nav id="menu">
    <ul>
        <li class="current-menu-item"><a href="menu">Home</a></li>
          <li><a href="#">Cadastrar</a><!-- nível 1 -->
            <ul>
                <li><a href="#">Loja</a><!-- nível 2 -->
                    <ul>
                        <li><a href="adiciona">UOL</a></li>
                        <li><a href="#">BoldCron</a></li>
                    </ul>
                </li>
                <li><a href="#">Bandeira</a></li>
                <li><a href="#">Operadora</a></li>
            </ul>
        </li>
        
        <li><a href="#">Pesquisar</a><!-- nível 1 -->
            <ul>
                <li><a href="lista">Listar</a></li>
                <li><a href="#">Loja</a><!-- nível 2 -->
                    <ul>
                        <li><a href="#">UOL</a></li>
                        <li><a href="#">BoldCron</a></li>
                    </ul>
                </li>
                <li><a href="#">Bandeira</a></li>
            </ul>
        </li>
        <li><a href="logoff">Logoff</a></li>
    </ul>
</nav>
</body>
</html>