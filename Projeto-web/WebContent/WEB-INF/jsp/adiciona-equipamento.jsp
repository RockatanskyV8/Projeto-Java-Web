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
		
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Adiciona Equipamento</h1>
		<hr />
		<form action="adicionaEquipamento">
			Nome:            <input type="text" name="nome" /><br /> 
			Local:           <input type="text" name="local" /><br />
			Data Adquirido:  <caelum:campoData 	id="adquirido" /><br />  
			
			<input type="submit" value="Gravar">
			
		</form>
		
		
		<c:import url="rodape.jsp" />
	</body>
</html>