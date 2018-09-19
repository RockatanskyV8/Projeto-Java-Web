<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
		<c:import url="cabecalho.jsp" />
		
		<link href="resources/css/jquery-ui.css" rel="stylesheet">
		<script src="resources/js/jquery.js"></script>
		<script src="resources/js/jquery-ui.js"></script>
		
		<jsp:useBean id="dao" class="br.com.teste.jdbc.EquipamentoDAO"/>
		<title>Bem vindo JSTL</title>
	</head>
	<body>
		<table style="width:50%">
			<tr>
				<th style="text-align:center">Nome</th>
				<th style="text-align:center">Local</th>
				<th style="text-align:center">Adquirido</th>
			</tr>
			<c:forEach var="e" items="${equipamentos}">
				<tr id=${e.id } id="id">
				<td style="text-align:center">${e.name }</td>
				<td style="text-align:center">${e.local }</td>
				<td style="text-align:center"><a href="mvc?logica=RemoveEquipLogica&id=${e.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<caelum:campoData id="dataNascimento"/>
		
		<c:import url="rodape.jsp" />
	</body>
</html>